package Herencia.Ejercicio1;

public class Vehiculo {
    private String marca;
    private String modelo;
    private String año;
    private double precioBase;

    public Vehiculo(String marca, String modelo, String año, double precioBase) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.precioBase = precioBase;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getAño() {
        return año;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void mostrarInfo() {
        System.out.printf("Marca: %s | Modelo: %s | Año: %s | Precio Base: %.2f%n",
                marca, modelo, año, precioBase);
    }
        public static void main(String[] args) {
            Coche coche1 = new Coche("Toyota", "Corolla", "2025", 25000, 4, "Gasolina");
            Moto moto1 = new Moto("Yamaha", "R6", "2025", 15000, 600, "Gasolina");

            coche1.mostrarInfo();

            moto1.mostrarInfo();
        }


}

class Coche extends Vehiculo {
    private int numPuertas;
    private String tipoCombustible;

    public Coche(String marca, String modelo, String año, double precioBase, int numPuertas, String tipoCombustible) {
        super(marca, modelo, año, precioBase);
        this.numPuertas = numPuertas;
        this.tipoCombustible = tipoCombustible;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.printf("Número de Puertas: %d | Tipo de Combustible: %s%n", numPuertas, tipoCombustible);
    }
}

class Moto extends Vehiculo {
    private int cilindrada;
    private String tipoMotor;

    public Moto(String marca, String modelo, String año, double precioBase, int cilindrada, String tipoMotor) {
        super(marca, modelo, año, precioBase);
        this.cilindrada = cilindrada;
        this.tipoMotor = tipoMotor;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.printf("Cilindrada: %dcc | Tipo de Motor: %s%n", cilindrada, tipoMotor);
    }
}
