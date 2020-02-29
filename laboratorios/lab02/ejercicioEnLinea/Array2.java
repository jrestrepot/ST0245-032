
/**
 * Write a description of class Array2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Array2
{

    public int countEvens(int[] nums) {
        int cont = 0;
        for (int i = 0; i<nums.length; i++){
            if (nums[i]%2==0){
                cont ++;
            }
        }
        return cont;
    }
    

    public int bigDiff(int[] nums) {
        int max= nums[0];
        int min= nums[0];
        for (int i = 0; i<nums.length; i++){
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }

        return max-min;
    }

    public int centeredAverage(int[] nums) {
        int sum = 0;
        int max = nums[0];
        int min = nums[0];

        for (int i = 0; i < nums.length; i++) {

            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);

            sum = sum + nums[i];
        }

        sum = sum - max;
        sum = sum - min;

        return sum / (nums.length - 2);
    }

    public int sum13(int[] nums) {
        int suma= 0;
        if (nums.length==0) {
            suma = 0;
        } 
        for (int i = 0; i<nums.length;i++){
            if (nums[i] != 13){
                suma = suma + nums[i];
            } else if (nums[i] == 13 && i != nums.length-1 && nums[i+1]!= 13) {
                suma = suma - nums[i+1];
            } else if (nums[i] == 13 && i == nums.length-1){
                suma = suma;
            } else{
                suma = 0;
            }
        }
        return suma;
    }

    public boolean haveThree(int[] nums) {
        int cont = 0;
        if (nums.length<3){
            return false;
        }
        for (int i = 0; i< nums.length-1; i++){
            if (nums[i] == 3 && nums[i+1] == 3 ){
                return false;
            }
            if (nums [i] == 3){
                cont ++;
            }
        }
        if (nums[nums.length-1]==3){
            cont ++;
        }
        return cont==3;
    }
}

