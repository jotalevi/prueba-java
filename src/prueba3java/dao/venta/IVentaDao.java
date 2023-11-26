package prueba3java.dao.venta;

import java.util.ArrayList;
import java.util.List;

import prueba3java.clases.Venta;
import prueba3java.clases.libro.Libro;

/**
 *
 * @author cetecom
 */
public interface IVentaDao {
    public boolean save(Venta venta);

    public void update(Venta venta);

    public void delete(Venta venta);

    public Venta getVenta(int folio);

    public ArrayList<Venta> getAllVentas();

}
