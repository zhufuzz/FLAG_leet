package ch9.BST;import java.util.*;

/*Binary Tree Level Order Traversal
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
Have you met this question in a real interview? Yes ExampleGiven binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[  [3],
  [9,20],
  [15,7]]*/  
// version 2:  DFS
public class binary_tree_level_order_traversal2 {
    /*** @param root: The root of binary tree.
     * @return: Level order a list of lists of integer  */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return results;
        }        
        int maxLevel = 0;
        while (true) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            dfs(root, level, 0, maxLevel);
            if (level.size() == 0) {
                break;
            }            
            results.add(level);
            maxLevel++;
        }        
        return results;
    }    
    private void dfs(TreeNode root,
                     ArrayList<Integer> level,
                     int curtLevel,
                     int maxLevel) {
        if (root == null || curtLevel > maxLevel) {
            return;
        }        
        if (curtLevel == maxLevel) {
            level.add(root.val);
            return;
        }        
        dfs(root.left, level, curtLevel + 1, maxLevel);
        dfs(root.right, level, curtLevel + 1, maxLevel);
    }
}
