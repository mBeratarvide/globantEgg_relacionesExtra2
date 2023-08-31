package servicios;

import entidades.Cine;
import entidades.Sala;

import java.util.ArrayList;

public class CineServicio {
    private Cine cine;
    private String nombreCine;
    private ArrayList<SalaServicio> salas = new ArrayList<>();

    public CineServicio(String nombre) {
        this.nombreCine = nombre;
    }

    public void abrirCine() {
        System.out.println("Cuántas salas vamos a abrir?");
        int cs;
        do {
            cs = Lector.leer().nextInt();
            Lector.leer().nextLine();
        } while(cs < 1);

        Sala[] salas = new Sala[cs];
        for(int i = 0; i < cs; i++) {
            SalaServicio ss = new SalaServicio();
            salas[i] = ss.crearSala();
            this.salas.add(ss);
        }

        cine = new Cine(nombreCine, salas, true);
    }

    public void verOcupacionDelCine() {
        System.out.println("De las " + cine.getSalas().length + " salas, cuál querés ver?");
        int salaElegida;
        do {
            salaElegida = Lector.leer().nextInt();
            Lector.leer().nextLine();
        } while(salaElegida < 1 || salaElegida > cine.getSalas().length);

        System.out.println("=== Sala " + salaElegida + " ===");
        salas.get(salaElegida - 1).verOcupacionSala();
    }

    public Sala getSala(int x) {
        return cine.getSalas()[x];
    }

}
