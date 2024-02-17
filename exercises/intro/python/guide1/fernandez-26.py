# Martín René Vilugrón
# mrvilugron@unrn.edu.ar
# Ejercicios Python – 1

numbers = []

for x in range(0, 3):
    numbers.append(int(input("Por favor, ingrese un numero: ")))

for i in range(0, len(numbers)):
    for j in range(i, len(numbers)):
        if numbers[j] < numbers[i]:
            swap = numbers[j]
            numbers[j] = numbers[i]
            numbers[i] = swap

print(f"{numbers[0]}\n{numbers[1]}\n{numbers[2]}")