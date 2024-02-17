# Martín René Vilugrón
# mrvilugron@unrn.edu.ar
# Ejercicios Python – 1

textInput = input("Por favor, ingrese la palabra: ")
cleanedText = textInput.replace(' ', '').lower()

leftIndex = 0
rightIndex = len(cleanedText) - 1

foundDifference = False

while leftIndex < rightIndex and not(foundDifference):
    if(cleanedText[leftIndex] != cleanedText[rightIndex]):
        foundDifference = True
    leftIndex+=1
    rightIndex-=1

if foundDifference:
    print(textInput + " NO es palindromo")
else:
    print(textInput + " es palindromo")
