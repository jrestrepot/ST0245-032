
/**
 * Write a description of class Punto2 here.
 *
 * @author Juliana Restrepo y Andrea Carvajal
 * @version (a version number or a date)
 */
public class Punto2
{
    public static boolean darkSouls(int i, int [] elemen, int max) {

        if(i>=elemen.length){
            return max==0;
        }
        else if (darkSouls(i+1,elemen,max-elemen[i]) || (darkSouls(i + 1, elemen, max))){
            return true;
        }
        return false;

    }
}
