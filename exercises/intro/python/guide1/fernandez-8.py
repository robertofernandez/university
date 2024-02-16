# Martín René Vilugrón
# mrvilugron@unrn.edu.ar
# Ejercicios Python – 1

seconds = int(input("Por favor, ingrese segundos: "))
minutes = 0
degrees = 0

if seconds > 60:
    minutes = seconds // 60
    seconds = seconds % 60
if minutes > 60:
    degrees = minutes // 60
    minutes = minutes % 60

print(f"grados: {degrees}\nminutos: {minutes}\nsegundos:{seconds}")