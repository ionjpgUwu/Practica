// a) Implementa las clases con sus constructores, getters y setters.

class Jugador {
    protected String nombre;
    protected int numero;
    protected String posicion;

    public Jugador(String nombre, int numero, String posicion) {
        this.nombre = nombre;
        this.numero = numero;
        this.posicion = posicion;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + ", Número: " + numero + ", Posición: " + posicion);
    }
}

class Portero extends Jugador {
    private String habilidadEspecial;

    public Portero(String nombre, int numero, String habilidadEspecial) {
        super(nombre, numero, "Portero");
        this.habilidadEspecial = habilidadEspecial;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Habilidad Especial: " + habilidadEspecial);
    }
}

class Defensa extends Jugador {
    private String habilidadEspecial;

    public Defensa(String nombre, int numero, String habilidadEspecial) {
        super(nombre, numero, "Defensa");
        this.habilidadEspecial = habilidadEspecial;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Habilidad Especial: " + habilidadEspecial);
    }
}

class Mediocampista extends Jugador {
    private String habilidadEspecial;

    public Mediocampista(String nombre, int numero, String habilidadEspecial) {
        super(nombre, numero, "Mediocampista");
        this.habilidadEspecial = habilidadEspecial;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Habilidad Especial: " + habilidadEspecial);
    }
}

class Delantero extends Jugador {
    private String habilidadEspecial;

    public Delantero(String nombre, int numero, String habilidadEspecial) {
        super(nombre, numero, "Delantero");
        this.habilidadEspecial = habilidadEspecial;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Habilidad Especial: " + habilidadEspecial);
    }
}

import java.util.ArrayList;
import java.util.List;

class Equipo {
    private String nombre;
    private List<Jugador> jugadores;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void mostrarEquipo() {
        System.out.println("Equipo: " + nombre);
        for (Jugador j : jugadores) {
            j.mostrarInfo();
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // b) Crea un equipo y agrega varios jugadores de diferentes tipos.
        Equipo equipo = new Equipo("Leones FC");
        equipo.agregarJugador(new Portero("Carlos", 1, "Atajadas"));
        equipo.agregarJugador(new Defensa("Luis", 4, "Marcaje"));
        equipo.agregarJugador(new Mediocampista("Jorge", 8, "Pases"));
        equipo.agregarJugador(new Delantero("Pedro", 9, "Goles"));

        // c) Muestra la información del equipo y sus jugadores.
        equipo.mostrarEquipo();
    }
}
    