'''
se lee desde un archivo csv
'''
import csv
lis=[]
with open("estudiantes.csv") as txt:
    archivo= csv.DictReader(txt,delimiter=";")
    for n in archivo:
        lis.append(n)



def consulta1(curso,semestre):
    for i in lis:
        if i["Periodo"]==str(semestre):
            print(i["Estudiante"],i[curso])


def consulta2(estudiante):
    for i in lis:
        if i["Estudiante"]==estudiante:
            print(i.values())
            break
