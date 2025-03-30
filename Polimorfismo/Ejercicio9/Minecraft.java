package Polimorfismo.Ejercicio9;

// Clase Padre
class Bloque {
    protected String tipo;

    public Bloque(String tipo) {
        this.tipo = tipo;
    }

    public void accion() {
        System.out.println("El bloque " + tipo + " realiza una acción.");
    }

    public void colocar(String posicion) {
        System.out.println("El bloque " + tipo + " ha sido colocado en la " + posicion + ".");
    }

    public void romper() {
        System.out.println("El bloque " + tipo + " ha sido roto.");
    }
}

// b) Sobrescribe accion() en BloqueCofre, BloqueTnt y BloqueHorno
class BloqueCofre extends Bloque {
    private int capacidad, resistencia;

    public BloqueCofre(int capacidad, int resistencia, String tipo) {
        super(tipo);
        this.capacidad = capacidad;
        this.resistencia = resistencia;
    }

    @Override
    public void accion() {
        System.out.println("El cofre " + tipo + " se abre para almacenar objetos.");
    }

    // c) Sobrecarga colocar()
    public void colocar(String posicion, boolean conLlave) {
        System.out.println("El cofre " + tipo + " se ha colocado en la " + posicion +
                (conLlave ? " y está cerrado con llave." : "."));
    }

    // d) Sobrescribe romper()
    @Override
    public void romper() {
        System.out.println("El cofre " + tipo + " se ha roto y sus objetos cayeron al suelo.");
    }
}

// b) Sobrescribe accion()
class BloqueTnt extends Bloque {
    private int dano;

    public BloqueTnt(int dano, String tipo) {
        super(tipo);
        this.dano = dano;
    }

    @Override
    public void accion() {
        System.out.println("La TNT " + tipo + " se enciende y está a punto de explotar.");
    }

    // c) Sobrecarga colocar()
    public void colocar(String posicion, int tiempoDetonacion) {
        System.out.println("La TNT " + tipo + " ha sido colocada en la " + posicion +
                " y explotará en " + tiempoDetonacion + " segundos.");
    }

    // d) Sobrescribe romper()
    @Override
    public void romper() {
        System.out.println("La TNT " + tipo + " se ha roto sin explotar.");
    }
}

// b) Sobrescribe accion()
class BloqueHorno extends Bloque {
    private int capacidadComida;
    private String color;

    public BloqueHorno(int capacidadComida, String color) {
        super("Horno");
        this.capacidadComida = capacidadComida;
        this.color = color;
    }

    @Override
    public void accion() {
        System.out.println("El horno de color " + color + " está cocinando alimentos.");
    }

    // c) Sobrecarga colocar()
    public void colocar(String posicion, String fuenteEnergia) {
        System.out.println("El horno de color " + color + " se ha colocado en la " + posicion +
                " y funciona con " + fuenteEnergia + ".");
    }

    // d) Sobrescribe romper()
    @Override
    public void romper() {
        System.out.println("El horno de color " + color + " se ha roto y dejó caer materiales.");
    }
}

// a) Crear e instanciar al menos 2 bloques de cada tipo
public class Minecraft {
    public static void main(String[] args) {
        BloqueCofre cofre1 = new BloqueCofre(27, 5, "de Madera");
        BloqueCofre cofre2 = new BloqueCofre(54, 7, "de Hierro");

        BloqueTnt tnt1 = new BloqueTnt(50, "Normal");
        BloqueTnt tnt2 = new BloqueTnt(100, "Mega");

        BloqueHorno horno1 = new BloqueHorno(3, "Gris");
        BloqueHorno horno2 = new BloqueHorno(5, "Negro");

        // b) Llamada a los métodos sobrescritos
        cofre1.accion();
        cofre2.accion();
        tnt1.accion();
        tnt2.accion();
        horno1.accion();
        horno2.accion();

        // c) Llamada a los métodos sobrecargados
        cofre1.colocar("suelo");
        cofre2.colocar("pared", true);

        tnt1.colocar("suelo");
        tnt2.colocar("pared", 10);

        horno1.colocar("mesa de trabajo");
        horno2.colocar("cocina", "carbón");

        // d) Llamada a los métodos sobrescritos de romper()
        cofre1.romper();
        tnt1.romper();
        horno2.romper();
    }
}
