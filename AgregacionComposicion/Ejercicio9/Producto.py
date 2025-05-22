class Producto:
    def __init__(self, nombre, precio):
        self.__nombre = nombre
        self.__precio = precio
    
    # Getters y setters
    def get_nombre(self): return self.__nombre
    def set_nombre(self, nombre): self.__nombre = nombre
    def get_precio(self): return self.__precio
    def set_precio(self, precio): self.__precio = precio
    
    def mostrar_info(self):
        print(f"Producto: {self.__nombre} | Precio: ${self.__precio:.2f}")

class CarritoCompras:
    MAX_PRODUCTOS = 10
    
    def __init__(self):
        self.__productos = []
    
    def agregar_producto(self, producto):
        if len(self.__productos) >= self.MAX_PRODUCTOS:
            print("¡Error! El carrito no puede contener más de 10 productos")
            return False
        if isinstance(producto, Producto):
            self.__productos.append(producto)
            return True
        return False
    
    def mostrar_carrito(self):
        print("\nContenido del carrito:")
        for producto in self.__productos:
            producto.mostrar_info()
        print(f"Total productos: {len(self.__productos)}/{self.MAX_PRODUCTOS}")
    
    def get_productos(self):
        return self.__productos.copy()

# Ejemplo de uso
if __name__ == "__main__":
    # Crear productos independientes
    p1 = Producto("Laptop", 1200.50)
    p2 = Producto("Mouse", 25.99)
    p3 = Producto("Teclado", 45.75)
    
    # Crear carrito
    carrito = CarritoCompras()
    
    # Agregar productos (validando límite)
    for i in range(12):  # Intentar agregar 12 productos
        nuevo_prod = Producto(f"Producto {i+1}", (i+1)*10)
        if not carrito.agregar_producto(nuevo_prod):
            break
    
    # Mostrar contenido
    carrito.mostrar_carrito()
    
    # Los productos existen independientemente
    print("\nProductos fuera del carrito:")
    p1.mostrar_info()
    p2.mostrar_info()