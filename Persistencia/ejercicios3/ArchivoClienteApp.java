package Persistencia.ejercicios3;

import java.io.*;
import java.util.ArrayList;

/**
 * Aplicación para gestionar clientes utilizando archivos con serialización.
 */
public class ArchivoClienteApp {

    // a) Clase Cliente
    static class Cliente implements Serializable {
        private static final long serialVersionUID = 1L;

        private int id;
        private String nombre;
        private String telefono;

        public Cliente(int id, String nombre, String telefono) {
            this.id = id;
            this.nombre = nombre;
            this.telefono = telefono;
        }

        public int getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public String getTelefono() {
            return telefono;
        }

        @Override
        public String toString() {
            return "Cliente{" +
                    "id=" + id +
                    ", nombre='" + nombre + '\'' +
                    ", telefono='" + telefono + '\'' +
                    '}';
        }
    }

    // b) Clase ArchivoCliente con métodos de persistencia y búsqueda
    static class ArchivoCliente {
        private ArrayList<Cliente> clientes = new ArrayList<>();
        private final String archivoNombre = "clientes.dat";

        // Crea el archivo limpiando cualquier contenido previo
        public void crearArchivo() {
            clientes = new ArrayList<>();
            guardarEnArchivo();
        }

        // Guarda un nuevo cliente
        public void guardarCliente(Cliente c) {
            clientes.add(c);
            guardarEnArchivo();
        }

        // b) Buscar cliente por ID
        public Cliente buscarCliente(int id) {
            cargarDesdeArchivo();
            for (Cliente c : clientes) {
                if (c.getId() == id) {
                    return c;
                }
            }
            return null;
        }

        // c) Buscar número de celular por ID
        public String buscarCelularCliente(int id) {
            cargarDesdeArchivo();
            for (Cliente c : clientes) {
                if (c.getId() == id) {
                    return "Cliente: " + c.getNombre() + ", Teléfono: " + c.getTelefono();
                }
            }
            return "Cliente no encontrado";
        }

        // Guarda la lista de clientes en el archivo
        private void guardarEnArchivo() {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoNombre))) {
                oos.writeObject(clientes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Carga los clientes desde el archivo
        @SuppressWarnings("unchecked")
        private void cargarDesdeArchivo() {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoNombre))) {
                clientes = (ArrayList<Cliente>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                clientes = new ArrayList<>(); // Si no existe el archivo o está vacío
            }
        }
    }

    // Main de prueba
    public static void main(String[] args) {
        ArchivoCliente archivo = new ArchivoCliente();

        // Crear o reiniciar archivo
        archivo.crearArchivo();

        // Agregar clientes
        archivo.guardarCliente(new Cliente(1, "Carlos", "123456789"));
        archivo.guardarCliente(new Cliente(2, "María", "987654321"));
        archivo.guardarCliente(new Cliente(3, "Lucía", "555555555"));

        // Buscar cliente por ID
        Cliente clienteEncontrado = archivo.buscarCliente(2);
        if (clienteEncontrado != null) {
            System.out.println("Cliente encontrado: " + clienteEncontrado);
        } else {
            System.out.println("Cliente no encontrado.");
        }

        // Buscar celular del cliente por ID
        System.out.println(archivo.buscarCelularCliente(3));
    }
}
