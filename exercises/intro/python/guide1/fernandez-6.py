# Martín René Vilugrón
# mrvilugron@unrn.edu.ar
# Ejercicios Python – 1

degrees = float(input("Por favor, ingrese grados: "))
minutes = float(input("Por favor, ingrese minutos: "))
seconds = float(input("Por favor, ingrese segundos: "))

totalSeconds = int(seconds + 60*minutes + 60*60*degrees);

print(f"El total de segundos es {totalSeconds}")
