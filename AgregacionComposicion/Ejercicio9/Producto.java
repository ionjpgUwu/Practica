import java.util.ArrayList;
import java.util.List;

class Producto {
    private String nombre;
    private double precio;
    
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    
    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    
    public void mostrarInfo() {
        System.out.printf("Producto: %s | Precio: $%.2f%n", nombre, precio);
    }
}

class CarritoCompras {
    private List<Producto> productos;
    public static final int MAX_PRODUCTOS = 10;
    
    public CarritoCompras() {
        this.productos = new ArrayList<>();
    }
    
    public boolean agregarProducto(Producto producto) {
        if (productos.size() >= MAX_PRODUCTOS) {
            System.out.println("¡Error! El carrito no puede contener más de 10 productos");
            return false;
        }
        if (producto != null) {
            productos.add(producto);
            return true;
        }
        return false;
    }
    
    public void mostrarCarrito() {
        System.out.println("\nContenido del carrito:");
        for (Producto p : productos) {
            p.mostrarInfo();
        }
        System.out.printf("Total productos: %d/%d%n", productos.size(), MAX_PRODUCTOS);
    }
    
    public List<Producto> getProductos() {
        return new ArrayList<>(productos); // Retorna copia
    }
}

public class Main {
    public static void main(String[] args) {
        // Productos independientes
        Producto p1 = new Producto("Smartphone", 599.99);
        Producto p2 = new Producto("Auriculares", 89.50);
        
        // Crear carrito
        CarritoCompras carrito = new CarritoCompras();
        
        // Agregar productos (validando límite)
        for (int i = 0; i < 12; i++) { // Intentar agregar 12
            Producto nuevo = new Producto("Artículo " + (i+1), (i+1)*15.0);
            if (!carrito.agregarProducto(nuevo)) {
                break;
            }
        }
        
        // Mostrar carrito
        carrito.mostrarCarrito();
        
        // Productos existen independientemente
        System.out.println("\nProductos fuera del carrito:");
        p1.mostrarInfo();
        p2.mostrarInfo();
    }
}