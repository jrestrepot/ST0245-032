
/**
 * Write a description of class Rectangulo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rectangulo
{
    
    public static int rectangulos(int n){

        if(n<=2){
            return n;
        } else{
            return rectangulos(n-2) + rectangulos(n-1);
        }
	
    }

    public static long obtTiempo(){
        long tiempoInicial = System.currentTimeMillis();
        rectangulos(44);
        long tiempoFinal = System.currentTimeMillis();
        long tiempo = tiempoFinal - tiempoInicial;
        return tiempo;
    }
}
