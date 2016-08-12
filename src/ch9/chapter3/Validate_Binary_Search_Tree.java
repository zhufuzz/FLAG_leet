package ch9.chapter3;
/*
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
A single node tree is a BST
Have you met this question in a real interview? Yes
Example
An example:

  2
 / \
1   4
   / \
  3   5
The above binary tree is serialized as {2,1,4,#,#,3,5} (in level order).

Tags 
Divide and Conquer Recursion Binary Search Tree Binary Tree
Related Problems 
Medium Inorder Successor in Binary Search Tree 30 %
Easy Balanced Binary Tree 38 %
 * */
public class Validate_Binary_Search_Tree {

}

//version 1 Traverse
class Solution {
 private int lastVal = Integer.MIN_VALUE;
 private boolean firstNode = true;
 public boolean isValidBST(TreeNode root) {
     if (root == null) {
         return true;
     }
     if (!isValidBST(root.left)) {
         return false;
     }
     if (!firstNode && lastVal >= root.val) {
         return false;
     }
     firstNode = false;
     lastVal = root.val;
     if (!isValidBST(root.right)) {
         return false;
     }
     return true;
 }
}


//version 2  Divide and Conquer
class ResultType {
 boolean is_bst;
 int maxValue, minValue;
 
 ResultType(boolean is_bst, int maxValue, int minValue) {
     this.is_bst = is_bst;
     this.maxValue = maxValue;
     this.minValue = minValue;
 }
}

class Solution2 {
 /**
  * @param root: The root of binary tree.
  * @return: True if the binary tree is BST, or false
  */
 public boolean isValidBST(TreeNode root) {
     ResultType r = validateHelper(root);
     return r.is_bst;
 }
 
 private ResultType validateHelper(TreeNode root) {
     if (root == null) {
         return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
     }
     
     ResultType left = validateHelper(root.left);
     ResultType right = validateHelper(root.right);
     
     if (!left.is_bst || !right.is_bst) {
         // if is_bst is false then minValue and maxValue are useless
         return new ResultType(false, 0, 0);
     }
     
     if (root.left != null && left.maxValue >= root.val || 
           root.right != null && right.minValue <= root.val) {
         return new ResultType(false, 0, 0);
     }
     
     return new ResultType(true,
                           Math.max(root.val, right.maxValue),
                           Math.min(root.val, left.minValue));
 }
}
