package prueba3java.dao.venta;

import java.sql.*;
import java.util.ArrayList;

import prueba3java.clases.Venta;
import prueba3java.conexion.Conexion;
import prueba3java.dao.iformadepago.IFormaDePagoDao;
import prueba3java.dao.libro.LibroDao;

public class VentaDao implements IVentaDao {
    private Connection conexion = null;

    public VentaDao() {
        this.conexion = Conexion.conectarBD("libreria");
    }

    @Override
    public boolean save(Venta venta) {
        try {
            String qry = "INSERT INTO VENTA (" +
                    venta.getFolio() + ", " +
                    venta.getDia() + ", " +
                    venta.getMes() + ", " +
                    venta.getAnio() + ", " +
                    venta.getTotal() + ")";

            Statement stm = conexion.createStatement();
            stm.execute(qry);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public void update(Venta venta) {
        try {
            /*
             * folio NUMBER PRIMARY KEY,
             * dia NUMBER NOT NULL,
             * mes NUMBER NOT NULL,
             * anio NUMBER NOT NULL,
             * total NUMBER NOT NULL
             */
            String qry = "UPDATE VENTA SET " +
                    "dia = " + venta.getDia() + ", " +
                    "mes = " + venta.getMes() + ", " +
                    "anio = " + venta.getAnio() + ", " +
                    "total = " + venta.getTotal() + ", " +
                    "WHERE folio=" + venta.getFolio();

            Statement stm = conexion.createStatement();
            stm.executeUpdate(qry);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Venta getVenta(int folio) {
        Venta venta = null;
        try {
            String qry = "SELECT * FROM VENTA WHERE folio='" + folio + "'";
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            if (rs.next()) {
                venta = new Venta(rs.getInt("folio"), rs.getInt("dia"), rs.getInt("mes"), rs.getInt("anio"),
                        rs.getInt("total"), (new LibroDao()).getLibrosByVenta(rs.getInt("folio")),
                        (new IFormaDePagoDao()).getFormaDePago(rs.getInt("folio")));
            }
        } catch (

        Exception ex) {
            System.out.println(ex.getMessage());
        }

        return venta;
    }

    @Override
    public ArrayList<Venta> getAllVentas() {
        ArrayList<Venta> ventas = new ArrayList<>();
        try {
            String qry = "SELECT * FROM VENTA";
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                ventas.add(new Venta(rs.getInt("folio"), rs.getInt("dia"), rs.getInt("mes"), rs.getInt("anio"),
                        rs.getInt("total"), (new LibroDao()).getLibrosByVenta(rs.getInt("folio")),
                        (new IFormaDePagoDao()).getFormaDePago(rs.getInt("folio"))));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ventas;
    }

    @Override
    public void delete(Venta venta) {
        try {
            String qry = "DELETE FROM VENTA WHERE folio=" + venta.getFolio();
            Statement stm = conexion.createStatement();
            stm.execute(qry);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
