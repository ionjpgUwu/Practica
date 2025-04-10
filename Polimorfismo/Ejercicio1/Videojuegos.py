class Videojuegos:
    def __init__(self, nombre, plataforma, cantidad_jugadores=0):
        self.nombre = nombre
        self.plataforma = plataforma
        self.cantidad_jugadores = cantidad_jugadores

    # d) Sobrecargar el método agregarJugadores()
    def agregar_jugadores(self):
        self.cantidad_jugadores += 1

    def agregar_jugadores_n(self, n):
        self.cantidad_jugadores += n

    def mostrar(self):
        print(f"Videojuego(Nombre: {self.nombre}, Plataforma: {self.plataforma}, Cantidad de Jugadores: {self.cantidad_jugadores})")


if __name__ == "__main__":
    # a) Instanciar al menos 2 videojuegos
    v1 = Videojuegos("Left 4 dead 2", "Steam")
    v2 = Videojuegos("League of Legend", "Riot", 1000000)

    v1.mostrar()
    v2.mostrar()

    v1.agregar_jugadores_n(150500)
    v1.agregar_jugadores()

    # c) Implementar un método mostrar()
    v1.mostrar()
    v2.mostrar()
