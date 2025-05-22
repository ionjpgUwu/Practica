class Restaurante:
    def __init__(self, nombre, sueldo_mes):
        self.nombre = nombre
        self.sueldo_mes = sueldo_mes

    def sueldo_total(self):
        return self.sueldo_mes

    def mostrar(self):
        print(f"{self.nombre} - Sueldo: {self.sueldo_total()}")

    # c) Sobrecarga del método para verificar si el sueldo es igual a X
    def sueldo_igual_a(self, sueldo):
        return self.sueldo_mes == sueldo


class Cocinero(Restaurante):
    def __init__(self, nombre, sueldo_mes, horas_extras, sueldo_hora):
        super().__init__(nombre, sueldo_mes)
        self.horas_extras = horas_extras
        self.sueldo_hora = sueldo_hora

    # b) Sobrecarga del método sueldo_total para sumar horas extras
    def sueldo_total(self):
        return super().sueldo_total() + (self.horas_extras * self.sueldo_hora)


class Mesero(Cocinero):
    def __init__(self, nombre, sueldo_mes, horas_extras, sueldo_hora, propina):
        super().__init__(nombre, sueldo_mes, horas_extras, sueldo_hora)
        self.propina = propina

    # b) Sobrecarga del método sueldo_total para sumar propina
    def sueldo_total(self):
        return super().sueldo_total() + self.propina


class Administrativo(Restaurante):
    def __init__(self, nombre, sueldo_mes):
        super().__init__(nombre, sueldo_mes)


if __name__ == "__main__":
    # a) Instanciar 1 Cocinero, 2 Meseros y 2 Administrativos
    empleados = [
        Cocinero("Carlos", 1200, 10, 5),
        Mesero("Ana", 1000, 5, 4, 50),
        Mesero("Luis", 1100, 8, 3, 70),
        Administrativo("Marta", 1500),
        Administrativo("Pedro", 1300)
    ]
    
    # c) Mostrar empleados con sueldo igual a X
    for e in empleados:
        if e.sueldo_igual_a(1000):
            e.mostrar()
