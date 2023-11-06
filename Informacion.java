//************************************************************************
//Universidad del Valle de Guatemala
//Departamento de Ciencia de la Computación
//Autor: Marielos Ortiz, Luisa Jiménez, Erick Barrera
//Carné: 23882, 23011, 231238
//CC2008 - 50
//Fecha: Noviembre de 2023
//Descripción: Proyecto Final
//************************************************************************
import java.sql.*;
import java.util.ArrayList;

/**
 * La clase Informacion se encarga de interactuar con una base de datos SQLite
 * para leer y mostrar información sobre videos y artículos multimedia.
 */
public class Informacion {
    private static Connection connection = null;
    private ArrayList<Multimedia> videos = new ArrayList<>();
    private ArrayList<Multimedia> articulos = new ArrayList<>();
    ResultSet result = null;
    Statement state = null;

    /**
     * Lee datos de la base de datos multimedia y los almacena en las listas de
     * videos y artículos.
     */
    public void leerData() {
        String url = "jdbc:sqlite:./db/multimedia.db";
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);

            state = connection.createStatement();
            result = state.executeQuery("select * from Videos");

            videos.clear();

            while (result.next()) {
                videos.add(new Multimedia(result.getInt(1), result.getString(2), result.getString(3)));
            }

            result = state.executeQuery("select * from Articulos");
            articulos.clear();
            while (result.next()) {
                articulos.add(new Multimedia(result.getInt(1), result.getString(2), result.getString(3)));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (state != null) {
                    state.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Muestra la información de los artículos disponibles en la base de datos.
     */
    public void mostrarArticulo() {
        System.out.println("--Artículos disponibles--");
        for (Multimedia multimedia : articulos) {
            System.out.println("\nNombre: " + multimedia.getTitulo() +
                    "\n URL: " + multimedia.getURL());
        }
    }

    /**
     * Muestra la información de los videos disponibles en la base de datos.
     */
    public void mostrarMultimedia() {
        System.out.println("--Multimedia disponible--");
        System.out.println("Videos:");
        for (Multimedia multimedia : videos) {
            System.out.println("\nNombre: " + multimedia.getTitulo() +
                    "\n URL: " + multimedia.getURL());
        }
    }
}
