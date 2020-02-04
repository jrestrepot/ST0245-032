




/**

 * Write a description of class Punto1 here.

 *

 * @author Juliana Restrepo y Andrea Carvajal

 * @version (a version number or a date)

 */

public class Punto1

//Se asume que p es mayor que q por indicaciones del profesor

{

    public int mcd(int p, int q){

        if(p%q==0)

        return q;

        else 

        return mcd(q,p%q);

    }

}