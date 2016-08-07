package leet_BFS;/*Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
For example:Given binary tree {3,9,20,#,#,15,7},
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
// version 4: BFS, queue with dummy node
public class 102_Binary_Tree_Level_Order_Traversal_4BFSQDummy {
    /** * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
      
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }        
        
        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        Q.offer(root);
        Q.offer(null); // dummy node        
        ArrayList<Integer> level = new ArrayList<Integer>();
        
        while (!Q.isEmpty()) {
            TreeNode node = Q.poll();
            if (node == null) {
                if (level.size() == 0) { break; }
                result.add(level);
                level = new ArrayList<Integer>();
                Q.offer(null); // add a new dummy node
                continue;
            }            
            level.add(node.val);
            if (node.left != null) {
                Q.offer(node.left);
            }
            if (node.right != null) {
                Q.offer(node.right);
            }
        }        
        return result;
    }
}