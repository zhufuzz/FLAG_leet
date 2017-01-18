package ch9.DFS;

/*Given a binary tree, determine if it is a valid binary search tree (BST).
Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
confused what "{1,#,2,3}" means?*/
public class Ch9_98_Validate_Binary_Search_Tree2 {
	// version 2  Divide and Conquer
	class ResultType {
	    boolean is_bst;
	    int maxValue, minValue;
	    
	    ResultType(boolean is_bst, int maxValue, int minValue) {
	        this.is_bst = is_bst;
	        this.maxValue = maxValue;
	        this.minValue = minValue;
	    }
	}

	public class Solution {
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
}