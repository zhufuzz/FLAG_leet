package ch9.chapter3;
/*
 * Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Have you met this question in a real interview? Yes
Example
Given a binary tree as follow:

  1
 / \ 
2   3
   / \
  4   5
The maximum depth is 3.

Tags 
Divide and Conquer Recursion Binary Tree Uber
Related Problems 
Easy Minimum Depth of Binary Tree 31 %
 * */
public class Maximum_Depth_of_Binary_Tree {
	  public int maxDepth(TreeNode root) {
	        if (root == null) {
	            return 0;
	        }

	        int left = maxDepth(root.left);
	        int right = maxDepth(root.right);
	        return Math.max(left, right) + 1;
	    }
}

//version 2: Traverse

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
  * @param root: The root of binary tree.
  * @return: An integer.
  */
 private int depth;
 
 public int maxDepth(TreeNode root) {
     depth = 0;
     helper(root, 1);
     
     return depth;
 }
 
 private void helper(TreeNode node, int curtDepth) {
     if (node == null) {
         return;
     }
     
     if (curtDepth > depth) {
         depth = curtDepth;
     }
     
     helper(node.left, curtDepth + 1);
     helper(node.right, curtDepth + 1);
 }
}