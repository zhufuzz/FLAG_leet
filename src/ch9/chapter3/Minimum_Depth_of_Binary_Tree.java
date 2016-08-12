package ch9.chapter3;
/*
 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Have you met this question in a real interview? Yes
Example
Given a binary tree as follow:

  1
 / \ 
2   3
   / \
  4   5
The minimum depth is 2.

Tags 
Binary Tree Depth First Search
Related Problems 
Easy Maximum Depth of Binary Tree 55 %
 * */
public class Minimum_Depth_of_Binary_Tree {
  public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMin(root);
    }

    public int getMin(TreeNode root){
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return Math.min(getMin(root.left), getMin(root.right)) + 1;
    }
}