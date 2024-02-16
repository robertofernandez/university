# Martín René Vilugrón
# mrvilugron@unrn.edu.ar
# Ejercicios Python – 1

firstNumber = int(input("Por favor, ingrese el numero inicial: "))
lastNumber = int(input("Por favor, ingrese el numero final: "))
step = int(input("Por favor, ingrese el paso: "))

if(step == 0):
    print("El paso no puede ser 0")
elif((firstNumber < lastNumber and step < 0) or (firstNumber > lastNumber and step > 0)):
    print("El paso no lleva hasta el numero final")
else:
    currentNumber = firstNumber
    if(firstNumber < lastNumber):
        while currentNumber <= lastNumber:
            print(currentNumber)
            currentNumber+=step
    else:
        while currentNumber >= lastNumber:
            print(currentNumber)
            currentNumber+=step
