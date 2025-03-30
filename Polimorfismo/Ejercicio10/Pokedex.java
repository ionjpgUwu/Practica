package Polimorfismo.Ejercicio10;
class Pokemon {
    protected String nombre;
    protected int puntosDeVida;

    public Pokemon(String nombre, int puntosDeVida) {
        this.nombre = nombre;
        this.puntosDeVida = puntosDeVida;
    }

    public void atacar() {
        System.out.println(nombre + " usa un ataque básico.");
    }

    // d) Sobrecarga recibirAtaque()
    public void recibirAtaque(int dano) {
        puntosDeVida -= dano;
        System.out.println(nombre + " ha recibido " + dano + " de daño. Vida restante: " + puntosDeVida);
    }

    public void recibirAtaque() {
        puntosDeVida -= 5;
        System.out.println(nombre + " ha recibido 5 de daño. Vida restante: " + puntosDeVida);
    }
}

// b) Sobrescribe atacar()
class PokemonPlanta extends Pokemon {
    public PokemonPlanta(String nombre, int puntosDeVida) {
        super(nombre, puntosDeVida);
    }

    @Override
    public void atacar() {
        System.out.println(nombre + " usa Hoja Afilada.");
    }
}

// b) Sobrescribe atacar()
class PokemonAgua extends Pokemon {
    private int nivel;

    public PokemonAgua(String nombre, int puntosDeVida, int nivel) {
        super(nombre, puntosDeVida);
        this.nivel = nivel;
    }

    @Override
    public void atacar() {
        System.out.println(nombre + " usa Pistola de Agua.");
    }
}

// b) Sobrescribe atacar()
// c) Sobrecarga atacar()
class PokemonFuego extends Pokemon {
    private int quemadura;

    public PokemonFuego(String nombre, int puntosDeVida, int quemadura) {
        super(nombre, puntosDeVida);
        this.quemadura = quemadura;
    }

    @Override
    public void atacar() {
        System.out.println(nombre + " usa Llamarada.");
    }

    public void atacar(String ataque) {
        System.out.println(nombre + " usa " + ataque + "!");
    }
}

// a) Crear e instanciar al menos 2 Pokémon de cada tipo
public class Pokedex {
    public static void main(String[] args) {
        PokemonPlanta bulbasaur = new PokemonPlanta("Bulbasaur", 50);
        PokemonPlanta chikorita = new PokemonPlanta("Chikorita", 55);

        PokemonAgua squirtle = new PokemonAgua("Squirtle", 60, 5);
        PokemonAgua totodile = new PokemonAgua("Totodile", 65, 6);

        PokemonFuego charmander = new PokemonFuego("Charmander", 58, 3);
        PokemonFuego cyndaquil = new PokemonFuego("Cyndaquil", 62, 4);

        // b) Llamada a los métodos sobrescritos de atacar()
        bulbasaur.atacar();
        chikorita.atacar();
        squirtle.atacar();
        totodile.atacar();
        charmander.atacar();
        cyndaquil.atacar();

        // c) Llamada a los métodos sobrecargados de atacar() en PokemonFuego
        charmander.atacar();
        cyndaquil.atacar("Lanzallamas");

        // d) Llamada a los métodos sobrecargados y sobrescritos de recibirAtaque()
        bulbasaur.recibirAtaque(10);
        squirtle.recibirAtaque();
        charmander.recibirAtaque(15);
        cyndaquil.recibirAtaque();
    }
}
