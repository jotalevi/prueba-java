package prueba3java.clases;

import prueba3java.clases.libro.Libro;
import java.util.*;

public final class Venta {
    private int folio;
    private int dia;
    private int mes;
    private int anio;
    private int total;
    private ArrayList<Libro> libros;

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
        return this.total;
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
