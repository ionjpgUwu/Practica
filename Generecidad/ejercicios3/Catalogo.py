from typing import Generic, TypeVar, List

T = TypeVar('T')

class Catalogo(Generic[T]):
    def __init__(self):
        self.elementos: List[T] = []

    def agregar(self, elemento: T):
        self.elementos.append(elemento)

    def buscar(self, criterio) -> T:
        for elem in self.elementos:
            if criterio(elem):
                return elem
        return None

# Clases de prueba
class Libro:
    def __init__(self, titulo, autor):
        self.titulo = titulo
        self.autor = autor

    def __str__(self):
        return f"{self.titulo} de {self.autor}"

class Producto:
    def __init__(self, nombre, precio):
        self.nombre = nombre
        self.precio = precio

    def __str__(self):
        return f"{self.nombre} (${self.precio})"

# Prueba con libros
catalogo_libros = Catalogo[Libro]()
catalogo_libros.agregar(Libro("1984", "George Orwell"))
catalogo_libros.agregar(Libro("El Principito", "Saint-Exupéry"))

libro_buscado = catalogo_libros.buscar(lambda l: l.titulo == "1984")
print("Libro encontrado:", libro_buscado)

# Prueba con productos
catalogo_productos = Catalogo[Producto]()
catalogo_productos.agregar(Producto("Laptop", 1200))
catalogo_productos.agregar(Producto("Mouse", 20))

producto_buscado = catalogo_productos.buscar(lambda p: p.nombre == "Mouse")
print("Producto encontrado:", producto_buscado)
