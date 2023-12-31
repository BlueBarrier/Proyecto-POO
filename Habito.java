/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencias de la Computación
 * Programación Orientada a Objetos
 * 
 * Clase Habito: clase que almacena los hábitos del usuario, le asigna nuevos habitos
 * y gradualmente va cambiando los malos hábitos del usuario por unos buenos.
 * 
 * @author: Erick Barrera - 231238
 * @date: 08/10/2023
 * @version: 1.0.2
 * @lastUpdate: 09/10/2023
 * Cambios realizados: eliminación de atributo usuario
 * 
 * 
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * La clase Habito representa una colección de datos relacionados con hábitos de salud y objetivos.
 */
public class Habito {
    private EntradaDatosTemp entrada = new EntradaDatosTemp(); 
    private ArrayList<String> habitosNuevos, habitosUsuario, habitosReemplazar;
    private ArrayList<String> objetivosChunked;
    ArrayList<String[]> palabrasClaveSaludables = new ArrayList<>();
    ArrayList<String[]> palabrasClavePerjudiciales = new ArrayList<>();
    
    
    
    /**
     * @param habitosNuevos
     * @param habitosUsuario
     * @param objetivosChunked
     * @param habitosReemplazar
     */
    public Habito(ArrayList<String> habitosNuevos, ArrayList<String> habitosUsuario, 
    ArrayList<String> objetivosChunked, ArrayList<String> habitosReemplazar){
        this.habitosUsuario = habitosUsuario;
        this.habitosNuevos = habitosNuevos;
        this.objetivosChunked = objetivosChunked;
        this.habitosReemplazar = habitosReemplazar;

    }

