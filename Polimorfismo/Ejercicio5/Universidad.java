package Polimorfismo.Ejercicio5;

class Oficina {
    private int nroSillas, nroEscritorios, nroEstanterias;

    public Oficina(int nroSillas, int nroEscritorios, int nroEstanterias) {
        this.nroSillas = nroSillas;
        this.nroEscritorios = nroEscritorios;
        this.nroEstanterias = nroEstanterias;
    }

    public void mostrar() {
        System.out.println("Oficina | Sillas: " + nroSillas + " | Escritorios: " + nroEscritorios + " | Estanterías: " + nroEstanterias);
    }

    // Metodo cantidadMuebles() para una sola oficina
    public int cantidadMuebles() {
        return nroSillas + nroEscritorios + nroEstanterias;
    }

    // Sobrecarga
    public int cantidadMuebles(Oficina otra) {
        return this.cantidadMuebles() + otra.cantidadMuebles();
    }
}

class Aula {
    private String nombre;
    private int capacidad, nroPupitres;

    public Aula(String nombre, int capacidad, int nroPupitres) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.nroPupitres = nroPupitres;
    }

    public void mostrar() {
        System.out.println("Aula: " + nombre + " | Capacidad: " + capacidad + " | Pupitres: " + nroPupitres);
    }

    // Metodo cantidadMuebles() para un aula
    public int cantidadMuebles() {
        return nroPupitres;
    }

    // Sobrecarga
    public int cantidadMuebles(Aula otra) {
        return this.cantidadMuebles() + otra.cantidadMuebles();
    }
}

class Laboratorio {
    private String nombre;
    private int capacidad, nroMesas, nroSillas;

    public Laboratorio(String nombre, int capacidad, int nroMesas, int nroSillas) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.nroMesas = nroMesas;
        this.nroSillas = nroSillas;
    }

    public void mostrar() {
        System.out.println("Laboratorio: " + nombre + " | Capacidad: " + capacidad + " | Mesas: " + nroMesas + " | Sillas: " + nroSillas);
    }

    // Metodo cantidadMuebles() para un laboratorio
    public int cantidadMuebles() {
        return nroMesas + nroSillas;
    }

    // Sobrecarga
    public int cantidadMuebles(Laboratorio otro) {
        return this.cantidadMuebles() + otro.cantidadMuebles();
    }
}

public class Universidad {
    public static void main(String[] args) {
        //a) Instanciar 2 objetos Oficina, 2 Aulas y 1 Laboratorio
        Oficina oficina1 = new Oficina(5, 3, 2);
        Oficina oficina2 = new Oficina(4, 2, 1);
        Aula aula1 = new Aula("Aula 101", 30, 30);
        Aula aula2 = new Aula("Aula 102", 25, 25);
        Laboratorio laboratorio1 = new Laboratorio("Lab Computación", 20, 10, 20);

        //b) Crear un metodo mostrar() para mostrar los datos de cada objeto
        oficina1.mostrar();
        oficina2.mostrar();
        aula1.mostrar();
        aula2.mostrar();
        laboratorio1.mostrar();

        //c) Sobrecargar el metodo cantidadMuebles(), para conocer el número total de
        //muebles dentro de cada ambiente
        System.out.println("Oficina 1: " + oficina1.cantidadMuebles());
        System.out.println("Aula 1: " + aula1.cantidadMuebles());

        // Sobrecarga
        System.out.println("Cantidad total de muebles entre Oficina 1 y Oficina 2: " + oficina1.cantidadMuebles(oficina2));
        System.out.println("Cantidad total de muebles entre Aula 1 y Aula 2: " + aula1.cantidadMuebles(aula2));
    }
}
