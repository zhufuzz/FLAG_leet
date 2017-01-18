package ch9.BST;

/* Maximum Depth of Binary Tree
http://www.cnblogs.com/yuzhangcmu/p/4172855.html
Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
Have you met this question in a real interview? Yes
Example Given a binary tree as follow:
  1
 / \ 
2   3
   / \
  4   5
The maximum depth is 3.
*/
// version 2: Traverse
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
public class maximum_depth_of_binary_tree2 {
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
