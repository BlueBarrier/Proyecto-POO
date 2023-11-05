/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencias de la Computación
 * Programación Orientada a Objetos
 * 
 * Clase para guardar los datos de las tablas Consejos y Quotes de la base de datos ayuda
 * 
 * @author: Erick Barrera; Maria de Los Angeles; Luisa Jiménez
 * @version: 1.0.0
 */

public class Phrase {
    private int ID;
    private String phrase;

    /**
     * Constructor de la clase Phrase
     * 
     * @param ID
     * @param phrase
     */
    public Phrase(int ID, String phrase){
        this.ID = ID;
        this.phrase = phrase;
    }
// Getters y Setters
    /**
     * @return ID
     */
    public int getID() {
        return ID;
    }
    /**
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return Phrase
     */
    public String getFrase() {
        return phrase;
    }
    /**
     * @param phrase
     */
    public void setFrase(String phrase) {
        this.phrase = phrase;
    }
}
