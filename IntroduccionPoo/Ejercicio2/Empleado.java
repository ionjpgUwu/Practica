package IntroduccionPoo.Ejercicio2;

class Empleado {
    private String nombre;
    private double sueldo;

    public Empleado(String nombre, double sueldo) {
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    // a) Calcular sueldo anual
    public double calcularSueldoAnual() {
        return sueldo * 12;
    }

    // b) Aplicar aumento del 10%
    public void aplicarAumento() {
        sueldo *= 1.1;
    }

    public void mostrarSueldo() {
        System.out.println(nombre + " tiene un sueldo de: $" + sueldo);
    }

    public static void main(String[] args) {
        // c) Crear dos empleados
        Empleado e1 = new Empleado("Juan", 1500);
        Empleado e2 = new Empleado("María", 2000);

        e1.mostrarSueldo();
        e2.mostrarSueldo();

        e1.aplicarAumento();
        e2.aplicarAumento();

        System.out.println("Después del aumento:");
        e1.mostrarSueldo();
        e2.mostrarSueldo();
    }
}

