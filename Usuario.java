/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencias de la Computación
 * Programación Orientada a Objetos
 * 
 * Clase Usuario: clase que almacena los datos de un usuario.
 * 
 * @author: Luisa Jiménez - 23011, Erick Barrera - 231238
 * @date: 08/10/2023
 * @version: 1.0.3
 * @lastUpdate: 09/10/2023
 * Cambios realizados: eliminación atributo diasSobrio
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;
public class Usuario {

    private String nombre, correo, password, sexo, ciudad;
    private int edad;
    private int[] frecuenciaConsumo;
    private ArrayList<String> objetivos, reflexiones, sintomas;
    private HashMap<String, String> contactosEmergencia;
    private Contador contador;
    private Habito habitos;

    /**
     * Obtiene el nombre del usuario.
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     * @param nombre El nuevo nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     * @return El correo electrónico del usuario.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del usuario.
     * @param correo El nuevo correo electrónico del usuario.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene la contraseña del usuario.
     * @return La contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del usuario.
     * @param password La nueva contraseña del usuario.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Obtiene la edad del usuario.
     * @return La edad del usuario.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad del usuario.
     * @param edad La nueva edad del usuario.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Obtiene el género del usuario.
     * @return El género del usuario.
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Establece el género del usuario.
     * @param sexo El nuevo género del usuario.
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * Obtiene la ciudad de residencia del usuario.
     * @return La ciudad de residencia del usuario.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad de residencia del usuario.
     * @param ciudad La nueva ciudad de residencia del usuario.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene la frecuencia de consumo de sustancias del usuario.
     * @return La frecuencia de consumo de sustancias del usuario.
     */
    public int[] getFrecuenciaConsumo() {
        return frecuenciaConsumo;
    }

    /**
     * Establece la frecuencia de consumo de sustancias del usuario.
     * @param frecuenciaConsumo La nueva frecuencia de consumo de sustancias del usuario.
     */
    public void setFrecuenciaConsumo(int[] frecuenciaConsumo) {
        this.frecuenciaConsumo = frecuenciaConsumo;
    }

    /**
     * Obtiene la lista de objetivos personales del usuario.
     * @return La lista de objetivos personales del usuario.
     */
    public ArrayList<String> getObjetivos() {
        return objetivos;
    }

    /**
     * Establece la lista de objetivos personales del usuario.
     * @param objetivos La nueva lista de objetivos personales del usuario.
     */
    public void setObjetivos(ArrayList<String> objetivos) {
        this.objetivos = objetivos;
    }

    /**
     * Obtiene los hábitos del usuario.
     * @return Los hábitos del usuario.
     */
    public Habito getHabitos() {
        return habitos;
    }

    /**
     * Establece los hábitos del usuario.
     * @param habitos Los nuevos hábitos del usuario.
     */
    public void setHabitos(Habito habitos) {
        this.habitos = habitos;
    }

    /**
     * Obtiene los contactos de emergencia del usuario.
     * @return Los contactos de emergencia del usuario.
     */
    public HashMap<String, String> getContactosEmergencia() {
        return contactosEmergencia;
    }

    /**
     * Establece los contactos de emergencia del usuario.
     * @param contactosEmergencia Los nuevos contactos de emergencia del usuario.
     */
    public void setContactosEmergencia(HashMap<String, String> contactosEmergencia) {
        this.contactosEmergencia = contactosEmergencia;
    }

    /**
     * Obtiene los síntomas registrados por el usuario.
     * @return Los síntomas registrados por el usuario.
     */
    public ArrayList<String> getSintomas() {
        return sintomas;
    }

    /**
     * Establece los síntomas registrados por el usuario.
     * @param sintomas Los nuevos síntomas registrados por el usuario.
     */
    public void setSintomas(ArrayList<String> sintomas) {
        this.sintomas = sintomas;
    }

    /**
     * Obtiene las reflexiones registradas por el usuario.
     * @return Las reflexiones registradas por el usuario.
     */
    public ArrayList<String> getReflexiones() {
        return reflexiones;
    }

    /**
     * Establece las reflexiones registradas por el usuario.
     * @param reflexiones Las nuevas reflexiones registradas por el usuario.
     */
    public void setReflexiones(ArrayList<String> reflexiones) {
        this.reflexiones = reflexiones;
    }

    /**
     * Obtiene el contador de días sobrios del usuario.
     * @return El contador de días sobrios del usuario.
     */
    public Contador getContador() {
        return contador;
    }

    /**
     * Establece el contador de días sobrios del usuario.
     * @param contador El nuevo contador de días sobrios del usuario.
     */
    public void setContador(Contador contador) {
        this.contador = contador;
    }

    /**
     * @param nombre
     * @param correo
     * @param password
     * @param edad
     * @param sexo
     * @param ciudad
     * @param frecuenciaConsumo
     * @param objetivos
     * @param contactosEmergencia
     * @param reflexiones
     * @param sintomas
     * @param contador
     * @param habitos
     */
    public Usuario(String nombre, String correo, String password, int edad, String sexo, String ciudad, int[] frecuenciaConsumo, 
    ArrayList<String> objetivos, HashMap<String, String> contactosEmergencia, ArrayList<String> reflexiones, ArrayList<String> sintomas,
    Contador contador, Habito habitos) {
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
        this.contador = contador;
    }
}