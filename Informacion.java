import java.sql.*;
import java.util.ArrayList;


public class Informacion{
    private static Connection connection = null;
    private ArrayList<Multimedia> videos = new ArrayList<>();
    private ArrayList<Multimedia> articulos = new ArrayList<>();
    ResultSet result;
    int fila, col;
    

    public void leerData(){
        String url = "jdbc:sqlite:./db/multimedia.db";
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            
            Statement state = connection.createStatement();
            result = state.executeQuery("select * from Videos");

            videos.clear();
            
            while (result.next()) {
                videos.add(new Multimedia(result.getInt(1),result.getString(2), result.getString(3)));
            }

            result = state.executeQuery("select * from Articulos");
            articulos.clear();  
            while (result.next()) {
                articulos.add(new Multimedia(result.getInt(1),result.getString(2), result.getString(3)));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void mostrarArticulo(){
        
        System.out.println("--Artículos disponibles--");
        for (Multimedia multimedia : articulos) {
            System.out.println("\nNombre: "+multimedia.getTitulo()+
                            "\n URL: "+multimedia.getURL());
        }
    }
    public void mostrarMultimedia(){
        
        System.out.println("--Multimedia disponible--");
        System.out.println("Videos:");
        for (Multimedia multimedia : videos) {
            System.out.println("\nNombre: "+multimedia.getTitulo()+
                            "\n URL: "+multimedia.getURL());
        }
    }
    
        
    
  
}