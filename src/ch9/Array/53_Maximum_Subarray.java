package leet_Array; /*Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.*/

// Version 1: Greedy
public class 53_Maximum_Subarray {
    public int maxSubArray1(int[] A) {
        if (A == null || A.length == 0){ return 0;}        
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }
        return max;
    }
    
// Version 2: Prefix Sum (DP)
    public int maxSubArray2(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }        
        int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        return max;
    }
    /**   * @param nums: a list of integers * @return: A integer indicate the sum of minimum subarray   */
    public int maxSubArray(ArrayList<Integer> nums) {
        // write your code
        if(nums.size()==0)  return 0;  
        int n = nums.size();
        int []global = new int[n];
        int []local = new int[n];
        global[0] = nums.get(0);
        local[0] = nums.get(0);
        for(int i=1;i<n;i++) {  
            local[i] = Math.max(nums.get(i),local[i-1]+nums.get(i));  
            global[i] = Math.max(local[i],global[i-1]);  
        }  
        return global[n-1];  
    }
}
