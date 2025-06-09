import pickle
import os

class Cliente:
    def __init__(self, id, nombre, telefono):
        self.id = id
        self.nombre = nombre
        self.telefono = telefono

    def __str__(self):
        return f"Cliente(id={self.id}, nombre='{self.nombre}', telefono='{self.telefono}')"

class ArchivoCliente:
    def __init__(self, archivo_nombre="clientes.pkl"):
        self.archivo_nombre = archivo_nombre
        self.clientes = []
        self._cargar_desde_archivo()

    def crear_archivo(self):
        self.clientes = []
        self._guardar_en_archivo()

    def guardar_cliente(self, cliente):
        self.clientes.append(cliente)
        self._guardar_en_archivo()

    def buscar_cliente(self, id):
        self._cargar_desde_archivo()
        for c in self.clientes:
            if c.id == id:
                return c
        return None

    def buscar_celular_cliente(self, id):
        self._cargar_desde_archivo()
        for c in self.clientes:
            if c.id == id:
                return f"Cliente: {c.nombre}, Teléfono: {c.telefono}"
        return "Cliente no encontrado"

    def _guardar_en_archivo(self):
        with open(self.archivo_nombre, "wb") as f:
            pickle.dump(self.clientes, f)

    def _cargar_desde_archivo(self):
        if os.path.exists(self.archivo_nombre):
            with open(self.archivo_nombre, "rb") as f:
                self.clientes = pickle.load(f)
        else:
            self.clientes = []

# Prueba
if __name__ == "__main__":
    archivo = ArchivoCliente()
    archivo.crear_archivo()  # Comenta esta línea si no quieres borrar datos anteriores

    archivo.guardar_cliente(Cliente(1, "Carlos", "123456789"))
    archivo.guardar_cliente(Cliente(2, "María", "987654321"))
    archivo.guardar_cliente(Cliente(3, "Lucía", "555555555"))

    cliente_encontrado = archivo.buscar_cliente(2)
    if cliente_encontrado:
        print("Cliente encontrado:", cliente_encontrado)
    else:
        print("Cliente no encontrado.")

    print(archivo.buscar_celular_cliente(3))
