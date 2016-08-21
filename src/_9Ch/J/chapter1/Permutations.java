package _9Ch.J.chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<>();
        helper(result, subset, nums);
        return result;
    }
    
    void helper(List<List<Integer>> result, List<Integer> subset, int[] nums){
        if (subset.size() == nums.length){
            result.add(new ArrayList(subset));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(subset.contains(nums[i])){
                continue;   
            }
            subset.add(nums[i]);
            helper(result, subset, nums);
            subset.remove(subset.size() - 1);
        }
    }
}