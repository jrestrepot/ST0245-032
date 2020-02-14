
/**
 * Write a description of class NMax here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NMax

{ public static int elementos(int i, int [] n, int Nmax){

  if (i>=n.length) {
    return Nmax;
 } else{
    if (n[i]> Nmax) {
      Nmax = n[i];
    }
    return elementos(i+1, n, Nmax);
  }
}


}

