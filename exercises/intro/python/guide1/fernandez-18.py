# Martín René Vilugrón
# mrvilugron@unrn.edu.ar
# Ejercicios Python – 1



currentMin = int(input("Por favor, ingrese un numero: "))

for x in range(0,3):
    n1 = int(input("Por favor, ingrese un numero: "))
    currentMin = min(n1, currentMin)

print(f"el numero menor es {currentMin}")