numeroDeEntrada = int(input("Por favor, ingrese un numero: "))
digitoBuscado = int(input("Por favor, ingrese el digito a encontrar: "))

resto = numeroDeEntrada

apariciones = 0

while resto > 0:
    ultimoDigito = resto % 10
    resto = resto // 10
    if ultimoDigito == digitoBuscado:
        apariciones = apariciones + 1

if apariciones == 1:
    print(f"El digito {digitoBuscado} aparece 1 vez")
else:
    print(f"El digito {digitoBuscado} aparece {apariciones} veces")
