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

    public Contacto(String usuario, String nombre, String relacion, int numero){
        this.usuario = usuario;
        this.nombre = nombre;
        this.relacion =relacion;
        this.numero = numero;
    } 
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRelacion() {
        return relacion;
    }
    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

}
