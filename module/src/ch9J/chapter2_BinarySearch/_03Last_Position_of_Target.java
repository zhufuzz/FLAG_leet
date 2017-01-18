package ch9J.chapter2_BinarySearch;

import org.junit.Test;

//version 1: with jiuzhang template
public class _03Last_Position_of_Target {
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
        //start + 1 == end就是相邻状况, 已经不满足以下循环条件，就不会遇到死循环情况
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] < target) {
               start = mid;
                 // or  start = mid + 1;
            } else {
            		end = mid;
             // or   end = mid - 1;
            }
        }
        //以上循环结束时，start和end有可能是一个很数，也有可能是两个数
        //因为是看last position，所以先看end，再看start
        if (nums[end] == target) {
            return end;
        }
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }
    
    @Test
    public void testLastPosition(){
    		//Random random = new Random();
    		int[] nums = new int[20000000];
    		for(int i = 0; i < nums.length; i++){
    			nums[i] = i;
    		}
	    	//int[] nums = {1,2,2,2,3,4,5,6,7,7,7,8,9,10,11,11,12,13,14};
	    	int result = lastPosition(nums, 7777777);
	    	System.out.println(result);
    }
 }


//version 2: without jiuzhang template
//this code is not working, will get time limit exceeded 
//because of dead loop
class Last_Position_of_Target2 {
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

/*
Find the last position of a target number in a sorted array. 
Return -1 if target does not exist.

Have you met this question in a real interview? Yes
Example: Given [1, 2, 2, 4, 5, 5].
For target = 2, return 2. 
For target = 5, return 5.
For target = 6, return -1.

Tags: Binary Search

Related Problems: 
Easy Closest Number in Sorted Array 38 %
Easy Classical Binary Search 47 %
Easy First Position of Target 32 %
 * */
