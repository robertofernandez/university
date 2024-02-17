# Martín René Vilugrón
# mrvilugron@unrn.edu.ar
# Ejercicios Python – 1

inputNumber = 2
foundPerfect = 0

while foundPerfect < 4:
  divisorsSum = 0
  divisors = []

  i = 1
  solved = False
  sumText = ""
  separator = ""

  while i <= inputNumber/2 and not(solved):
    if inputNumber % i == 0:
      divisorsSum += i
      divisors.append(i)
      sumText = sumText + separator + f"{i}"
      separator = " + "
      if divisorsSum > inputNumber:
        solved = True
    i+=1

  if divisorsSum == inputNumber:
    foundPerfect+=1
    print(sumText + " = " + f"{inputNumber}")
  inputNumber+=1
