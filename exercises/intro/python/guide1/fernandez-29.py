# Martín René Vilugrón
# mrvilugron@unrn.edu.ar
# Ejercicios Python – 1

shallContinue = True
result = 0
currentOperator = "+"
requestNumber = True
errorFound = False
text = ""

while currentOperator != '=' and not(errorFound):
    if requestNumber:
        currentNumberText = input("Por favor, ingrese un numero: ")
        text+=currentNumberText
        currentNumber = int(currentNumberText)
        if currentOperator == '+':
            result = result + currentNumber
        elif currentOperator == '-':
            result = result - currentNumber
        elif currentOperator == '*':
            result = result * currentNumber
        elif currentOperator == '/':
            result = result / currentNumber
        elif currentOperator == '**':
            result = result ** currentNumber
        else:
            text = "Operador desconocido: " + currentOperator
            errorFound = True
        requestNumber = False
    else:
        currentOperator = input("Por favor, ingrese un operador: ")
        text+=currentOperator
        requestNumber = True

print(text + f"{result}")