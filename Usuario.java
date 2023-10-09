/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencias de la Computación
 * Programación Orientada a Objetos
 * 
 * Clase Habito: clase que almacena los hábitos del usuario, le asigna nuevos habitos
 * y gradualmente va cambiando los malos hábitos del usuario por unos buenos.
 * 
 * @author: Luisa Jiménez - 23011, Erick Barrera - 231238
 * @date: 08/10/2023
 * @version: 1.0.1
 * @lastUpdate: 08/10/2023
 * Cambios realizados: corrección de errores
 * 
 */

import java.util.ArrayList;
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
    private Habito habito;

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

    public Usuario(String nombre, int edad, String sexo, String ciudad, int[] frecuenciaConsumo, ArrayList<String> objetivos, int diasSobrio, Contador contador, Habito habito) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.ciudad = ciudad;
        this.frecuenciaConsumo = frecuenciaConsumo;
        this.objetivos = objetivos;
        this.diasSobrio = diasSobrio;
        this.contador = contador;
        this.habito = habito;
    }
}