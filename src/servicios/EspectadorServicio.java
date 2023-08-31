package servicios;

import entidades.Espectador;

public class EspectadorServicio {

    public Espectador crearEspectador() {
        System.out.println("Cómo te llamás?");
        String nombre = Lector.leer().nextLine();
        System.out.println("Qué edad tenés?");
        int edad = Lector.leer().nextInt();
        Lector.leer().nextLine();
        System.out.println("Cuánta plata tenés?");
        double dinero = Lector.leer().nextDouble();
        Lector.leer().nextLine();

        return new Espectador(nombre, edad, dinero);
    }

    public Espectador crearEspectador(String nombre, int edad, double dinero) {
        return new Espectador(nombre, edad, dinero);
    }

}
