# -*- coding: utf-8 -*-
"""Proyecto_final_datos1.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/16dMFqJZj4FSapziqd1kQHj9hA4e07V5s

En la parte de la lectura de datos usaremos la libreria de pandas con la que crearemos un framework, para que nuestro algoritmo lea mejor los datos.
"""

import pandas
from time import time
import sys

pandas.__version__

data0=pandas.read_csv("https://raw.githubusercontent.com/mauriciotoro/ST0245-Eafit/master/proyecto/datasets/0_train_balanced_15000.csv",sep=";", index_col=0)
data1=pandas.read_csv("https://raw.githubusercontent.com/mauriciotoro/ST0245-Eafit/master/proyecto/datasets/1_train_balanced_45000.csv",sep=";", index_col=0)
data2=pandas.read_csv("https://raw.githubusercontent.com/mauriciotoro/ST0245-Eafit/master/proyecto/datasets/2_train_balanced_75000.csv",sep=";", index_col=0)
data3=pandas.read_csv("https://raw.githubusercontent.com/mauriciotoro/ST0245-Eafit/master/proyecto/datasets/3_train_balanced_105000.csv",sep=";", index_col=0)
data4=pandas.read_csv("https://raw.githubusercontent.com/mauriciotoro/ST0245-Eafit/master/proyecto/datasets/4_train_balanced_135000.csv",sep=";", index_col=0)
data5=pandas.read_csv("https://raw.githubusercontent.com/mauriciotoro/ST0245-Eafit/master/proyecto/datasets/5_train_balanced_57765.csv",sep=";", index_col=0)

