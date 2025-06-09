import pickle
import os

class Medicamento:
    def __init__(self, nombre="", cod_medicamento="", tipo="", precio=0.0):
        self.nombre = nombre
        self.cod_medicamento = cod_medicamento
        self.tipo = tipo
        self.precio = precio

    def leer(self):
        self.nombre = input("Nombre: ")
        self.cod_medicamento = input("Código: ")
        self.tipo = input("Tipo: ")
        self.precio = float(input("Precio: "))

    def mostrar(self):
        print(f"Nombre: {self.nombre}, Código: {self.cod_medicamento}, Tipo: {self.tipo}, Precio: {self.precio}")

class Farmacia:
    def __init__(self):
        self.nombre_farmacia = ""
        self.sucursal = 0
        self.direccion = ""
        self.medicamentos = []

    def leer(self):
        self.nombre_farmacia = input("Nombre Farmacia: ")
        self.sucursal = int(input("Sucursal: "))
        self.direccion = input("Dirección: ")
        nro_medicamentos = int(input("Nro medicamentos: "))
        self.medicamentos = []
        for i in range(nro_medicamentos):
            print(f"Medicamento {i+1}:")
            m = Medicamento()
            m.leer()
            self.medicamentos.append(m)

    def mostrar(self):
        print(f"\nFarmacia: {self.nombre_farmacia} | Sucursal: {self.sucursal} | Dirección: {self.direccion}")
        for m in self.medicamentos:
            m.mostrar()

    def contiene_medicamento(self, nombre):
        return any(m.nombre.lower() == nombre.lower() for m in self.medicamentos)

    def mostrar_medicamentos_por_tipo(self, tipo):
        for m in self.medicamentos:
            if m.tipo.lower() == tipo.lower():
                m.mostrar()

class ArchFarmacia:
    def __init__(self, archivo_nombre="farmacias.pkl"):
        self.archivo_nombre = archivo_nombre
        self.farmacias = []
        self._cargar_desde_archivo()

    def crear_archivos(self):
        self.farmacias = []
        self._guardar_en_archivo()

    def adicionar(self, farmacia):
        self.farmacias.append(farmacia)
        self._guardar_en_archivo()

    def listar(self):
        for f in self.farmacias:
            f.mostrar()

    def mostrar_medicamentos_tos(self, sucursal_x):
        for f in self.farmacias:
            if f.sucursal == sucursal_x:
                print(f"\n--- Medicamentos para la TOS en Sucursal {sucursal_x} ---")
                f.mostrar_medicamentos_por_tipo("tos")

    def mostrar_sucursales_con_medicamento(self, nombre_medicamento):
        print(f"\nFarmacias con el medicamento '{nombre_medicamento}':")
        for f in self.farmacias:
            if f.contiene_medicamento(nombre_medicamento):
                print(f"Sucursal: {f.sucursal} | Dirección: {f.direccion}")

    def _guardar_en_archivo(self):
        with open(self.archivo_nombre, "wb") as f:
            pickle.dump(self.farmacias, f)

    def _cargar_desde_archivo(self):
        if os.path.exists(self.archivo_nombre):
            with open(self.archivo_nombre, "rb") as f:
                self.farmacias = pickle.load(f)
        else:
            self.farmacias = []

# Programa principal para probar
def main():
    arch = ArchFarmacia()
    arch.crear_archivos()  # Comentar para no borrar datos anteriores

    for i in range(2):
        print(f"\n--- Ingresando Farmacia {i + 1} ---")
        f = Farmacia()
        f.leer()
        arch.adicionar(f)

    arch.listar()

    arch.mostrar_medicamentos_tos(1)
    arch.mostrar_sucursales_con_medicamento("Golpex")

if __name__ == "__main__":
    main()
