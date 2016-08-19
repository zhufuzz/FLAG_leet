package ch9.DFS;/*Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.*/
// Version 1: with ResultType
// Definition of TreeNode:
class ResultType {
    public boolean isBalanced;
    public int maxDepth;
    public ResultType(boolean isBalanced, int maxDepth) {
        this.isBalanced = isBalanced;
        this.maxDepth = maxDepth;
    }
}
public class Ch9_110_Balanced_Binary_Tree1 {
	class TreeNode {
		public int val;   public TreeNode left, right;
		public TreeNode(int val) {
			this.val = val;  this.left = this.right = null;
		}
	} 
    /*** @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false. */
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, 0);
        }        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);        
        // subtree not balance
        if (!left.isBalanced || !right.isBalanced) {
            return new ResultType(false, -1);
        }        
        // root not balance
        if (Math.abs(left.maxDepth - right.maxDepth) > 1) {
            return new ResultType(false, -1);
        }        
        return new ResultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
    }
}
