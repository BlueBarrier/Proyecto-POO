/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencias de la Computación
 * Programación Orientada a Objetos
 * 
 * Clase Habito: clase que almacena los hábitos del usuario, le asigna nuevos habitos
 * y gradualmente va cambiando los malos hábitos del usuario por unos buenos.
 * 
 * @author: Erick Barrera - 231238
 * @date: 08/10/2023
 * @version: 1.0.0
 * @lastUpdate: 08/10/2023
 * Cambios realizados: --
 * 
 * 
 */
import java.util.ArrayList;
public class Habito {
    private Usuario usuario;
    private ArrayList<String> habitosNuevos, habitosUsuario;
    
    /**
     * @param habitosNuevos
     * @param habitosUsuario
     * @param usuario
     */
    public Habito(ArrayList<String> habitosNuevos, ArrayList<String> habitosUsuario, Usuario usuario){
        this.habitosUsuario = habitosUsuario;
        this.habitosNuevos = habitosNuevos;
        this.usuario = usuario;
    }
// Getters y Setters
    /**
     * @return habitosNuevos
     */
    public ArrayList<String> getHabitosNuevos() {
        return habitosNuevos;
    }
    /**
     * @param habitosNuevos
     */
    public void setHabitosNuevos(ArrayList<String> habitosNuevos) {
        this.habitosNuevos = habitosNuevos;
    }

    /**
     * @return habitosUsuario
     */
    public ArrayList<String> getHabitosUsuario() {
        return habitosUsuario;
    }
    /**
     * @param habitosUsuario
     */
    public void setHabitosUsuario(ArrayList<String> habitosUsuario) {
        this.habitosUsuario = habitosUsuario;
    }

    /**
     * @return usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }
    /**
     * @param usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Funcionalidades

    public void reemplazarHabitos(){

    }
    
    public void analizarHabitos(){

    }

}
