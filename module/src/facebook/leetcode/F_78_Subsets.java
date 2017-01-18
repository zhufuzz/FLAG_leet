package facebook.leetcode;
//Array Backtracking Bit Manipulation
import java.util.*;

public class F_78_Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(num);  
        subsetsHelper(result, list, num, 0);

        return result;
    }
    private void subsetsHelper(ArrayList<ArrayList<Integer>> result,
        ArrayList<Integer> list, int[] num, int pos) {

        result.add(new ArrayList<Integer>(list));

        for (int i = pos; i < num.length; i++) {

            list.add(num[i]);
            subsetsHelper(result, list, num, i + 1);
            list.remove(list.size() - 1);
        }
    }    
    ///////////////////////////////////////////////////Non-Recursive
    public ArrayList<ArrayList<Integer>> subsets2(int[] nums) {
      ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
      int n = nums.length;
      Arrays.sort(nums);      
      // 1 << n is 2^n
      // each subset equals to an binary integer between 0 .. 2^n - 1
      // 0 -> 000 -> [] // 1 -> 001 -> [1] // 2 -> 010 -> [2] // .. // 7 -> 111 -> [1,2,3]
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