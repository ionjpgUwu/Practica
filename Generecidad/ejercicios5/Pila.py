from typing import Generic, TypeVar, List, Optional

T = TypeVar('T')

class Pila(Generic[T]):
    def __init__(self):
        self.elementos: List[T] = []

    def apilar(self, elemento: T):
        self.elementos.append(elemento)

    def desapilar(self) -> Optional[T]:
        if self.elementos:
            return self.elementos.pop()
        return None

    def mostrar(self):
        print("Contenido de la pila:", self.elementos)

# Pruebas con diferentes tipos de datos
pila_enteros = Pila[int]()
pila_enteros.apilar(10)
pila_enteros.apilar(20)
pila_enteros.mostrar()
print("Desapilado:", pila_enteros.desapilar())
pila_enteros.mostrar()

pila_texto = Pila[str]()
pila_texto.apilar("Hola")
pila_texto.apilar("Mundo")
pila_texto.mostrar()
print("Desapilado:", pila_texto.desapilar())
pila_texto.mostrar()
