package prueba3java.clases.libro;

import java.util.*;

public final class LibroTecnico extends Libro {

    private String tema;

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getTema() {
        return tema;
    }

    public int calcularSubTotal(ArrayList<Libro> others) {
        int tecnicos = 0;
        for (Libro item : others) {
            if (item.getClass() == (new LibroTecnico()).getClass()) {
                tecnicos++;
            }
        }

        if (tecnicos > 3) {
            return (int) Math.round(super.calcularSubTotal(others) * 0.75);
        }

        return super.calcularSubTotal(others);
    }
}
