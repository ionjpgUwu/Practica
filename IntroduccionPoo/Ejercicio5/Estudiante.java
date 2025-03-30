package IntroduccionPoo.Ejercicio5;

class Estudiante {
    private String nombre;
    private double nota1, nota2;

    public Estudiante(String nombre, double nota1, double nota2) {
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    // a) Calcular promedio
    public double calcularPromedio() {
        return (nota1 + nota2) / 2;
    }

    // b) Verificar si aprobó
    public boolean aprobo() {
        return calcularPromedio() >= 6;
    }

    public static void main(String[] args) {
        Estudiante e1 = new Estudiante("Pedro", 7, 8);
        Estudiante e2 = new Estudiante("Laura", 5, 6);
        Estudiante e3 = new Estudiante("Diego", 9, 10);

        System.out.println("Pedro promedio: " + e1.calcularPromedio() + " - ¿Aprobó? " + e1.aprobo());
        System.out.println("Laura promedio: " + e2.calcularPromedio() + " - ¿Aprobó? " + e2.aprobo());
        System.out.println("Diego promedio: " + e3.calcularPromedio() + " - ¿Aprobó? " + e3.aprobo());
    }
}

