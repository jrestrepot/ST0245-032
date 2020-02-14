
/**
 * Write a description of class VolMax here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VolMax
{
   public static boolean volumenes(int i, int[] elemen, int volMax){
  if (i>=elemen.length){
    return volMax==0;
} else{
     if (volumenes(i+1,elemen,volMax-elemen[i]) || volumenes(i + 1, elemen, volMax)){
            return true;
        }
  return false;
 }
}    
}

