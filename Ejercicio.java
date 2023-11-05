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
    public void setID(int iD) {
        this.ID = iD;
    }

    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
    }

    public String getPasos() {
        return Pasos;
    }
    public void setPasos(String pasos) {
        this.Pasos = pasos;
    }

    public int getDuracion() {
        return Duracion;
    }
    public void setDuracion(int duracion) {
        this.Duracion = duracion;
    }

    public int getRepeticiones() {
        return Repeticiones;
    }
    public void setRepeticiones(int repeticiones) {
        this.Repeticiones = repeticiones;
    }
}
