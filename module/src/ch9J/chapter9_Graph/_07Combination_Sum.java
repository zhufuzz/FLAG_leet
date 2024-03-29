package ch9J.chapter9_Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class _07Combination_Sum {
public  ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (candidates == null) {
        return result;
    }

    ArrayList<Integer> path = new ArrayList<Integer>();
    Arrays.sort(candidates);
    helper(candidates, target, path, 0, result);

    return result;
}

 void helper(int[] candidates, int target, ArrayList<Integer> path, int index,
    ArrayList<ArrayList<Integer>> result) {
    if (target == 0) {
        result.add(new ArrayList<Integer>(path));
        return;
    }

    int prev = -1;
    for (int i = index; i < candidates.length; i++) {
        if (candidates[i] > target) {
            break;
        }

        if (prev != -1 && prev == candidates[i]) {
            continue;
        }

        path.add(candidates[i]);
        helper(candidates, target - candidates[i], path, i, result);
        path.remove(path.size() - 1);

        prev = candidates[i];
    }
}
}

/*Given a set of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers 
 * sums to T.
 

The same repeated number may be chosen from C unlimited number 
of times.



For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 

 Notice

All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, � , ak) must be in 
non-descending order. (ie, a1 � a2 � � � ak).
The solution set must not contain duplicate combinations.
Have you met this question in a real interview? Yes
Example
given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 

Tags 
Backtracking Array
Related Problems 
Medium Combination Sum II 26 %*/