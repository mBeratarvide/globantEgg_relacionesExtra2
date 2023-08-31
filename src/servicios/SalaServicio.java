package servicios;

import entidades.Butaca;
import entidades.Sala;

public class SalaServicio {
    private PeliculaServicio ps = new PeliculaServicio();
    private Butaca[][] sala = new Butaca[8][6];

    public Sala crearSala() {
        return new Sala(
                ps.getPelicula(),
                definirPrecio(),
                montarSala(8,6)
        );
    }

    private Butaca[][] montarSala(int filas, int columnas) {
        for(int i = 0; i < filas; i++) {
            for(int j = 0; j < columnas; j++) {
                int fila = 8-i;
                char letra = (char) (j + 65);
                String asiento = String.valueOf(letra);
                sala[i][j] = new Butaca(fila, asiento);
            }
        }
        return sala;
    }

    private double definirPrecio() {
        System.out.println("Cuánto cuesta ver "+ps.getPelicula().getTitulo()+"?");
        double precio = Lector.leer().nextDouble();
        //Lector.leer().nextLine();
        return precio;
    }

    public void verOcupacionSala() {
        for(int i = 0; i < sala.length; i++) {
            StringBuilder fila = new StringBuilder();
            for(int j = 0; j < sala[0].length; j++) {
                Butaca b = sala[i][j];
                if(j == 0) {
                    fila = new StringBuilder(b.toString());
                } else {
                    fila.append(" | ").append(b.toString());
                }
            }
            System.out.println(fila);
        }
    }

}
