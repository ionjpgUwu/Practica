package IntroduccionPoo.Ejercicio3;

class Coche {
    private String marca;
    private String modelo;
    private int velocidad;

    public Coche(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidad = 0;
    }

    // a) Acelerar
    public void acelerar() {
        velocidad += 10;
    }

    // b) Frenar
    public void frenar() {
        velocidad -= 5;
    }

    public void mostrarVelocidad() {
        System.out.println(marca + " " + modelo + " va a " + velocidad + " km/h");
    }

    public static void main(String[] args) {
        Coche c1 = new Coche("Toyota", "Corolla");
        Coche c2 = new Coche("Ford", "Mustang");

        c1.acelerar();
        c1.acelerar();
        c1.frenar();
        c1.mostrarVelocidad();

        c2.acelerar();
        c2.mostrarVelocidad();
    }
}
