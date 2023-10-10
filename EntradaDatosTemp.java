import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
public class EntradaDatosTemp {
    Scanner scan = new Scanner(System.in);

    public ArrayList<String> pedirSubObjetivos(){
        boolean salir = false;
        ArrayList<String> subObjetivos = new ArrayList<>();
        while (!salir) {
            System.out.println("Ingrese el subobjetivo: ");
            String objetivoTemp = scan.nextLine();
            subObjetivos.add(objetivoTemp.trim().toLowerCase());
            System.out.println("\n ¿Desea agregar otro?"+
                                        "\n1.Si"+
                                        "\n2.No");
            try {
                int respuesta = scan.nextInt();
                scan.nextLine();
                if (respuesta == 2) {
                    salir = true;
                }
            } catch (Exception e) {
                System.out.println("ingrese un valor entero entre 1 o 2: ");
                int respuesta = scan.nextInt();
                scan.nextLine();
                if (respuesta == 2) {
                    salir = true;
                }
            }
        }
        return subObjetivos;
    }
    public ArrayList<String> pedirAcciones(){
        boolean salir = false;
        ArrayList<String> acciones = new ArrayList<>();
        while (!salir) {
            System.out.println("Ingrese la acción concreta, que sea un verbo de preferencia: ");
            String accion = scan.nextLine();
            acciones.add(accion.trim().toLowerCase());
            System.out.println("\n ¿Desea agregar otro?"+
                                        "\n1.Si"+
                                        "\n2.No");
            try {
                int respuesta = scan.nextInt();
                scan.nextLine();
                if (respuesta == 2) {
                    salir = true;
                }
            } catch (Exception e) {
                System.out.println("ingrese un valor entero entre 1 o 2: ");
                int respuesta = scan.nextInt();
                scan.nextLine();
                if (respuesta == 2) {
                    salir = true;
                }
            }
        }
        return acciones;
    }

    public int menu(){
        System.out.println("---Menu----"+
                                "\n1. ver días sobrio"+
                                "\n2. crear hábitos"+
                                "\n3. ver hábitos a realizar"+
                                "\n4. ver hábitos a cambiar"+
                                "\n5. salir");
        try {
            int respuesta = scan.nextInt();
            scan.nextLine();
            return respuesta;
        } catch (Exception e) {
            System.out.println("Ingrese un valor válido: "+e.getMessage());
            int respuesta = scan.nextInt();
            scan.nextLine();
            return respuesta;
        }
    }

    public String nombre(){
        System.out.println("Ingrese su nombre: ");
        String nombre = scan.nextLine();
        return nombre;
    }

    public ArrayList<String> Objetivos(){
        boolean salir = false;
        ArrayList<String> objetivos = new ArrayList<>();
        while (!salir) {
            System.out.println("Ingrese un objetivo que quiera cumplir: ");
            String objetivo = scan.nextLine();
            objetivos.add(objetivo.trim().toLowerCase());
            System.out.println("\n ¿Desea agregar otro?"+
                                        "\n1.Si"+
                                        "\n2.No");
            try {
                int respuesta = scan.nextInt();
                scan.nextLine();
                if (respuesta == 2) {
                    salir = true;
                }
            } catch (Exception e) {
                System.out.println("ingrese un valor entero entre 1 o 2: ");
                int respuesta = scan.nextInt();
                scan.nextLine();
                if (respuesta == 2) {
                    salir = true;
                }
            }
        }
        return objetivos;
    }

    public HashMap<String, String> contactorEmergencia(){
        boolean salir = false;
        HashMap<String,String> contactos = new HashMap<>();
        while (!salir) {
            System.out.println("Ingrese el nombre del contacto: ");
            String contacto = scan.nextLine();
            System.out.println("Ingrese el número del contacto (Ej.: 4587-9865): ");
            String numero = scan.nextLine();
            contactos.put(contacto, numero);
            System.out.println("\n ¿Desea agregar otro?"+
                                        "\n1.Si"+
                                        "\n2.No");
            try {
                int respuesta = scan.nextInt();
                scan.nextLine();
                if (respuesta == 2) {
                    salir = true;
                }
            } catch (Exception e) {
                System.out.println("ingrese un valor entero entre 1 o 2: ");
                int respuesta = scan.nextInt();
                scan.nextLine();
                if (respuesta == 2) {
                    salir = true;
                }
            }
        }
        return contactos;
    }

    public ArrayList<String> habitosUsuario(){
        boolean salir = false;
        ArrayList<String> habitosSeleccionados = new ArrayList<>();
        ArrayList<String> todosLosHabitos = new ArrayList<>(Arrays.asList(
                "ejercicio", "alimentación", "hidratación", "sueño", "meditación",
                "gratitud", "lectura", "aprender", "socialización", "familia",
                "alcohol", "drogas", "tabaco", "comida chatarra", "sedentarismo",
                "insomnio", "pantallas", "cafeína", "aislamiento", "rumiación",
                "CocaCola", "seguido", "En exceso"
        ));
        while (!salir) {
            System.out.println("Lista de hábitos disponibles:");
            for (int i = 0; i < todosLosHabitos.size(); i++) {
                System.out.println((i + 1) + ". " + todosLosHabitos.get(i));
            }

            System.out.print("Elija un hábito (o 0 para salir): ");
            int opcion = scan.nextInt();

            if (opcion == 0) {
                salir = true; 
            } else if (opcion > 0 && opcion <= todosLosHabitos.size()) {
                String habitoElegido = todosLosHabitos.get(opcion - 1);

                if (!habitosSeleccionados.contains(habitoElegido)) {
                    habitosSeleccionados.add(habitoElegido);
                    System.out.println("Hábito agregado: " + habitoElegido);
                } else {
                    System.out.println("El hábito ya está en la lista.");
                }
            } else {
                System.out.println("Opción no válida. Por favor, elija un número válido.");
            }
        }
        return habitosSeleccionados;
    }


    public LocalDateTime fechaInicio() {
        System.out.print("Ingrese una fecha en formato 'yyyy-MM-dd HH:mm:ss': ");
        String fechaTexto = scan.nextLine();
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime fecha = LocalDateTime.parse(fechaTexto, formatter);
            return fecha;
        } catch (Exception e) {
            System.out.println("Formato de fecha incorrecto. Asegúrese de usar el formato 'yyyy-MM-dd HH:mm:ss'.");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime fecha = LocalDateTime.parse(fechaTexto, formatter);
            return fecha;
        }
    }
}
