import java.util.ArrayList;
public abstract class digraph
{
   protected int size;
   public digraph(int vertices){
       size=vertices;
    }
   public abstract void addarc(int source, int destination, int weigth);
   public abstract ArrayList<Integer> getsuccesors(int vertex);
   public abstract int getweigth(int source,int destination);
   public int size(){
       return size;
    }
}
