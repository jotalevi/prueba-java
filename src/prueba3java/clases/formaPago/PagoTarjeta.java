package prueba3java.clases.formaPago;

public final class PagoTarjeta implements IFormaDePago {
    private int monto;
    private String codigoAutorizacion;
    private int venta;

    public PagoTarjeta() {
    }

    public PagoTarjeta(int monto, String codigoAutorizacion, int venta) {
        this.monto = monto;
        this.codigoAutorizacion = codigoAutorizacion;
        this.venta = venta;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public void setCodigoAutorizacion(String codigoAutorizacion) {
        this.codigoAutorizacion = codigoAutorizacion;
    }

    public void setVenta(int venta) {
        this.venta = venta;
    }

    public int getMonto() {
        return this.monto;
    }

    public String getCodigoAutorizacion() {
        return this.codigoAutorizacion;
    }

    @Override
    public int getVenta() {
        return venta;
    }

    @Override
    public int calcularComision() {
        return (int) Math.round((monto / 100) * 3.5);
    }

    @Override
    public String getTipeStr() {
        return "Tarjeta";
    }

}
