# Martín René Vilugrón
# mrvilugron@unrn.edu.ar
# Ejercicios Python – 1

n1 = int(input("Por favor, ingrese un numero: "))

currentText = "2"
output=0

for x in range(0,n1):
    output = output + int(currentText)
    currentText = currentText + "2"

print(f"{output}")