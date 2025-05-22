class Persona:
    def __init__(self, nombre, edad, ciudad):
        self.nombre = nombre
        self.edad = edad
        self.ciudad = ciudad

    # a) Saludo
    def saludar(self):
        print(f"Hola, soy {self.nombre} de {self.ciudad}")

    # c) Verificar si es mayor de edad
    def es_mayor_de_edad(self):
        return self.edad >= 18


if __name__ == "__main__":
    # b) Crear 3 personas
    p1 = Persona("Carlos", 25, "Lima")
    p2 = Persona("Ana", 17, "Bogotá")
    p3 = Persona("Luis", 30, "Buenos Aires")

    p1.saludar()
    p2.saludar()
    p3.saludar()

    print(f"¿Carlos es mayor de edad? {p1.es_mayor_de_edad()}")
