
/*
 * RESPUESTAS:
 * 1) No es apropiado utilizarlo como editor de texto pues en caso de que el
 * sea muy extenso, se demoría mucho, pues casi todos los métodos tienen una
 * complejidad de O(n).
 * 2) O(n).
**/
public class ArrayList1
{ private int size;
    private char [] elementos;
    private final int capacidad = 10;
    public ArrayList1(){
        size = 0;
        elementos = new char[capacidad];
    }

    public char[] insert(char x, int index) throws IndexOutOfBoundsException{
        if(index>elementos.length) duplicate();
        char aux = elementos[index];
        elementos[index] = x;

        for(int i = index+1;i<elementos.length-1;i++){
            elementos[i] = aux;
            aux = elementos[i+1];
        }
        size += 1;
        return elementos;
    }

    public char[] insert(char x){
        if(size==elementos.length) duplicate();
        elementos[size] = x;
        size+=1;
        return elementos;
    }

    private char [] duplicate(){
        char [] arr = new char[2*elementos.length];
        for(int i = 0;i<elementos.length;i++){
            arr[i]=elementos[i];
        }
        return arr;
    }

    public char get(int i){
        if (i>size) return 0;
        return elementos[i];
    }

    public char[] remove(int index){
        char aux = elementos[index+1];
        for(int i = index;i<size-1;i++){
            elementos[i] = aux;
        }
        if(elementos[size-2]==elementos[size-1]) elementos[size-1]  = '\u0000';
        size -= 1;
        return elementos;
    }

    public boolean contains(char x){
        for(int i =0;i<elementos.length;i++){
            if(elementos[i]==x) return true;
            break;
        }
        return false;
    }
    
}
 