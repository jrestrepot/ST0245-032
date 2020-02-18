# -*- coding: utf-8 -*-
"""
Editor de Spyder

Este es un archivo temporal.
"""
from time import time
import random
def generate(l):
  a=[]
  h=0
  while h<l:
    a.append(random.randrange(100))
    h=h+1
  return a

def sort(arr):
  for i in range (1,len(arr)):
    aux = arr[i]
    j = i-1
    while j>=0 and aux < arr[j]:
      arr[j+1]=arr[j]
      j = j-1
    arr[j+1]=aux
  return arr

for i in range (21):
  start=time()
  b=random.randrange(1000,3000,100)
  sort(generate(b))
  final=time()-start
  print(final, b)
  
def sum(m):
  su=0
  for n in range(len(m)):
      su=su+m[n]
  return su
