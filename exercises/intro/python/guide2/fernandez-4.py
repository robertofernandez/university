# Martín René Vilugrón
# mrvilugron@unrn.edu.ar
# Ejercicios Python – 2
# Imprime triangulo

altura = int(input("Por favor, ingrese la altura del triangulo: "))
columnas = 1

for fila in range (0, altura - 1):
    textoActual = "";
    for columna in range (0 ,columnas):
        textoActual = textoActual + "*"
    columnas = columnas + 1
    print(textoActual)

for fila in range (0, altura):
    textoActual = "";
    for columna in range (0 ,columnas):
        textoActual = textoActual + "*"
    columnas = columnas - 1
    print(textoActual)
