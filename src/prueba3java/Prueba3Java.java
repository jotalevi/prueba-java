/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba3java;

import prueba3java.conexion.Conexion;
import prueba3java.interfaz.Interfaz;

/**
 *
 * @author neto
 */
public class Prueba3Java {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion.conectarBD("libreria");
        Interfaz.main(args);
    }
}
