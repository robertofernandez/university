# Martín René Vilugrón
# mrvilugron@unrn.edu.ar
# Ejercicios Python – 1

shallContinue = True
result = 0
total = 0

while shallContinue:
    textInput = input("Por favor, ingrese un numero, o ENTER para continuar: ")
    if(textInput.lstrip('-').isdigit()):
        result+=int(textInput)
        total+=1
    else:
        shallContinue = False

print(f"El promedio es {result/total:.2f}")