
/**
 * Write a description of class Desencriptacion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Desencriptacion
{
    public static void perm(String base, String str){
        if(str.equals("")){
            System.out.println(base);
        }
        else {
            for(int i = 0; i<str.length(); i++){
               perm(base+str.charAt(i), str.substring(0,i)+str.substring(i+1,str.length()));
            }
        }
    }


}
