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
 * @version: 1.0.1
 * @lastUpdate: 09/10/2023
 * Cambios realizados: finalización de funcionalidades y correción de atributos
 * 
 * 
 */
import java.util.ArrayList;
import java.util.Arrays;
public class Habito {
    private EntradaDatosTemp entrada = new EntradaDatosTemp(); // temporal 
    private Usuario usuario;
    private ArrayList<String> habitosNuevos, habitosUsuario, habitosReemplazar;
    private ArrayList<String> palabrasClaveSaludables = new ArrayList<>(Arrays.asList(
            "ejercicio", "alimentación", "hidratación", "sueño", "meditación",
            "gratitud", "lectura", "aprender", "socialización", "familia"
        ));
    private ArrayList<String> palabrasClavePerjudiciales = new ArrayList<>(Arrays.asList(
        "alcohol", "drogas", "tabaco", "comida chatarra", "sedentarismo",
        "insomnio", "pantallas", "cafeína", "aislamiento", "rumiación", "CocaCola", "seguido", "En exceso"
    ));
    private ArrayList<String> objetivosChunked;
    
    
    
    /**
     * @param habitosNuevos
     * @param habitosUsuario
     * @param usuario
     * @param objetivosChunked
     * @param habitosReemplazar
     */
    public Habito(ArrayList<String> habitosNuevos, ArrayList<String> habitosUsuario, Usuario usuario, ArrayList<String> objetivosChunked, ArrayList<String> habitosReemplazar){
        this.habitosUsuario = habitosUsuario;
        this.habitosNuevos = habitosNuevos;
        this.usuario = usuario;
        this.objetivosChunked = objetivosChunked;
        this.habitosReemplazar = habitosReemplazar;
        
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
    public ArrayList<String> getHabitosReemplazar() {
        return habitosReemplazar;
    }
    public void setHabitosReemplazar(ArrayList<String> habitosReemplazar) {
        this.habitosReemplazar = habitosReemplazar;
    }
    public ArrayList<String> getObjetivosChunked() {
        return objetivosChunked;
    }
    public void setObjetivosChunked(ArrayList<String> objetivosChunked) {
        this.objetivosChunked = objetivosChunked;
    }
    public ArrayList<String> getPalabrasClavePerjudiciales() {
        return palabrasClavePerjudiciales;
    }
    public ArrayList<String> getPalabrasClaveSaludables() {
        return palabrasClaveSaludables;
    }

    // Funcionalidades

    /**
     * función para agregar los nuevos habitos del usuario
     */
    public void reemplazarHabitos(){
        ArrayList<ArrayList<String>> habitosSorted = analizarHabitos();
        habitosReemplazar = habitosSorted.get(1);
        ArrayList<String> habitosMantener = habitosSorted.get(0);

        habitosNuevos.addAll(habitosMantener);
        habitosNuevos.addAll(objetivosChunked);
    }

    /**
     * @return lista de habitos buenos y malos del usuario
     */
    public ArrayList<ArrayList<String>> analizarHabitos(){
        ArrayList<String> habitosSaludablesEncontrados = new ArrayList<>();
        ArrayList<String> habitosPerjudicialesEncontrados = new ArrayList<>();
        for (String  habito : habitosUsuario) {
            if (palabrasClaveSaludables.contains(habito)) {
                habitosSaludablesEncontrados.add(habito);
            } else if(palabrasClavePerjudiciales.contains(habito)){
                habitosPerjudicialesEncontrados.add(habito);
            }
        }
        return new ArrayList<>(Arrays.asList(habitosSaludablesEncontrados, habitosPerjudicialesEncontrados));
    }

    /**
     * función para crear habitos en relación a los objetivos del usuario
     */
    public void chunkingObjetivos(){
        for (String objetivo : usuario.getObjetivos()) {
            System.out.println("\n Piensa en los recursos que necesitas para lograr este objetivo\n");
            System.out.printf("\nGenial!! ahora: ¿Cómo puedes dividir este objetivo (%s) en subobjetivos más específicos y realistas? ",objetivo );
            ArrayList<String> subObjetivos = entrada.pedirSubObjetivos(); // solicitud de data
            for (String subObjetivo : subObjetivos) {
                System.out.printf("\n¿Qué acciones concretas vas a realizar para poder realizar (%s) (se concret@)?", subObjetivo);
                ArrayList<String> tempAcciones = entrada.pedirAcciones(); // solicitud de data
                objetivosChunked.addAll(tempAcciones);
            }
        }
    }
}
