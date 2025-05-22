import java.util.ArrayList;
import java.util.List;

class Estudiante {
    private String nombre;
    private String carrera;
    private int semestre;
    
    public Estudiante(String nombre, String carrera, int semestre) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.semestre = semestre;
    }
    
    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }
    public int getSemestre() { return semestre; }
    public void setSemestre(int semestre) { this.semestre = semestre; }
    
    public void mostrarInfo() {
        System.out.printf("Estudiante: %s | Carrera: %s | Semestre: %d%n", 
                         nombre, carrera, semestre);
    }
}

class Universidad {
    private String nombre;
    private List<Estudiante> estudiantes;
    
    public Universidad(String nombre) {
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
    }
    
    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public List<Estudiante> getEstudiantes() { return estudiantes; }
    
    public void agregarEstudiante(Estudiante estudiante) {
        if (estudiante != null) {
            estudiantes.add(estudiante);
        }
    }
    
    public void mostrarUniversidad() {
        System.out.printf("%nUniversidad: %s%n", nombre);
        System.out.println("Estudiantes inscritos:");
        for (Estudiante est : estudiantes) {
            est.mostrarInfo();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Estudiantes independientes
        Estudiante est1 = new Estudiante("Luisa Méndez", "Derecho", 5);
        Estudiante est2 = new Estudiante("Jorge Castro", "Arquitectura", 3);
        
        // Universidad
        Universidad uni = new Universidad("UNI");
        uni.agregarEstudiante(est1);
        uni.agregarEstudiante(est2);
        
        // Mostrar información
        uni.mostrarUniversidad();
        
        // Estudiantes existen independientemente
        System.out.println("\nEstudiantes por separado:");
        est1.mostrarInfo();
        est2.mostrarInfo();
    }
}