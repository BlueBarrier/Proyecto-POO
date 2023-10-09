/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencias de la Computación
 * Programación Orientada a Objetos
 * 
 * Clase Usuario: clase que almacena los datos de un usuario.
 * 
 * @author: Luisa Jiménez - 23011, Erick Barrera - 231238
 * @date: 08/10/2023
 * @version: 1.0.2
 * @lastUpdate: 09/10/2023
 * Cambios realizados: correción de errores y cambios a atributos
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;
public class Usuario {

    private String nombre, correo, password, sexo, ciudad;
    private int edad, diasSobrio;
    private int[] frecuenciaConsumo;
    private ArrayList<String> objetivos, reflexiones, sintomas;
    private HashMap<String, String> contactosEmergencia;
    private Contador contador;
    private Habito habitos;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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

    public int[] getFrecuenciaConsumo() {
        return frecuenciaConsumo;
    }
    public void setFrecuenciaConsumo(int[] frecuenciaConsumo) {
        this.frecuenciaConsumo = frecuenciaConsumo;
    }

    public ArrayList<String> getObjetivos() {
        return objetivos;
    }
    public void setObjetivos(ArrayList<String> objetivos) {
        this.objetivos = objetivos;
    }

    public Habito getHabitos() {
        return habitos;
    }
    public void setHabitos(Habito habitos) {
        this.habitos = habitos;
    }

    public HashMap<String, String> getContactosEmergencia() {
        return contactosEmergencia;
    }
    public void setContactosEmergencia(HashMap<String, String> contactosEmergencia) {
        this.contactosEmergencia = contactosEmergencia;
    }

    public ArrayList<String> getSintomas() {
        return sintomas;
    }
    public void setSintomas(ArrayList<String> sintomas) {
        this.sintomas = sintomas;
    }

    public ArrayList<String> getReflexiones() {
        return reflexiones;
    }
    public void setReflexiones(ArrayList<String> reflexiones) {
        this.reflexiones = reflexiones;
    }

    public int getDiasSobrio() {
        return diasSobrio;
    }
    public void setDiasSobrio(int diasSobrio) {
        this.diasSobrio = diasSobrio;
    }

    public Contador getContador() {
        return contador;
    }
    public void setContador(Contador contador) {
        this.contador = contador;
    }

    public Usuario(String nombre, String correo, String password, int edad, String sexo, String ciudad, int[] frecuenciaConsumo, 
    ArrayList<String> objetivos, HashMap<String, String> contactosEmergencia, ArrayList<String> reflexiones, ArrayList<String> sintomas,
     int diasSobrio, Contador contador, Habito habitos) {
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.edad = edad;
        this.sexo = sexo;
        this.ciudad = ciudad;
        this.frecuenciaConsumo = frecuenciaConsumo;
        this.objetivos = objetivos;
        this.habitos = habitos;
        this.contactosEmergencia = contactosEmergencia;
        this.reflexiones = reflexiones;
        this.sintomas = sintomas;
        this.diasSobrio = diasSobrio;
        this.contador = contador;
    }
}