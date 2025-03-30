package Herencia.Ejercicio2;

public class Electrodomestico {
    private int precioBase, peso;
    private String color;
    private char consumoEnergetico;

    public Electrodomestico(int precioBase, int peso, String color, char consumoEnergetico) {
        this.precioBase = precioBase;
        this.peso = peso;
        this.color = color;
        this.consumoEnergetico = consumoEnergetico;
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public void precioFinal() {
        switch (consumoEnergetico) {
            case 'A': precioBase += 100; break;
            case 'B': precioBase += 80; break;
            case 'C': precioBase += 60; break;
            case 'D': precioBase += 50; break;
            case 'E': precioBase += 30; break;
            case 'F': precioBase += 10; break;
            default:
                System.out.println("Ingrese un valor válido para el consumo energético");
        }

        if (peso >= 80) {
            precioBase += 100;
        } else if (peso >= 50) {
            precioBase += 80;
        } else if (peso >= 20) {
            precioBase += 50;
        } else {
            precioBase += 10;
        }
    }
}

class Lavadora extends Electrodomestico {
    private int carga;

    public Lavadora(int precioBase, int peso, String color, char consumoEnergetico, int carga) {
        super(precioBase, peso, color, consumoEnergetico);
        this.carga = carga;
    }

    @Override
    public void precioFinal() {
        super.precioFinal();
        if (carga > 30) {
            // Si la carga es mayor a 30 kg, se suma 50 al precio
            int nuevoPrecio = getPrecioBase() + 50;
            System.out.println("Precio final Lavadora (con ajuste por carga): " + nuevoPrecio);
        } else {
            System.out.println("Precio final Lavadora: " + getPrecioBase());
        }
    }
}

class Televisor extends Electrodomestico {
    private int resolucion;
    private boolean sintonizadorTDT;

    public Televisor(int precioBase, int peso, String color, char consumoEnergetico, int resolucion, boolean sintonizadorTDT) {
        super(precioBase, peso, color, consumoEnergetico);
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    @Override
    public void precioFinal() {
        super.precioFinal();
        int precioFinal = getPrecioBase();

        if (resolucion > 40) {
            precioFinal += (precioFinal * 30) / 100;
        }

        if (sintonizadorTDT) {
            precioFinal += 50;
        }

        System.out.println("Precio final Televisor: " + precioFinal);
    }
}

class Main {
    public static void main(String[] args) {
        Lavadora lavadora1 = new Lavadora(300, 25, "Blanco", 'A', 35);
        Televisor televisor1 = new Televisor(500, 15, "Negro", 'B', 42, true);

        lavadora1.precioFinal();
        televisor1.precioFinal();
    }
}
