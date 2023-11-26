package prueba3java.clases.formaPago;

public final class PagoTarjeta implements iFormaDePago {
    private int monto;
    private String codigoAutorizacion;

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public void setCodigoAutorizacion(String codigoAutorizacion) {
        this.codigoAutorizacion = codigoAutorizacion;
    }

    public int getMonto() {
        return this.monto;
    }

    public String getCodigoAutorizacion() {
        return this.codigoAutorizacion;
    }

    @Override
    public int calcularComision() {
        return (int) Math.round((monto / 100) * 3.5);
    }

}
