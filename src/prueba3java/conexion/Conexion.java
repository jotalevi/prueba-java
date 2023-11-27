/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba3java.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andre
 */
public class Conexion {
    private static Connection conn = null;

    public static Connection conectarBD(String miBD) {
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbUri = "jdbc:mysql://database-java-3.cprhkixavenx.us-east-1.rds.amazonaws.com:3306/" + miBD;
        String dbUser = "root";
        String dbPass = "F4XC14C0";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion.conn = DriverManager.getConnection(dbUri, dbUser, dbPass);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public static Connection getConnection(String miDB) {
        if (Conexion.conn == null) {
            Conexion.conectarBD(miDB);
        }

        return Conexion.conn;
    }

}
