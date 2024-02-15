# Martín René Vilugrón
# mrvilugron@unrn.edu.ar
# Ejercicios Python – 1

height = int(input("Por favor, ingrese la altura del arbol: "))

floor = 0;
spacesNumber = height - 1

while floor < height :
  spaces = " " * spacesNumber
  leavesNumber = floor * 2 + 1
  leaves = "*" * leavesNumber
  print(spaces + leaves)
  floor+=1
  spacesNumber-=1

spacesNumber = height - 2
spaces = " " * spacesNumber
print(spaces + "| |")