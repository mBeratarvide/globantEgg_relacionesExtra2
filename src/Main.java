import servicios.CineServicio;
import servicios.Simulador;

public class Main {
    public static void main(String[] args) {

        CineServicio cs = new CineServicio("Mondonga Cine");
        Simulador s = new Simulador();

        cs.abrirCine();
        cs.verOcupacionDelCine();
        s.simularAlgo(cs.getSala(0));
        cs.verOcupacionDelCine();

    }
}
