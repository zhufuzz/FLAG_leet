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

 // version 1: BFS
public class 102_Binary_Tree_Level_Order_Traversal_1BFS {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList result = new ArrayList();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                level.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(level);
        }

        return result;
    }
}
