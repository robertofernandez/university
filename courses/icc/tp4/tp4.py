def isfloat(num):
    try:
        float(num)
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
        if isfloat(precioComoTexto):
            precio = float(precioComoTexto)
            if precio >= 10.00 and precio <= 999.99:
                entradaValidada = True
    return precio

precio = leerPrecio()
print(f"El precio leído es {precio}")