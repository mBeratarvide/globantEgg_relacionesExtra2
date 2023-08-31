package servicios;

import entidades.Pelicula;

import java.util.Objects;

public class PeliculaServicio {
    private Pelicula p;
    public void crearPelicula() {
        System.out.println("Cómo se llama la peli?");
        String titulo = Lector.leer().nextLine();
        System.out.println("Cuánto dura?");
        int duracionMinutos = Lector.leer().nextInt();
        Lector.leer().nextLine();
        System.out.println("Cuál es la edad mínima para verla?");
        int edadMinima = Lector.leer().nextInt();
        Lector.leer().nextLine();
        System.out.println("Cómo se llama el director?");
        String director = Lector.leer().nextLine();

        // generar un idrandom;
        int hash = Objects.hash(titulo, duracionMinutos, edadMinima, director);

        p = new Pelicula(hash, titulo, duracionMinutos, edadMinima, director);
    }

    public Pelicula crearPelicula(String titulo, int duracionMinutos, int edadMinima, String director) {
        int hash = Objects.hash(titulo, duracionMinutos, edadMinima, director);
        return new Pelicula(hash, titulo, duracionMinutos, edadMinima, director);
    }

    public Pelicula getPelicula() {
        if(p == null) {
            crearPelicula();
        }
        return p;
    }
}
