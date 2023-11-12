/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencias de la Computación
 * Programación Orientada a Objetos
 * 
 * Clase que muestra diferentes tipos de ayuda al usuario, como ejercicios para la ansiedad,
 * consejos para la adicción, contactos de emergencia y frases motivacionales
 * 
 * @author: Erick Barrera; Maria de Los Angeles; Luisa Jiménez
 * @version: 1.0.0
 */

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
public class AyudaRecurso {
    EntradaDatosTemp entrada = new EntradaDatosTemp();
    private ArrayList<Ejercicio> ejercicios = new ArrayList<>();
    private ArrayList<Phrase> consejos = new ArrayList<>();
    private ArrayList<Phrase> quotes = new ArrayList<>();
    private ArrayList<Contacto> contactos = new ArrayList<>();
    private ArrayList<Contacto> contactosUser = new ArrayList<>();
    private ArrayList<Reflexion> reflexiones = new ArrayList<>();
    private ArrayList<Sintoma> sintomas = new ArrayList<>();
    private static Connection connection = null;
    private static Connection connection2 = null;
    ResultSet result = null;
    Statement state = null;
    ResultSet result2 = null;
    Statement state2 = null;
    
    public void leerData(){
        String url = "jdbc:sqlite:./db/ayuda.db";
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            
            state = connection.createStatement();

            result = state.executeQuery("select * from Ejercicios");
            ejercicios.clear();
            while (result.next()) {
                ejercicios.add(new Ejercicio(result.getInt(1), result.getString(2), result.getString(3), result.getString(4),
                 result.getInt(5), result.getInt(6)));
            }

            result = state.executeQuery("select * from Consejos");
            consejos.clear();
            while (result.next()) {
                consejos.add(new Phrase(result.getInt(1), result.getString(2)));
            }
            
            result = state.executeQuery("select * from Quotes");
            quotes.clear();
            while (result.next()) {
                quotes.add(new Phrase(result.getInt(1), result.getString(2)));
            }
  
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if (result != null) {
                    result.close();
                }
                if (state != null) {
                    state.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void mostrarEjercicio(){
        Random rand = new Random();
        int indice = rand.nextInt(0, 12);
        Ejercicio temp = ejercicios.get(indice);
        System.out.println("--Ejercicio a realizar--");
        System.out.println("\nNombre: "+temp.getNombre()+
                         "\n Descripción: "+temp.getDescripcion()+
                         "\n Pasos: "+temp.getPasos()+
                         "\nDuración: "+temp.getDuracion()+
                         "\nRepeticiones: "+temp.getRepeticiones());
    }
    public void mostrarConsejo(){
        Random rand = new Random();
        int indice = rand.nextInt(0,20);
        Phrase temp = consejos.get(indice);
        System.out.println("--Consejo--");
        System.out.println(temp.getFrase());
    }

    public void mostrarQuote(){
        Random rand = new Random();
        int indice = rand.nextInt(0,10);
        Phrase temp = quotes.get(indice);
        System.out.println("--Quote--");
        System.out.println(temp.getFrase());
    }
    public void crearContacto(String user){
        String nombre = entrada.pedirContacto();
        String relacion = entrada.pedirRelacion();
        int numero = entrada.pedirNumero();
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("insert into Contactos_User('User','nombre','relacion','numero') VALUES ('"+
            user+"','"+nombre+"','"+relacion+"','"+numero+"')");
            System.out.println("Contacto agregado!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void loadContactos(String usuario){
        String url2 = "jdbc:sqlite:./db/userInfo.db";
        try {
            Class.forName("org.sqlite.JDBC");
            connection2 = DriverManager.getConnection(url2);
            state2 = connection2.createStatement();
            
            result2 = state2.executeQuery("select * from Contactos_Profesionales");
            contactos.clear();
            while (result2.next()) {
                contactos.add(new Contacto(usuario, result2.getString(2),result2.getString(3),result2.getInt(4)));
            }
            
            String selectQuery = "select * from Contactos_User where User = ?";
            PreparedStatement stmtPrep = connection2.prepareStatement(selectQuery);
            stmtPrep.setString(1, usuario);
            ResultSet rest = stmtPrep.executeQuery();
            contactosUser.clear();
            while (rest.next()) {
                contactosUser.add(new Contacto(usuario,rest.getString("nombre"),rest.getString("relacion"),
                rest.getInt("numero")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void mostrarContactos(Usuario user){
        loadContactos(user.getCorreo());
        user.setContactosEmergencia(contactosUser);
        System.out.println("-Servicios Profesionales de Ayuda-");
        for (Contacto contact : contactos) {
            System.out.println("\nNombre: "+contact.getNombre()+
                                "\t-"+contact.getRelacion()+"-"+
                                "\n Número: "+contact.getNumero());
        }
        System.out.println("-Contactos de Ayuda Personales-");
        for (Contacto contact2 : user.getContactosEmergencia()) {
            System.out.println("\nNombre: "+contact2.getNombre()+
                                "\t-"+contact2.getRelacion()+"-"+
                                "\n Número: "+contact2.getNumero());
        }
    }
    private String url = "jdbc:sqlite:./db/userInfo.db";
    private static Connection conn = null;
    public void checkSintomas(){
        String query = "CREATE TABLE IF NOT EXISTS Sintomas ("+
        " User TEXT NOT NULL,"+
        " Sintoma TEXT NOT NULL,"+
        " Fecha TEXT NOT NULL,"+
        " Descripcion TEXT NOT NULL,"+
        " Gravedad INT NOT NULL,"+
        " Duracion INT NOT NULL,"+
        " Accion TEXT NOT NULL,"+
        " FOREIGN KEY (User) REFERENCES Usuarios(correo)"+
        ");";
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void addSintoma(String user){
        checkSintomas();
        String sintoma = entrada.pedirSintoma();
        LocalDateTime fechaDateTime = LocalDateTime.now();
        String fecha = fechaDateTime.toString();
        String descripcion = entrada.pedirSDescripcion();
        int gravedad = entrada.pedirSGravedad();
        int duracion = entrada.pedirSDuracion();
        String accion = entrada.pedirSAccion();

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("insert into Sintomas('User','Sintoma','Fecha','Descripcion','Gravedad','Duracion','Accion') VALUES ('"+
            user+"','"+sintoma+"','"+fecha+"','"+descripcion+"','"+gravedad+"','"+duracion+"','"+accion+"')");
            System.out.println("Sintoma agregado");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void loadSintomas(String user){
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);

            String selectQuery = "select * from Sintomas where User = ?";
            PreparedStatement stmtPrep = conn.prepareStatement(selectQuery);
            stmtPrep.setString(1, user);
            ResultSet rest = stmtPrep.executeQuery();

            sintomas.clear();
            while (rest.next()) {
                sintomas.add(new Sintoma(user, rest.getString(2), 
                LocalDateTime.parse(rest.getString(3)), rest.getString(4), 
                rest.getInt(5), rest.getInt(6), rest.getString(7)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void mostrarSintomas(Usuario user){
        loadSintomas(user.getCorreo());
        user.setSintomas(sintomas);
        for (Sintoma sint : user.getSintomas()) {
            System.out.println("\nSintoma: "+sint.getSintoma()+
                               "\nFecha: "+sint.getFecha().toString()+
                               "\nDescripción: "+sint.getDescripcion()+
                               "\nGravedad: "+sint.getGravedad()+
                               "\nDuración: "+sint.getDuracion()+" min"+
                               "\nAcción tomada: "+sint.getAccion());
        }
    }


    private String urlR = "jdbc:sqlite:./db/userInfo.db";
    private static Connection connR = null;
    public void checkReflexion(){
        String query = "CREATE TABLE IF NOT EXISTS Reflexiones ("+
        " User TEXT NOT NULL,"+
        " Fecha TEXT NOT NULL,"+
        " Titulo TEXT NOT NULL,"+
        " Entrada TEXT NOT NULL,"+
        " FOREIGN KEY (User) REFERENCES Usuarios(correo)"+
        ");";
        try {
            Class.forName("org.sqlite.JDBC");
            connR = DriverManager.getConnection(urlR);
            Statement stmt = connR.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void addReflexion(String user){
        checkReflexion();
        LocalDateTime fechaDateTime = LocalDateTime.now();
        String fecha = fechaDateTime.toString();
        String titulo = entrada.pedirRTitulo();
        String reflex = entrada.pedirREntrada();

        try {
            Class.forName("org.sqlite.JDBC");
            connR = DriverManager.getConnection(urlR);
            Statement stmt = connR.createStatement();
            stmt.executeUpdate("insert into Reflexiones('User','Fecha','Titulo','Entrada') VALUES ('"+
            user+"','"+fecha+"','"+titulo+"','"+reflex+"')");
            System.out.println("Reflexión agregada");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void loadReflexiones(String user){
        try {
            Class.forName("org.sqlite.JDBC");
            connR = DriverManager.getConnection(urlR);

            String selectQuery = "select * from Reflexiones where User = ?";
            PreparedStatement stmtPrep = connR.prepareStatement(selectQuery);
            stmtPrep.setString(1, user);
            ResultSet rest = stmtPrep.executeQuery();
            
            reflexiones.clear();
            while (rest.next()) {
                reflexiones.add(new Reflexion(LocalDateTime.parse(rest.getString(2)),
                rest.getString(3),rest.getString(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarReflexiones(Usuario user){
        loadReflexiones(user.getCorreo());
        user.setReflexiones(reflexiones);
        for (Reflexion reflex : user.getReflexiones()) {
            System.out.println("\nFecha: "+reflex.getFecha().toString()+
                               "\nTítulo: "+reflex.getTitulo()+
                               "\nReflexión: "+reflex.getEntrada());
        }
    }

    public void addHabitos(Usuario user){
        ArrayList<String> habitos = entrada.habitosUsuario();
        try {
            Class.forName("org.sqlite.JDBC");
            connR = DriverManager.getConnection(urlR);
            Statement stmt = connR.createStatement();
            for (String habito : habitos) {
                stmt.executeUpdate("insert into Habitos('User','Habitos') VALUES ('"+
                user.getCorreo()+"','"+habito+"')");
            }
            System.out.println("Habitos agregados");
        } catch (Exception e) {
            System.out.println(e);
        } 
    }

    public ArrayList<String> loadHabitos(String user){
        ArrayList<String> habitos = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
            connR = DriverManager.getConnection(urlR);

            String selectQuery = "select * from Habitos where User = ?";
            PreparedStatement stmtPrep = connR.prepareStatement(selectQuery);
            stmtPrep.setString(1, user);
            ResultSet rest = stmtPrep.executeQuery();
            
            habitos.clear();
            while (rest.next()) {
                habitos.add(rest.getString("Habitos"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return habitos;
    }
    
    public void addObjetivos(Usuario user){
        ArrayList<String> objetivos = entrada.pedirObjetivos();
        try {
            Class.forName("org.sqlite.JDBC");
            connR = DriverManager.getConnection(urlR);
            Statement stmt = connR.createStatement();
            for (String objetivo : objetivos) {
                stmt.executeUpdate("insert into Objetivo('User','Objetivo') VALUES ('"+
                user.getCorreo()+"','"+objetivo+"')");
            }
            System.out.println("Objetivos agregados");
        } catch (Exception e) {
            System.out.println(e);
        } 
    }

    public ArrayList<String> loadObjetivos(String user){
        ArrayList<String> objetivos = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
            connR = DriverManager.getConnection(urlR);

            String selectQuery = "select * from Objetivo where User = ?";
            PreparedStatement stmtPrep = connR.prepareStatement(selectQuery);
            stmtPrep.setString(1, user);
            ResultSet rest = stmtPrep.executeQuery();
            
            objetivos.clear();
            while (rest.next()) {
                objetivos.add(rest.getString("Objetivo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objetivos;
    }


}
