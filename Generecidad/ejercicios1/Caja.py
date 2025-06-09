from typing import Generic, TypeVar

T = TypeVar('T')

class Caja(Generic[T]):
    def __init__(self):
        self.objeto = None

    def guardar(self, objeto: T):
        self.objeto = objeto

    def obtener(self) -> T:
        return self.objeto

# Crear dos cajas con diferentes tipos de datos
caja1 = Caja[int]()
caja2 = Caja[str]()

caja1.guardar(123)
caja2.guardar("Hola mundo")

# Mostrar contenido de las cajas
print("Contenido de caja1:", caja1.obtener())
print("Contenido de caja2:", caja2.obtener())
