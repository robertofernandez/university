#test: reintento de ingreso de componente
# Representa el camino 3
# Salida esperada:
# Para la pieza 01, debe solicitar que se ingrese al menos un componente
from procesar_piezas import procesarPiezas

piezas = [1, 3, 55, 56, 0]
componentes = [0, 2101, 2201, 0, 2103, 0, 2155, 0, 2156, 0]
precios = [21, 22, 23, 25, 26]

piezaActual = 0
componenteActual = 0
precioActual = 0

def leerPrecio2():
    global precios
    global precioActual
    valor = precios[precioActual]
    precioActual += 1
    return valor

def leerCodigoDeComponente2(codigoDePieza):
    global componentes
    global componenteActual
    valor = componentes[componenteActual]
    componenteActual += 1
    return valor

def leerCodigoDePieza2():
    global piezas
    global piezaActual
    valor = piezas[piezaActual]
    piezaActual += 1
    return valor

print("Ejecutando test 'reintento de ingreso de componente'")
procesarPiezas(leerPrecio2, leerCodigoDePieza2, leerCodigoDeComponente2)