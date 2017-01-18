package ch9.BFS;
import java.util.*;

/*Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
For example:Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[  [15,7],
  [9,20],
  [3]]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
Here's an example:
   1-3-4-5
  / 
 2
The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".*/
public class Ch9_107_Binary_Tree_Level_Order_Traversal_II {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {  return result;  }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int currLevelNodeNum = 1; int nextLevelNodeNum = 0;
        
        while (currLevelNodeNum != 0) {
            ArrayList<Integer> currLevelResult = new ArrayList<Integer>();
            nextLevelNodeNum = 0;
            while (currLevelNodeNum != 0) {
                TreeNode node = queue.poll();
                currLevelNodeNum--;
                currLevelResult.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);  nextLevelNodeNum++;
                }
                if (node.right != null) {
                    queue.offer(node.right); nextLevelNodeNum++;
                }
            }
            result.add(0, currLevelResult);
            currLevelNodeNum = nextLevelNodeNum;
        }
        return result;
    }
}
