import java.util.*;
public class Taller_8
{
    public static int polaca (String string){
        String[] str= string.split(" ");
        Stack<Integer> pila= new Stack<>();
        
        for (int i=0; i<str.length; i++){
            
            if (str[i].equals("+")){
                pila.push(pila.pop()+pila.pop());
                
            }else if (str[i].equals("*")){
                pila.push(pila.pop()*pila.pop());
                
            }else if (str[i].equals("-")){
                int a=pila.pop();
                pila.push(pila.pop()-a);
            }else if (str[i].equals("/")){
                int b=pila.pop();
                if (b==0){
                    break;
                }
                pila.push((pila.pop()/b));
            }else {
                pila.push(Integer.parseInt(str[i]));
            }
            
            
        }
        
        return pila.pop();
        
    }
    public static Stack<Integer> inverse (Stack<Integer> original){
        Stack<Integer> nuevo= new Stack<>();
        while (!original.isEmpty()){
            nuevo.push(original.pop());
            
        }
        
        return nuevo;
        
        }
    
    public static void cola(Queue<Integer> pedidos, Stack<String> neveras){
        while (!pedidos.isEmpty() || !neveras.isEmpty()){
            int a=pedidos.poll();
            for (int i=0; i<a; i++){
                if (!neveras.isEmpty()){
                    break;
                }
                System.out.println("estamos atendiendo a: " + a +"la nevera a:" + neveras.pop());
            }
            
            
        }
        
    }
    
        
        
    
    
    
}
