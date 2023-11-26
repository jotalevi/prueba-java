package prueba3java.dao.iformadepago;

import prueba3java.clases.formaPago.IFormaDePago;

public interface IIFormaDePagoDao {
    public boolean save(IFormaDePago pago);

    public void update(IFormaDePago pago);

    public void delete(IFormaDePago pago);

    public IFormaDePago getFormaDePago(int folioVenta);
}
