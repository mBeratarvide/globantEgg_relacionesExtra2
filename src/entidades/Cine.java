package entidades;

public class Cine {
    private String nombre;
    private Sala[] salas;
    private boolean abierto;

    public Cine() {}

    public Cine(String nombre, Sala[] salas, boolean abierto) {
        this.nombre = nombre;
        this.salas = salas;
        this.abierto = abierto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Sala[] getSalas() {
        return salas;
    }

    public void setSalas(Sala[] salas) {
        this.salas = salas;
    }

    public boolean isAbierto() {
        return abierto;
    }

    public void setAbierto(boolean abierto) {
        this.abierto = abierto;
    }
}
