package prueba3java.clases.libro;

import java.util.*;

public abstract class Libro {
    private String codigo;
    private String descripcion;
    private int paginas;
    private int cantidad;
    private int precio;

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPaginas() {
        return paginas;
    }

    public int getPrecio() {
        return precio;
    }

    public int calcularSubTotal(ArrayList<Libro> others) {
        return this.precio * this.cantidad;
    }
}
