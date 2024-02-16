# Martín René Vilugrón
# mrvilugron@unrn.edu.ar
# Ejercicios Python – 1

n = int(input("Por favor, ingrese el numero para calcular su factorial: "))

if n==0:
    print("0! = 1")
elif n < 0:
    print("Factorial no esta definida para numeros negativos")
else:
    currentValue = n
    currentResult = 1
    currentOutputText = f"!{n} = "
    separator = ""

    while currentValue > 0:
        currentResult = currentValue * currentResult
        currentOutputText = currentOutputText + separator + f"{currentValue}"
        separator = " x "
        currentValue-=1

    print(currentOutputText + f" = {currentResult}")
