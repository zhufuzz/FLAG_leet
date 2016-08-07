package facebook.leetcode;
/*Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:
Return true if there exists i, j, k 
such that arr[i] < arr[j] < arr[k] given 0 鈮� i < j < k 鈮� n-1 else return false.
Your algorithm should run in O(n) time complexity and O(1) space complexity.

Examples:
Given [1, 2, 3, 4, 5],
return true.

Given [5, 4, 3, 2, 1],
return false.*/

//https://www.hrwhisper.me/leetcode-increasing-triplet-subsequence/

/*题意：给定一个长度为n的乱序的数组arr，让你求是否有i,j,k三个数，使得 arr[i] < arr[j] < arr[k] ( 0 ≤ i < j < k ≤ n-1)

思路：设 x1为到目前为止的最小值 ，  x2为到目前为止至少有一个数比x2小的最小的数。

初始时设置x1 = x2 = INT_MAX ，然后遍历数组,不断的更新x1和x2 具体如下

num <= x1,  此时将x1设置为num
若 x1 < num <= x2，则 把x2 设置为num
x2 < num  说明有解，返回true即可
简单的说，上述的过程就是不断的缩小x1和x2，看看是否有第三个数 比x2大。

如果出现第三个数 num > x2，则之前必定还有个数x 小于x2，就是说满足 x < x2 < num，就是说有答案啦。*/


public class F_334_Increasing_Triplet_Subsequence {
    public boolean increasingTriplet(int[] nums) {
       int x1 = 0x7fffffff, x2 = 0x7fffffff;
        for(int num : nums){
            if(num <= x1) x1 = num;
            else if(num <=x2) x2 = num;
            else return true;
        }
        return false;
    }
}