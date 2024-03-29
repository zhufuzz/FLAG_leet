package ch9.BFS;
import java.util.*;

/*Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
For example:Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[  [3],
  [20,9],
  [15,7]]*/

public class Ch9_103_Binary_Tree_Zigzag_Level_Order_Traversal {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
      
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {           return result;        }
        Stack<TreeNode> currLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        Stack<TreeNode> tmp;
        currLevel.push(root);
        boolean normalOrder = true;

        while (!currLevel.isEmpty()) {
            ArrayList<Integer> currLevelResult = new ArrayList<Integer>();

            while (!currLevel.isEmpty()) {
                TreeNode node = currLevel.pop();
                currLevelResult.add(node.val);
                if (normalOrder) {
                    if (node.left != null) {nextLevel.push(node.left);}
                    if (node.right != null) {nextLevel.push(node.right);}
                } else {
                    if (node.right != null) {nextLevel.push(node.right);}
                    if (node.left != null) {nextLevel.push(node.left);}
                }
            }
            
            result.add(currLevelResult);
            tmp = currLevel;
            currLevel = nextLevel;
            nextLevel = tmp;
            normalOrder = !normalOrder;
        }
        return result;
    }
}