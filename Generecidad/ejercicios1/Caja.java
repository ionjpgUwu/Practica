public class Caja<T> {
    private T contenido;

    public void guardar(T valor) {
        contenido = valor;
    }

    public T obtener() {
        return contenido;
    }

    public static void main(String[] args) {
        // a) Agrega métodos guardar() y obtener()

        // b) Crea dos instancias de la caja y almacena 2 datos de diferente tipo
        Caja<String> caja1 = new Caja<>();
        Caja<Integer> caja2 = new Caja<>();

        caja1.guardar("Hola Mundo");
        caja2.guardar(42);

        // c) Muestra el contenido de las cajas
        System.out.println("Contenido de caja1: " + caja1.obtener());
        System.out.println("Contenido de caja2: " + caja2.obtener());
    }
}
