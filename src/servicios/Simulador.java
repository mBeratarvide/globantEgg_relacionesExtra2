package servicios;

import entidades.Butaca;
import entidades.Espectador;
import entidades.Sala;

import java.util.ArrayList;
import java.util.Random;

public class Simulador {
    private Random rnd = new Random();
    private String[] vocales = {"a","e","i","o","u","y"};
    private String[] consonantes = {"b","c","d","f","g","h","j","k","l","m","n","ñ","p","q","r","s","t","v","w","x","y","z"};

    public void simularAlgo(Sala s) {
        // genero la gente
        double gente = (int) s.getLugares().length * s.getLugares()[0].length * 1.5;
        ArrayList<Espectador> people = makeDummyPeople((int) gente);
        // ahora tengo que sentarlos, si pueden
        ocuparSala(s, people);
    }

    private ArrayList<Espectador> makeDummyPeople(int amount) {
        ArrayList<Espectador> people = new ArrayList<>();

        for(int i = 0; i < amount; i++) {
            int randomAge = rnd.nextInt(55)+10;
            double randomMoney = rnd.nextDouble() * 150;
            people.add(new Espectador(nombreRandom(), randomAge, randomMoney));
        }

        return people;
    }

    private void ocuparSala(Sala s, ArrayList<Espectador> gente) {
        int capacidadSala = s.getLugares().length * s.getLugares()[0].length;
        ArrayList<Integer> lugaresDisponibles = generarTalonario(capacidadSala);

        for(Espectador e : gente) {
            if(lugaresDisponibles.isEmpty()) {
                System.out.println("¡Sala llena!");
                break;
            }

            if(s.getPelicula().getEdadMinima() > e.getEdad()) {
                System.out.print("No cumple edad mínima (" + s.getPelicula().getEdadMinima() + "): ");
                System.out.println(e);
                continue;
            }

            if(s.getPrecioEntrada() > e.getDineroDisponible()) {
                System.out.print("No tiene plata suficiente ($"+s.getPrecioEntrada()+"): ");
                System.out.println(e);
                continue;
            }

            // tomo un random de los lugaresDisponibles
            int ticket = rnd.nextInt(lugaresDisponibles.size());
            // le quito la plata
            e.setDineroDisponible(s.getPrecioEntrada() - e.getDineroDisponible());
            // siento al dolobu + ocupo el asiento
            sentarZapallo(s, e, lugaresDisponibles.get(ticket));
            // remuevo el lugarDisponible
            lugaresDisponibles.remove(ticket);
        }
        System.out.println("asentamientos fin...");
    }

    private Butaca conversorDecimalToAsiento(int nro, int filas, int asientosPorFila) {
        int decimal = nro / asientosPorFila;
        int unidad = nro % asientosPorFila;

        if(decimal > filas) {
            System.out.println("Error filas");
            return null;
        }

        if(unidad > asientosPorFila) {
            System.out.println("Error columnas");
            return null;
        }

        String letra;
        if(unidad == 0) {
            letra = String.valueOf(64 + asientosPorFila);
        } else {
            letra = String.valueOf(64 + unidad);
        }

        return new Butaca(decimal + 1, letra);
    }

    private void sentarZapallo(Sala s, Espectador e, int l) {
        l = l - 1;
        int fila = l / s.getLugares()[0].length;
        int asiento = l % s.getLugares()[0].length;

        if(!s.getLugares()[fila][asiento].isOcupado()) {
            s.getLugares()[fila][asiento].setOcupado(true);
            s.getLugares()[fila][asiento].setEspectador(e);
        } else {
            System.out.print("ERRRRRRRRO 404 R " + l + "f"+fila+"a"+asiento + " | ");
            System.out.println(s.getLugares()[fila][asiento]);
        }
    }

    private String nombreRandom() {
        int cantLetras = rnd.nextInt(3) + 3; // 3,4,5

        String nombre = "";
        switch (cantLetras) {
            case 5:
                nombre += dameUna(vocales);
            case 4:
                nombre += dameUna(consonantes);
            case 3:
                nombre += dameUna(vocales);
                nombre += dameUna(consonantes);
                nombre += dameUna(vocales);
        }

        nombre = nombre.substring(0,1).toUpperCase() + nombre.substring(1);

        return nombre;
    }

    private String dameUna(String[] letras) {
        return letras[rnd.nextInt(letras.length)];
    }

    private ArrayList<Integer> generarTalonario(int cantidadEntradas) {
        ArrayList<Integer> ticketsEnVenta = new ArrayList<>();

        for(int i = 0; i < cantidadEntradas; i++) {
            ticketsEnVenta.add(i+1);
        }

        return ticketsEnVenta;
    }
}
