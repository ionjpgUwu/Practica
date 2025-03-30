package IntroduccionPoo.Ejercicio9;

class Computadora {
    private boolean encendida = false;

    // a) Muestra los componentes principales de la computadora
    public void mostrarComponentes() {
        System.out.println("Componentes: Procesador, RAM, Tarjeta Gráfica, Almacenamiento, Placa base.");
    }

    // b) Metodo para mostrar el estado de la computadora (encendido o apagado)
    public void mostrarEstado() {
        System.out.println("Estado: " + (encendida ? "Encendida" : "Apagada"));
    }

    // c) Encender la computadora
    public void encender() {
        if (!encendida) {
            encendida = true;
            System.out.println("Computadora encendida.");
        } else {
            System.out.println("La computadora ya está encendida.");
        }
    }

    // c) Apagar la computadora
    public void apagar() {
        if (encendida) {
            encendida = false;
            System.out.println("Computadora apagada.");
        } else {
            System.out.println("La computadora ya está apagada.");
        }
    }

    public static void main(String[] args) {
        Computadora pc = new Computadora();
        pc.mostrarComponentes();
        pc.mostrarEstado();
        pc.encender();
        pc.mostrarEstado();
        pc.apagar();
    }
}
