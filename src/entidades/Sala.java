package entidades;

public class Sala {
    private Pelicula pelicula;
    private double precioEntrada;
    private Butaca[][] lugares;

    public Sala() {}

    public Sala(Pelicula pelicula, double precioEntrada, Butaca[][] lugares) {
        this.pelicula = pelicula;
        this.precioEntrada = precioEntrada;
        this.lugares = lugares;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public double getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public Butaca[][] getLugares() {
        return lugares;
    }

    public void setLugares(Butaca[][] lugares) {
        this.lugares = lugares;
    }

}
