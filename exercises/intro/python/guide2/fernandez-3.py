# Martín René Vilugrón
# mrvilugron@unrn.edu.ar
# Ejercicios Python – 2
# Numero capicua

numeroDeEntrada = int(input("Por favor, ingrese un numero: "))

resto = numeroDeEntrada
reverso = 0

while resto > 0:
    reverso = reverso * 10
    ultimoDigito = resto % 10
    resto = resto // 10
    reverso = reverso + ultimoDigito

if(numeroDeEntrada == reverso):
    print("es capicua")
else:
    print("NO es capicua")