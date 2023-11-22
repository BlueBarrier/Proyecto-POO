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
 * @version: 1.0.1
 * @lastUpdate: 08/10/2023
 * Cambios realizados: corrección de errores
 * 
 * 
 */

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
// import java.time.format.DateTimeFormatter;

public class Contador {
    private LocalDateTime diaInicio, diaActual;

    /**
     * Constructor para la clase Contador.
     *
     * @param diaInicio La fecha de inicio.
     */
    public Contador(LocalDateTime diaInicio) {
        this.diaInicio = diaInicio;
        this.diaActual = LocalDateTime.now();
    }

    /**
     * Devuelve la fecha de inicio.
     *
     * @return La fecha de inicio.
     */
    public LocalDateTime getDiaInicio() {
        return diaInicio;
    }

    /**
     * Establece la fecha de inicio.
     *
     * @param diaInicio La nueva fecha de inicio.
     */
    public void setDiaInicio(LocalDateTime diaInicio) {
        this.diaInicio = diaInicio;
    }

    /**
     * Devuelve la fecha actual.
     *
     * @return La fecha actual.
     */
    public LocalDateTime getDiaActual() {
        return diaActual;
    }

    /**
     * Establece la fecha actual.
     *
     * @param diaActual La nueva fecha actual.
     */
    public void setDiaActual(LocalDateTime diaActual) {
        this.diaActual = diaActual;
    }

    /**
     * Muestra los días sobrios.
     * Calcula la diferencia entre la fecha de inicio y la fecha actual en días.
     */
    public void mostrarDiasSobrio() {
        long diasSobrio = ChronoUnit.DAYS.between(diaInicio, diaActual);
        System.out.println("Días sobrios: " + diasSobrio);
    }


    
}
