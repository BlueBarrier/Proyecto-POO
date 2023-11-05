import java.util.ArrayList;
import java.util.Scanner;
public class Driver {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        EntradaDatosTemp entrada = new EntradaDatosTemp();
        Informacion info = new Informacion();
        info.leerData();
        Usuario user = new Usuario(entrada.nombre(), "Test","Test", 0, "Test", "Test", 
        null, entrada.Objetivos(), entrada.contactorEmergencia(), new ArrayList<>(), new ArrayList<>(),
         new Contador(entrada.fechaInicio()), new Habito(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
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