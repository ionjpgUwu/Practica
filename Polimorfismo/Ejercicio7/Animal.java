package Polimorfismo.Ejercicio7;

class Perro {
    private String nombre, raza;
    private int edad;

    public Perro(String nombre, int edad, String raza) {
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
    }

    // Sobrecarga
    public void hacerSonido() {
        System.out.println(nombre + " hace: ¡Guau, guau!");
    }

    // b)Sobrecarga con un parámetro para el volumen
    public void hacerSonido(int volumen) {
        if (volumen > 5) {
            System.out.println(nombre + " hace: ¡GUAAAU, GUAAAU! (muy fuerte)");
        } else {
            System.out.println(nombre + " hace: ¡guau, guau! (suave)");
        }
    }

    // Sobrecarga
    public void moverse() {
        System.out.println(nombre + " corre rápidamente.");
    }

    // c)Sobrecarga para indicar la velocidad
    public void moverse(int velocidad) {
        if (velocidad > 10) {
            System.out.println(nombre + " corre muy rápido a " + velocidad + " km/h.");
        } else {
            System.out.println(nombre + " corre despacio a " + velocidad + " km/h.");
        }
    }
}

class Gato {
    private String nombre, color;

    public Gato(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
    }

    // Sobrecarga
    public void hacerSonido() {
        System.out.println(nombre + " hace: ¡Miau, miau!");
    }

    // b)Sobrecarga con un parámetro para el volumen
    public void hacerSonido(int volumen) {
        if (volumen > 5) {
            System.out.println(nombre + " hace: ¡MIAU, MIAU! (muy fuerte)");
        } else {
            System.out.println(nombre + " hace: ¡miau, miau! (suave)");
        }
    }

    // Sobrecarga
    public void moverse() {
        System.out.println(nombre + " salta ágilmente.");
    }

    // c)Sobrecarga para indicar la velocidad
    public void moverse(int velocidad) {
        if (velocidad > 10) {
            System.out.println(nombre + " salta muy alto a " + velocidad + " km/h.");
        } else {
            System.out.println(nombre + " salta bajo a " + velocidad + " km/h.");
        }
    }
}

class Pajaro {
    private String nombre, tipo;

    public Pajaro(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    // Sobrecarga
    public void hacerSonido() {
        System.out.println(nombre + " hace: ¡Pío, pío!");
    }

    // b)Sobrecarga con un parámetro para el volumen
    public void hacerSonido(int volumen) {
        if (volumen > 5) {
            System.out.println(nombre + " hace: ¡PÍO, PÍO! (muy fuerte)");
        } else {
            System.out.println(nombre + " hace: ¡pío, pío! (suave)");
        }
    }

    // Sobrecarga
    public void moverse() {
        System.out.println(nombre + " vuela alto en el cielo.");
    }

    // c)Sobrecarga para indicar la velocidad
    public void moverse(int velocidad) {
        if (velocidad > 10) {
            System.out.println(nombre + " vuela rápido a " + velocidad + " km/h.");
        } else {
            System.out.println(nombre + " vuela despacio a " + velocidad + " km/h.");
        }
    }
}

public class Animal {
    public static void main(String[] args) {
        // a)Instanciar 1 Perro, 1 Gato y 1 Pájaro
        Perro perro = new Perro("Max", 3, "Labrador");
        Gato gato = new Gato("Mia", "Negro");
        Pajaro pajaro = new Pajaro("Tweety", "Canario");

        perro.hacerSonido();
        perro.moverse();
        perro.hacerSonido(6);
        perro.moverse(12);


        gato.hacerSonido();
        gato.moverse();
        gato.hacerSonido(3);
        gato.moverse(8);

        pajaro.hacerSonido();
        pajaro.moverse();
        pajaro.hacerSonido(7);
        pajaro.moverse(15);
    }
}
