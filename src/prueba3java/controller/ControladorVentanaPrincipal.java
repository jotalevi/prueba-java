package prueba3java.controller;

import prueba3java.clases.formaPago.IFormaDePago;
import prueba3java.clases.formaPago.PagoCheque;
import prueba3java.clases.formaPago.PagoTarjeta;
import prueba3java.clases.libro.Libro;
import prueba3java.dao.iformadepago.IFormaDePagoDao;
import prueba3java.dao.libro.LibroDao;
import prueba3java.dao.venta.VentaDao;
import prueba3java.clases.Venta;

public final class ControladorVentanaPrincipal {
    private Venta venta;
    private Libro libro;
    private IFormaDePago formaDePago;

    public Venta getVenta() {
        return venta;
    }

    public ControladorVentanaPrincipal() {
        initVenta();
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;

    }

    public void initVenta() {
        this.venta = new Venta();
        this.libro = null;
        this.formaDePago = null;
    }

    public void cargarLibroFromCodigo(String codigo, boolean isNovela) {
        LibroDao libroDao = new LibroDao();
        this.libro = libroDao.getLibro(codigo, isNovela);
        if (this.libro != null) {
            this.libro.setCantidad(0);
        }
    }

    public void agregarLibroAVenta() {
        this.venta.agregarLibro(this.libro);
        this.libro = null;
    }

    public void configVenta(int dia, int mes, int anio, int folio) {
        this.venta.setDia(dia);
        this.venta.setAnio(anio);
        this.venta.setFolio(folio);
        this.venta.setMes(mes);
        this.venta.setPago(this.formaDePago);
    }

    public void configFormaDePago(String tipo, String numeroOAuth) {
        IFormaDePago pago = null;
        if (tipo.equals("Cheque")) {
            pago = new PagoCheque(venta.getTotal(), Integer.parseInt(numeroOAuth), this.venta.getFolio());
        } else {
            pago = new PagoTarjeta(venta.getTotal(), numeroOAuth, this.venta.getFolio());
        }

        this.formaDePago = pago;
        this.venta.setPago(pago);
    }

    public void realizarVenta() {
        VentaDao ventasDao = new VentaDao();
        LibroDao librosDao = new LibroDao();
        IFormaDePagoDao pagosDao = new IFormaDePagoDao();
        int folio = this.venta.getFolio();

        ventasDao.save(this.venta);

        this.formaDePago.setVenta(folio);
        pagosDao.save(this.formaDePago);

        for (Libro l : this.venta.getLibros()) {
            l.setCodigo(l.getCodigo() + "" + folio);
            l.setVenta(folio);
            librosDao.save(l);
        }

        this.initVenta();
    }
}