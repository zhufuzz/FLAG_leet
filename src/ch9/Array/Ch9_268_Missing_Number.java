package ch9.Array;
/*Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?*/

//http://blog.welkinlan.com/2015/09/05/missing-number-leetcode-lintcode-java/

public class Ch9_268_Missing_Number {
    public int missingNumber(int[] nums) {
          int xorAll = 0;
        for (int i = 0; i <= nums.length; i++) {
            xorAll ^= i;
        }
        for (int i = 0; i < nums.length; i++) {
            xorAll ^= nums[i];
        }
        return xorAll;
    }
}