
/**
 * Write a description of class TorresDeHanoi here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TorresDeHanoi
{
    public void hanoi(int n, int origen, int aux, int dest){
        if (n<0){
            System.out.println("No hay discos");
        }
        if (n==1){
            System.out.println("Disco " + n + " desde " + origen + " hasta " + dest);
        }   
        if (n>1){
            hanoi(n-1, origen, dest, aux);
            System.out.println("Disco " + n + " desde " + origen + " hasta " + dest);
            hanoi(n-1, aux, origen, dest);
        }
    }
}
