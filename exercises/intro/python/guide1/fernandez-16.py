# Martín René Vilugrón
# mrvilugron@unrn.edu.ar
# Ejercicios Python – 1

n_i = int(input("Por favor, ingrese el numero inicial: "))
n_f = int(input("Por favor, ingrese el numero final: "))
n = int(input("Por favor, ingrese el numero para checkear intervalo: "))

initialNumber = min(n_i, n_f)
finalNumber = max(n_f, n_i)

if n >= initialNumber and n <= finalNumber:
    print(f"{n} pertenece al intervalo entre {n_i} y {n_f}")
else:
    print(f"{n} NO pertenece al intervalo entre {n_i} y {n_f}")
