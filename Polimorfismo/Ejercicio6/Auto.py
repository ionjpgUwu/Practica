class Auto:
    #a)Sobrecargar el constructor 2 veces
    def __init__(self, modelo: str, placa: str, color: str = "Desconocido"):
        self.modelo = modelo
        self.placa = placa
        self.color = color

    def __str__(self):
        return f"Modelo: {self.modelo}, Placa: {self.placa}, Color: {self.color}"

    def __add__(self, otro):
        return Auto(self.modelo + " Nuevo", self.placa + "X", self.color)

    def __sub__(self, otro):
        return f"Auto 1 -> {self}\nAuto 2 -> {otro}"

# b)Instanciar 2 objetos Auto con diferentes constructores
auto1 = Auto("Toyota", "ABC123", "Rojo")
auto2 = Auto("Honda", "XYZ789")  # Color por defecto

print("Auto 1:", auto1)
print("Auto 2:", auto2)

# c)Simular el operador ++ (crear un nuevo auto)
auto_nuevo = auto1 + auto2
print("Nuevo Auto:", auto_nuevo)

# d)Simular el operador -- (mostrar comparación entre autos)
print(auto1 - auto2)
