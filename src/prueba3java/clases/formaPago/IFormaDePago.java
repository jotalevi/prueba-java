package prueba3java.clases.formaPago;

public interface IFormaDePago {

    public int calcularComision();

    public int getMonto();

    public void setMonto(int monto);

    public int getVenta();

    public void setVenta(int venta);

    public String getTipeStr();
}
