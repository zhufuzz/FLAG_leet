package ch9.chapter1;

import java.util.ArrayList;
import java.util.Arrays;

/*Subsets

 Description
 Notes
 Testcase
 Judge
Given a set of distinct integers, return all fromIndexsible subsets.

 Notice

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Example
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
Challenge 
Can you do it in both recursively and iteratively?

Tags 
Recursion Facebook Uber
Related Problems 
Medium Restore IP Addresses 20 %
Medium Subsets II*/
public class Subsets {
	
    public ArrayList<ArrayList<Integer>> subsets(int[] num) {
    		//recursion -> 程序的一种实现方式
    		//函数自己调用自己
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) {
            return result;
        }
        ArrayList<Integer> subset = new ArrayList<Integer>();
        Arrays.sort(num);  //为了选代表，123 比 132顺眼
        //find all fromIndexsible subsets, put them into results
        //把以空集开头的所有集合找到放到results里面。
        subsetsHelper(result, subset, num, 0);

        return result;
    }

    //递归的三要素之一，定义：
    //把以subset开头的所有子集，全部找到，并放到results里面
    private void subsetsHelper(ArrayList<ArrayList<Integer>> result,
    							  ArrayList<Integer> subset, 
    							  int[] num, 
    							  int fromIndex) {
    		//递归三要素之2:极端条件
    		//if xxx {
    		//return
    		//}
    		//fromIndex会越加越大，直到退出循环条件
    		//reference
        result.add(new ArrayList<Integer>(subset));
        //递归三要素之3:如何变为更小的状态
        for (int i = fromIndex; i < num.length; i++) {
        		subset.add(num[i]);
        		//当前选了第i个数，下一次就从i+1开始选
            subsetsHelper(result, subset, num, i + 1);
            //以｛1｝开头的都找到了。下一层循环寻找以2开头的
            subset.remove(subset.size() - 1);
        }
    }
}


// Non Recursion，二进制的方式
class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int n = nums.length;
        Arrays.sort(nums);
        
        // 1 << n is 2^n
        // each subset equals to an binary integer between 0 .. 2^n - 1
        // 0 -> 000 -> []
        // 1 -> 001 -> [1]
        // 2 -> 010 -> [2]
        // ..
        // 7 -> 111 -> [1,2,3]
        for (int i = 0; i < (1 << n); i++) {
            ArrayList<Integer> subset = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                // check whether the jth digit in i's binary representation is 1
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        
        return result;
    }
}
