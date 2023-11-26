package prueba3java.dao.iformadepago;

import java.util.ArrayList;

import prueba3java.clases.formaPago.IFormaDePago;
import prueba3java.clases.libro.Libro;

/**
 *
 * @author cetecom
 */
public interface IIFormaDePagoDao {
    public boolean save(IFormaDePago pago);

    public void update(IFormaDePago pago);

    public void delete(IFormaDePago pago);

    public IFormaDePago getFormaDePago(int folioVenta);
}
