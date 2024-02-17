# Martín René Vilugrón
# mrvilugron@unrn.edu.ar
# Ejercicios Python – 1

inputNumber = int(input("Por favor, ingrese un numero: "))

divisorsSum = 0
divisors = []

i = 1
solved = False
sumText = ""
separator = ""

while i < inputNumber and not(solved):
  if inputNumber % i == 0:
    divisorsSum += i
    divisors.append(i)
    sumText = sumText + separator + f"{i}"
    separator = " + "
    if divisorsSum > inputNumber:
      solved = True
  i+=1

if divisorsSum != inputNumber:
  print(f"{inputNumber} no es perfecto")
else:
  print(f"{inputNumber} es perfecto\nya que")
  for currentDivisor in divisors:
    print(f"{currentDivisor} es divisor")
  print("entonces\n" + sumText + " = " + f"{inputNumber}")