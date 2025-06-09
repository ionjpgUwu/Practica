package Persistencia.ejercicios1;

import java.io.*;
import java.util.ArrayList;

public class ArchivoEmpleadoApp {

    static class Empleado implements Serializable {
        private static final long serialVersionUID = 1L;

        private String nombre;
        private int edad;
        private float salario;

        public Empleado(String nombre, int edad, float salario) {
            this.nombre = nombre;
            this.edad = edad;
            this.salario = salario;
        }

        public String getNombre() {
            return nombre;
        }

        public int getEdad() {
            return edad;
        }

        public float getSalario() {
            return salario;
        }

        @Override
        public String toString() {
            return "Empleado{" +
                    "nombre='" + nombre + '\'' +
                    ", edad=" + edad +
                    ", salario=" + salario +
                    '}';
        }
    }

    static class ArchivoEmpleado {
        private ArrayList<Empleado> empleados = new ArrayList<>();
        private final String archivoNombre = "empleados.dat";

        public void crearArchivo() {
            empleados = new ArrayList<>();
            guardarEnArchivo();
        }

        // a) guardarEmpleado(Empleado e)
        public void guardarEmpleado(Empleado e) {
            empleados.add(e);
            guardarEnArchivo();
        }

        // b) buscarEmpleado(String nombre)
        public Empleado buscarEmpleado(String nombre) {
            cargarDesdeArchivo();
            for (Empleado e : empleados) {
                if (e.getNombre().equalsIgnoreCase(nombre)) {
                    return e;
                }
            }
            return null;
        }

        // c) mayorSalario(float sueldo)
        public Empleado mayorSalario(float sueldo) {
            cargarDesdeArchivo();
            for (Empleado e : empleados) {
                if (e.getSalario() > sueldo) {
                    return e;
                }
            }
            return null;
        }

        private void guardarEnArchivo() {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoNombre))) {
                oos.writeObject(empleados);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @SuppressWarnings("unchecked")
        private void cargarDesdeArchivo() {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoNombre))) {
                empleados = (ArrayList<Empleado>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                empleados = new ArrayList<>();
            }
        }
    }

    public static void main(String[] args) {
        ArchivoEmpleado archivo = new ArchivoEmpleado();

        archivo.crearArchivo();

        archivo.guardarEmpleado(new Empleado("Ana", 30, 1200.50f));
        archivo.guardarEmpleado(new Empleado("Luis", 25, 950.00f));
        archivo.guardarEmpleado(new Empleado("Carla", 28, 1500.00f));

        Empleado encontrado = archivo.buscarEmpleado("Luis");
        if (encontrado != null) {
            System.out.println("Empleado encontrado: " + encontrado);
        } else {
            System.out.println("Empleado no encontrado.");
        }

        Empleado mejorPago = archivo.mayorSalario(1000.00f);
        if (mejorPago != null) {
            System.out.println("Empleado con salario mayor a 1000: " + mejorPago);
        } else {
            System.out.println("Ningún empleado supera ese salario.");
        }
    }
}
