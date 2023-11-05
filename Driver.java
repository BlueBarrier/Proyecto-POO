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
        info.leerData();

        
        boolean logIn = false;
        do {
            switch (entrada.logIn()) {
                case 1:
                    String correo = entrada.pedirCorreo();
                    String password = entrada.pedirPassword();
                    
                    String url = "jdbc:sqlite:./db/userInfo.db";
                    Connection conn = null;
                    try {
                        Class.forName("org.sqlite.JDBC");
                        conn = DriverManager.getConnection(url);
                        Statement state = conn.createStatement();
                        ResultSet rest = state.executeQuery("select * from User");

                        while (rest.next()) {
                            String[]frecString = new String[2];
                            frecString = rest.getString(8).split(",");
                            int[] frecuencia = new int[2];
                            frecuencia[0] = Integer.parseInt(frecString[0]);
                            frecuencia[1] = Integer.parseInt(frecString[1]);
                            if (rest.getString(3).equals(correo) && rest.getString(4).equals(password)) {
                                user = new Usuario(rest.getString(2), correo, password,rest.getInt(5), rest.getString(6),
                                 rest.getString(7),frecuencia, null, 
                                 null, null, null, new Contador(LocalDateTime.parse(rest.getString(9))), null);
                                logIn = true;
                            }                            
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                    break;
                case 2:
                     // HACER AQUI PARA CREAR UN NUEVO USARIO, DEJAR NULL LOS SIGUIENTES CAMPOS: 
                     //objetivos, contactosEmergencia, reflexiones, sintomas, habitos
                    break;
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
                    System.out.println("Saliendo...");
                    scan.close();
                    return;
                default:
                    System.out.println("Ingrese una opción entre 1 y 5");
                    break;
            }
        } while (true);
    }
}