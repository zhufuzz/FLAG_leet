package ch9J.chapter7_Array;

import java.util.ArrayList;

public class _10Maximum_Subarray_II {
	/**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        int size = nums.size();
        int[] left = new int[size];
        int[] right = new int[size];
        int sum = 0;
        int minSum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < size; i++){
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            left[i] = max;
        }
        sum = 0;
        minSum = 0;
        max = Integer.MIN_VALUE;
        for(int i = size - 1; i >= 0; i--){
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            right[i] = max;
        }
        max = Integer.MIN_VALUE;
        for(int i = 0; i < size - 1; i++){
            max = Math.max(max, left[i] + right[i + 1]);
        }
        return max;
    }
}

/*Given an array of integers, find two non-overlapping subarrays 
 * which have the largest sum.
 
The number in each subarray should be contiguous.
Return the largest sum.

 Notice

The subarray should contain at least one number

Example
For given [1, 3, -1, 2, -1, 2], the two subarrays are [1, 3] and 
[2, -1, 2] or [1, 3, -1, 2] and [2], they both have the largest sum 7.

Challenge 
Can you do it in time complexity O(n) ?

Tags 
Greedy Enumeration LintCode Copyright Array Subarray Forward-Backward
 
Traversal
Related Problems 
Medium Maximum Product Subarray 28 %
Medium Best Time to Buy and Sell Stock III 27 %
Hard Maximum Subarray III 23 %*/