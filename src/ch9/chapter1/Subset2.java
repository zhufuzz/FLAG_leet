package ch9.chapter1;

import java.util.ArrayList;
import java.util.Collections;

/*Given a subset of numbers that may has duplicate numbers, return all fromIndexsible subsets

 Notice

Each element in a subset must be in non-descending order.
The ordering between two subsets is free.
The solution set must not contain duplicate subsets.
Example
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
Challenge 
Can you do it in both recursively and iteratively?

Tags 
Recursion
Related Problems 
Medium Subsets*/
//input有重复的数，result避免有重复结果。
//实际上是问去重的问题，选代表
//｛1，2'，2''，2'''｝取12'最顺眼，按顺序取，不能跳着取。
public class Subset2 {
    /**
     * @param S: A set of numbers.
     * @return: A subset of subsets. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if ( nums == null || nums.size() == 0){
            return result;
        }
        
        Collections.sort(nums);
        ArrayList<Integer> subset = new ArrayList<Integer>();
        helper(result,subset,nums,0);
        return result;
    }
    
	public void helper(ArrayList<ArrayList<Integer>> result, 
    					   ArrayList<Integer> subset,
    					   ArrayList<Integer> nums, 
    					   int fromIndex) {    	
        result.add( new ArrayList(subset));
        
        for ( int i = fromIndex; i < nums.size();i++){
         	//跳过重复元素
            if ( i != fromIndex && nums.get(i) == nums.get(i-1)){
                continue;
            }
  
            subset.add(nums.get(i));
            helper(result,subset,nums,i+1);
            subset.remove(subset.size()-1);
        }
    }
}
