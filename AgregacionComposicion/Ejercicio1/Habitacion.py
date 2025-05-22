# a) Implementa las clases con sus constructores, getters y setters.
class Habitacion:
    def __init__(self, nombre, tamano):
        self.nombre = nombre
        self.tamano = tamano

    def mostrar_info(self):
        print(f'Habitación: {self.nombre}, Tamaño: {self.tamano} m²')


class Casa:
    def __init__(self, direccion):
        self.direccion = direccion
        self.habitaciones = []

    def agregar_habitacion(self, habitacion):
        self.habitaciones.append(habitacion)

    def mostrar_casa(self):
        print(f'Dirección: {self.direccion}')
        for h in self.habitaciones:
            h.mostrar_info()


# b) Crea una casa y agrega varias habitaciones.
mi_casa = Casa("Av. Siempre Viva 742")
mi_casa.agregar_habitacion(Habitacion("Sala", 25.0))
mi_casa.agregar_habitacion(Habitacion("Cocina", 15.5))
mi_casa.agregar_habitacion(Habitacion("Dormitorio", 20.0))

# c) Muestra la información de la casa y sus habitaciones.
mi_casa.mostrar_casa()
