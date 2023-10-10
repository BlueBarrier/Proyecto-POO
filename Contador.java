/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencias de la Computación
 * Programación Orientada a Objetos
 * 
 * Clase Contador: clase que contará los días que lleva sobrio el usuario mediante un cálculo desde el día que inició el 
 * programa hasta la fecha.
 * 
 * @author: María Ortiz - 23882, Erick Barrera - 231238
 * @date: 08/10/2023
 * @version: 1.0.0
 * @lastUpdate: 08/10/2023
 * Cambios realizados: --
 * 
 * 
 */

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
// import java.time.format.DateTimeFormatter;

public class Contador {
    private Usuario usuario;
    private LocalDateTime diaInicio, diaActual;

    public Contador(Usuario usuario, LocalDateTime diaInicio) {
        this.usuario = usuario;
        this.diaInicio = diaInicio;
        this.diaActual = LocalDateTime.now();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario (Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getdiaInicio() {
        return diaInicio;
    }

    public void setDiaInicio(LocalDateTime diaInicio) {
        this.diaInicio = diaInicio;
    }

    public LocalDateTime getDiaActual() {
        return diaActual;
    }

    public void setDiaActual(LocalDateTime diaActual) {
        this.diaActual = diaActual;
    }

    public void mostrarDiasSobrio() {
        long diasSobrio = ChronoUnit.DAYS.between(diaInicio, diaActual);
        System.out.println("Días sobrios: " + diasSobrio);
    }

    
}
