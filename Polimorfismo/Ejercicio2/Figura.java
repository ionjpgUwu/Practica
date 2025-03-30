package Polimorfismo.Ejercicio2;

class Cuadrado {
    private int lado;

    public Cuadrado(int lado) {
        this.lado = lado;
    }

    public double area() {
        return lado * lado;
    }
    //Area combinada de dos cuadrados
    public double area(Cuadrado otro) { // Sobrecarga
        return this.area() + otro.area();
    }

    public void mostrar() {
        System.out.println("Cuadrado - Lado: " + lado + ", Área: " + area());
    }
}

class Rectangulo {
    private int base, altura;

    public Rectangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    public double area() {
        return base * altura;
    }
    //Area combinada de dos rectangulos
    public double area(Rectangulo otro) { // Sobrecarga
        return this.area() + otro.area();
    }

    public void mostrar() {
        System.out.println("Rectángulo - Base: " + base + ", Altura: " + altura + ", Área: " + area());
    }
}

class Circulo {
    private int radio;

    public Circulo(int radio) {
        this.radio = radio;
    }

    public double area() {
        return Math.PI * radio * radio;
    }
    //Area combinada de dos circulos
    public double area(Circulo otro) { // Sobrecarga
        return this.area() + otro.area();
    }

    public void mostrar() {
        System.out.println("Círculo - Radio: " + radio + ", Área: " + area());
    }
}

public class Figura {
    public static void main(String[] args) {
        //a) Instanciar 1 Cuadrado, 1 Rectángulo y 1 Círculo
        Cuadrado cuadrado1 = new Cuadrado(4);
        Cuadrado cuadrado2 = new Cuadrado(3);

        Rectangulo rectangulo1 = new Rectangulo(5, 3);
        Rectangulo rectangulo2 = new Rectangulo(2, 6);

        Circulo circulo1 = new Circulo(2);
        Circulo circulo2 = new Circulo(4);

//        b) Implementar un metodo mostrar() en cada clase para imprimir sus
//        dimensiones y área.
        cuadrado1.mostrar();
        cuadrado2.mostrar();

        rectangulo1.mostrar();
        rectangulo2.mostrar();

        circulo1.mostrar();
        circulo2.mostrar();

        //c) Sobrecargar el metodo Área para mostrar el área de todas las figuras.
        System.out.println("Área combinada de dos cuadrados: " + cuadrado1.area(cuadrado2));
        System.out.println("Área combinada de dos rectángulos: " + rectangulo1.area(rectangulo2));
        System.out.println("Área combinada de dos círculos: " + circulo1.area(circulo2));
    }
}
