# Martín René Vilugrón
# mrvilugron@unrn.edu.ar
# Ejercicios Python – 1

n = int(input("Por favor, ingrese un numero mayor que 1: "))

if n > 1:
    i = 2
    foundMultiplier = False
    while i < n and not(foundMultiplier):
        if n % i == 0:
            foundMultiplier = True
        i+=1
    if foundMultiplier:
        print(f"{n} NO es primo")
    else:
        print(f"{n} es primo")