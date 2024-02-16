# Martín René Vilugrón
# mrvilugron@unrn.edu.ar
# Ejercicios Python – 1

n = int(input("Por favor, ingrese numerador: "))
d = int(input("Por favor, ingrese denominador: "))

currentRemainder = n
currentIteration = 0

print(f"{n}\n")

if d > 0:
    while currentRemainder >= d:
        currentIteration += 1
        currentRemainder-= d
        print(f"-{d}\n")

print(f"cociente: {currentIteration}")
print(f"resto: {currentRemainder}")
