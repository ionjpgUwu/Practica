package Herencia.Ejercicio5;

import java.util.ArrayList;

public class Empleado {
    private String nombre, apellido;
    private int antiguedad, salarioBase;

    public Empleado(String nombre, String apellido, int antiguedad, int salarioBase) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.antiguedad = antiguedad;
        this.salarioBase = salarioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public int getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(int salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double calcularSalario() {
        return salarioBase + (salarioBase * 0.05 * antiguedad);
    }

    public void mostrarInfo() {
        System.out.printf("Nombre: %s %s | Antigüedad: %d años | Salario: $%.2f%n",
                nombre, apellido, antiguedad, calcularSalario());
    }
}

// Clase Gerente
class Gerente extends Empleado {
    private String departamento;
    private int bonoGerencial;

    public Gerente(String nombre, String apellido, int antiguedad, int salarioBase, String departamento, int bonoGerencial) {
        super(nombre, apellido, antiguedad, salarioBase);
        this.departamento = departamento;
        this.bonoGerencial = bonoGerencial;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getBonoGerencial() {
        return bonoGerencial;
    }

    public void setBonoGerencial(int bonoGerencial) {
        this.bonoGerencial = bonoGerencial;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + bonoGerencial;
    }

    @Override
    public void mostrarInfo() {
        System.out.printf("Gerente: %s %s | Departamento: %s | Salario: $%.2f%n",
                getNombre(), getApellido(), departamento, calcularSalario());
    }
}

// Clase Desarrollador
class Desarrollador extends Empleado {
    private String lenguajeProgramacion;
    private int horasExtras;

    public Desarrollador(String nombre, String apellido, int antiguedad, int salarioBase, String lenguajeProgramacion, int horasExtras) {
        super(nombre, apellido, antiguedad, salarioBase);
        this.lenguajeProgramacion = lenguajeProgramacion;
        this.horasExtras = horasExtras;
    }

    public String getLenguajeProgramacion() {
        return lenguajeProgramacion;
    }

    public void setLenguajeProgramacion(String lenguajeProgramacion) {
        this.lenguajeProgramacion = lenguajeProgramacion;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + horasExtras * 100;
    }

    @Override
    public void mostrarInfo() {
        System.out.printf("Desarrollador: %s %s | Lenguaje: %s | Salario: $%.2f%n",
                getNombre(), getApellido(), lenguajeProgramacion, calcularSalario());
    }
}

// Clase Main para probar las funcionalidades
class Main {
    public static void main(String[] args) {
        // Crear lista de empleados
        ArrayList<Gerente> gerentes = new ArrayList<>();
        ArrayList<Desarrollador> desarrolladores = new ArrayList<>();

        // Crear instancias de Gerente y Desarrollador
        Gerente g1 = new Gerente("Carlos", "Pérez", 10, 5000, "TI", 1500);
        Gerente g2 = new Gerente("María", "González", 5, 4500, "Ventas", 800);
        Gerente g3 = new Gerente("Juan", "López", 7, 4700, "Marketing", 1200);

        Desarrollador d1 = new Desarrollador("Ana", "Fernández", 3, 3000, "Java", 12);
        Desarrollador d2 = new Desarrollador("Luis", "Gómez", 2, 2800, "Python", 8);
        Desarrollador d3 = new Desarrollador("Pedro", "Martínez", 4, 3200, "JavaScript", 15);

        // Agregar empleados a las listas
        gerentes.add(g1);
        gerentes.add(g2);
        gerentes.add(g3);

        desarrolladores.add(d1);
        desarrolladores.add(d2);
        desarrolladores.add(d3);

        // b) Mostrar salario de cada gerente y desarrollador
        System.out.println("\nSalarios de Gerentes:");
        for (Gerente g : gerentes) {
            g.mostrarInfo();
        }

        System.out.println("\nSalarios de Desarrolladores:");
        for (Desarrollador d : desarrolladores) {
            d.mostrarInfo();
        }

        // c) Mostrar gerentes con bono gerencial mayor a 1000
        System.out.println("\nGerentes con bono mayor a 1000:");
        for (Gerente g : gerentes) {
            if (g.getBonoGerencial() > 1000) {
                g.mostrarInfo();
            }
        }

        // d) Mostrar desarrolladores con más de 10 horas extras
        System.out.println("\nDesarrolladores con más de 10 horas extras:");
        for (Desarrollador d : desarrolladores) {
            if (d.getHorasExtras() > 10) {
                d.mostrarInfo();
            }
        }
    }
}