    /**
     * Carga datos de hábitos saludables y perjudiciales desde bases de datos y los almacena en listas.
     */
    public void cargarBaseDeDatosHabitos() {

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:./db/habitosb.db");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT nombre, descripcion FROM habitos");

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                String[] habito = {nombre, descripcion};
                palabrasClaveSaludables.add(habito);            
            }

            conn.close();

            conn = DriverManager.getConnection("jdbc:sqlite:./db/habitosm.db");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT nombre, descripcion FROM habitosm");

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                String[] HabitoM = {nombre, descripcion};
                palabrasClavePerjudiciales.add(HabitoM);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return habitosNuevos
     */
    public ArrayList<String> getHabitosNuevos() {
        return habitosNuevos;
    }
    /**
     * @param habitosNuevos
     */
    public void setHabitosNuevos(ArrayList<String> habitosNuevos) {
        this.habitosNuevos = habitosNuevos;
    }

    /**
     * @return habitosUsuario
     */
    public ArrayList<String> getHabitosUsuario() {
        return habitosUsuario;
    }
    /**
     * @param habitosUsuario
     */
    public void setHabitosUsuario(ArrayList<String> habitosUsuario) {
        this.habitosUsuario = habitosUsuario;
    }

    /**
     * Obtiene la lista de hábitos a reemplazar.
     *
     * @return La lista de hábitos a reemplazar.
     */
    public ArrayList<String> getHabitosReemplazar() {
        return habitosReemplazar;
    }

    /**
     * Establece la lista de hábitos a reemplazar.
     *
     * @param habitosReemplazar La lista de hábitos a reemplazar que se va a establecer.
     */
    public void setHabitosReemplazar(ArrayList<String> habitosReemplazar) {
        this.habitosReemplazar = habitosReemplazar;
    }

    /**
     * Obtiene la lista de objetivos fragmentados.
     *
     * @return La lista de objetivos fragmentados.
     */
    public ArrayList<String> getObjetivosChunked() {
        return objetivosChunked;
    }

    /**
     * Establece la lista de objetivos fragmentados.
     *
     * @param objetivosChunked La lista de objetivos fragmentados que se va a establecer.
     */
    public void setObjetivosChunked(ArrayList<String> objetivosChunked) {
        this.objetivosChunked = objetivosChunked;
    }


    // Funcionalidades

    /**
     * función para agregar los nuevos habitos del usuario
     */
    public void reemplazarHabitos(){
        ArrayList<ArrayList<String>> habitosSorted = analizarHabitos();
        habitosReemplazar = habitosSorted.get(1);
        ArrayList<String> habitosMantener = habitosSorted.get(0);

        habitosNuevos.addAll(habitosMantener);
        habitosNuevos.addAll(objetivosChunked);
    }

    /**
     * 
     * Guarda la lista de habitos en una tabla
     * 
     * @param user
     */
    public void addHabitos(Usuario user){
        try {
            ArrayList<String> habitosR = user.getHabitos().getHabitosReemplazar();
            ArrayList<String> habitosN = user.getHabitos().getHabitosNuevos();
            ArrayList<String> ObjetivosC = user.getHabitos().getObjetivosChunked();
            
            try {
                Class.forName("org.sqlite.JDBC");
                Connection conn = DriverManager.getConnection("jdbc:sqlite:./db/userInfo.db");
                Statement stmt = conn.createStatement();
    
                for (String habito : habitosR) {
                    stmt.executeUpdate("insert into HabitosR('User','habito') VALUES ('"+
                    user.getCorreo()+"','"+habito+"')");
                }
                for (String habito : habitosN) {
                    stmt.executeUpdate("insert into HabitosN('User','habito') VALUES ('"+
                    user.getCorreo()+"','"+habito+"')");
                }
                for (String obj : ObjetivosC) {
                    stmt.executeUpdate("insert into ObjetivosC('User','chunked') VALUES ('"+
                    user.getCorreo()+"','"+obj+"')");
                }
                System.out.println("Habitos Guardados");

            } catch (Exception e) {
                System.out.println(e);
            } 
        } catch (Exception e) {
            System.out.println("Cree sus hábitos primero");
        }
    }

    /**
     * carga los habitos de las tablas y los asigna al usuario
     * 
     * @param user
     */
    public void loadHabitos(Usuario user){
        ArrayList<String> habitosR = new ArrayList<>();
        ArrayList<String> habitosN = new ArrayList<>();
        ArrayList<String> ObjetivosC = new ArrayList<>();
        try {
           Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:./db/userInfo.db");
            
            String selectQuery = "select * from HabitosR where User = ?";
            PreparedStatement stmtPrep = conn.prepareStatement(selectQuery);
            stmtPrep.setString(1, user.getCorreo());
            ResultSet rest = stmtPrep.executeQuery();
            habitosR.clear();
            while (rest.next()) {
                habitosR.add(rest.getString("habito"));
            }
            user.getHabitos().setHabitosReemplazar(habitosR);
            
            selectQuery = "select * from HabitosN where User = ?";
            stmtPrep = conn.prepareStatement(selectQuery);
            stmtPrep.setString(1, user.getCorreo());
            rest = stmtPrep.executeQuery();
            habitosN.clear();
            while (rest.next()) {
                habitosN.add(rest.getString("habito"));
            }
            user.getHabitos().setHabitosNuevos(habitosN);
            
            selectQuery = "select * from ObjetivosC where User = ?";
            stmtPrep = conn.prepareStatement(selectQuery);
            stmtPrep.setString(1, user.getCorreo());
            rest = stmtPrep.executeQuery();
            ObjetivosC.clear();
            while (rest.next()) {
                ObjetivosC.add(rest.getString("chunked"));
            }
            user.getHabitos().setObjetivosChunked(ObjetivosC);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @return lista de habitos buenos y malos del usuario
     */
    public ArrayList<ArrayList<String>> analizarHabitos(){
        cargarBaseDeDatosHabitos();
        ArrayList<String> habitosS = new ArrayList<>();
        ArrayList<String> habitosM = new ArrayList<>();
        for (String[] habit : palabrasClavePerjudiciales) {
            habitosM.add(habit[0]);
        }
        for (String[] habit : palabrasClaveSaludables) {
            habitosS.add(habit[0]);
        }
        ArrayList<String> habitosSaludablesEncontrados = new ArrayList<>();
        ArrayList<String> habitosPerjudicialesEncontrados = new ArrayList<>();
        // agregar lista temp de la base
        for (String  habito : habitosUsuario) {
            if (habitosS.contains(habito)) {
                habitosSaludablesEncontrados.add(habito);
            } else if(habitosM.contains(habito)){
                habitosPerjudicialesEncontrados.add(habito);
            }
        }
        return new ArrayList<>(Arrays.asList(habitosSaludablesEncontrados, habitosPerjudicialesEncontrados));
    }

    /**
     * función para crear habitos en relación a los objetivos del usuario
     */
    public void chunkingObjetivos(ArrayList<String> objetivos){
        for (String objetivo : objetivos) {
            System.out.println("\n Piensa en los recursos que necesitas para lograr este objetivo\n");
            System.out.printf("\nGenial!! ahora: ¿Cómo puedes dividir este objetivo '(%s)' en subobjetivos más específicos y realistas? ",objetivo );
            ArrayList<String> subObjetivos = entrada.pedirSubObjetivos(); // solicitud de data
            for (String subObjetivo : subObjetivos) {
                System.out.printf("\n¿Qué acciones concretas vas a realizar para poder realizar '(%s)' (se concret@)?", subObjetivo);
                ArrayList<String> tempAcciones = entrada.pedirAcciones(); // solicitud de data
                objetivosChunked.addAll(tempAcciones);
            }
        }
    }
}
