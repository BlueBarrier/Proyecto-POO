
public class Multimedia {
	private int ID;
	private String Titulo, URL;
        
	public Multimedia (int ID, String Titulo, String URL){
			this.ID = ID;
			this.Titulo=Titulo;
			this.URL = URL;       
	}

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	public String getTitulo() {
		return Titulo;
	}	
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}	

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}			
}
