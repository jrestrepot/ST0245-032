
/**
 * Write a description of class Fibonacci here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Fibonacci
{
    public static int fibonacci(int n){
    
  if(n==0){
    return 0;
} if(n==1){
    return 1;
} else {
    return fibonacci(n-1) + fibonacci(n-2);
}
}
}
