package ch9.BST;import java.util.*;

/*Binary Tree Level Order Traversal
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
Have you met this question in a real interview? Yes
Example Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
 return its level order traversal as:
[  [3],
  [9,20],
  [15,7]]*/
// version 3: BFS. two queues
public class binary_tree_level_order_traversal3 {
    /**    * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer    */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }        
        ArrayList<TreeNode> Q1 = new ArrayList<TreeNode>();
        ArrayList<TreeNode> Q2 = new ArrayList<TreeNode>();
        Q1.add(root);
        while (Q1.size() != 0) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            Q2.clear();
            for (int i = 0; i < Q1.size(); i++) {
                TreeNode node = Q1.get(i);
                level.add(node.val);
                if (node.left != null) {
                    Q2.add(node.left);
                }
                if (node.right != null) {
                    Q2.add(node.right);
                }
            }            
            // swap q1 and q2
            ArrayList<TreeNode> temp = Q1;
            Q1 = Q2;
            Q2 = temp;            
            // add to result
            result.add(level);
        }        
        return result;
    }
}
