package ch9.BST;

import java.util.*;

/*Binary Tree Level Order Traversal II
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
Have you met this question in a real interview? Yes
ExampleGiven binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
 return its bottom-up level order traversal as:
[  [15,7],
  [9,20],
  [3]]*/
public class binary_tree_level_order_traversal_ii {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int currLevelNodeNum = 1;
        int nextLevelNodeNum = 0;
        while (currLevelNodeNum != 0) {
            ArrayList<Integer> currLevelResult = new ArrayList<Integer>();
            nextLevelNodeNum = 0;
            while (currLevelNodeNum != 0) {
                TreeNode node = queue.poll();
                currLevelNodeNum--;
                currLevelResult.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                    nextLevelNodeNum++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nextLevelNodeNum++;
                }
            }
            result.add(0, currLevelResult);
            currLevelNodeNum = nextLevelNodeNum;
        }
        return result;
    }
}