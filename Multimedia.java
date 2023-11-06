/**
 * La clase Multimedia representa un objeto multimedia con un identificador,
 * título y URL.
 */
public class Multimedia {
	// Atributos
	private int ID;
	private String Titulo, URL;

	/**
	 * Constructor para crear un objeto Multimedia con ID, título y URL.
	 *
	 * @param ID     El identificador único del multimedia.
	 * @param Titulo El título del multimedia.
	 * @param URL    La URL del multimedia.
	 */
	public Multimedia(int ID, String Titulo, String URL) {
		this.ID = ID;
		this.Titulo = Titulo;
		this.URL = URL;
	}

	/**
	 * Obtiene el identificador del multimedia.
	 *
	 * @return El identificador del multimedia.
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Establece el identificador del multimedia.
	 *
	 * @param iD El nuevo identificador del multimedia.
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * Obtiene el título del multimedia.
	 *
	 * @return El título del multimedia.
	 */
	public String getTitulo() {
		return Titulo;
	}

	/**
	 * Establece el título del multimedia.
	 *
	 * @param titulo El nuevo título del multimedia.
	 */
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	/**
	 * Obtiene la URL del multimedia.
	 *
	 * @return La URL del multimedia.
	 */
	public String getURL() {
		return URL;
	}

	/**
	 * Establece la URL del multimedia.
	 *
	 * @param uRL La nueva URL del multimedia.
	 */
	public void setURL(String uRL) {
		URL = uRL;
	}
}
