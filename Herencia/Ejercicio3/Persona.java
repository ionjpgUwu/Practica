package Herencia.Ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre, apellido, fechaNac;
    private int ci, celular;

    public Persona(String nombre, String apellido, String fechaNac, int ci, int celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.ci = ci;
        this.celular = celular;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        int añoNacimiento = Integer.parseInt(fechaNac.split("/")[2]); // Extrae el año como entero
        return 2025 - añoNacimiento; // Suponiendo el año actual como 2025
    }

    public void mostrar() {
        System.out.printf("Nombre: %s | Apellido: %s | Fecha de Nacimiento: %s | CI: %d | Celular: %d%n",
                nombre, apellido, fechaNac, ci, celular);
    }
}

// Subclase Estudiante
class Estudiante extends Persona {
    private int ru, semestre;
    private String fechaIngreso;

    public Estudiante(String nombre, String apellido, String fechaNac, int ci, int celular, int ru, int semestre, String fechaIngreso) {
        super(nombre, apellido, fechaNac, ci, celular);
        this.ru = ru;
        this.semestre = semestre;
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.printf(" | RU: %d | Semestre: %d | Fecha de Ingreso: %s%n", ru, semestre, fechaIngreso);
    }
}

// Subclase Docente
class Docente extends Persona {
    private String profesion, especialidad, sexo;
    private int nit;

    public Docente(String nombre, String apellido, String fechaNac, int ci, int celular, String profesion, String especialidad, int nit, String sexo) {
        super(nombre, apellido, fechaNac, ci, celular);
        this.profesion = profesion;
        this.especialidad = especialidad;
        this.nit = nit;
        this.sexo = sexo;
    }

    public String getProfesion() {
        return profesion;
    }

    public String getSexo() {
        return sexo;
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.printf(" | Profesión: %s | Especialidad: %s | NIT: %d%n", profesion, especialidad, nit);
    }
}

// Clase Main para pruebas
class Main {
    public static void main(String[] args) {
        // Lista de estudiantes y docentes
        List<Estudiante> estudiantes = new ArrayList<>();
        List<Docente> docentes = new ArrayList<>();

        // Crear estudiantes
        estudiantes.add(new Estudiante("Carlos", "Pérez", "15/06/1998", 1234567, 789654, 1001, 8, "01/03/2020"));
        estudiantes.add(new Estudiante("Ana", "López", "20/08/2001", 7654321, 321987, 1002, 5, "01/03/2022"));
        estudiantes.add(new Estudiante("Juan", "González", "30/09/1995", 4567891, 852741, 1003, 10, "01/03/2018"));

        // Crear docentes
        docentes.add(new Docente("Mario", "Fernández", "05/07/1980", 1122334, 123456, "Ingeniero", "Software", 556677, "Masculino"));
        docentes.add(new Docente("Luis", "Gómez", "12/11/1975", 2233445, 987654, "Ingeniero", "Redes", 112233, "Masculino"));
        docentes.add(new Docente("Laura", "Pérez", "25/04/1985", 3344556, 456123, "Licenciada", "Matemáticas", 778899, "Femenino"));

        // a) Mostrar estudiantes mayores de 25 años
        System.out.println("\n--- Estudiantes mayores de 25 años ---");
        for (Estudiante est : estudiantes) {
            if (est.getEdad() > 25) {
                est.mostrar();
            }
        }

        // b) Mostrar al docente Ingeniero masculino más mayor
        Docente mayorIngeniero = null;
        for (Docente doc : docentes) {
            if (doc.getProfesion().equals("Ingeniero") && doc.getSexo().equals("Masculino")) {
                if (mayorIngeniero == null || doc.getEdad() > mayorIngeniero.getEdad()) {
                    mayorIngeniero = doc;
                }
            }
        }
        if (mayorIngeniero != null) {
            System.out.println("\n--- Docente Ingeniero Masculino Más Mayor ---");
            mayorIngeniero.mostrar();
        }

        // c) Mostrar estudiantes y docentes con el mismo apellido
        System.out.println("\n--- Personas con el mismo apellido ---");
        for (Estudiante est : estudiantes) {
            for (Docente doc : docentes) {
                if (est.getApellido().equals(doc.getApellido())) {
                    System.out.println("Coincidencia de apellido: " + est.getApellido());
                    est.mostrar();
                    doc.mostrar();
                }
            }
        }
    }
}
