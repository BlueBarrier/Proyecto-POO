import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
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
        Connection conn = null; // Declarar 'conn' fuera del switch
        String url = "jdbc:sqlite:./db/userInfo.db"; // Declarar 'url' una vez al inicio del método

        do {
            switch (entrada.logIn()) {
                case 1:
                    String correo = entrada.pedirCorreo();
                    String password = entrada.pedirPassword();

                    try {
                        Class.forName("org.sqlite.JDBC");
                        conn = DriverManager.getConnection(url); // Conectar a la base de datos
                        Statement state = conn.createStatement();
                        ResultSet rest = state.executeQuery("select * from User");

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
                    String nombreNuevo = entrada.pedirNombre();
                    String correoNuevo = entrada.pedirCorreo();
                    String passwordNuevo = entrada.pedirPassword();

                    // Puedes dejar los siguientes campos como null o con valores por defecto
                    // ya que en tu base de datos probablemente tengan valores por defecto.

                    // Los siguientes campos se pueden inicializar con valores por defecto o null.
                    int edadNuevo = 0;
                    String generoNuevo = null;
                    String ciudadNueva = null;

                    // Añade lógica para insertar el nuevo usuario en la base de datos.
                    try {
                        Class.forName("org.sqlite.JDBC");
                        conn = DriverManager.getConnection(url); // Conectar a la base de datos

                        // Aquí debes crear una consulta SQL para insertar un nuevo usuario en la base de datos.
                        // Puedes utilizar una declaración preparada para mejorar la seguridad de la inserción.

                        String insertQuery = "INSERT INTO User (nombre, correo, password, edad, genero, ciudad, frecuencia, fecha_inicio) " +
                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

                        PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
                        preparedStatement.setString(1, nombreNuevo);
                        preparedStatement.setString(2, correoNuevo);
                        preparedStatement.setString(3, passwordNuevo);
                        preparedStatement.setInt(4, edadNuevo);
                        preparedStatement.setString(5, generoNuevo);
                        preparedStatement.setString(6, ciudadNueva);
                        preparedStatement.setString(7, "0,0"); // Frecuencia por defecto
                        preparedStatement.setString(8, LocalDateTime.now().toString()); // Fecha de inicio actual

                        int rowsInserted = preparedStatement.executeUpdate();

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
                                conn.close(); // Cerrar la conexión
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