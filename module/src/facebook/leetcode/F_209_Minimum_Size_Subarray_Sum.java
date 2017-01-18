package facebook.leetcode;
//Array, Two Pointers, Binary Search
/*Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.*/

public class F_209_Minimum_Size_Subarray_Sum {
    public int minSubArrayLen1(int s, int[] nums) {
        int sum = 0, left = 0, right = 0, minLength = nums.length+1;
        while (true) {
            if (sum >= s) {  // should contract
                minLength = Math.min(minLength, right-left);
                sum -= nums[left++];
            } else {  // should expand
                if (right == nums.length) { break; }
                sum += nums[right++];
            }
        }
        return minLength==nums.length+1 ? 0 : minLength;
    }
    /*basic idea is that, i goes right to add new nums[i] to sum, if sum >= s, we update the ret, and let begin++, which means we remove one element from the front to see if it still >= s.*/

    public int minSubArrayLen2(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int sum = 0;
        int ret = Integer.MAX_VALUE;
        int begin = 0;

        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
            while(sum >= s && begin <= i){
                ret = Math.min(ret, i - begin + 1);
                sum = sum - nums[begin];
                begin++;
            }
        }

        return ret == Integer.MAX_VALUE ? 0 : ret;
    }
}