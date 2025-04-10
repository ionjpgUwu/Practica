class Coche:
    def __init__(self, marca, modelo):
        self.marca = marca
        self.modelo = modelo
        self.velocidad = 0

    # a) Acelerar
    def acelerar(self):
        self.velocidad += 10

    # b) Frenar
    def frenar(self):
        self.velocidad -= 5

    def mostrar_velocidad(self):
        print(f"{self.marca} {self.modelo} va a {self.velocidad} km/h")


if __name__ == "__main__":
    c1 = Coche("Toyota", "Corolla")
    c2 = Coche("Ford", "Mustang")

    c1.acelerar()
    c1.acelerar()
    c1.frenar()
    c1.mostrar_velocidad()

    c2.acelerar()
    c2.mostrar_velocidad()
