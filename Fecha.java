
/**
 * Write a description of class Fecha here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Fecha
{
    private int dia;
    private int year;
    private int mes;

    public Fecha(String f){
        String diaTemp = f.substring(0,f.indexOf('/'));
        String mesTemp = f.substring(f.indexOf('/')+1, f.lastIndexOf('/'));
        String yearTemp = f.substring(f.lastIndexOf('/')+1,f.length());
        dia = Integer.parseInt(diaTemp);
        mes = Integer.parseInt(mesTemp);
        year = Integer.parseInt(yearTemp);
    }

    public Fecha(int dia, int mes, int year){ 
        this.dia = dia;
        this.mes = mes;
        this.year = year;
    }

    public int obtDia(){
        return dia;
    }

    public int obtMes(){
        return mes;
    }

    public int obtYear(){
        return year;
    }

    public boolean sonIguales(Fecha f){
        if(dia == f.obtDia() && mes == f.obtMes() && year == f.obtYear())
            return true;
        return false;
    }

    public String comparar(Fecha f){
        if (year < f.obtYear()){
            return "Fecha 1 mayor que fecha 2";
        } else if(year > f.obtYear()){
            return "Fecha 1 menor que fecha 2";
        } else {
            if (mes < f.obtMes()){
                return "Fecha 1 mayor que fecha 2";
            } else if (mes > f.obtMes()){
                return "Fecha 1 menor que fecha 2";
            } else {
                if (dia< f.obtDia()){
                    return "Fecha 1 mayor que fecha 2";
                } else if (dia< f.obtDia()){
                    return "Fecha 1 menor que fecha 2";
                }
            }
        }
        return "Son iguales";
    }
    
    public void imprimir(){
     Scanner scan = new Scanner(System.in);
     System.out.println(""+dia+"/"+mes+"/"+year+"");
     
    }
}
