
/**
 * Write a description of class Array3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Array3
{
    public int maxSpan(int[] nums) {
        int span = 0;
        int temp = 0;
        for(int i = 0; i<nums.length; i++){
            for(int j = nums.length; j>0; j--){
                if(nums[i]==nums[j-1]) temp = (j-i);
                span = Math.max(temp,span);
            }
        }
        return span;
    }

    public boolean canBalance(int[] nums) {
        int sumap=nums[0];
        int sumaf=0;
        int i=0;
        boolean valor=false;
        if(nums.length>1){
            for(int j =1;j<nums.length;j++){
                sumaf=sumaf+nums[j];
            }
            while(i<nums.length-1){
                for(int j=i+1;j<nums.length;j++){
                    if(!(sumap==sumaf)){
                        sumap=sumap+nums[j];
                        sumaf=sumaf-nums[j];
                    }else
                    {valor=true;
                        break;
                    }
                }
                i++;
            }
            return valor;
        }
        else{
            return false;
        }
    }

    /*Recuperado de:
    https://github.com/mirandaio/codingbat/blob/master/java/array-3/fix34.java*/
    public int[] fix34(int[] nums) {
        int i = 0;

        while(i < nums.length && nums[i] != 3)
            i++;

        int j = i + 1;

        while(j < nums.length && nums[j] != 4)
            j++;

        while(i < nums.length) {
            if(nums[i] == 3) {
                int temp = nums[i+1];
                nums[i+1] = nums[j];
                nums[j] = temp;

                while(j < nums.length && nums[j] != 4)
                    j++;
            }
            i++;
        }
        return nums;

    }

    /*Recuperado de:
    https://github.com/mirandaio/codingbat/blob/master/java/array-3/fix34.java*/public int[] fix45(int[] nums) {
        int i = 0;
        int j = 0;

        while(j < nums.length && nums[j] != 5)
            j++;

        while(i < nums.length) {
            if(nums[i] == 4) {
                int temp = nums[i+1];
                nums[i+1] = nums[j];
                nums[j] = temp;

                while((j < nums.length && nums[j] != 5) || j == i + 1)
                    j++;
            }
            i++;
        }
        return nums;
    }

    /*Recuperado de:
    https://github.com/mirandaio/codingbat/blob/master/java/array-3/fix34.java*/
    public boolean linearIn(int[] outer, int[] inner) {
        int i = 0;
        int j = 0;
        while(i < inner.length && j < outer.length) {
            if(inner[i] > outer[j]) {
                j++;
            } else if(inner[i] < outer[j]) {
                return false;
            } else {
                i++;
            }
        }
        if(i != inner.length)
            return false;
        return true;
    }
}