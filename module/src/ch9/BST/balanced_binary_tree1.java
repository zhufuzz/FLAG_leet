package ch9.BST;

/*
Balanced Binary Tree
Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
Have you met this question in a real interview? Yes
Example
Given binary tree A={3,9,20,#,#,15,7}, B={3,#,20,15,7}
A)  3            B)    3 
   / \                  \
  9  20                 20
    /  \                / \
   15   7              15  7
The binary tree A is a height-balanced binary tree, but B is not.
*/
 class TreeNode {
     public static final TreeNode parent = null;
	public int val;
     public TreeNode left, right;
     public TreeNode(int val) {
        this.val = val;
         this.left = this.right = null;
     }
 }
class ResultType1 {
    public boolean isBalanced;
    public int maxDepth;
    public ResultType1(boolean isBalanced, int maxDepth) {
        this.isBalanced = isBalanced;
        this.maxDepth = maxDepth;
    }
}
public class balanced_binary_tree1 {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }    
    private ResultType1 helper(TreeNode root) {
        if (root == null) {
            return new ResultType1(true, 0);
        }        
        ResultType1 left = helper(root.left);
        ResultType1 right = helper(root.right);        
        // subtree not balance
        if (!left.isBalanced || !right.isBalanced) {
            return new ResultType1(false, -1);
        }        
        // root not balance
        if (Math.abs(left.maxDepth - right.maxDepth) > 1) {
            return new ResultType1(false, -1);
        }        
        return new ResultType1(true, Math.max(left.maxDepth, right.maxDepth) + 1);
    }
}
