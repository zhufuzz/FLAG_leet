package leet_Array;
/*Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.*/

//https://leetcode.com/discuss/59543/move-zeros-solution-in-java

public class 283_Move_Zeroes {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length <= 1){
            return;
        }
         int numOfNonZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
               swap(i, numOfNonZero, nums);
               numOfNonZero++;
            }
        }
    }
    
    private void swap (int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}