 package ch9J.chapter7_Array;

public class _21Partition_Array {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int left = 0, right = nums.length - 1;
        while (left <= right) {

            while (left <= right && nums[left] < k) {
                left++;
            }

            while (left <= right && nums[right] >= k) {
                right--;
            }

            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                
                left++;
                right--;
            }
        }
        return left;
    }
}

/*Given an array nums of integers and an int k, partition the array
 *  (i.e move the elements in "nums") such that:
 

All elements < k are moved to the left
All elements >= k are moved to the right
Return the partitioning index, i.e the first index i nums[i] >= k.

 Notice

You should do really partition in array nums instead of just counting 
the numbers of integers smaller than k.

If all elements in nums are smaller than k, then return nums.length

Have you met this question in a real interview? Yes
Example
If nums = [3,2,2,1] and k=2, a valid answer is 1.

Challenge 
Can you partition the array in-place and in O(n)?

Tags 
Two Pointers Sort Array
Related Problems 
Easy Partition Array by Odd and Even 39 %
Medium Interleaving Positive and Negative Numbers 21 %
Easy Partition List 30 %*/