package prueba3java.clases;

import prueba3java.clases.libro.Libro;
import prueba3java.clases.formaPago.IFormaDePago;
import java.util.*;

public final class Venta {
    private int folio;
    private int dia;
    private int mes;
    private int anio;
    private int total;
    private ArrayList<Libro> libros;
    private IFormaDePago pago;

    public Venta() {

    }

    public Venta(int folio, int dia, int mes, int anio, int total, ArrayList<Libro> libros, IFormaDePago formaDePago) {
        this.folio = folio;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.total = total;
        this.libros = libros;
        this.pago = formaDePago;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public void setPago(IFormaDePago pago) {
        this.pago = pago;
    }

    public int getAnio() {
        return this.anio;
    }

    public int getDia() {
        return this.dia;
    }

    public int getFolio() {
        return this.folio;
    }

    public int getMes() {
        return this.mes;
    }

    public int getTotal() {
        this.total = 0;

        for (Libro libro : this.libros) {
            this.total += libro.calcularSubTotal(libros);
        }

        return this.total;
    }

    public IFormaDePago getPago() {
        return pago;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void agregarLibro(Libro libro) {
        this.libros.add(libro);
    }

    public Libro buscarLibro(int indice) {
        return this.libros.get(indice);
    }
}
