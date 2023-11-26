package prueba3java.dao.libro;

import java.sql.*;
import java.util.ArrayList;

import prueba3java.clases.libro.Libro;
import prueba3java.clases.libro.LibroNovela;
import prueba3java.clases.libro.LibroTecnico;
import prueba3java.conexion.Conexion;

public class LibroDao implements ILibroDao {
    private Connection conexion = null;

    public LibroDao() {
        this.conexion = Conexion.conectarBD("db");
    }

    @Override
    public boolean save(Libro libro) {
        try {
            String qry = "";

            if (libro.getClass() == (new LibroTecnico()).getClass()) {
                LibroTecnico l = (LibroTecnico) libro;
                qry = "INSERT INTO LIBRO ('" +
                        l.getCodigo() + "', '" +
                        l.getDescripcion() + "', " +
                        l.getPaginas() + ", " +
                        l.getCantidad() + ", " +
                        l.getPrecio() + ", '" +
                        l.getTema() + "', " +
                        0 + ", " +
                        l.getVenta() + ")";
            } else {
                LibroNovela l = (LibroNovela) libro;
                qry = "INSERT INTO LIBRO ('" +
                        l.getCodigo() + "', '" +
                        l.getDescripcion() + "', " +
                        l.getPaginas() + ", " +
                        l.getCantidad() + ", " +
                        l.getPrecio() + ", '" +
                        l.getAutor() + "', " +
                        0 + ", " +
                        l.getVenta() + ")";
            }
            Statement stm = conexion.createStatement();
            stm.execute(qry);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public void update(Libro libro) {
        try {
            String qry = "";
            if (libro.getClass() == (new LibroTecnico()).getClass()) {
                LibroTecnico l = (LibroTecnico) libro;
                qry = "UPDATE LIBRO SET " +
                        "descripcion = '" + l.getDescripcion() + "', " +
                        "paginas = " + l.getPaginas() + ", " +
                        "cantidad = " + l.getCantidad() + ", " +
                        "precio = " + l.getPrecio() + ", " +
                        "autorOTema = '" + l.getTema() + "'" +
                        "WHERE codigo='" + l.getCodigo() + "'";
            } else {
                LibroNovela l = (LibroNovela) libro;
                qry = "UPDATE LIBRO SET " +
                        "descripcion = '" + l.getDescripcion() + "', " +
                        "paginas = " + l.getPaginas() + ", " +
                        "cantidad = " + l.getCantidad() + ", " +
                        "precio = " + l.getPrecio() + ", " +
                        "autorOTema = '" + l.getAutor() + "'" +
                        "WHERE codigo='" + l.getCodigo() + "'";
            }
            Statement stm = conexion.createStatement();
            stm.executeUpdate(qry);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Libro getLibro(String codigo) {
        Libro libro = null;
        try {
            String qry = "SELECT * FROM LIBRO WHERE codigo='" + codigo + "'";
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            if (rs.next()) {
                if (rs.getBoolean("isNovela")) {
                    LibroNovela l = new LibroNovela(rs.getString("codigo"), rs.getString("descripcion"),
                            rs.getInt("paginas"), rs.getInt("cantidad"), rs.getInt("precio"), rs.getInt("venta"),
                            rs.getString("autorOTema"));
                    libro = l;
                } else {
                    LibroTecnico l = new LibroTecnico(rs.getString("codigo"), rs.getString("descripcion"),
                            rs.getInt("paginas"), rs.getInt("cantidad"), rs.getInt("precio"), rs.getInt("venta"),
                            rs.getString("autorOTema"));
                    libro = l;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return libro;
    }

    @Override
    public Libro getLibro(String codigo, boolean isNovela) {
        Libro libro = null;
        try {
            String qry = "SELECT * FROM LIBRO WHERE codigo='" + codigo + "'";
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            if (rs.next()) {
                if (rs.getBoolean("isNovela") && isNovela) {
                    LibroNovela l = new LibroNovela(rs.getString("codigo"), rs.getString("descripcion"),
                            rs.getInt("paginas"), rs.getInt("cantidad"), rs.getInt("precio"), rs.getInt("venta"),
                            rs.getString("autorOTema"));
                    libro = l;
                } else if (!isNovela) {
                    LibroTecnico l = new LibroTecnico(rs.getString("codigo"), rs.getString("descripcion"),
                            rs.getInt("paginas"), rs.getInt("cantidad"), rs.getInt("precio"), rs.getInt("venta"),
                            rs.getString("autorOTema"));
                    libro = l;
                } else {
                    throw new Exception("No Book Found");
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return libro;
    }

    @Override
    public ArrayList<Libro> getAllLibros() {
        ArrayList<Libro> libros = new ArrayList<>();
        try {
            String qry = "SELECT * FROM LIBRO";
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                if (rs.getBoolean("isNovela")) {
                    LibroNovela l = new LibroNovela(rs.getString("codigo"), rs.getString("descripcion"),
                            rs.getInt("paginas"), rs.getInt("cantidad"), rs.getInt("precio"), rs.getInt("venta"),
                            rs.getString("autorOTema"));
                    libros.add(l);
                } else {
                    LibroTecnico l = new LibroTecnico(rs.getString("codigo"), rs.getString("descripcion"),
                            rs.getInt("paginas"), rs.getInt("cantidad"), rs.getInt("precio"), rs.getInt("venta"),
                            rs.getString("autorOTema"));
                    libros.add(l);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return libros;
    }

    @Override
    public ArrayList<Libro> getLibrosByVenta(int folioVenta) {
        ArrayList<Libro> libros = new ArrayList<>();
        try {
            String qry = "SELECT * FROM LIBRO WHERE venta=" + folioVenta;
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                if (rs.getBoolean("isNovela")) {
                    LibroNovela l = new LibroNovela(rs.getString("codigo"), rs.getString("descripcion"),
                            rs.getInt("paginas"), rs.getInt("cantidad"), rs.getInt("precio"), rs.getInt("venta"),
                            rs.getString("autorOTema"));
                    libros.add(l);
                } else {
                    LibroTecnico l = new LibroTecnico(rs.getString("codigo"), rs.getString("descripcion"),
                            rs.getInt("paginas"), rs.getInt("cantidad"), rs.getInt("precio"), rs.getInt("venta"),
                            rs.getString("autorOTema"));
                    libros.add(l);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return libros;
    }

    @Override
    public void delete(Libro libro) {
        try {
            String qry = "DELETE FROM LIBRO WHERE codigo='" + libro.getCodigo() + "'";
            Statement stm = conexion.createStatement();
            stm.execute(qry);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
