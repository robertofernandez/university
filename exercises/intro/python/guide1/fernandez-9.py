# Martín René Vilugrón
# mrvilugron@unrn.edu.ar
# Ejercicios Python – 1

n1 = int(input("Por favor, ingrese un numero: "))
n2 = int(input("Por favor, ingrese otro numero para intercambiar: "))

if n2!=n1:
    n3=n1
    n1=n2
    n2=n3

print(f"{n1}\n{n2}")