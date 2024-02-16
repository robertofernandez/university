# Martín René Vilugrón
# mrvilugron@unrn.edu.ar
# Ejercicios Python – 1

number = int(input("Por favor, ingrese un numero: "))
calificative = "0"
if number < 0:
    calificative = "negativo"
elif number > 0:
    calificative = "positivo"

print(f"{number} es {calificative}")