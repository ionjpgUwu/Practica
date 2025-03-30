package IntroduccionPoo.Ejercicio10;

class Avion {
    private int pasajeros;
    private double combustible;
    private int horaVuelo;

    public Avion(double combustible, int horaVuelo) {
        this.pasajeros = 0;
        this.combustible = combustible;
        this.horaVuelo = horaVuelo;
    }

    // a) Metodo para que suban pasajeros al avión
    public void subirPasajeros(int cantidad) {
        pasajeros += cantidad;
        System.out.println("Subieron " + cantidad + " pasajeros. Total: " + pasajeros);
    }

    // b) Verifica la cantidad de combustible disponible según la distancia de viaje
    public boolean verificarCombustible(int distancia) {
        double requerido = distancia * 12;
        if (combustible >= requerido) {
            System.out.println("Combustible suficiente para el viaje.");
            return true;
        } else {
            System.out.println("No hay suficiente combustible.");
            return false;
        }
    }

    // c) Retrasa el vuelo 3 horas
    public void retrasarVuelo() {
        horaVuelo += 3;
        System.out.println("El vuelo ha sido retrasado 3 horas. Nueva hora de vuelo: " + horaVuelo);
    }

    public static void main(String[] args) {
        Avion avion = new Avion(5000, 14);
        avion.subirPasajeros(150);
        avion.verificarCombustible(300);
        avion.retrasarVuelo();
    }
}

