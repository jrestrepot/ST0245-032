  
# -*- coding: utf-8 -*-
"""Proyecto_final_datos1.ipynb
David Vergara Patiño
Andrea Carvajal Maldonado
Juliana Restrepo Tobar
"""

import pandas as pd
import numpy
from sklearn.metrics import confusion_matrix


def count(data: pd.DataFrame):
    '''
    Returns a diccionary whose keys are pos and neg. The pos key holds the value
    of how many students succeeded in the test, the neg key holds the value of
    how many students didn´t.
    '''
    dicc = {}
    dicc["pos"] = data["exito"].sum()
    '''
    This works since students' success is represented with 1's.
    When it sums the data, it will only take into account the 1's, because the 0's
    don't change the sum. This leaves us with the number of 1's.
    '''
    dicc["neg"] = data["exito"].count() - dicc["pos"]  # 
    '''
    It counts everything and then subtracts the sum of 1's, leaving us with 
    the number of 0's.
    '''
    return dicc

def vals(serie: pd.Series):
    '''
    Input: a Serie (a column of the DataFrame).
    It returns a list containing the unique values of the column.
    '''
    lis = []
    for key in serie.value_counts().index: 
        lis.append(key)
    return lis

class question:
    '''
    This class represents the posible questions.
    Its arguments are column and value.
    '''

    def __init__(self,column,value):
        self.column=column
        self.value=value

    def match(self,row):
        val=row[self.column]
        if isinstance(val, (str,float)):
            return val == self.value
        else:
            return val >= self.value
        
    def __repr__(self):
        '''
        This method prints the object question in a String format.
        '''
        cond="=="
        if isinstance(self.value,int) or isinstance(self.value,float):
            cond=">="
        return "Es %s %s %s?" % (self.column, cond, str(self.value))
   
    

def partition(data, question):
    '''
    The method divides the dataframe into two smaller dataframes based on
    whether the element of the column satisfies or not a condition.
    '''
    if isinstance(question.value, int) or isinstance(question.value, float):
        true_rows = data[data[question.column] >= question.value]
        false_rows = data[data[question.column] < question.value]
    else:
        true_rows = data[data[question.column] == question.value]
        false_rows = data[data[question.column] != question.value]
    return true_rows, false_rows

def gini(data):
    '''
    It calculates the Gini Impurity by using its ecuation. N is the diccionary
    that count returns. The keys in N are pos and neg, their probability is
    calculating dividing their values by the total number of elements in the
    column.
    '''
    N = count(data)
    gin = 1
    for keys in N:
        probi = N[keys] / float(len(data))
        gin -= probi ** 2
    return gin

def informationGain(left: pd.DataFrame, right: pd.DataFrame, gin):
    '''
    This function calculates the information gain in each column
    args: Two pd.dataframe of a training set, left and right; and the gini impurity
    of the training dataset.
    return: The information gain (it is a float data type).
    '''
    infog = float((len(left)) / (len(left) + len(right)))
    return gin - infog * gini(left) - (1 - infog) * gini(right)

def bestoption(data: pd.DataFrame):
    """
    Finds which is the question that gives the best information gain.
    Returns the maximun information gain and the best question.
    """
    maxi = 0
    bestquestion = None
    gin = gini(data)
    for key in data.keys():
        values = vals(data[key])
        if key == "exito":
            continue
        for v in values:
            q = question(key, v)
            true_rows, false_rows = partition(data, q)

            if len(true_rows) == 0 or len(false_rows) == 0:
                continue
            gain = informationGain(true_rows, false_rows, gin)

            if gain >= maxi:
                maxi, bestquestion = gain, q

    return maxi, bestquestion

class Leaf:
    '''
    Is a class that returns a dictionary with how many positives and negatives 
    the DataFrame has.
    Its argument is a Data Frame (the data set).
    '''

    def __init__(self, data):
        self.predic =  count(data)["pos"]/len(data)

class Node:
    '''
    Is a class that asks the questions. It has two child Nodes.
    Its arguments are the question, the rows that fulfill the condition and the 
    rows that don't.
    '''

    def __init__(self, question, True_row, False_row):
        self.question = question
        self.True_row = True_row
        self.False_row = False_row

def build(data: pd.DataFrame, deep):
    '''
    This method builds the tree.
    Inputs: Data set and how deep the user wants the decision tree to be.
    Returns: Decision tree.
    '''
    gain, bestQues = bestoption(data)

    if deep==0 or gain==0:
        return Leaf(data)
    '''
    Once the tree has reached the desired depth, the method returns a Leaf, 
    stopping the recursion.
    '''
    
    true_row, false_row = partition(data, bestQues)

    True_branch = build(true_row,deep-1)
    False_branch = build(false_row,deep-1)
    '''
    It recurses on both Data Frames, aditionally it subtracts 1 to deep each 
    time it recurses in order to get the desired depth.
    '''

    return Node(bestQues, True_branch, False_branch)

def printT(node, spacing=""):
    '''
    This fuction prints the tree.
    '''
    if isinstance(node, Leaf):
        print(spacing + "predict", node.predic)
        return

    print(spacing + str(node.question))

    print(spacing + '--> True:')
    printT(node.True_row, spacing + "  ")

    print(spacing + '--> False:')
    printT(node.False_row, spacing + "  ")

def classify(serie: pd.Series, node):
    '''
    Decides whether a particular student will be or not successful by placing him/her
    on a leaf of the already built decision tree.
    '''
    if isinstance(node, Leaf):
        if node.predic >= 0.5:
            return node.predic, 1
        else:
            return node.predic, 0

    if node.question.match(serie):
        return classify(serie, node.True_row)
    else:
        return classify(serie, node.False_row)
  

def organice(data: pd.DataFrame):
    data.drop(["periodo","estu_exterior",'estu_cursodocentesies','estu_tipodocumento.1','estu_nacionalidad.1','estu_genero.1','estu_fechanacimiento.1','periodo.1',
               "estu_estudiante.1",'estu_pais_reside.1','estu_inst_cod_departamento','estu_cod_reside_depto.1','estu_mcpio_reside.1','estu_cod_reside_mcpio.1',
               'fami_pisoshogar','fami_tienemicroondas','fami_tienehorno','fami_tieneautomovil.1','fami_tienedvd','fami_tiene_nevera.1','cole_codigo_icfes',
               'cole_cod_dane_establecimiento', 'cole_nombre_establecimiento','cole_genero','cole_naturaleza','cole_calendario','cole_cod_dane_sede','cole_nombre_sede',
               'cole_sede_principal','cole_cod_mcpio_ubicacion','cole_mcpio_ubicacion','cole_cod_depto_ubicacion',],axis=1,inplace=True)
    return data


#TEST:
data0=pd.read_csv("https://raw.githubusercontent.com/jrestrepot/ST0245-032/master/proyecto/codigo/4_train_balanced_135000.csv",sep=";", index_col=0)
data0=organice(data0)
mytree=build(data0, 8)
dataset=pd.read_csv("https://raw.githubusercontent.com/jrestrepot/ST0245-032/master/proyecto/codigo/4_test_balanced_45000.csv",sep=";", index_col=0)
exito=[]
proba=[]
for i in range(len(dataset)):
    a,b=classify(dataset.iloc[i],mytree)
    exito.append(b)
    proba.append(a)
print(confusion_matrix(dataset["exito"],exito))
