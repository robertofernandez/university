# Martín René Vilugrón
# mrvilugron@unrn.edu.ar
# Ejercicios Python – 2
# PRE: ingresa la cantidad de números que será sumada
# POST: devuelve, por cada numero, la suma del número con su anterior

cantidadASumar = int(input("Por favor, ingrese la cantidad de numeros a sumar: "))
print(f"actual {0} - anterior {0} - suma {0}")
for numeroActual in range(1, cantidadASumar):
    print(f"actual {numeroActual} - anterior {numeroActual - 1} - suma {numeroActual + numeroActual - 1}")
