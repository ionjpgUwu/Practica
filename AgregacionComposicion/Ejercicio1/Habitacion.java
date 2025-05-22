// a) Implementa las clases con sus constructores, getters y setters.
class Habitacion {
    private String nombre;
    private double tamano;

    public Habitacion(String nombre, double tamano) {
        this.nombre = nombre;
        this.tamano = tamano;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTamano() {
        return tamano;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTamano(double tamano) {
        this.tamano = tamano;
    }

    public void mostrarInfo() {
        System.out.println("Habitación: " + nombre + ", Tamaño: " + tamano + " m²");
    }
}

import java.util.ArrayList;
import java.util.List;

class Casa {
    private String direccion;
    private List<Habitacion> habitaciones;

    public Casa(String direccion) {
        this.direccion = direccion;
        this.habitaciones = new ArrayList<>();
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    public void mostrarCasa() {
        System.out.println("Dirección: " + direccion);
        for (Habitacion h : habitaciones) {
            h.mostrarInfo();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // b) Crea una casa y agrega varias habitaciones.
        Casa miCasa = new Casa("Av. Siempre Viva 742");
        miCasa.agregarHabitacion(new Habitacion("Sala", 25.0));
        miCasa.agregarHabitacion(new Habitacion("Cocina", 15.5));
        miCasa.agregarHabitacion(new Habitacion("Dormitorio", 20.0));

        // c) Muestra la información de la casa y sus habitaciones.
        miCasa.mostrarCasa();
    }
}
