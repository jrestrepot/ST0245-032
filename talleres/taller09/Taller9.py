#Punto1
class HashTable(): 
    def __init__(self):
       self.tabla = [0]*10
       for i in range(len(self.tabla)):
          self.tabla[i] = []
    def funcion_hash(self, k):
       return k[0]%len(k)
    def get(self, k):
       return self.tabla[funcion_hash(k)]
       #retorna 0 en caso de que no esté 
    def put(self, k, v): 
       self.tabla[funcion_hash(k)].append(v,k)

#Punto2
tabla={"Google":"Estados Unidos", "La locura":"Colombia", "Nokia":"Finlandia", "Sony": "Japon"}

#Punto3
def esta(k):
  try:
    return tabla[k]!=None
  except:
    return False

#Punto4
def valor(v):
  for key in tabla:
    if tabla[key]==v:
      return key
      break
    else:
      print("no existe ese valor")
    
