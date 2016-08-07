package ch9.DFS;/*Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest 
path from the root node down to the farthest leaf node.*/
public class Ch9_104_Maximum_Depth_of_Binary_Tree1 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
// version 2: Traverse
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val; public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val; this.left = this.right = null;
 *     }
 * }
 */
class Ch9_104_Maximum_Depth_of_Binary_Tree2 {
    /** @param root: The root of binary tree.
     * @return: An integer.  */
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