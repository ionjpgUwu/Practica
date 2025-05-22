# a) Implementa las clases con sus constructores, getters y setters.

class Jugador:
    def __init__(self, nombre, numero, posicion):
        self.nombre = nombre
        self.numero = numero
        self.posicion = posicion

    def mostrar_info(self):
        print(f"Nombre: {self.nombre}, Número: {self.numero}, Posición: {self.posicion}")


class Portero(Jugador):
    def __init__(self, nombre, numero, habilidad_especial):
        super().__init__(nombre, numero, "Portero")
        self.habilidad_especial = habilidad_especial

    def mostrar_info(self):
        super().mostrar_info()
        print(f"Habilidad Especial: {self.habilidad_especial}")


class Defensa(Jugador):
    def __init__(self, nombre, numero, habilidad_especial):
        super().__init__(nombre, numero, "Defensa")
        self.habilidad_especial = habilidad_especial

    def mostrar_info(self):
        super().mostrar_info()
        print(f"Habilidad Especial: {self.habilidad_especial}")


class Mediocampista(Jugador):
    def __init__(self, nombre, numero, habilidad_especial):
        super().__init__(nombre, numero, "Mediocampista")
        self.habilidad_especial = habilidad_especial

    def mostrar_info(self):
        super().mostrar_info()
        print(f"Habilidad Especial: {self.habilidad_especial}")


class Delantero(Jugador):
    def __init__(self, nombre, numero, habilidad_especial):
        super().__init__(nombre, numero, "Delantero")
        self.habilidad_especial = habilidad_especial

    def mostrar_info(self):
        super().mostrar_info()
        print(f"Habilidad Especial: {self.habilidad_especial}")


class Equipo:
    def __init__(self, nombre):
        self.nombre = nombre
        self.jugadores = []

    def agregar_jugador(self, jugador):
        self.jugadores.append(jugador)

    def mostrar_equipo(self):
        print(f"Equipo: {self.nombre}")
        for j in self.jugadores:
            j.mostrar_info()
            print()


# b) Crea un equipo y agrega varios jugadores de diferentes tipos.
equipo = Equipo("Leones FC")
equipo.agregar_jugador(Portero("Carlos", 1, "Atajadas"))
equipo.agregar_jugador(Defensa("Luis", 4, "Marcaje"))
equipo.agregar_jugador(Mediocampista("Jorge", 8, "Pases"))
equipo.agregar_jugador(Delantero("Pedro", 9, "Goles"))

# c) Muestra la información del equipo y sus jugadores.
equipo.mostrar_equipo()
