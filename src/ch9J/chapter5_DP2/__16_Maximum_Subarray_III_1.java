package ch9J.chapter5_DP2;//划分类

//方法一 划分类DP
public class __16_Maximum_Subarray_III_1 {
 /**
  * @param nums: A list of integers
  * @param k: An integer denote to find k non-overlapping subarrays
  * @return: An integer denote the sum of max k non-overlapping subarrays
  */
 public int maxSubArray(int[] nums, int k) {
     if (nums.length < k) {
         return 0;
     }
     int len = nums.length;
    
     int[][] globalMax = new int[k + 1][len + 1];
     int[][] localMax = new int[k + 1][len + 1];
     
     for (int i = 1; i <= k; i++) {
         localMax[i][i-1] = Integer.MIN_VALUE;
         //小于 i 的数组不能够partition
         for (int j = i; j <= len; j++) {
             localMax[i][j] = 
            		 Math.max(localMax[i][j-1], globalMax[i - 1][j-1]) + nums[j-1];
             if (j == i){
            	 	globalMax[i][j] = localMax[i][j];
             } else{
            	 	globalMax[i][j] = Math.max(globalMax[i][j-1], localMax[i][j]);
             }
         }
     }
     return globalMax[k][len];
 }
}
