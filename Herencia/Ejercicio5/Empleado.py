class Persona:
    def __init__(self, nombre, apellido, fecha_nac, ci, celular):
        self.nombre = nombre
        self.apellido = apellido
        self.fecha_nac = fecha_nac
        self.ci = ci
        self.celular = celular
    
    def get_apellido(self):
        return self.apellido
    
    def get_nombre(self):
        return self.nombre
    
    def get_edad(self):
        año_nacimiento = int(self.fecha_nac.split("/")[2])  # Extrae el año como entero
        return 2025 - año_nacimiento  # Suponiendo el año actual como 2025
    
    def mostrar(self):
        print(f"Nombre: {self.nombre} | Apellido: {self.apellido} | Fecha de Nacimiento: {self.fecha_nac} | CI: {self.ci} | Celular: {self.celular}")


class Estudiante(Persona):
    def __init__(self, nombre, apellido, fecha_nac, ci, celular, ru, semestre, fecha_ingreso):
        super().__init__(nombre, apellido, fecha_nac, ci, celular)
        self.ru = ru
        self.semestre = semestre
        self.fecha_ingreso = fecha_ingreso
    
    def mostrar(self):
        super().mostrar()
        print(f" | RU: {self.ru} | Semestre: {self.semestre} | Fecha de Ingreso: {self.fecha_ingreso}")


class Docente(Persona):
    def __init__(self, nombre, apellido, fecha_nac, ci, celular, profesion, especialidad, nit, sexo):
        super().__init__(nombre, apellido, fecha_nac, ci, celular)
        self.profesion = profesion
        self.especialidad = especialidad
        self.nit = nit
        self.sexo = sexo
    
    def get_profesion(self):
        return self.profesion
    
    def get_sexo(self):
        return self.sexo
    
    def mostrar(self):
        super().mostrar()
        print(f" | Profesión: {self.profesion} | Especialidad: {self.especialidad} | NIT: {self.nit}")


# Clase Main para pruebas
if __name__ == "__main__":
    # Lista de estudiantes y docentes
    estudiantes = []
    docentes = []

    # Crear estudiantes
    estudiantes.append(Estudiante("Carlos", "Pérez", "15/06/1998", 1234567, 789654, 1001, 8, "01/03/2020"))
    estudiantes.append(Estudiante("Ana", "López", "20/08/2001", 7654321, 321987, 1002, 5, "01/03/2022"))
    estudiantes.append(Estudiante("Juan", "González", "30/09/1995", 4567891, 852741, 1003, 10, "01/03/2018"))

    # Crear docentes
    docentes.append(Docente("Mario", "Fernández", "05/07/1980", 1122334, 123456, "Ingeniero", "Software", 556677, "Masculino"))
    docentes.append(Docente("Luis", "Gómez", "12/11/1975", 2233445, 987654, "Ingeniero", "Redes", 112233, "Masculino"))
    docentes.append(Docente("Laura", "Pérez", "25/04/1985", 3344556, 456123, "Licenciada", "Matemáticas", 778899, "Femenino"))

    # a) Mostrar estudiantes mayores de 25 años
    print("\n--- Estudiantes mayores de 25 años ---")
    for est in estudiantes:
        if est.get_edad() > 25:
            est.mostrar()

    # b) Mostrar al docente Ingeniero masculino más mayor
    mayor_ingeniero = None
    for doc in docentes:
        if doc.get_profesion() == "Ingeniero" and doc.get_sexo() == "Masculino":
            if mayor_ingeniero is None or doc.get_edad() > mayor_ingeniero.get_edad():
                mayor_ingeniero = doc
    
    if mayor_ingeniero is not None:
        print("\n--- Docente Ingeniero Masculino Más Mayor ---")
        mayor_ingeniero.mostrar()

    # c) Mostrar estudiantes y docentes con el mismo apellido
    print("\n--- Personas con el mismo apellido ---")
    for est in estudiantes:
        for doc in docentes:
            if est.get_apellido() == doc.get_apellido():
                print(f"Coincidencia de apellido: {est.get_apellido()}")
                est.mostrar()
                doc.mostrar()