package Polimorfismo.Ejercicio4;


class Bus extends automovil {
    private int nroPasajeros;

    public Bus(String modelo, String placa, String conductor, int kilometraje, int nroPasajeros) {
        super(modelo, placa, conductor, kilometraje);
        this.nroPasajeros = nroPasajeros;
    }

    // c)Sobrecarga del metodo registrarViaje
    public void registrarViaje(int distancia) {
        aumentarKilometraje(distancia);
        System.out.println("Viaje registrado. Kilometraje actualizado.");
    }

    public void registrarViaje(int distancia, String destino, int pasajeros) {
        this.nroPasajeros = pasajeros;
        aumentarKilometraje(distancia);
        System.out.println("Viaje a " + destino + " con " + pasajeros + " pasajeros registrado.");
    }
}

class Camioneta extends automovil {
    public Camioneta(String modelo, String placa, String conductor, int kilometraje) {
        super(modelo, placa, conductor, kilometraje);
    }

    // b)Sobrecarga del metodo asignarConductor
    public void asignarConductor(String nuevoConductor) {
        System.out.println("Conductor asignado: " + nuevoConductor);
    }

    public void asignarConductor(String nuevoConductor, int experiencia) {
        System.out.println("Conductor asignado: " + nuevoConductor + " | Experiencia: " + experiencia + " años.");
    }
}

public class automovil {
    private String modelo, placa, conductor;
    private int kilometraje;

    public automovil(String modelo, String placa, String conductor, int kilometraje) {
        this.modelo = modelo;
        this.placa = placa;
        this.conductor = conductor;
        this.kilometraje = kilometraje;
    }

    public void mostrarInfo() {
        System.out.println(modelo + " | Placa: " + placa + " | Conductor: " + conductor + " | Kilometraje: " + kilometraje);
    }

    protected void aumentarKilometraje(int km) {
        this.kilometraje += km;
    }
    public static void main(String[] args) {
        // a) Instanciar 2 objetos Bus y 1 objeto Camioneta
        Bus bus1 = new Bus("Volvo", "ABC-123", "Carlos", 50000, 40);
        Bus bus2 = new Bus("Honda", "XYZ-789", "Luis", 60000, 50);
        Camioneta camioneta1 = new Camioneta("Toyota", "LMN-456", "Ana", 30000);
        bus1.mostrarInfo();
        bus2.mostrarInfo();
        camioneta1.mostrarInfo();

        // b) Asignar conductor a la camioneta
        camioneta1.asignarConductor("Pedro");
        camioneta1.asignarConductor("Pedro", 5);

        // c) Registrar viajes en el bus
        bus1.registrarViaje(200);
        bus2.registrarViaje(150, "La Paz", 45);

        bus1.mostrarInfo();
        bus2.mostrarInfo();
    }
}
