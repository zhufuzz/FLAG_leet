package ch9J.chapter3_BianryTree;
/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than 
the node's key.The right subtree of a node contains only nodes with
 keys greater than the node's key.
 
Both the left and right subtrees must also be binary search trees.
A single node tree is a BST

Example An example:

  2
 / \
1   4
   / \
  3   5
The above binary tree is serialized as {2,1,4,#,#,3,5} (in level order).

Tags: Divide and Conquer Recursion Binary Search Tree Binary Tree
Related Problems:Medium Inorder Successor in Binary Search Tree 30 %
				 Easy Balanced Binary Tree 38 %
 * */

//version 1 Traverse， 缺点：经常要用到全局变量
public class _10Validate_Binary_Search_Tree_Traverse {
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
