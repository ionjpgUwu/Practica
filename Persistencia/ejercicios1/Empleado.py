import pickle
import os

# Clase Empleado
class Empleado:
    def __init__(self, nombre, edad, salario):
        self.nombre = nombre
        self.edad = edad
        self.salario = salario

    def __str__(self):
        return f"Empleado(nombre='{self.nombre}', edad={self.edad}, salario={self.salario})"

# Clase ArchivoEmpleado
class ArchivoEmpleado:
    def __init__(self, archivo_nombre="empleados.pkl"):
        self.archivo_nombre = archivo_nombre
        self.empleados = []
        self._cargar_desde_archivo()

    def crear_archivo(self):
        self.empleados = []
        self._guardar_en_archivo()

    def guardar_empleado(self, empleado):
        self.empleados.append(empleado)
        self._guardar_en_archivo()

    def buscar_empleado(self, nombre):
        self._cargar_desde_archivo()
        for e in self.empleados:
            if e.nombre.lower() == nombre.lower():
                return e
        return None

    def mayor_salario(self, sueldo):
        self._cargar_desde_archivo()
        for e in self.empleados:
            if e.salario > sueldo:
                return e
        return None

    def _guardar_en_archivo(self):
        with open(self.archivo_nombre, "wb") as f:
            pickle.dump(self.empleados, f)

    def _cargar_desde_archivo(self):
        if os.path.exists(self.archivo_nombre):
            with open(self.archivo_nombre, "rb") as f:
                self.empleados = pickle.load(f)
        else:
            self.empleados = []

# --- Prueba ---
if __name__ == "__main__":
    archivo = ArchivoEmpleado()
    archivo.crear_archivo()  # Comenta esta línea si no quieres borrar los empleados previos

    archivo.guardar_empleado(Empleado("Ana", 30, 1200.50))
    archivo.guardar_empleado(Empleado("Luis", 25, 950.00))
    archivo.guardar_empleado(Empleado("Carla", 28, 1500.00))

    encontrado = archivo.buscar_empleado("Luis")
    if encontrado:
        print("Empleado encontrado:", encontrado)
    else:
        print("Empleado no encontrado.")

    mejor_pago = archivo.mayor_salario(1000.00)
    if mejor_pago:
        print("Empleado con salario mayor a 1000:", mejor_pago)
    else:
        print("Ningún empleado supera ese salario.")
