//************************************************************************
//Universidad del Valle de Guatemala
//Departamento de Ciencia de la Computación
//Autor: Marielos Ortiz, Luisa Jiménez, Erick Barrera
//Carné: 23882, 23011, 231238
//CC2008 - 50
//Fecha: Noviembre de 2023
//Descripción: Proyecto Final
//************************************************************************
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * La clase EntradaDatosTemp proporciona métodos para interactuar con el usuario
 * y recopilar información.
 */

public class EntradaDatosTemp {
    Scanner scan = new Scanner(System.in);

    /**
     * Pide al usuario una lista de subobjetivos y la devuelve en forma de ArrayList
     * de cadenas.
     *
     * @return Una lista de subobjetivos ingresados por el usuario.
     */

    public ArrayList<String> pedirSubObjetivos() {
        boolean salir = false;
        ArrayList<String> subObjetivos = new ArrayList<>();
        while (!salir) {
            System.out.println("Ingrese el subobjetivo: ");
            String objetivoTemp = scan.nextLine();
            subObjetivos.add(objetivoTemp.trim().toLowerCase());
            System.out.println("\n ¿Desea agregar otro?" +
                    "\n1.Si" +
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

    /**
     * Pide al usuario una lista de acciones y la devuelve en forma de ArrayList de
     * cadenas.
     *
     * @return Una lista de acciones ingresadas por el usuario.
     */
    public ArrayList<String> pedirAcciones() {
        boolean salir = false;
        ArrayList<String> acciones = new ArrayList<>();
        while (!salir) {
            System.out.println("Ingrese la acción concreta, que sea un verbo de preferencia: ");
            String accion = scan.nextLine();
            acciones.add(accion.trim().toLowerCase());
            System.out.println("\n ¿Desea agregar otro?" +
                    "\n1.Si" +
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

    /**
     * Muestra un menú de opciones al usuario y devuelve la opción seleccionada.
     *
     * @return La opción seleccionada por el usuario.
     */

    public int menu() {
        System.out.println("---Menu----" +
                "\n1. ver días sobrio" +
                "\n2. crear hábitos y objetivos" +
                "\n3. ver hábitos a realizar" +
                "\n4. ver hábitos a cambiar" +
                "\n5. Mostrar artículos" +
                "\n6. Mostrar videos" +
                "\n7. Crear contactos"+
                "\n8. Mostrar Contactos" +
                "\n9. Mostrar un ejercicio" +
                "\n10. Mostrar un consejo" +
                "\n11. Mostrar una frase motivadora" +
                "\n12. Ingresar un sintoma" +
                "\n13. Crear una reflexión" +
                "\n14. Mostrar reflexiones" +
                "\n15. Mostrar sintomas" +
                "\n16. salir");
        try {
            int respuesta = scan.nextInt();
            scan.nextLine();
            return respuesta;
        } catch (Exception e) {
            System.out.println("Ingrese un valor válido: " + e.getMessage());
            int respuesta = scan.nextInt();
            scan.nextLine();
            return respuesta;
        }
    }

    /**
     * Pide al usuario su nombre y lo devuelve como una cadena.
     *
     * @return El nombre ingresado por el usuario.
     */
    public String nombre() {
        System.out.println("Ingrese su nombre: ");
        String nombre = scan.nextLine();
        return nombre;
    }

    /**
     * Pide al usuario una lista de contactos de emergencia y los devuelve como un
     * HashMap de nombre y número de teléfono.
     *
     * @return Un HashMap que contiene los contactos de emergencia ingresados por el
     *         usuario.
     */
    public HashMap<String, String> contactorEmergencia() {
        boolean salir = false;
        HashMap<String, String> contactos = new HashMap<>();
        while (!salir) {
            System.out.println("Ingrese el nombre del contacto: ");
            String contacto = scan.nextLine();
            System.out.println("Ingrese el número del contacto (Ej.: 4587-9865): ");
            String numero = scan.nextLine();
            contactos.put(contacto, numero);
            System.out.println("\n ¿Desea agregar otro?" +
                    "\n1.Si" +
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

    /**
     * Permite que el usuario seleccione hábitos de una lista y agregarlos a una lista personal de hábitos.
     * @return Un ArrayList de cadenas que contiene los hábitos seleccionados por el usuario.
     */
    public ArrayList<String> habitosUsuario() {
        boolean salir = false;
        ArrayList<String> habitosSeleccionados = new ArrayList<>();
        ArrayList<String> todosLosHabitos = new ArrayList<>(Arrays.asList(
                "ejercicio","hidratación", "sueño", "meditación",
                "lectura", "aprender", "socialización", 
                "alcohol", "drogas", "tabaco", "comida chatarra", "sedentarismo",
                "insomnio", "cafeína", "aislamiento", 
                "CocaCola"));
        while (!salir) {
            System.out.println("Lista de hábitos disponibles:");
            System.out.println("\n1. ejercicio \t 2. hidratación \t 3. Dormir temprano"+
                               "\n4. meditación \t5. lectura \t6. aprender"+
                               "\n7. socialización \t8. alcohol \t 9. drogas"+
                               "\n10. tabaco \t11. comida chatarra \t12. sedentarismo"+
                               "\n13. insomnio \t14. cafeína \t15. aislamiento"+
                               "\n16. CocaCola");

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

    /**
     * Pide al usuario una fecha y hora en formato "yyyy-MM-dd HH:mm:ss" y la
     * devuelve como LocalDateTime.
     *
     * @return La fecha y hora ingresada por el usuario como LocalDateTime.
     */

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

    /**
     * Solicita al usuario que ingrese un síntoma y devuelve la cadena introducida por el usuario.
     * @return La cadena que representa el síntoma ingresado por el usuario.
     */
    public String pedirSintoma() {
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

    /**
     * Solicita al usuario que describa un síntoma y devuelve la descripción introducida por el usuario.
     * @return La descripción del síntoma ingresada por el usuario.
     */
    public String pedirSDescripcion() {
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

    /**
     * Solicita al usuario que ingrese un valor de gravedad en una escala del 1 al 10 y devuelve el valor ingresado.
     * @return El valor de gravedad en una escala del 1 al 10 ingresado por el usuario.
     */
    public int pedirSGravedad() {
        System.out.println("Ingrese la gravedad en una escala del 1 al 10:");
        try {
            int gravity = scan.nextInt();
            scan.nextLine();
            if (gravity > 10 || gravity < 0) {
                System.out.println("Entre 1 - 10!");
                pedirSGravedad();
            } else {
                return gravity;
            }
        } catch (Exception e) {
            System.out.println(e);
            pedirSGravedad();
        }
        return 0;
    }

    /**
     * Solicita al usuario que ingrese la duración en minutos de una acción y devuelve el valor ingresado.
     * @return La duración en minutos de una acción ingresada por el usuario.
     */
    public int pedirSDuracion() {
        System.out.println("Ingrese la cantidad de minutos que duró: ");
        try {
            int duracion = scan.nextInt();
            scan.nextLine();
            if (duracion < 0) {
                System.out.println("No menos de 0");
                pedirSDuracion();
            } else {
                return duracion;
            }
        } catch (Exception e) {
            System.out.println(e);
            pedirSDuracion();
        }
        return 0;
    }

    /**
     * Solicita al usuario que describa una acción y devuelve la descripción ingresada por el usuario.
     * @return La descripción de una acción ingresada por el usuario.
     */
    public String pedirSAccion() {
        System.out.println("Describa la acción que tomó:");
        String accion = scan.nextLine();
        return accion;
    }

    /**
     * Solicita al usuario que ingrese el título de una reflexión y devuelve el título ingresado.
     * @return El título de la reflexión ingresado por el usuario.
     */
    public String pedirRTitulo() {
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

    /**
     * Solicita al usuario que ingrese una reflexión y devuelve la reflexión ingresada.
     * @return La reflexión ingresada por el usuario.
     */
    public String pedirREntrada() {
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

    /**
     * Solicita al usuario que seleccione una opción de inicio de sesión o creación de usuario en el programa contra adicciones.
     * @return Un entero que representa la opción seleccionada por el usuario (1 para iniciar sesión, 2 para crear usuario).
     */
    public int logIn() {
        System.out.println("--Programa Contra Adicciones--");
        System.out.println("\n1. Iniciar Sesión" +
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

    /**
     * Pide al usuario un correo electrónico y lo devuelve como una cadena.
     *
     * @return El correo electrónico ingresado por el usuario.
     */
    public String pedirCorreo() {
        System.out.println("Ingrese su correo: ");
        try {
            String correo = scan.nextLine();
            if (correo.contains("@")) {
                return correo;
            } else {
                System.out.println("Correo Invalido");
            }
        } catch (Exception e) {
            e.printStackTrace();
            pedirCorreo();
        }
        return "";
    }

    /**
     * Solicita al usuario que ingrese su contraseña y devuelve la contraseña ingresada.
     * @return La contraseña ingresada por el usuario.
     */
    public String pedirPassword() {
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

    /**
     * @return pide la edad
     */
    public int pedirEdad(){
        System.out.println("Ingrese su edad: ");
        try {
            int edad = scan.nextInt();
            scan.nextLine();
            if (edad>0) {
                return edad;
            }else{pedirEdad();}
        } catch (Exception e) {
            System.out.println(e);
            pedirEdad();
        }
        return 0;
    }

    /**
     * @return pide el sexo
     */
    public String pedirSexo(){
        System.out.println("Ingrese su sexo (Masculino o Femenino): ");
        try {
            String sexo = scan.nextLine().trim();
            return sexo;
        } catch (Exception e) {
            System.out.println(e);
            pedirSexo();
        }
        return "";
    }

    /**
     * @return pide la ciudad
     */
    public String pedirCiudad(){
        System.out.println("Ingrese su ciudad: ");
        try {
            String city = scan.nextLine().trim();
            return city;
        } catch (Exception e) {
            System.out.println(e);
            pedirCiudad();
        }
        return "";
    }

    /**
     * @return pide el intervalo de frecuencia de consumo
     */
    public String pedirFreq(){
        System.out.println("Ingrese un intervalo de frecuencia de consumo (Ej.: 2,5): ");
        System.out.println("\n Este se refiere a ingresar un día mínimo y uno máximo. Por ejemplo:");
        System.out.println("Si consume CocaCola de dos a tres días a la semana, entonces ingrese: ");
        System.out.println("2,3  De esta manera se podrá tener un registro de su consumo");
        try {
            String intervalo = scan.nextLine();

            try {
                String[] interv = intervalo.split(",");
                try {
                    int init = Integer.parseInt(interv[0]);
                    try {
                        int fin = Integer.parseInt(interv[1]);
                        int[] frequ = {init, fin};
                        System.out.println(frequ.toString());
                        return intervalo;
                    } catch (Exception e) {
                        e.printStackTrace();
                        pedirFreq();
                    }
                } catch (Exception e) {
                    System.out.println("Ingrese un número válido");
                    pedirFreq();
                }
            } catch (Exception e) {
                System.out.println("Separe los números con una coma");
                pedirFreq();
            }
        } catch (Exception e) {
            e.printStackTrace();
            pedirFreq();
        }
        return "";
    }

    public String pedirContacto(){
        System.out.println("Ingrese el nombre de su contacto: ");
        try {
            String nombre = scan.nextLine();
            return nombre;
        } catch (Exception e) {
            System.out.println("Ingreso invalido");
            pedirContacto();
        }
        return "";
    }

    public String pedirRelacion(){
        System.out.println("Ingrese el parentesco que tiene el contacto(madre, amigo, hermano): ");
        try {
            String par = scan.nextLine();
            return par;
        } catch (Exception e) {
            System.out.println("Ingreso invalido");
            pedirRelacion();
        }
        return "";
    }

    public int pedirNumero(){
        System.out.println("Ingrese el número de teléfono del contacto (8 dígitos sin espacio):");
        try {
            String num = scan.nextLine();
            scan.nextLine();
            if (num.length() == 8) {
                try {
                    int numInt = Integer.parseInt(num);
                    return numInt;
                } catch (Exception e) {
                    System.out.println("Ingrese una opción valida");
                    pedirNumero();
                }
            }else{
                System.out.println("Verifique que sean 8 dígitos");
                pedirNumero();
            }
        } catch (Exception e) {
            System.out.println("Ingreso inválido!");
            pedirNumero();
        }
        return 0;
    }


    /**
     * Pide al usuario una lista de objetivos y la devuelve en forma de ArrayList de
     * cadenas.
     *
     * @return Una lista de objetivos ingresados por el usuario.
     */

    public ArrayList<String> pedirObjetivos(){
        ArrayList<String> objetivos = new ArrayList<>();
        System.out.println("¿Cuántas metas desea cumplir?");
        try {
            int num = scan.nextInt();
            scan.nextLine();
            for (int i = 0; i < num; i++) {
                System.out.println("Ingrese una meta que quiera cumplir: ");
                try {
                    String objetivo = scan.nextLine().trim();
                    objetivos.add(objetivo);
                } catch (Exception e) {
                    System.out.println("Ingreso invalido");
                    pedirObjetivos();
                }
            }
            return objetivos;
        } catch (Exception e) {
            System.out.println("Ingreso inválido");
            pedirObjetivos();
        }
        return null;
    }
}
