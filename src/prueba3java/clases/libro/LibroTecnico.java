package prueba3java.clases.libro;

import java.util.*;

public final class LibroTecnico extends Libro {

    private String tema;

    public LibroTecnico() {
    }

    public LibroTecnico(String codigo, String descripcion, int paginas, int cantidad, int precio, int venta,
            String tema) {
        super.setCodigo(codigo);
        super.setDescripcion(descripcion);
        super.setPaginas(paginas);
        super.setCantidad(cantidad);
        super.setPrecio(precio);
        super.setVenta(venta);
        this.tema = tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getTema() {
        return tema;
    }

    public int calcularSubTotal(ArrayList<Libro> others) {
        int tecnicos = 0;
        if (others != null) {
            for (Libro item : others) {
                if (item.getClass() == (new LibroTecnico()).getClass()) {
                    tecnicos += item.getCantidad();
                }
            }
        }

        if (tecnicos > 3)

        {
            return (int) Math.round(super.calcularSubTotal(others) * 0.75);
        }

        return super.calcularSubTotal(others);
    }

}
