class Empleado:
    def __init__(self, nombre, apellido, antiguedad, salario_base):
        self.nombre = nombre
        self.apellido = apellido
        self.antiguedad = antiguedad
        self.salario_base = salario_base
    
    def get_nombre(self):
        return self.nombre
    
    def set_nombre(self, nombre):
        self.nombre = nombre
    
    def get_apellido(self):
        return self.apellido
    
    def set_apellido(self, apellido):
        self.apellido = apellido
    
    def get_antiguedad(self):
        return self.antiguedad
    
    def set_antiguedad(self, antiguedad):
        self.antiguedad = antiguedad
    
    def get_salario_base(self):
        return self.salario_base
    
    def set_salario_base(self, salario_base):
        self.salario_base = salario_base
    
    def calcular_salario(self):
        return self.salario_base + (self.salario_base * 0.05 * self.antiguedad)
    
    def mostrar_info(self):
        print(f"Nombre: {self.nombre} {self.apellido} | Antigüedad: {self.antiguedad} años | Salario: ${self.calcular_salario():.2f}")


class Gerente(Empleado):
    def __init__(self, nombre, apellido, antiguedad, salario_base, departamento, bono_gerencial):
        super().__init__(nombre, apellido, antiguedad, salario_base)
        self.departamento = departamento
        self.bono_gerencial = bono_gerencial
    
    def get_departamento(self):
        return self.departamento
    
    def set_departamento(self, departamento):
        self.departamento = departamento
    
    def get_bono_gerencial(self):
        return self.bono_gerencial
    
    def set_bono_gerencial(self, bono_gerencial):
        self.bono_gerencial = bono_gerencial
    
    def calcular_salario(self):
        return super().calcular_salario() + self.bono_gerencial
    
    def mostrar_info(self):
        print(f"Gerente: {self.get_nombre()} {self.get_apellido()} | Departamento: {self.departamento} | Salario: ${self.calcular_salario():.2f}")


class Desarrollador(Empleado):
    def __init__(self, nombre, apellido, antiguedad, salario_base, lenguaje_programacion, horas_extras):
        super().__init__(nombre, apellido, antiguedad, salario_base)
        self.lenguaje_programacion = lenguaje_programacion
        self.horas_extras = horas_extras
    
    def get_lenguaje_programacion(self):
        return self.lenguaje_programacion
    
    def set_lenguaje_programacion(self, lenguaje_programacion):
        self.lenguaje_programacion = lenguaje_programacion
    
    def get_horas_extras(self):
        return self.horas_extras
    
    def set_horas_extras(self, horas_extras):
        self.horas_extras = horas_extras
    
    def calcular_salario(self):
        return super().calcular_salario() + self.horas_extras * 100
    
    def mostrar_info(self):
        print(f"Desarrollador: {self.get_nombre()} {self.get_apellido()} | Lenguaje: {self.lenguaje_programacion} | Salario: ${self.calcular_salario():.2f}")


# Clase Main para probar las funcionalidades
if __name__ == "__main__":
    # Crear listas de empleados
    gerentes = []
    desarrolladores = []

    # Crear instancias de Gerente y Desarrollador
    g1 = Gerente("Carlos", "Pérez", 10, 5000, "TI", 1500)
    g2 = Gerente("María", "González", 5, 4500, "Ventas", 800)
    g3 = Gerente("Juan", "López", 7, 4700, "Marketing", 1200)

    d1 = Desarrollador("Ana", "Fernández", 3, 3000, "Java", 12)
    d2 = Desarrollador("Luis", "Gómez", 2, 2800, "Python", 8)
    d3 = Desarrollador("Pedro", "Martínez", 4, 3200, "JavaScript", 15)

    # Agregar empleados a las listas
    gerentes.extend([g1, g2, g3])
    desarrolladores.extend([d1, d2, d3])

    # b) Mostrar salario de cada gerente y desarrollador
    print("\nSalarios de Gerentes:")
    for g in gerentes:
        g.mostrar_info()

    print("\nSalarios de Desarrolladores:")
    for d in desarrolladores:
        d.mostrar_info()

    # c) Mostrar gerentes con bono gerencial mayor a 1000
    print("\nGerentes con bono mayor a 1000:")
    for g in gerentes:
        if g.get_bono_gerencial() > 1000:
            g.mostrar_info()

    # d) Mostrar desarrolladores con más de 10 horas extras
    print("\nDesarrolladores con más de 10 horas extras:")
    for d in desarrolladores:
        if d.get_horas_extras() > 10:
            d.mostrar_info()