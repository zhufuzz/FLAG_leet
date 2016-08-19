package ch9.BST;

import ch9J.chapter6_LinkedList.TreeNode;

//Template 1: Traverse
public class Solution {
    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // do something with root
        traverse(root.left);
        // do something with root
        traverse(root.right);
        // do something with root
    }
}


//Tempate 2: Divide & Conquer 
class Solution2 {
	
	
   /* public node traversal(TreeNode root) {
        // null or leaf
        if (root == null) {
            // do something and return;
        }
        
        // Divide
         TreeNode left = traversal(root.left);
        TreeNode right = traversal(root.right);
        
        // Conquer
       // TreeNode result = Merge from left and right.
        /*return result;
        
    }*/
}