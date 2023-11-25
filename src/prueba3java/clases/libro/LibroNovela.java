package prueba3java.clases.libro;

import java.util.*;

public class LibroNovela extends Libro {

    private String autor;

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public int calcularSubTotal(ArrayList<Libro> others) {
        return (int) Math.round(super.calcularSubTotal(others) - (super.calcularSubTotal(others) * 0.05));
    }
}
