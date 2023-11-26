/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba3java.crud;
import prueba3java.conexion.Conexion;
import prueba3java.clases.libro.LibroNovela;
import prueba3java.clases.libro.Libro;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author andre
 */
public class CrudLibro {
      public LibroNovela buscar(String codigo) {
        Statement stmt;
        ResultSet rs;
        Conexion con= new Conexion();
        Connection conn=con.conectarBD("libreria");
        LibroNovela pro=new LibroNovela();
        try {
            stmt = conn.createStatement(); 
            rs = stmt.executeQuery("select descripcion from profesion where cod_pro="+codigo);
            if (rs.next()) {
                pro.setCodigo(codigo);
                pro.setDescripcion(rs.getString(1));
            }
            rs.close(); 
            stmt.close(); 
            return pro;
        } catch (SQLException ex) {
            return null;
        }
    }  
    
}
