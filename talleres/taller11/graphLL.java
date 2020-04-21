import java.util.*;
import javafx.util.Pair;

public class graphLL extends digraph
{
    ArrayList<LinkedList<Pair<Integer,Integer>>> lista;
    public graphLL(int size){
        super(size);
        lista=new ArrayList<>();
        for(int i=0; i<size;i++){
        lista.add(new LinkedList<>());
    }
        
    }
    @Override
    public void addarc(int source, int destination, int weigth){
        lista.get(source).add(new Pair<>(destination,weigth));
    }
    public ArrayList<Integer> getsuccesors(int vertex){
        ArrayList<Integer> n= new ArrayList<>();
        lista.get(vertex).forEach(i->n.add(i.getKey()));
        
        return n;
    }
    public int getweigth(int source,int destination){
        int a=0;
        for (Pair<Integer,Integer> integerIntegerPair: lista.get(source)){
            if (integerIntegerPair.getKey()==destination)a=integerIntegerPair.getValue();
            
        }
        return a;
    }
    
    
    
}
