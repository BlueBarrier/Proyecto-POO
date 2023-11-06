import java.sql.*;
import java.time.LocalDateTime;
import java.util.Scanner;
public class Driver {

    public static void main(String[] args) {
        Usuario user = null;
        Scanner scan = new Scanner(System.in);
        EntradaDatosTemp entrada = new EntradaDatosTemp();
        Informacion info = new Informacion();
        AyudaRecurso ayuda = new AyudaRecurso();
        info.leerData();
        ayuda.leerData();

        boolean logIn = false;
        Connection conn = null; 
        String url = "jdbc:sqlite:./db/userInfo.db"; 

        do {
            switch (entrada.logIn()) {
                case 1:
                    String correo = entrada.pedirCorreo();
                    String password = entrada.pedirPassword();

                    try {
                        Class.forName("org.sqlite.JDBC");
                        conn = DriverManager.getConnection(url); 
                        Statement state = conn.createStatement();
                        ResultSet rest = state.executeQuery("select * from Usuarios");

                        while (rest.next()) {
                            String[] frecString = rest.getString(8).split(",");
                            int[] frecuencia = new int[2];
                            frecuencia[0] = Integer.parseInt(frecString[0]);
                            frecuencia[1] = Integer.parseInt(frecString[1]);
                            if (rest.getString(3).equals(correo) && rest.getString(4).equals(password)) {
                                user = new Usuario(rest.getString(2), correo, password, rest.getInt(5), rest.getString(6),
                                        rest.getString(7), frecuencia, null,
                                        null, null, null, new Contador(LocalDateTime.parse(rest.getString(9))), null);
                                logIn = true;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;
                case 2:
                    String nombre = entrada.nombre();
                    String correoNuevo = entrada.pedirCorreo();
                    String passwordNuevo = entrada.pedirPassword();

                    int edad = entrada.pedirEdad();
                    String sexo = entrada.pedirSexo();
                    String ciudad = entrada.pedirCiudad();
                    String freq = entrada.pedirFreq();
                    LocalDateTime fechaNow = LocalDateTime.now();


                    try {
                        Class.forName("org.sqlite.JDBC");
                        conn = DriverManager.getConnection(url); 
                        Statement stmt = conn.createStatement();
                        
                        int rowsInserted = stmt.executeUpdate(
                            "INSERT INTO User (nombre, correo, password, edad, sexo, ciudad, frecuencia, fecha) VALUES('"+
                            nombre+"','"+correoNuevo+"','"+passwordNuevo+"','"+edad+"','"+sexo+"','"+ciudad+"','"+freq+"','"+fechaNow+"')");

                        if (rowsInserted > 0) {
                            System.out.println("Nuevo usuario creado con éxito.");
                        } else {
                            System.out.println("No se pudo crear el usuario.");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (conn != null) {
                                conn.close(); 
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

                    break;
                case 3:
                    System.out.println("Salir");
                    return;
                default:
                    System.out.println("Ingrese una opción válida");
                    break;
            }
        } while (!logIn);
        do {
            switch (entrada.menu()) {
                case 1:
                    user.getContador().mostrarDiasSobrio();
                    break;
                case 2:
                    user.getHabitos().setHabitosUsuario(entrada.habitosUsuario());
                    user.getHabitos().chunkingObjetivos(user.getObjetivos());
                    user.getHabitos().reemplazarHabitos();
                    
                    break;
                case 3:
                    try {
                        for (String habito : user.getHabitos().getHabitosNuevos()) {
                            System.out.println("Hábito: "+habito);
                        }
                        
                    } catch (Exception e) {
                        System.out.println("Cree sus hábitos primero");
                    }
                    break;
                case 4:
                    try {
                        for (String habito : user.getHabitos().getHabitosReemplazar()) {
                        System.out.println("Hábito a reemplazar: "+habito);
                    }
                    } catch (Exception e) {
                        System.out.println("Cree sus hábitos primero");
                    }
                    break;
                case 5:
                    info.mostrarArticulo();
                    break;
                case 6:
                    info.mostrarMultimedia();
                    break;
                case 7:
                    ayuda.mostrarContactos(user);
                    break;
                case 8:
                    ayuda.mostrarEjercicio();
                    break;
                case 9:
                    ayuda.mostrarConsejo();
                    break;
                case 10:
                    ayuda.mostrarQuote();
                    break;
                case 11:
                    ayuda.mostrarQuote();
                    ayuda.addSintoma(user.getCorreo());
                    break;
                case 12:
                    System.out.println("\n¡¡Expresate!!\n");
                    ayuda.addReflexion(user.getCorreo());
                    break;
                case 13:
                    try {
                        ayuda.mostrarReflexiones(user);
                    } catch (Exception e) {
                        System.out.println("Ingrese primero una reflexión");
                        e.printStackTrace();
                    }
                    break;
                case 14:
                    try {
                        ayuda.mostrarSintomas(user);
                        if (user.getSintomas().size() > 3) {
                            System.out.println("Estas pasando por un momento complicado, realiza un ejercicio");
                            ayuda.mostrarEjercicio();
                        }
                    } catch (Exception e) {
                        System.out.println("Ingrese un sintoma primero");
                        e.printStackTrace();
                    }
                    break;
                case 15:
                    System.out.println("Saliendo...");
                    scan.close();
                    return;
                default:
                    System.out.println("Ingrese una opción entre 1 y 15");
                    break;
            }
        } while (true);
    }
}