package Persistencia.ejercicios5;

import java.io.*;
import java.util.*;

public class SistemaFarmacia implements Serializable {

    // ---------- CLASE MEDICAMENTO ----------
    static class Medicamento implements Serializable {
        private String nombre;
        private String codMedicamento;
        private String tipo;
        private float precio;

        public void leer(Scanner sc) {
            System.out.print("Nombre: ");
            nombre = sc.nextLine();
            System.out.print("Código: ");
            codMedicamento = sc.nextLine();
            System.out.print("Tipo: ");
            tipo = sc.nextLine();
            System.out.print("Precio: ");
            precio = Float.parseFloat(sc.nextLine());
        }

        public void mostrar() {
            System.out.println("Nombre: " + nombre + ", Código: " + codMedicamento + ", Tipo: " + tipo + ", Precio: " + precio);
        }

        public String getTipo() {
            return tipo;
        }

        public float getPrecio() {
            return precio;
        }

        public String getNombre() {
            return nombre;
        }
    }

    // ---------- CLASE FARMACIA ----------
    static class Farmacia implements Serializable {
        private String nombreFarmacia;
        private int sucursal;
        private String direccion;
        private int nroMedicamentos;
        private Medicamento[] medicamentos = new Medicamento[100];

        public void leer(Scanner sc) {
            System.out.print("Nombre Farmacia: ");
            nombreFarmacia = sc.nextLine();
            System.out.print("Sucursal: ");
            sucursal = Integer.parseInt(sc.nextLine());
            System.out.print("Dirección: ");
            direccion = sc.nextLine();
            System.out.print("Nro medicamentos: ");
            nroMedicamentos = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < nroMedicamentos; i++) {
                medicamentos[i] = new Medicamento();
                System.out.println("Medicamento " + (i + 1) + ":");
                medicamentos[i].leer(sc);
            }
        }

        public void mostrar() {
            System.out.println("\nFarmacia: " + nombreFarmacia + " | Sucursal: " + sucursal + " | Dirección: " + direccion);
            for (int i = 0; i < nroMedicamentos; i++) {
                medicamentos[i].mostrar();
            }
        }

        public String getDireccion() {
            return direccion;
        }

        public int getSucursal() {
            return sucursal;
        }

        public boolean contieneMedicamento(String nombre) {
            for (int i = 0; i < nroMedicamentos; i++) {
                if (medicamentos[i].getNombre().equalsIgnoreCase(nombre)) {
                    return true;
                }
            }
            return false;
        }

        public void mostrarMedicamentosPorTipo(String tipo) {
            for (int i = 0; i < nroMedicamentos; i++) {
                if (medicamentos[i].getTipo().equalsIgnoreCase(tipo)) {
                    medicamentos[i].mostrar();
                }
            }
        }
    }

    // ---------- CLASE ARCHIVO ----------
    static class ArchFarmacia implements Serializable {
        private ArrayList<Farmacia> farmacias = new ArrayList<>();
        private static final String ARCHIVO = "farmacias.dat";

        public void crearArchivos() {
            farmacias = new ArrayList<>();
            guardarEnArchivo();
        }

        public void adicionar(Farmacia f) {
            farmacias.add(f);
            guardarEnArchivo();
        }

        public void listar() {
            for (Farmacia f : farmacias) {
                f.mostrar();
            }
        }

        // b) Mostrar medicamentos tipo "tos" en sucursal específica
        public void mostrarMedicamentosTos(int sucursalX) {
            for (Farmacia f : farmacias) {
                if (f.getSucursal() == sucursalX) {
                    System.out.println("\n--- Medicamentos para la TOS en Sucursal " + sucursalX + " ---");
                    f.mostrarMedicamentosPorTipo("tos");
                }
            }
        }

        // c) Mostrar sucursales que tienen un medicamento específico
        public void mostrarSucursalesConMedicamento(String nombreMedicamento) {
            System.out.println("\nFarmacias con el medicamento '" + nombreMedicamento + "':");
            for (Farmacia f : farmacias) {
                if (f.contieneMedicamento(nombreMedicamento)) {
                    System.out.println("Sucursal: " + f.getSucursal() + " | Dirección: " + f.getDireccion());
                }
            }
        }

        public void guardarEnArchivo() {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
                oos.writeObject(farmacias);
            } catch (IOException e) {
                System.out.println("Error guardando archivo: " + e.getMessage());
            }
        }

        @SuppressWarnings("unchecked")
        public void cargarDesdeArchivo() {
            File f = new File(ARCHIVO);
            if (f.exists()) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
                    farmacias = (ArrayList<Farmacia>) ois.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("Error cargando archivo: " + e.getMessage());
                    farmacias = new ArrayList<>();
                }
            } else {
                farmacias = new ArrayList<>();
            }
        }
    }

    // ---------- MÉTODO PRINCIPAL ----------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArchFarmacia arch = new ArchFarmacia();
        arch.cargarDesdeArchivo();

        System.out.println("¿Desea crear un nuevo archivo? (S/N)");
        String respuesta = sc.nextLine();
        if (respuesta.equalsIgnoreCase("S")) {
            arch.crearArchivos();
        }

        for (int i = 0; i < 2; i++) {
            System.out.println("\n--- Ingresando Farmacia " + (i + 1) + " ---");
            Farmacia f = new Farmacia();
            f.leer(sc);
            arch.adicionar(f);
        }

        System.out.println("\n--- Listado de Farmacias ---");
        arch.listar();

        // b) Mostrar medicamentos para la tos en sucursal 1
        arch.mostrarMedicamentosTos(1);

        // c) Mostrar sucursales que tienen "Golpex"
        arch.mostrarSucursalesConMedicamento("Golpex");
    }
}
