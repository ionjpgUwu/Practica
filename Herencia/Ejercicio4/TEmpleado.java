package Herencia.Ejercicio4;

// Clase base TEmpleado
public class TEmpleado {
    private String nombre;

    public TEmpleado() {
        this.nombre = "Desconocido";
    }

    public TEmpleado(String nombre) {
        this.nombre = nombre;
    }

    public TEmpleado(TEmpleado otro) {
        this.nombre = otro.nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

// Clase TFijo que hereda de TEmpleado
class TFijo extends TEmpleado {
    private double sueldo;

    // Constructor por defecto
    public TFijo() {
        super(); // Llama al constructor de la superclase
        this.sueldo = 0.0;
    }

    // Constructor con parámetros
    public TFijo(String nombre, double sueldo) {
        super(nombre);
        this.sueldo = sueldo;
    }

    // Constructor de copia
    public TFijo(TFijo otro) {
        super(otro); // Llama al constructor de copia de la superclase
        this.sueldo = otro.sueldo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}

// Clase TComisionista que hereda de TEmpleado
class TComisionista extends TEmpleado {
    private double base, comision, ventas;

    // Constructor por defecto
    public TComisionista() {
        super();
        this.base = 0.0;
        this.comision = 0.0;
        this.ventas = 0.0;
    }

    // Constructor con parámetros
    public TComisionista(String nombre, double base, double comision, double ventas) {
        super(nombre);
        this.base = base;
        this.comision = comision;
        this.ventas = ventas;
    }

    // Constructor de copia
    public TComisionista(TComisionista otro) {
        super(otro);
        this.base = otro.base;
        this.comision = otro.comision;
        this.ventas = otro.ventas;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public double getVentas() {
        return ventas;
    }

    public void setVentas(double ventas) {
        this.ventas = ventas;
    }

    // Método para calcular el salario total del comisionista
    public double calcularSalario() {
        return base + (comision * ventas);
    }
}

// Clase Main para probar las clases
class Main {
    public static void main(String[] args) {
        TFijo empleadoFijo1 = new TFijo("Carlos Pérez", 2500);
        TFijo empleadoFijo2 = new TFijo(empleadoFijo1); // Uso del constructor de copia

        TComisionista empleadoCom1 = new TComisionista("Ana López", 1000, 0.05, 20000);
        TComisionista empleadoCom2 = new TComisionista(empleadoCom1); // Uso del constructor de copia

        System.out.println("Empleado Fijo 1: " + empleadoFijo1.getNombre() + " | Sueldo: $" + empleadoFijo1.getSueldo());
        System.out.println("Empleado Fijo 2 (copia): " + empleadoFijo2.getNombre() + " | Sueldo: $" + empleadoFijo2.getSueldo());

        System.out.println("Empleado Comisionista 1: " + empleadoCom1.getNombre() + " | Salario Total: $" + empleadoCom1.calcularSalario());
        System.out.println("Empleado Comisionista 2 (copia): " + empleadoCom2.getNombre() + " | Salario Total: $" + empleadoCom2.calcularSalario());
    }
}
