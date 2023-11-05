/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencias de la Computación
 * Programación Orientada a Objetos
 * 
 * Clase para registrar un sintoma a la base de datos
 * 
 * @author: Erick Barrera - 231238
 * @version: 1.0.3
 * 
 */
import java.time.LocalDateTime;
public class Sintoma {
    private String usuario, sintoma, descripcion, accion;
    private LocalDateTime fecha;
    private int gravedad, duracion;

    /**
     * constructor de la clase
     * 
     * @param usuario
     * @param sintoma
     * @param fecha
     * @param descripcion
     * @param gravedad
     * @param duracion
     * @param accion
     */
    public Sintoma(String usuario, String sintoma, LocalDateTime fecha, String descripcion, 
    int gravedad, int duracion, String accion){
        this.usuario = usuario;
        this.sintoma = sintoma;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.gravedad = gravedad;
        this.duracion = duracion;
        this.accion = accion;
    }

    // getters y setters
   /**
     *
     * @return usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     *
     * @param usuario 
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     *
     * @return sintoma
     */
    public String getSintoma() {
        return sintoma;
    }

    /**
     *
     * @param sintoma 
     */
    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    /**
     *
     * @return fecha.
     */
    public LocalDateTime getFecha() {
        return fecha;
    }

    /**
     *
     * @param fecha .
     */
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    /**
     *
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     *
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     *
     * @return gravedad
     */
    public int getGravedad() {
        return gravedad;
    }

    /**
     *
     * @param gravedad 
     */
    public void setGravedad(int gravedad) {
        this.gravedad = gravedad;
    }

    /**
     *
     * @return duracion
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     *
     * @param duracion 
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     *
     * @return accion
     */
    public String getAccion() {
        return accion;
    }

    /**
     *
     * @param accion 
     */
    public void setAccion(String accion) {
        this.accion = accion;
    }

}
