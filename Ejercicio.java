/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencias de la Computación
 * Programación Orientada a Objetos
 * 
 * Clase para guardar los datos de la tabla Ejercicios de la base de datos ayuda
 * 
 * @author: Erick Barrera; Maria de Los Angeles; Luisa Jiménez
 * @version: 1.0.0
 */
public class Ejercicio {
    private int ID,Duracion, Repeticiones;
    private String Nombre, Descripcion, Pasos ;

    /**
     * Constructor de la clase Ejercicio
     * 
     * @param ID
     * @param Nombre
     * @param Descripcion
     * @param Pasos
     * @param Duracion
     * @param Repeticiones
     */
    public Ejercicio(int ID, String Nombre, String Descripcion, String Pasos, int Duracion, int Repeticiones){
        this.ID = ID;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Pasos = Pasos;
        this.Duracion = Duracion;
        this.Repeticiones = Repeticiones;
    }
    /**
     * @return ID
     */
    public int getID() {
        return ID;
    }
    /**
     * Establece el valor del ID.
     *
     * @param iD El nuevo valor del ID.
     */
    public void setID(int iD) {
        this.ID = iD;
    }

    /**
     * Devuelve el valor del nombre.
     *
     * @return El valor del nombre.
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * Establece el valor del nombre.
     *
     * @param nombre El nuevo valor del nombre.
     */
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    /**
     * Devuelve la descripción.
     *
     * @return La descripción.
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * Establece la descripción.
     *
     * @param descripcion La nueva descripción.
     */
    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
    }

    /**
     * Devuelve los pasos.
     *
     * @return Los pasos.
     */
    public String getPasos() {
        return Pasos;
    }

    /**
     * Establece los pasos.
     *
     * @param pasos Los nuevos pasos.
     */
    public void setPasos(String pasos) {
        this.Pasos = pasos;
    }

    /**
     * Devuelve la duración.
     *
     * @return La duración.
     */
    public int getDuracion() {
        return Duracion;
    }

    /**
     * Establece la duración.
     *
     * @param duracion La nueva duración.
     */
    public void setDuracion(int duracion) {
        this.Duracion = duracion;
    }

    /**
     * Devuelve las repeticiones.
     *
     * @return Las repeticiones.
     */
    public int getRepeticiones() {
        return Repeticiones;
    }

    /**
     * Establece las repeticiones.
     *
     * @param repeticiones Las nuevas repeticiones.
     */
    public void setRepeticiones(int repeticiones) {
        this.Repeticiones = repeticiones;
    }

}
