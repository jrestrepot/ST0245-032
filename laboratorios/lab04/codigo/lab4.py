class Node():
    def __init__(self,data):
        self.data=data
        self.right=None
        self.left=None


    def insert(self,data):
        if self.data:
            if data<self.data:
                if self.left is None:
                    self.left=Node(data)
                else:
                    self.left.insert(data)
            elif data>self.data:
                if self.right is None:
                    self.right=Node(data)
                else:
                    self.right.insert(data)
        else:
            self.data=data

lista=[50,30,24,5,28,45,98,52,60]
tree=Node(lista[0])
for i in range(1,len(lista)):
    tree.insert(lista[i])
def imprimir(Nodo):
    if Nodo is not None:
        imprimir(Nodo.left)
        imprimir(Nodo.right)
        print(Nodo.data)
imprimir(tree)


