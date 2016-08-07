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

 // version 2:  DFS
public class 102_Binary_Tree_Level_Order_Traversal_2DFS {
    /**     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
      
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (root == null) {  return results;  }
        
        int maxLevel = 0;
        while (true) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            dfs(root, level, 0, maxLevel);
            if (level.size() == 0) {
                break;
            }            
            results.add(level);
            maxLevel++;
        }        
        return results;
    }
    
    private void dfs(TreeNode root, ArrayList<Integer> level,
                     int curtLevel, int maxLevel) {
        if (root == null || curtLevel > maxLevel) {
            return;
        }        
        if (curtLevel == maxLevel) {
            level.add(root.val);
            return;
        }        
        dfs(root.left, level, curtLevel + 1, maxLevel);
        dfs(root.right, level, curtLevel + 1, maxLevel);
    }
}