
import java.util.LinkedList;
public class BFS
{
    Graph g=new Graph();
    public boolean auxHayCamino(Graph g, int i, int j){
        LinkedList<Integer> visitado = new LinkedList<Integer>();
        LinkedList<Integer> aVisitar = new LinkedList<Integer>();
        aVisitar.add(i);
        while(aVisitar!= null){
            int temp = aVisitar.remove();
            if(temp==j){
                return true;
            }

            if(visitado.contains(temp)){
                continue;
            }
            visitado.add(temp);
            
            for(int sucesor: g.getAdyacentes(i)){
                aVisitar.add(sucesor);
            }
        }
        return false;
    }
    
    public boolean hayCamino(int i, int j, Graph g){
        return auxHayCamino(g,i,j);
    }
}
