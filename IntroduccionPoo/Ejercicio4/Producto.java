package IntroduccionPoo.Ejercicio4;

class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // a) Aplicar descuento
    public void aplicarDescuento() {
        if ((int) precio % 2 == 0) {
            precio *= 0.9; // 10% descuento
        } else {
            precio *= 0.85; // 15% descuento
        }
    }

    public double getPrecio() {
        return precio;
    }

    public static void main(String[] args) {
        Producto p1 = new Producto("Laptop", 1000);
        Producto p2 = new Producto("Celular", 750);
        Producto p3 = new Producto("Tablet", 500);

        p1.aplicarDescuento();
        p2.aplicarDescuento();
        p3.aplicarDescuento();

        System.out.println("Precio con descuento:");
        System.out.println("Laptop: $" + p1.getPrecio());
        System.out.println("Celular: $" + p2.getPrecio());
        System.out.println("Tablet: $" + p3.getPrecio());
    }
}
