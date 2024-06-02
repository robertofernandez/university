def procesarPiezas(leerPrecio, leerCodigoDePieza, leerCodigoDeComponente):
    contadorPiezas = 0
    procesoFinalizado = False
    while not procesoFinalizado:
        pieza = leerCodigoDePieza()
        if pieza == 0:
            print(f"Proceso finalizado, {contadorPiezas} piezas procesadas.")
            procesoFinalizado = True
        else:
            print(f"Procesando pieza {pieza:02d}")
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
                    print(f"Componente {componente:04d}, de precio ${precio}, agregado a la pieza {pieza:02d}.")
