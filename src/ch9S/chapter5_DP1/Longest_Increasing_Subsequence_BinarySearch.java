package ch9S.chapter5_DP1;


//O(nlogn) Binary Search
public class Longest_Increasing_Subsequence_BinarySearch{
	 /**
	  * @param nums: The integer array
	  * @return: The length of LIS (longest increasing subsequence)
	  */
	 public int longestIncreasingSubsequence(int[] nums) {
	     int[] minLast = new int[nums.length + 1];
	     minLast[0] = -1;
	     for (int i = 1; i <= nums.length; i++) {
	         minLast[i] = Integer.MAX_VALUE;
	     }
	     
	     for (int i = 0; i < nums.length; i++) {
	         // find the first number in minLast > nums[i]
	         int index = binarySearch(minLast, nums[i]);
	         minLast[index] = nums[i];
	     }
	     
	     for (int i = nums.length; i >= 1; i--) {
	         if (minLast[i] != Integer.MAX_VALUE) {
	             return i;
	         }
	     }
	     
	     return 0;
	 }
	 
	 // find the first number > num
	 private int binarySearch(int[] minLast, int num) {
	     int start = 0, end = minLast.length - 1;
	     while (start + 1 < end) {
	         int mid = (end - start) / 2 + start;
	         if (minLast[mid] < num) {
	             start = mid;
	         } else {
	             end = mid;
	         }
	     }
	     
	     if (minLast[start] > num) {
	         return start;
	     }
	     return end;
	 }
}
