#test sin piezas
# Representa el camino 4
# Salida esperada:
# Proceso finalizado, 0 piezas procesadas.
from procesar_piezas import procesarPiezas

piezas = [0]
componentes = [0]
precios = []

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

print("Ejecutando test: sin piezas")
procesarPiezas(leerPrecio2, leerCodigoDePieza2, leerCodigoDeComponente2)