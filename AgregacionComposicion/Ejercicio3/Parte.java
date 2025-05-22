// a) Implementa las clases con sus constructores, getters y setters.
class Parte {
    private String nombre;
    private double peso;

    public Parte(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void mostrarInfo() {
        System.out.println("Parte: " + nombre + ", Peso: " + peso + " kg");
    }
}

import java.util.ArrayList;
import java.util.List;

class Avion {
    private String modelo;
    private String fabricante;
    private List<Parte> partes;

    public Avion(String modelo, String fabricante) {
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.partes = new ArrayList<>();
    }

    public String getModelo() {
        return modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public List<Parte> getPartes() {
        return partes;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void agregarParte(Parte parte) {
        partes.add(parte);
    }

    public void mostrarAvion() {
        System.out.println("Modelo: " + modelo + ", Fabricante: " + fabricante);
        for (Parte p : partes) {
            p.mostrarInfo();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // b) Crea un avión y agrega varias partes.
        Avion avion = new Avion("Boeing 747", "Boeing");
        avion.agregarParte(new Parte("Motor", 3000));
        avion.agregarParte(new Parte("Ala izquierda", 2000));
        avion.agregarParte(new Parte("Ala derecha", 2000));
        avion.agregarParte(new Parte("Tren de aterrizaje", 1500));

        // c) Muestra la información del avión y sus partes.
        avion.mostrarAvion();
    }
}
