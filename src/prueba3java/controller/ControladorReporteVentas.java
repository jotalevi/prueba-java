package prueba3java.controller;

import java.util.*;
import prueba3java.clases.Venta;

public final class ControladorReporteVentas {
    private int dia;
    private int mes;
    private int anio;
    private ArrayList<Venta> ventas;

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setVentas(ArrayList<Venta> ventas) {
        this.ventas = ventas;
    }

    public int getAnio() {
        return anio;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public void cargarPorFecha() {
    }

    public void mostrarLibro(int indexLibro) {

    }

}
