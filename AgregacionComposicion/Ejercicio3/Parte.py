# a) Implementa las clases con sus constructores, getters y setters.
class Parte:
    def __init__(self, nombre, peso):
        self.nombre = nombre
        self.peso = peso

    def mostrar_info(self):
        print(f'Parte: {self.nombre}, Peso: {self.peso} kg')


class Avion:
    def __init__(self, modelo, fabricante):
        self.modelo = modelo
        self.fabricante = fabricante
        self.partes = []

    def agregar_parte(self, parte):
        self.partes.append(parte)

    def mostrar_avion(self):
        print(f'Modelo: {self.modelo}, Fabricante: {self.fabricante}')
        for p in self.partes:
            p.mostrar_info()


# b) Crea un avión y agrega varias partes.
avion = Avion("Boeing 747", "Boeing")
avion.agregar_parte(Parte("Motor", 3000))
avion.agregar_parte(Parte("Ala izquierda", 2000))
avion.agregar_parte(Parte("Ala derecha", 2000))
avion.agregar_parte(Parte("Tren de aterrizaje", 1500))

# c) Muestra la información del avión y sus partes.
avion.mostrar_avion()
