package prueba3java.dao.iformadepago;

import java.sql.*;

import prueba3java.clases.formaPago.IFormaDePago;
import prueba3java.clases.formaPago.PagoCheque;
import prueba3java.clases.formaPago.PagoTarjeta;
import prueba3java.conexion.Conexion;

public class IFormaDePagoDao implements IIFormaDePagoDao {
    private Connection conexion;

    public IFormaDePagoDao() {
        this.conexion = Conexion.conectarBD("db");
    }

    @Override
    public boolean save(IFormaDePago pago) {
        try {
            String qry = "";
            if (pago.getClass() == (new PagoCheque()).getClass()) {
                PagoCheque p = (PagoCheque) pago;
                qry = "INSERT INTO PAGO (" +
                        p.getMonto() + ", " +
                        p.getNumero() + ", " +
                        "'', " +
                        "0, " +
                        p.getVenta() + ")";
            } else {
                PagoTarjeta p = (PagoTarjeta) pago;
                qry = "INSERT INTO PAGO (" +
                        p.getMonto() + ", " +
                        "0, " +
                        "'" + p.getCodigoAutorizacion() + "', " +
                        "1, " +
                        p.getVenta() + ")";
            }

            Statement stm = conexion.createStatement();
            stm.execute(qry);
            return true;
        } catch (

        Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public void update(IFormaDePago pago) {
        try {
            String qry = "";
            if (pago.getClass() == (new PagoCheque()).getClass()) {
                PagoCheque p = (PagoCheque) pago;
                qry = "UPDATE PAGO SET " +
                        "monto=" + p.getMonto() + ", " +
                        "numero=" + p.getNumero() + ", " +
                        "codigo='', " +
                        "isTarjeta=0," +
                        "WHERE venta=" + p.getVenta();
            } else {
                PagoTarjeta p = (PagoTarjeta) pago;
                qry = "UPDATE PAGO SET " +
                        "monto=" + p.getMonto() + ", " +
                        "numero=0, " +
                        "codigo='" + p.getCodigoAutorizacion() + "', " +
                        "isTarjeta=1," +
                        "WHERE venta=" + p.getVenta();
            }
            Statement stm = conexion.createStatement();
            stm.executeUpdate(qry);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public IFormaDePago getFormaDePago(int folioVenta) {
        IFormaDePago pago = null;
        try {
            String qry = "SELECT * FROM PAGO WHERE venta='" + folioVenta + "'";
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            if (rs.next()) {
                if (rs.getBoolean("isTarjeta")) {
                    PagoTarjeta p = new PagoTarjeta(rs.getInt("monto"), rs.getString("codigo"), folioVenta);
                    pago = p;
                } else {
                    PagoCheque p = new PagoCheque(rs.getInt("monto"), rs.getInt("numero"), folioVenta);
                    pago = p;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return pago;
    }

    @Override
    public void delete(IFormaDePago pago) {
        try {
            String qry = "DELETE FROM PAGO WHERE venta='" + pago.getVenta() + "'";
            Statement stm = conexion.createStatement();
            stm.execute(qry);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
