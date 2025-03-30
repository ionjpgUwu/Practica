package Polimorfismo.Ejercicio1;

public class Videojuegos {
    private String nombre;
    private String plataforma;
    private int cantidadJugadores;

    //b) Sobrecargar el constructor 2 veces
    public Videojuegos(String nombre, String plataforma, int cantidadJugadores) {
        this.nombre = nombre;
        this.plataforma = plataforma;
        this.cantidadJugadores = cantidadJugadores;
    }

    public Videojuegos(String nombre, String plataforma) {
        this.nombre = nombre;
        this.plataforma = plataforma;
        this.cantidadJugadores = 0;
    }

    public void mostrar() {
        System.out.printf("Videojuego(Nombre: %s, Plataforma: %s, Cantidad de Jugadores: %d)%n", this.nombre, this.plataforma, this.cantidadJugadores);
    }
    //d) Sobrecargar el metodo agregarJugadores() donde en el primero se agregue
    //solo 1 jugador y en otro se ingrese una cantidad de jugadores a aumentar.
    public void agregarJugadores() {
        ++this.cantidadJugadores;
    }

    public void agregarJugadores(int n) {
        this.cantidadJugadores += n;
    }

    public static void main(String[] args) {
        //a) Instanciar al menos 2 videojuegos
        Videojuegos v1 = new Videojuegos("Left 4 dead 2", "Steam");
        Videojuegos v2 = new Videojuegos("League of legend", "Riot", 1000000);
        v1.mostrar();
        v2.mostrar();

        v1.agregarJugadores(150500);
        v1.agregarJugadores();
        //c) Implementar un mwtodo mostrar()
        v1.mostrar();
        v2.mostrar();
    }
}
