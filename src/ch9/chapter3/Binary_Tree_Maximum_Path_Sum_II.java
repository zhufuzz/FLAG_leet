package ch9.chapter3;
/*
 * Given a binary tree, find the maximum path sum from root.

The path may end at any node in the tree and contain at least one node in it.

Have you met this question in a real interview? Yes
Example
Given the below binary tree:

  1
 / \
2   3
return 4. (1->3)

Tags 
Binary Tree
Related Problems 
Medium Binary Tree Maximum Path Sum 24 %
 * */
public class Binary_Tree_Maximum_Path_Sum_II {

}

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
 class Solution {
    /**
     * @param root the root of binary tree.
     * @return an integer
     */
    public int maxPathSum2(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        return root.val + Math.max(0, Math.max(left, right));
    }
}