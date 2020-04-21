import java.util.ArrayList;
public class graphAM extends digraph{
    int[][] matriz;
    public graphAM(int size){
        super(size);
        matriz=new int[size][size];
    }
    @Override
    public void addarc(int source, int destination, int weigth){
        matriz[source][destination]=weigth;
    }
    public ArrayList<Integer> getsuccesors(int vertex){
        ArrayList<Integer> a=new ArrayList<>();
        for(int i=0; i<size;i++){
            if (matriz[vertex][i]!=0){
                a.add(vertex);
            }
        }
        return a;
    }
    public int getweigth(int source,int destination){
        return matriz[source][destination];
    }
}


    
