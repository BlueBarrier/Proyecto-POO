import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {

    private String nombre;
    private String correo;
    private int edad;
    private String sexo;
    private String ciudad;
    private int[] frecuenciaConsumo;
    private ArrayList<String> objetivos;
    private ArrayList<String> reflexiones;
    private ArrayList<String> sintomas;
    private int diasSobrio;
    private Contador contador;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int[] getConsumo() {
        return frecuenciaConsumo;
    }

    public void setConsumo(int[] frecuenciaConsumo) {
        this.frecuenciaConsumo = frecuenciaConsumo;
    }

    public String[] getObjetivos() {
        return objetivos.toArray(new String[0]);
    }

    public void setObjetivos(String objetivo) {
        this.objetivos.add(objetivo);
    }

    public int getDiasSobrio() {
        return diasSobrio;
    }

    public void setDiasSobrio(int diasSobrio) {
        this.diasSobrio = diasSobrio;
    }

    public Usuario(Scanner scanner) {
        System.out.print("Nombre: ");
        this.nombre = scanner.nextLine();
        System.out.print("Correo: ");
        this.correo = scanner.nextLine();
        System.out.print("Edad: ");
        this.edad = scanner.nextInt();
        scanner.nextLine();
        this.sexo = scanner.nextLine();
        System.out.print("Ciudad: ");
        this.ciudad = scanner.nextLine();
        this.frecuenciaConsumo = new int[7];
        for (int i = 0; i < 7; i++) {
            System.out.print("Frecuencia de consumo para el día " + (i + 1) + ": ");
            this.frecuenciaConsumo[i] = scanner.nextInt();
        }
        this.objetivos = new ArrayList<>();
        this.reflexiones = new ArrayList<>();
        this.sintomas = new ArrayList<>();
        System.out.print("Días sobrio: ");
        this.diasSobrio = scanner.nextInt();
        scanner.nextLine();
        this.contador = new Contador();
    }
}