package IntroduccionPoo.Ejercicio1;

class Persona {
    private String nombre;
    private int edad;
    private String ciudad;

    public Persona(String nombre, int edad, String ciudad) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    // a) Saludo
    public void saludar() {
        System.out.println("Hola, soy " + nombre + " de " + ciudad);
    }

    // c) Verificar si es mayor de edad
    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    public static void main(String[] args) {
        // b) Crear 3 personas
        Persona p1 = new Persona("Carlos", 25, "Lima");
        Persona p2 = new Persona("Ana", 17, "Bogotá");
        Persona p3 = new Persona("Luis", 30, "Buenos Aires");

        p1.saludar();
        p2.saludar();
        p3.saludar();

        System.out.println("¿Carlos es mayor de edad? " + p1.esMayorDeEdad());
    }
}
