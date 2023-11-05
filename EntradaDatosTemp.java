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
                                "\n5. Mostrar artículos"+
                                "\n6. Mostrar videos"+
                                "\n7. salir");
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

    public String pedirSintoma(){
        System.out.println("Ingrese el sintoma que sufrió: ");
        try {
            String sintoma = scan.nextLine();
            return sintoma;
        } catch (Exception e) {
            System.out.println(e);
            pedirSintoma();
        }
        return "";
    }

    public String pedirSDescripcion(){
        System.out.println("Describa el sintoma que aconteció: ");
        try {
            String desc = scan.nextLine();
            return desc;
        } catch (Exception e) {
            System.out.println(e);
            pedirSDescripcion();
        }
        return "";
    }

    public int pedirSGravedad(){
        System.out.println("Ingrese la gravedad en una escala del 1 al 10:");
        try {
            int gravity = scan.nextInt();
            scan.nextLine();
            if (gravity>10 || gravity<0) {
                System.out.println("Entre 1 - 10!");
                pedirSGravedad();
            }else{
                return gravity;
            }
        } catch (Exception e) {
            System.out.println(e);
            pedirSGravedad();
        }
        return 0;
    }

    public int pedirSDuracion(){
        System.out.println("Ingrese la cantidad de minutos que duró: ");
        try {
            int duracion = scan.nextInt();
            scan.nextLine();
            if (duracion<0) {
                System.out.println("No menos de 0");
                pedirSDuracion();
            }else{
                return duracion;
            }
        } catch (Exception e) {
            System.out.println(e);
            pedirSDuracion();
        }
        return 0;
    }

    public String pedirSAccion(){
        System.out.println("Describa la acción que tomó:");
        String accion = scan.nextLine();
        return accion;
    }

    public String pedirRTitulo(){
        System.out.println("Ingresa el título de tu reflexión: ");
        try {
            String name = scan.nextLine();
            return name;
        } catch (Exception e) {
            System.out.println(e);
            pedirRTitulo();
        }
        return "";
    }

    public String pedirREntrada(){
        System.out.println("Ingresa tu reflexión:");
        try {
            String entrada = scan.nextLine();
            return entrada;
        } catch (Exception e) {
            System.out.println(e);
            pedirREntrada();
        }
        return "";
    }

    public int logIn(){
        System.out.println("--Programa Contra Adicciones--");
        System.out.println("\n1. Iniciar Sesión"+
                           "\n2. Crear Usuario");
        try {
            int op = scan.nextInt();
            scan.nextLine();
            return op;
        } catch (Exception e) {
            System.out.println("Ingrese una opción válida");
            logIn();
        }
        return 0;
    }

    public String pedirCorreo(){
        System.out.println("Ingrese su correo: ");
        try {
            String correo = scan.nextLine();
            if (correo.contains("@")) {
                return correo;
            }
            else{
                System.out.println("Correo Invalido");
            }
        } catch (Exception e) {
            e.printStackTrace();
            pedirCorreo();
        }
        return "";
    }
    public String pedirPassword(){
        System.out.println("Ingrese su contraseña: ");
        try {
            String pass = scan.nextLine();
            return pass;
        } catch (Exception e) {
            e.printStackTrace();
            pedirPassword();
        }
        return "";
    }
}
