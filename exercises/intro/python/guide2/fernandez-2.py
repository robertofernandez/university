# Martín René Vilugrón
# mrvilugron@unrn.edu.ar
# Ejercicios Python – 2
# Caracteres pares
# POST: devuelve, por cada numero, la suma del número con su anterior

cadenaDeEntrada = input("Por favor, ingrese la frase de entrada: ")
indiceActual = 0
cadenaDeSalida = ""
for caracterDeCadena in cadenaDeEntrada:
    if(indiceActual % 2 == 0):
        cadenaDeSalida = cadenaDeSalida + caracterDeCadena
    indiceActual = indiceActual + 1

print(cadenaDeSalida)
