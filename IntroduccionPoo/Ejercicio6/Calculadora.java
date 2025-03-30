package IntroduccionPoo.Ejercicio6;

class Calculadora {
    // a) Operaciones básicas
    public static double sumar(double a, double b) {
        return a + b;
    }

    public static double restar(double a, double b) {
        return a - b;
    }

    public static double multiplicar(double a, double b) {
        return a * b;
    }

    public static double dividir(double a, double b) {
        if (b != 0) return a / b;
        else throw new ArithmeticException("No se puede dividir por cero");
    }

    // b) Promedio de tres números
    public static double calcularPromedio(double a, double b, double c) {
        return (a + b + c) / 3;
    }

    // c) Soluciones de ecuación cuadrática
    public static void resolverEcuacion(double a, double b, double c) {
        double discriminante = b * b - 4 * a * c;
        if (discriminante >= 0) {
            double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            System.out.println("Las soluciones son: " + x1 + " y " + x2);
        } else {
            System.out.println("No hay soluciones reales.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Suma: " + sumar(5, 3));
        System.out.println("Resta: " + restar(10, 2));
        System.out.println("Multiplicación: " + multiplicar(4, 3));
        System.out.println("División: " + dividir(20, 5));

        resolverEcuacion(1, -3, 2); // x^2 - 3x + 2 = 0
    }
}

