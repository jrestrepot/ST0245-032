
/**
 * Write a description of class Linea here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Linea
{
    private Punto a;
    private Punto b;
    private int dy;
    private int dx;
    public Linea(Punto a, Punto b){
        this.a = a;
        this.b = b;
    }

    public int mcd(int p, int q){
        if(p>q){
            if(p%q==0)

                return q;

            else 

                return mcd(q,p%q);

        } else {

            if(q%p==0)

                return p;

            else 

                return mcd(p,q%p);
        }
    }

    public void pendiente(){
        int y = (b.obtY()-a.obtY());
        int x = (b.obtX()-a.obtX());
        dy = y/mcd(x,y);
        dx = x/mcd(x,y);
    }

    public void puntosInter(){
        pendiente();
        int ax = a.obtX();
        int ay = a.obtY();
        for (int i=ax; i<=b.obtX(); i+=dx){
            Punto p = new Punto(ax, ay);
            System.out.println("("+ ax + "," + ay + ")");
            ax = ax + dx;
            ay = ay + dy;
        }
    }
}
