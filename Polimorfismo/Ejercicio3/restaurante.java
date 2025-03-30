package Polimorfismo.Ejercicio3;

class Restaurante {
    private String nombre;
    private int sueldoMes;

    public Restaurante(String nombre, int sueldoMes) {
        this.nombre = nombre;
        this.sueldoMes = sueldoMes;
    }

    public int sueldoTotal() {
        return sueldoMes;
    }

    public void mostrar() {
        System.out.println(nombre + " - Sueldo: " + sueldoTotal());
    }

    // c) Sobrecarga del metodo para verificar si el sueldo es igual a X
    public boolean sueldoIgualA(int sueldo) {
        return this.sueldoMes == sueldo;
    }
}

class Cocinero extends Restaurante {
    private int horasExtras, sueldoHora;

    public Cocinero(String nombre, int sueldoMes, int horasExtras, int sueldoHora) {
        super(nombre, sueldoMes);
        this.horasExtras = horasExtras;
        this.sueldoHora = sueldoHora;
    }

    // b)Sobrecarga del metodo sueldoTotal para sumar horas extras
    @Override
    public int sueldoTotal() {
        return super.sueldoTotal() + (horasExtras * sueldoHora);
    }
}

class Mesero extends Cocinero {
    private int propina;

    public Mesero(String nombre, int sueldoMes, int horasExtras, int sueldoHora, int propina) {
        super(nombre, sueldoMes, horasExtras, sueldoHora);
        this.propina = propina;
    }

    // b)Sobrecarga del metodo sueldoTotal para sumar propina
    @Override
    public int sueldoTotal() {
        return super.sueldoTotal() + propina;
    }
}

class Administrativo extends Restaurante {
    public Administrativo(String nombre, int sueldoMes) {
        super(nombre, sueldoMes);
    }
}

public class restaurante {
    public static void main(String[] args) {
        // a) Instanciar 1 Cocinero, 2 Meseros y 2 Administrativos
        Restaurante[] empleados = {
                new Cocinero("Carlos", 1200, 10, 5),
                new Mesero("Ana", 1000, 5, 4, 50),
                new Mesero("Luis", 1100, 8, 3, 70),
                new Administrativo("Marta", 1500),
                new Administrativo("Pedro", 1300)
        };
        // c) Mostrar empleados con sueldo igual a X
        for (Restaurante e : empleados) {
            if (e.sueldoIgualA(1000)) e.mostrar();
        }
    }
}
