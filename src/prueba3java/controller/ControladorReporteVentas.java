package prueba3java.controller;

import java.util.*;
import prueba3java.clases.Venta;
import prueba3java.dao.venta.VentaDao;

public final class ControladorReporteVentas {
    private int dia = 1;
    private int mes = 1;
    private int anio = 2020;
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

    public Venta getVenta(int index) {
        return this.ventas.get(index);
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public void cargarPorFecha() {
        VentaDao ventasDao = new VentaDao();
        this.ventas = ventasDao.getByDate(this.dia, this.mes, this.anio);
    }
}
