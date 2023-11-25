/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba3java;
import prueba3java.conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author neto
 */
public class Prueba3Java {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion pruebaConexion = new Conexion();
        
        // Obtener la conexión
        Connection conexion = pruebaConexion.getConexion();

        // Verificar si la conexión fue exitosa
        if (conexion != null) {
            System.out.println("¡Conexión exitosa!");

            // Realizar una consulta de prueba
            try {
                Statement statement = conexion.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM libro;");

                // Imprimir los resultados de la consulta
                while (resultSet.next()) {
                    
                    int columna1 = resultSet.getInt("codigo");
                    String columna2 = resultSet.getString("descripcion");
                   

                    System.out.println("Columna1: " + columna1 + ", Columna2: " + columna2);
                }

                // Cerrar recursos
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                System.err.println("Error al ejecutar la consulta: " + e.getMessage());
            }
        } else {
            System.out.println("Error al conectar a la base de datos.");
        }


        System.out.println("chupalo DJ");
    }

}
