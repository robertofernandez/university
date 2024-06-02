#test: piezas con componentes cuyos precios suman distintas cantidades
# Representa el camino 3
# Salida esperada:
# Proceso de pieza 01 finalizado. La pieza contiene 2 componentes, y su precio total es de $ 43
# Proceso de pieza 03 finalizado. La pieza contiene 1 componentes, y su precio total es de $ 23
# Proceso de pieza 55 finalizado. La pieza contiene 3 componentes, y su precio total es de $ 35
# Proceso de pieza 56 finalizado. La pieza contiene 1 componentes, y su precio total es de $ 456
# Proceso finalizado, 4 piezas procesadas.
from procesar_piezas import procesarPiezas

piezas = [1, 3, 55, 56, 0]
componentes = [101, 2201, 0, 2103, 0, 2155, 2255, 2355, 0, 2156, 0]
precios = [21, 22, 23, 10, 12, 13, 456]
# 21 + 22 = 43
# 23 = 23
# 10 + 12 + 13 = 35
# 456 = 456

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

print("Ejecutando test 'piezas con componentes cuyos precios suman distintas cantidades'")
procesarPiezas(leerPrecio2, leerCodigoDePieza2, leerCodigoDeComponente2)