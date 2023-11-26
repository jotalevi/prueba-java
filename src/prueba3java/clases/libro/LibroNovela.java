package prueba3java.clases.libro;

import java.util.*;

import prueba3java.clases.Venta;

public final class LibroNovela extends Libro {

    private String autor;

    public LibroNovela() {
    }

    public LibroNovela(String codigo, String descripcion, int paginas, int cantidad, int precio, int venta,
            String autor) {
        super.setCodigo(codigo);
        super.setDescripcion(descripcion);
        super.setPaginas(paginas);
        super.setCantidad(cantidad);
        super.setPrecio(precio);
        super.setVenta(venta);
        this.autor = autor;
    }

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
