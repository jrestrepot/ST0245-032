
/**
 * Write a description of class SubsecuenciaADN here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SubsecuenciaADN
{
    public int subsequence(String a, String b, int m, int n){
        if(m == 0 || n== 0) 
            return 0;
        if(a.charAt(m-1) == b.charAt(n-1))
            return subsequence(a,b,m-1,n-1) + 1;
        else
            return Math.max(subsequence(a,b,m,n-1),subsequence(a,b,m-1,n));

    }

}
