
/**
 * Write a description of class CodingBatRecursion1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CodingBatRecursion1
{

    public int bunnyEars(int bunnies) {
        if (bunnies==0) return 0;
        else return 2+ bunnyEars(bunnies-1);
    }

    public String changeXY(String str) {
        if (str.equals("")) return str;
        else if (str.charAt(0)=='x') return "y"+changeXY(str.substring(1));
        else return str.charAt(0)+changeXY(str.substring(1));
    }

    public int array11(int[] nums, int index) {
        if(index>=nums.length) return 0;
        if (nums[index]==11) return 1 + array11(nums, index+1);
        else return array11(nums, index+1);

    }

    public int countHi(String str) {
        if (str.length()<=1) return 0;
        else if (str.substring(0,2).equals("hi")) return 1 + countHi(str.substring(2));
        else return countHi(str.substring(1));
    }

    public String endX(String str) {
        if (str.length()==0) return str;
        else if (str.charAt(0)=='x') return endX(str.substring(1)) + str.charAt(0);
        else return str.charAt(0) + endX(str.substring(1));
    }

    public int countPairs(String str) {
        if(str.length()<3) return 0;
        if (str.charAt(0)==str.charAt(2)) return 1 + countPairs(str.substring(1));
        else return countPairs(str.substring(1));
    }

    public boolean array220(int[] nums, int index) {
        if (index>= nums.length-1) return false;
        if (nums[index+1]==nums[index]*10) return true;
        else return array220(nums,index+1);
    }

}
