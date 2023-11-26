package prueba3java.dao.libro;

import java.util.ArrayList;

import prueba3java.clases.libro.Libro;

public interface ILibroDao {
    public boolean save(Libro libro);

    public void update(Libro libro);

    public void delete(Libro libro);

    public Libro getLibro(String codigo);

    public Libro getLibro(String codigo, boolean isNovela);

    public ArrayList<Libro> getAllLibros();

    public ArrayList<Libro> getLibrosByVenta(int folioVenta);
}
