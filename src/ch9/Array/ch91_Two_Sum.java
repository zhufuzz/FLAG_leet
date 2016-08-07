package ch9.Array;

import java.util.*;
/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
UPDATE (2016/2/13):
The return format had been changed to zero-based indices. Please read the above updated description carefully.*/

  public class ch91_Two_Sum {
    public int[] twoSum(int[] nums, int target) {
      Map<Integer, Integer> hash = new HashMap<Integer, Integer> ();
      int[] result = new int[2];
      for (int i = 0; i < nums.length; ++i) {
        if (hash.containsKey(target - nums[i])) {
          result[0] = hash.get(target - nums[i]) + 1;
          result[1] = i + 1;
          break;
        }
        hash.put(nums[i], i);
      }
      return result;
    }
}