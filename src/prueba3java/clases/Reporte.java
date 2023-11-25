package prueba3java.clases;

import java.util.*;

public final class Reporte {
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
}
