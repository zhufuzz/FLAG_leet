package leet_Array;
/*Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)*/

//https://leetcode.com/discuss/54752/java-solution-of-product-of-array-except-self?show=54752#q54752

public class 238_Product_of_Array_Except_Self{
	public int[] productExceptSelf(int[] nums) {

	    int[] ret = new int[nums.length];


	    int overall = 1;
	    for(int i = 0; i < nums.length; i++){
	        overall = overall * nums[i];
	    }

	    for(int k = 0; k < ret.length; k++){
	        ret[k] = 1;
	    }

	    for(int j = 0; j < ret.length; j++){
	        if(nums[j] == 0){
	            for(int m = 0; m < ret.length; m++){
	                if(m == j){
	                    ret[j] = ret[j];
	                }else{
	                    ret[j] = ret[j] * nums[m];
	                }
	            }
	        }else{
	                ret[j] = overall / nums[j];
	        }
	    }

	    return ret;
	}
}