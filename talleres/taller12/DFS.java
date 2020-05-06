
/**
 * Write a description of class DFS here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DFS
{
    private static boolean hayCamino(Graph g, int i, int j){
        boolean[] visitado = new boolean[g.size()];
        visitado[i] = true;
        if (i == j)
            return true;
        else {
            for(Integer sucesor : g.getSuccessors(i)){
                if (!visitado[sucesor] && hayCamino(g, sucesor, j))
                    return true;
            }
            return false;
        }
    }
}
