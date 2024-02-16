# Martín René Vilugrón
# mrvilugron@unrn.edu.ar
# Ejercicios Python – 1

secondsToAdd = float(input("Por favor, ingrese los segundos a adicionar: "))

hours = float(input("Por favor, ingrese horas: "))
minutes = float(input("Por favor, ingrese minutos: "))
seconds = float(input("Por favor, ingrese segundos: "))

seconds += secondsToAdd

rest = 0

if seconds >= 60:
    rest = seconds // 60
    seconds = seconds % 60
minutes += rest
rest = 0
if minutes >= 60:
    rest = minutes // 60
    minutes = minutes % 60
hours += rest

hours = hours % 24

print(f"horas: {hours}\nminutos: {minutes}\nsegundos: {seconds}")