
public class Punto{
    private int x;
    private int y;
    
    public Punto(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int obtX(){
        return x;
    }

    public int obtY(){
        return y;
    } 

    public double obtRadioPolar(){
        return Math.sqrt(Math.pow(y,2)+ Math.pow(x,2));
    }

    public double obtAnguloPolar(){
        return Math.toDegrees(Math.atan(y/x));
    }
    
    public double obtDistEuclidiana(Punto p){
        double cateto = Math.abs(p.obtX()-x);
        double cateto2 = Math.abs(p.obtY()-y);
        return Math.sqrt(Math.pow(cateto,2)+ Math.pow(cateto2,2));
    }
}
