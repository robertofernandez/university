def isFloat(num):
    try:
        float(num)
        return True
    except ValueError:
        return False

def isInt(num):
    try:
        int(num)
        return True
    except ValueError:
        return False

def leerPrecio():
    entradaValidada = False
    precio = 0
    prompt = "Por favor, ingrese el precio: "
    while not entradaValidada:
        precioComoTexto = input(prompt)
        prompt = "Ingrese un precio válido, entre 10.00 y 999.99: "
        if isFloat(precioComoTexto):
            precio = float(precioComoTexto)
            if precio >= 10.00 and precio <= 999.99:
                entradaValidada = True
    return precio

def leerCodigoDeComponente(codigoDePieza):
    entradaValidada = False
    codigo = 0
    prompt = "Por favor, ingrese código de componente: "
    while not entradaValidada:
        codigoComoTexto = input(prompt)
        prompt = "Ingrese un código de componente válido: "
        if isInt(codigoComoTexto):
            codigo = int(codigoComoTexto)
            if codigo == 0:
                return 0
            if codigo >= 101 and codigo <= 9999:
                if codigo%100 == codigoDePieza:
                    entradaValidada = True
                else:
                    prompt = "Ingrese un código de componente válido, que termine en el código de pieza: "
            else:
                prompt = "Código fuera de rango. Ingrese un código de componente válido: "
        else:
            prompt = "Ingrese un código de componente numérico válido: "
    return codigo

def leerCodigoDePieza():
    entradaValidada = False
    codigo = 0
    prompt = "Por favor, ingrese código de pieza: "
    while not entradaValidada:
        codigoComoTexto = input(prompt)
        prompt = "Ingrese un código de pieza válido: "
        if isInt(codigoComoTexto):
            codigo = int(codigoComoTexto)
            if codigo >= 0 and codigo <= 99:
                    entradaValidada = True
            else:
                prompt = "Código fuera de rango. Ingrese un código de pieza válido: "
        else:
            prompt = "Ingrese un código de pieza numérico válido: "
    return codigo

def procesarPiezas():
    contadorPiezas = 0
    procesoFinalizado = False
    while not procesoFinalizado:
        pieza = leerCodigoDePieza()
        if pieza == 0:
            print(f"Proceso finalizado, {contadorPiezas} piezas procesadas.")
            procesoFinalizado = True
        else:
            print(f"Procesando pieza {pieza}")
            contadorPiezas += 1
            contadorComponentes = 0
            precioTotalPieza = 0
            procesoDeComponentesFinalizado = False
            while not procesoDeComponentesFinalizado:
                componente = leerCodigoDeComponente(pieza)
                if componente == 0:
                    if contadorComponentes > 0:
                        print(f"Proceso de pieza {pieza:02d} finalizado. La pieza contiene {contadorComponentes} componentes, y su precio total es de $ {precioTotalPieza}")
                        procesoDeComponentesFinalizado = True
                    else:
                        print(f"Debe cargar al menos un componente para la pieza {pieza:02d}")
                else:
                    contadorComponentes += 1
                    precio = leerPrecio()
                    precioTotalPieza += precio
                    print(f"Componente {componente:02d}, de precio ${precio}, agregado a la pieza {pieza:02d}.")


#precio = leerPrecio()
#print(f"El precio leído es {precio}")
#componente = leerCodigoDeComponente(21)
#print(f"El codigo leído es {componente}")
#pieza = leerCodigoDePieza()
#print(f"El codigo leído es {pieza}")
procesarPiezas()