# Martín René Vilugrón
# mrvilugron@unrn.edu.ar
# Ejercicios Python – 1

n1 = int(input("Por favor, ingrese un numero: "))
n2 = int(input("Por favor, ingrese otro numero para sumarle: "))

currentValue = n1
elementsToAdd = n2
multiplier = 1

if elementsToAdd<0:
    multiplier=-1

while elementsToAdd != 0:
    currentValue+= 1 * multiplier
    elementsToAdd-= 1 * multiplier

print(f"{currentValue}")