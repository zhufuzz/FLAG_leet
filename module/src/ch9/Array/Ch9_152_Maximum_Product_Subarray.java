package ch9.Array;
import java.util.*;


/*Find the contiguous subarray within an array (containing at least one number) which has the largest product.
For example, given the array [2,3,-2,4],the contiguous subarray [2,3] has the largest product = 6.*/
// LeetCode version:
public class Ch9_152_Maximum_Product_Subarray {
    /**  * @param nums: an array of integers  * @return: an integer */
    public int maxProduct1(List<Integer> nums) {
        int[] max = new int[nums.size()];
        int[] min = new int[nums.size()];        
        min[0] = max[0] = nums.get(0);
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            min[i] = max[i] = nums.get(i);
            if (nums.get(i) > 0) {
                max[i] = Math.max(max[i], max[i - 1] * nums.get(i));
                min[i] = Math.min(min[i], min[i - 1] * nums.get(i));
            } else if (nums.get(i) < 0) {
                max[i] = Math.max(max[i], min[i - 1] * nums.get(i));
                min[i] = Math.min(min[i], max[i - 1] * nums.get(i));
            }            
            result = Math.max(result, max[i]);
        }        
        return result;
    }
	// LintCode Version:
    /**  * @param nums: an array of integers * @return: an integer  */
    public int maxProduct2(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];        
        min[0] = max[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = max[i] = nums[i];
            if (nums[i] > 0) {
                max[i] = Math.max(max[i], max[i - 1] * nums[i]);
                min[i] = Math.min(min[i], min[i - 1] * nums[i]);
            } else if (nums[i] < 0) {
                max[i] = Math.max(max[i], min[i - 1] * nums[i]);
                min[i] = Math.min(min[i], max[i - 1] * nums[i]);
            }            
            result = Math.max(result, max[i]);
        }        
        return result;
    }
}