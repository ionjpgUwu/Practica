class Estudiante:
    def __init__(self, nombre, carrera, semestre):
        self.__nombre = nombre
        self.__carrera = carrera
        self.__semestre = semestre
    
    # Getters y setters
    def get_nombre(self): return self.__nombre
    def set_nombre(self, nombre): self.__nombre = nombre
    def get_carrera(self): return self.__carrera
    def set_carrera(self, carrera): self.__carrera = carrera
    def get_semestre(self): return self.__semestre
    def set_semestre(self, semestre): self.__semestre = semestre
    
    def mostrar_info(self):
        print(f"Estudiante: {self.__nombre} | Carrera: {self.__carrera} | Semestre: {self.__semestre}")

class Universidad:
    def __init__(self, nombre):
        self.__nombre = nombre
        self.__estudiantes = []
    
    # Getters y setters
    def get_nombre(self): return self.__nombre
    def set_nombre(self, nombre): self.__nombre = nombre
    def get_estudiantes(self): return self.__estudiantes
    
    def agregar_estudiante(self, estudiante):
        if isinstance(estudiante, Estudiante):
            self.__estudiantes.append(estudiante)
    
    def mostrar_universidad(self):
        print(f"\nUniversidad: {self.__nombre}")
        print("Estudiantes inscritos:")
        for estudiante in self.__estudiantes:
            estudiante.mostrar_info()

# Ejemplo de uso
if __name__ == "__main__":
    # Estudiantes independientes
    est1 = Estudiante("Ana Torres", "Ing. Sistemas", 4)
    est2 = Estudiante("Carlos Ruiz", "Medicina", 2)
    
    # Universidad
    uni = Universidad("UNMSM")
    uni.agregar_estudiante(est1)
    uni.agregar_estudiante(est2)
    
    # Mostrar información
    uni.mostrar_universidad()
    
    # Estudiantes existen independientemente
    print("\nEstudiantes por separado:")
    est1.mostrar_info()
    est2.mostrar_info()