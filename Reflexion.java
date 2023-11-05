/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencias de la Computación
 * Programación Orientada a Objetos
 * 
 * Clase para almacenar las reflexiones del usuario
 * 
 * @author: Erick Barrera 
 * @version: 1.0.3
 * 
 */
import java.time.LocalDateTime;
public class Reflexion {
    private LocalDateTime fecha;
    private String titulo, entrada;

    /**
     * @param fecha
     * @param titulo
     * @param entrada
     */
    public Reflexion(LocalDateTime fecha, String titulo, String entrada){
        this.fecha = fecha;
        this.titulo = titulo;
        this.entrada = entrada;
    }
// getters y setters
    /**
     * @return fecha
     */
    public LocalDateTime getFecha() {
        return fecha;
    }
    /**
     * @param fecha
     */
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    /**
     * @return entrada
     */
    public String getEntrada() {
        return entrada;
    }
    /**
     * @param entrada
     */
    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    /**
     * @return titulo
     */
    public String getTitulo() {
        return titulo;
    }
    /**
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
