package IntroduccionPoo.Ejercicio7;

class Celular {
    private int espacioDisponible = 1024; // En MB
    private int bateria = 100;

    // a) Método para instalar una nueva aplicación
    public void instalarApp(int tamaño) {
        if (tamaño <= espacioDisponible) {
            espacioDisponible -= tamaño;
            System.out.println("Aplicación instalada. Espacio restante: " + espacioDisponible + "MB");
        } else {
            System.out.println("No hay suficiente espacio para instalar la aplicación.");
        }
    }

    // b) Método para utilizar una aplicación
    public void usarApp(int tamaño, int minutos) {
        if (bateria <= 0) {
            System.out.println("Celular apagado. No hay batería.");
            return;
        }

        int consumo = 1;
        if (tamaño > 250) consumo = 5;
        else if (tamaño > 100) consumo = 2;

        int consumoTotal = (minutos / 10) * consumo;

        if (bateria - consumoTotal <= 0) {
            bateria = 0;
            System.out.println("La batería se agotó. Celular apagado.");
        } else {
            bateria -= consumoTotal;
            System.out.println("Aplicación usada. Batería restante: " + bateria + "%");
        }
    }

    // c) Muestra el porcentaje de batería restante
    public void mostrarBateria() {
        System.out.println("Batería actual: " + bateria + "%");
    }

    public static void main(String[] args) {
        Celular miCelular = new Celular();
        miCelular.instalarApp(300);
        miCelular.usarApp(300, 30);
        miCelular.usarApp(50, 20);
        miCelular.mostrarBateria();
    }
}
