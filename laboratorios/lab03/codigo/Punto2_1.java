import java.util.*;
public class Punto2_1
{
    private static String string1;

    public static void texto(String s1){
        String aux=s1;
        LinkedList<String> s2 = new LinkedList();
        if(s1.indexOf("]")!=-1 && s1.indexOf("]")!=-1){
            int i=s1.indexOf("["); 
            while(i<aux.length()){
                if(aux.charAt(i)=='[' && aux.indexOf("]")!=-1){
                    s2.add(aux.substring(i+1,aux.indexOf("]")));
                    aux=aux.substring(aux.indexOf("]")+1,aux.length());
                }
                if(aux.indexOf("[")==-1||aux.indexOf("]")==-1){
                    break;
                }
                i=aux.indexOf("[");
            }
            s2.add(s1.substring(0,s1.indexOf("[")));
            s2.add(s1.substring(s1.lastIndexOf("]")+1,s1.length()));
        }
        else {
            s2.add(s1.substring(0,s1.length()));
        }
        System.out.println(s2);
    }

    /* SOLUCION OPCIONAL
    public static void texto(String s1){
    String aux=s1;
    String s2 = "";
    if(s1.indexOf("]")!=-1 && s1.indexOf("]")!=-1){
    int i=s1.indexOf("["); 
    while(i<aux.length()){
    if(aux.charAt(i)=='[' && aux.indexOf("]")!=-1){
    s2=s2+(aux.substring(i+1,aux.indexOf("]")));
    aux=aux.substring(aux.indexOf("]")+1,aux.length());
    }
    if(aux.indexOf("[")==-1||aux.indexOf("]")==-1){
    break;
    }
    i=aux.indexOf("[");
    }
    s2+s2=(s1.substring(0,s1.indexOf("[")));
    s2+s2=(s1.substring(s1.lastIndexOf("]")+1,s1.length()));
    }
    else {
    s2+s2=(s1.substring(0,s1.length()));
    }
    System.out.println(s2);
    }
     */

    public static void leer(){
        Scanner sc= new Scanner(System.in);
        String s="";
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            s=s+"\n"+str;
        }
        string1=s;
    }

    public static String [] splitStr(String str){
        String [] lines = str.split("\n");
        return lines;
    }

    public static void main(String args[]){
        leer();
        for(int i = 1; i<splitStr(string1).length; i++){
            texto(splitStr(string1)[i]);
        }

    }

}

