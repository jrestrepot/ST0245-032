
/**
 * Write a description of class CodingBatRecursion2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CodingBatRecursion2
{
    public boolean groupSum6(int start, int[] nums, int target) {
        if(start>=nums.length) 
            return target==0;
        if(nums[start]==6) 
            return groupSum6(start+1, nums, target-nums[start]);
        return groupSum6(start+1, nums, target-nums[start]) || groupSum6(start+1, nums, target);

    }

    public boolean groupSum5(int start, int[] nums, int target) {
        if(start>=nums.length) return target==0;
        if(nums[start]%5==0){
            return groupSum5(start+1,nums,target-nums[start]);
        } 
        if(nums[start]==1 && start>0){
            if(nums[start-1]%5==0){
                return  groupSum5(start+1,nums,target);
            }
        }
        return groupSum5(start+1,nums,target-nums[start]) || groupSum5(start+1,nums,target);
    }

    public boolean groupNoAdj(int start, int[] nums, int target){
        if(start >= nums.length)
            return target==0;
        if(groupNoAdj(start + 2, nums, target - nums[start]))
            return true;
        return groupNoAdj(start + 1, nums, target);
    }

    public boolean splitArray(int[] nums){	
        return iguales(nums, 0, 0);
    }

    public boolean iguales(int[] nums, int n, int j){
        if(n == nums.length)
            return (j == 0);
        if(iguales(nums, n + 1,j + nums[n]))
            return true;
        return iguales(nums, n + 1, j - nums[n]);
    }

    public boolean splitOdd10(int[] nums) {
        return splitOdd10Helper(0, nums, 0, 0);
    }

    public boolean splitOdd10Helper(int start, int[] nums, int mult, int odd) {
        if(start >= nums.length)
            return mult % 10 == 0 && odd % 2 == 1;        
        if(splitOdd10Helper(start+1, nums, mult + nums[start], odd))
            return true;                  
        if(splitOdd10Helper(start+1, nums, mult, odd + nums[start]))
            return true;                            
        return false;
    } //El último ejercicio fue recuperado de: https://github.com/mirandaio/codingbat/blob/master/java/recursion-2/splitOdd10.java
}
