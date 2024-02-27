# Martín René Vilugrón
# mrvilugron@unrn.edu.ar
# Ejercicios Python – 1
# La sucesion de Fibonacci

termsNumber = int(input("Por favor, ingrese la cantidad de terminos: "))

oldTerm = 0
lastTerm = 1
currentTerm = 3

if(termsNumber > 0):
    print("termino 1: 0")

if(termsNumber > 1):
    print("termino 2: 1")

if(termsNumber > 2):
    while currentTerm <= termsNumber:
        newTerm = lastTerm + oldTerm
        print(f"termino {currentTerm}: {newTerm}")
        oldTerm = lastTerm
        lastTerm = newTerm
        currentTerm += 1
