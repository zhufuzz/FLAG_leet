package ch9J.chapter3_BianryTree;

import java.util.*;

public class _3Postorder_Traversal {
	//Recursive
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    if (root == null) {
	        return result;
	    }
	    result.addAll(postorderTraversal(root.left));
	    result.addAll(postorderTraversal(root.right));
	    result.add(root.val);
	    return result;   
	}
	

	//Iterative
	public ArrayList<Integer> postorderTraversal2(TreeNode root) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode prev = null; // previously traversed node
	    TreeNode curr = root;

	    if (root == null) {
	        return result;
	    }

	    stack.push(root);
	    while (!stack.empty()) {
	        curr = stack.peek();
	        if (prev == null || prev.left == curr || prev.right == curr) { 
	        	// traverse down the tree
	            if (curr.left != null) {
	                stack.push(curr.left);
	            } else if (curr.right != null) {
	                stack.push(curr.right);
	            }
	        } else if (curr.left == prev) { 
	        	// traverse up the tree from the left
	            if (curr.right != null) {
	                stack.push(curr.right);
	            }
	        } else { // traverse up the tree from the right
	            result.add(curr.val);
	            stack.pop();
	        }
	        prev = curr;
	    }

	    return result;
	}
}

/*Given a binary tree, return the postorder traversal of its nodes' values.

Have you met this question in a real interview? Yes
Example
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3
 

return [3,2,1].

Challenge 
Can you do it without recursion?

Tags 
Recursion Binary Tree Binary Tree Traversal
Related Problems 
Easy Binary Tree Preorder Traversal 40 %
*/
