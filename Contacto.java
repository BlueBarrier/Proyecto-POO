/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencias de la Computación
 * Programación Orientada a Objetos
 * 
 * Clase para guardar los datos de los contactos de ayuda  
 * @author: Erick Barrera; Maria de Los Angeles; Luisa Jiménez
 * @version: 1.0.0
 */
public class Contacto {
    private int numero;
    private String usuario, nombre,relacion;

    /**
     * constructor de contactos
     * 
     * 
     * @param usuario
     * @param nombre
     * @param relacion
     * @param numero
     */
    public Contacto(String usuario, String nombre, String relacion, int numero){
        this.usuario = usuario;
        this.nombre = nombre;
        this.relacion =relacion;
        this.numero = numero;
    } 
    /**
     * Devuelve el valor del usuario.
     *
     * @return El valor del usuario.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el valor del usuario.
     *
     * @param usuario El nuevo valor del usuario.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Devuelve el valor del nombre.
     *
     * @return El valor del nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el valor del nombre.
     *
     * @param nombre El nuevo valor del nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el valor del número.
     *
     * @return El valor del número.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Establece el valor del número.
     *
     * @param numero El nuevo valor del número.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Devuelve el valor de la relación.
     *
     * @return El valor de la relación.
     */
    public String getRelacion() {
        return relacion;
    }

    /**
     * Establece el valor de la relación.
     *
     * @param relacion El nuevo valor de la relación.
     */
    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }


}
