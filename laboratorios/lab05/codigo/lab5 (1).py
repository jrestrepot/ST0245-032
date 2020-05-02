import numpy as np

info = ["3", "3", "01", "12", "20", "3", "2", "01", "21", "9", "8", "01", "02", "03", "04", "05", "06", "07", "08"]
listaInstrucciones = []
n = len(info)
listita = []
listita.append(info[0])
listita.append(info[1])

for i in range(2, n):
    if len(info[i]) == 1 and len(info[i + 1]) == 1:
        listaInstrucciones.append(listita)
        listita = []
        listita.append(info[i])

    else:
        listita.append(info[i])
listaInstrucciones.append(listita)

m = len(listaInstrucciones)
for j in range(0, m):
    tamaño = int(listaInstrucciones[j][0])
    uniones = int(listaInstrucciones[j][1])
    matriz_de_uniones = np.zeros([tamaño, tamaño], dtype=int)
    # 0 es azul 1 es otro color, tenemos que toddas son azules menos 1
    azul = [-1 for i in range(tamaño)]

    azul[0] = 1
    possible = True
    for i in range(2, uniones + 2):
        matriz_de_uniones[int(listaInstrucciones[j][i][0])][int(listaInstrucciones[j][i][1])] = 1
        matriz_de_uniones[int(listaInstrucciones[j][i][1])][int(listaInstrucciones[j][i][0])] = 1

    # se recorre
    for n in range(0, tamaño):
        for m in range(0, tamaño):
            if matriz_de_uniones[n][m] == 1 and azul[m] == -1:
                azul[m] = 1 - azul[n]
            elif matriz_de_uniones[n][m] == 1 and azul[m] == azul[n]:
                possible = False

    if possible == True:
        print("BICOLORABLE")
    else:
        print("NOT BICOLORABLE")

