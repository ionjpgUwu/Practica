package IntroduccionPoo.Ejercicio8;

import java.util.HashMap;

class Banco {
    private HashMap<String, Double> cuentas = new HashMap<>();
    private double totalDinero = 0;

    // a) Método para agregar un usuario
    public void agregarUsuario(String nombre, double saldoInicial) {
        cuentas.put(nombre, saldoInicial);
        totalDinero += saldoInicial;
    }

    // b) Método para que un usuario pueda retirar dinero del banco
    public void retirarDinero(String nombre, double cantidad) {
        if (cuentas.containsKey(nombre) && cuentas.get(nombre) >= cantidad) {
            cuentas.put(nombre, cuentas.get(nombre) - cantidad);
            totalDinero -= cantidad;
            System.out.println(nombre + " retiró $" + cantidad);
        } else {
            System.out.println("Fondos insuficientes o usuario no encontrado.");
        }
    }

    // c) Método para que un usuario pueda guardar dinero en el banco
    public void guardarDinero(String nombre, double cantidad) {
        if (cuentas.containsKey(nombre)) {
            cuentas.put(nombre, cuentas.get(nombre) + cantidad);
            totalDinero += cantidad;
            System.out.println(nombre + " depositó $" + cantidad);
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    // d) Dar un 2% de bono en las cuentas de los usuarios
    public void aplicarBono() {
        for (String usuario : cuentas.keySet()) {
            double nuevoSaldo = cuentas.get(usuario) * 1.02;
            totalDinero += nuevoSaldo - cuentas.get(usuario);
            cuentas.put(usuario, nuevoSaldo);
        }
        System.out.println("Se aplicó el bono del 2% a todas las cuentas.");
    }

    // e) Muestra el total de dinero que posee el banco
    public void mostrarTotalBanco() {
        System.out.println("Total dinero en el banco: $" + totalDinero);
    }

    public static void main(String[] args) {
        Banco banco = new Banco();
        banco.agregarUsuario("Carlos", 1000);
        banco.agregarUsuario("Ana", 2000);
        banco.retirarDinero("Carlos", 300);
        banco.guardarDinero("Ana", 500);
        banco.aplicarBono();
        banco.mostrarTotalBanco();
    }
}

