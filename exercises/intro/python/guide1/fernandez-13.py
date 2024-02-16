# Martín René Vilugrón
# mrvilugron@unrn.edu.ar
# Ejercicios Python – 1

gradePercentage = int(input("Por favor, ingrese una nota: "))
grade = "UK"

if(gradePercentage>=90):
    grade="A"
elif(gradePercentage>=80):
    grade="B"
elif(gradePercentage>=70):
    grade="C"
elif(gradePercentage>=60):
    grade="D"
else:
    grade="F"
print(f"La nota {gradePercentage} es {grade}")