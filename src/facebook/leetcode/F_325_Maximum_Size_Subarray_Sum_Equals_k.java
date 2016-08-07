package facebook.leetcode;
//Hash Table
import java.util.*;

/*Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

Follow Up:
Can you do it in O(n) time?*/
//https://leetcode.com/discuss/84371/java-easy-version-to-understand

public class F_325_Maximum_Size_Subarray_Sum_Equals_k{
	
  public static int maxSubArrayLen(int[] nums, int k) {
      if (nums == null || nums.length == 0)
          return 0;
      
      int len = nums.length, maxLen = 0, sum = 0;
      HashMap<Integer, Integer> map = new HashMap<>();
      
      for (int i = 0; i < len; i++) {
          sum += nums[i];
          if (sum == k){
              maxLen = i + 1;
          } else if (map.get(sum - k) != null){            
              maxLen = Integer.max(maxLen, i - map.get(sum - k));
          }
          if (map.get(sum) == null){
              map.put(sum, i);
          }            
      }
      
      return maxLen;
    }
}