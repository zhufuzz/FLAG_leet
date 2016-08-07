package ch9.BFS;
import java.util.*;
/*For example:Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7    return its level order traversal as: [  [3], [9,20], [15,7]]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
OJ's Binary Tree Serialization:The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
Here's an example:
   1 - 3 - 4 - 5
  / 
 2   The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".*/
// version 3: BFS. two queues
public class Ch9_102BinaryTreeLevelOrderTraversal3BFS2Q {
    /** * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer  */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
      
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {  return result;  }        
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