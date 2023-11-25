package prueba3java.clases.formaPago;

public class PagoCheque implements iFormaDePago {
    private int monto;
    private int numero;

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getMonto() {
        return this.monto;
    }

    public int getCodigoAutorizacion() {
        return this.numero;
    }

    @Override
    public int calcularComision() {
        return (int) Math.round((monto / 100) * 5);
    }
}
