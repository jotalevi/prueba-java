package prueba3java.controller;

import prueba3java.clases.formaPago.IFormaDePago;
import prueba3java.clases.libro.Libro;
import prueba3java.clases.Venta;

public final class ControladorVentanaPrincipal {
    private String codigoLibro;
    private Venta venta;
    private Libro libro;
    private IFormaDePago formaDePago;

    public void setCodigoLibro(String codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public String getCodigoLibro() {
        return codigoLibro;
    }

    public void initVenta() {
        this.venta = new Venta();
        this.libro = null;
        this.formaDePago = null;
        this.codigoLibro = "";

    }

    public void cargarLibroFromCodigo() {

    }

    public void agregarLibroAVenta() {
        this.venta.agregarLibro(this.libro);
    }

    public void configFormaDePago() {

    }

    public void realizarVenta() {
    }
}