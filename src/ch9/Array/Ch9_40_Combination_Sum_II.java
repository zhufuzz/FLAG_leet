package ch9.Array;
import java.util.*; 

/*Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
Each number in C may only be used once in the combination.Note:All numbers (including target) will be positive integers.Elements in a combination (a1, a2, �� , ak) must be in non-descending order. (ie, a1 �� a2 �� �� �� ak).
The solution set must not contain duplicate combinations.For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] */

public class Ch9_40_Combination_Sum_II {
    private ArrayList<ArrayList<Integer>> results;
    
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length < 1) {
            return results;
        }
        ArrayList<Integer> path = new ArrayList<Integer>();
        java.util.Arrays.sort(candidates);
        results = new ArrayList<ArrayList<Integer>> ();
        combinationSumHelper(path, candidates, target, 0);
        return results;
    }

    private void combinationSumHelper(ArrayList<Integer> path, int[] candidates, int sum, int pos) {
        if (sum == 0) {
            results.add(new ArrayList<Integer>(path));
        }        
        if (pos >= candidates.length || sum < 0) {
            return;
        }
        int prev = -1;
        for (int i = pos; i < candidates.length; i++) {
            if (candidates[i] != prev) {
                path.add(candidates[i]);
                combinationSumHelper(path, candidates, sum - candidates[i], i + 1);
                prev = candidates[i];
                path.remove(path.size()-1);
            }
        }
    }

}
