package Polimorfismo.Ejercicio8;
class HabitacionSimple extends Habitacion {
    public HabitacionSimple(int nroHabitacion, float precioxNoche, int nrodeNoches, int capacidad) {
        super(nroHabitacion, precioxNoche, nrodeNoches, capacidad);
    }

    // b)Sobrescritura de calcularCosto
    @Override
    public float calcularCosto(int noches) {
        float costo = super.calcularCosto(noches);
        return (float) (costo * 0.95);
    }
}

class HabitacionDoble extends Habitacion {
    private int nrodeHabitaciones;

    public HabitacionDoble(int nroHabitacion, float precioxNoche, int nrodeNoches, int capacidad, int nrodeHabitaciones) {
        super(nroHabitacion, precioxNoche, nrodeNoches, capacidad);
        this.nrodeHabitaciones = nrodeHabitaciones;
    }

    // b)Sobrescritura de calcularCosto
    @Override
    public float calcularCosto(int noches) {
        float costo = super.calcularCosto(noches);
        return (float) (costo * 1.10);
    }
}

class Suite extends HabitacionDoble {
    public Suite(int nroHabitacion, float precioxNoche, int nrodeNoches, int capacidad, int nrodeHabitaciones) {
        super(nroHabitacion, precioxNoche, nrodeNoches, capacidad, nrodeHabitaciones);
    }

    // b)Sobrescritura de calcularCosto
    @Override
    public float calcularCosto(int noches) {
        float costo = super.calcularCosto(noches);
        return costo * 1.20f;
    }
}


class Habitacion {
    private int nroHabitacion, nrodeNoches, capacidad;
    private float precioxNoche;

    public Habitacion(int nroHabitacion, float precioxNoche, int nrodeNoches, int capacidad) {
        this.nroHabitacion = nroHabitacion;
        this.precioxNoche = precioxNoche;
        this.nrodeNoches = nrodeNoches;
        this.capacidad = capacidad;
    }

    // b)Metodo calcularCosto
    public float calcularCosto(int noches) {
        return noches * precioxNoche;
    }

    // c)Metodo reservar
    public void reservar(int noches) {
        System.out.println("Reserva realizada por " + noches + " noches.");
    }
    // c)Sobrecarga
    public void reservar(int noches, int personas) {
        System.out.println("Reserva realizada por " + noches + " noches para " + personas + " personas.");
    }

    public int getNrodeNoches() {
        return nrodeNoches;
    }

    public float getPrecioxNoche() {
        return precioxNoche;
    }
    public static void main(String[] args) {
        //a) Instanciar 1 objeto de cada tipo de habitación
        HabitacionSimple simple = new HabitacionSimple(101, 50, 3, 2);
        HabitacionDoble doble = new HabitacionDoble(202, 80, 4, 4, 2);
        Suite suite = new Suite(303, 150, 5, 6, 3);

        // b)Calcular costos
        System.out.println("Costo habitación simple: $" + simple.calcularCosto(3));
        System.out.println("Costo habitación doble: $" + doble.calcularCosto(4));
        System.out.println("Costo suite: $" + suite.calcularCosto(5));

        // c)Realizar reservas con sobrecarga
        simple.reservar(2);
        doble.reservar(3, 4);
        suite.reservar(5, 6);
    }
}