# Martín René Vilugrón
# mrvilugron@unrn.edu.ar
# Ejercicios Python – 1

shallContinue = True
result = 0

while shallContinue:
    textInput = input("Por favor, ingrese un sumando, o ENTER para continuar: ")
    if(textInput.isdigit()):
        result+=int(textInput)
    else:
        shallContinue = False

print(f"{result}")