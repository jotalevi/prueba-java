package prueba3java.dao.venta;

import java.util.ArrayList;

import prueba3java.clases.Venta;

public interface IVentaDao {
    public boolean save(Venta venta);

    public void update(Venta venta);

    public void delete(Venta venta);

    public Venta getVenta(int folio);

    public ArrayList<Venta> getAllVentas();

}
