package entidades;

public class Butaca {
    private int fila;
    private String asiento;
    private boolean ocupado;
    private Espectador espectador;

    public Butaca() {}
    public Butaca(int f, String a) {
        fila = f;
        asiento = a;
        ocupado = false;
        espectador = null;
    }
    public Butaca(int f, String a, boolean o, Espectador e) {
        fila = f;
        asiento = a;
        ocupado = o;
        espectador = e;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Espectador getEspectador() {
        return espectador;
    }

    public void setEspectador(Espectador espectador) {
        this.espectador = espectador;
    }

    @Override
    public String toString() {
        String o = " ";
        if(ocupado) {
            o = "X";
        }
        return fila + " " + asiento + " " + o;
    }
}
