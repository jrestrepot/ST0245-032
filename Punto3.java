
/**
 * Write a description of class Punto3 here.
 *
 * @author Juliana Restrepo y Andrea Carvajal
 * @version (a version number or a date)
 */
public class Punto3
{
    public static void cadena(String base, String str){
    if (str.equals("")){
        System.out.println(base);
    }
    else {
        cadena(base+str.charAt(0),str.substring(1));
        cadena(base,str.substring(1));
    }   
}
}
