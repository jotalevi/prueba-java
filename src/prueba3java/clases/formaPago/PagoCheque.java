package prueba3java.clases.formaPago;

public final class PagoCheque implements IFormaDePago {
    private int monto;
    private int numero;
    private int venta;

    public PagoCheque() {
    }

    public PagoCheque(int monto, int numero, int venta) {
        this.monto = monto;
        this.numero = numero;
        this.venta = venta;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setVenta(int venta) {
        this.venta = venta;
    }

    public int getMonto() {
        return this.monto;
    }

    public int getNumero() {
        return this.numero;
    }

    @Override
    public int getVenta() {
        return venta;
    }

    @Override
    public int calcularComision() {
        return (int) Math.round((monto / 100) * 5);
    }
}
