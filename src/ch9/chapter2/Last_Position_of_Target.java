package ch9.chapter2;
/*
 * Find the last position of a target number in a sorted array. Return -1 if target does not exist.

Have you met this question in a real interview? Yes
Example
Given [1, 2, 2, 4, 5, 5].

For target = 2, return 2.

For target = 5, return 5.

For target = 6, return -1.

Tags 
Binary Search
Related Problems 
Easy Closest Number in Sorted Array 38 %
Easy Classical Binary Search 47 %
Easy First Position of Target 32 %
 * */

//version 1: with jiuzhang template
public class Last_Position_of_Target {
	/**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */
    public int lastPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] < target) {
                start = mid;
                // or start = mid + 1
            } else {
                end = mid;
                // or start = mid - 1
            }
        }
        
        if (nums[end] == target) {
            return end;
        }
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }
}


//version 2: without jiuzhang template
//this code is not working, it will get time limit exceeded because of dead loop
class Solution {
 /**
  * @param nums: An integer array sorted in ascending order
  * @param target: An integer
  * @return an integer
  */
 public int lastPosition(int[] nums, int target) {
     if (nums == null || nums.length == 0) {
         return -1;
     }
     
     int start = 0, end = nums.length - 1;
     while (start < end) {
         int mid = start + (end - start) / 2;
         if (nums[mid] == target) {
             start = mid;
         } else if (nums[mid] < target) {
             start = mid + 1;
         } else {
             end = mid - 1;
         }
     }
     
     if (nums[start] == target) {
         return start;
     }
     return -1;
 }
}

