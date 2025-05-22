class Vehiculo(): 
    def __init__(self,marca:str,modelo:str,ano:int,precio_base:float)->None:
        self.marca=marca;
        self.modelo=modelo;
        self.ano=ano;
        self.precio_base=precio_base;
    def mostrar_info(self):
        return f"Marca: {self.marca}, Modelo: {self.modelo}, Año: {self.ano}, Precio Base: {self.precio_base}"
# a) Implementa las clases con sus constructores, getters y setters.

    def getMarca(self):
        return self.marca
    def setMarca(self, value:str):
        self.marca=value;
        
    def getModelo(self):
        return self.marca
    def setModelo(self, value:str):
        self.modelo=value;
        
    def getAno(self):
        return self.ano
    def setAno(self, value:int):
        self.ano=value;
        
    def getPrecioBase(self):
        return self.precio_base
    def setPrecioBase(self, value:float):
        self.precio_base=value;
    
class Coche(Vehiculo):
    def __init__(self, marca, modelo, ano, precio_base,num_puertas:int,tipo_combustible:str)->None:
        super().__init__(marca, modelo, ano, precio_base)
        self.num_puertas=num_puertas;
        self.tipo_combustible=tipo_combustible;
    def mostrar_info(self):
        print(super().mostrar_info(),f", numero de puertas: {self.num_puertas}, tipo de combistible: {self.tipo_combustible}")
# a) Implementa las clases con sus constructores, getters y setters.

    def getNum_puertas(self):
        return self.marca
    def setNum_puertas(self, value:int):
        self.num_puertas=value;
    
    def getTipoCombustible(self):
        return self.marca
    def setTipoCombustible(self, value:str):
        self.tipo_combustible=value;
    
class Moto(Vehiculo):
    def __init__(self, marca, modelo, ano, precio_base,cilindrada,tipo_motor):
        super().__init__(marca, modelo, ano, precio_base)
        self.cilindrada=cilindrada;
        self.tipo_motor=tipo_motor;
    def mostrar_info(self):
        print(super().mostrar_info(),f", Cilindrada: {self.cilindrada}, tipo de Motor: {self.tipo_motor}")
# a) Implementa las clases con sus constructores, getters y setters.    
    def getCilindrada(self):
        return self.marca
    def setCilindrada(self, value:str):
        self.cilindrada=value;
        
    def getTipoMotor(self):
        return self.marca
    def setTipoMotor(self, value:str):
        self.tipo_motor=value;
# b) Crea instancias de Coche y Moto y muestra su información usando el
# método mostrar_info().        
moto1 = Moto("Honda", "CBR500R", 2025, 9500, "471cc", "4 tiempos")
moto2 = Moto("Suzuki", "GSX250R", 2025, 5300, "248cc", "4 tiempos")
moto3 = Moto("Yamaha", "MT-07", 2022, 8000, "689cc", "4 tiempos")
auto1 = Coche("Toyota", "Corolla", 2025, 15000, 6, "Gasolina")
auto2 = Coche("Toyota", "Fiat1", 1990, 5000, 2, "Diesel")
auto3 = Coche("Renault12", "Renault12", 2000, 7000, 4, "Gasolina")
auto4 = Coche("Kia", "Rio", 2025, 16000, 4, "Gasolina")
autos=[auto1,auto2,auto3,auto4]
vehiculos=[auto1,auto2,auto3,auto4,moto1,moto2,moto3]

for vehiculo in vehiculos:
    vehiculo.mostrar_info()
    
# c) Muestra todos los coches que tienen más de 4 puertas.
for auto in autos:
    if (auto.num_puertas>4):
        auto.mostrar_info()
        
# d) Mostrar los coches y motos actuales (gestión 2025)
for vehiculo in vehiculos:
    if (vehiculo.ano==2025):
        vehiculo.mostrar_info()
    
    