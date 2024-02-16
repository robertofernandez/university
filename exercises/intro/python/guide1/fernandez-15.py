# Martín René Vilugrón
# mrvilugron@unrn.edu.ar
# Ejercicios Python – 1

n1 = int(input("Por favor, ingrese un numero: "))
n2 = int(input("Por favor, ingrese el numero para checkear multiplicidad: "))

if n1%n2 == 0:
    print(f"El numero {n1} es multiplo de {n2}")
else:
    print(f"El numero {n1} NO es multiplo de {n2}")