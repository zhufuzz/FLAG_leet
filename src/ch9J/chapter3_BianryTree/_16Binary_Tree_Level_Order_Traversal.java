package ch9J.chapter3_BianryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

Have you met this question in a real interview? Yes
Example
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
 

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
Challenge 
Challenge 1: Using only 1 queue to implement it.

Challenge 2: Use DFS algorithm to do it.

Tags 
Queue Binary Tree Breadth First Search Binary Tree Traversal LinkedIn Uber Facebook*/
public class _16Binary_Tree_Level_Order_Traversal {

}

//version 1: BFS
class Solution1 {
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


//version 2:  DFS
class Solution2 {
 /**
  * @param root: The root of binary tree.
  * @return: Level order a list of lists of integer
  */
 public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
     ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
     
     if (root == null) {
         return results;
     }
     
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
 
 private void dfs(TreeNode root,
                  ArrayList<Integer> level,
                  int curtLevel,
                  int maxLevel) {
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


//version 3: BFS. two queues
 class Solution3 {
 /**
  * @param root: The root of binary tree.
  * @return: Level order a list of lists of integer
  */
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

//version 4: BFS, queue with dummy node
class Solution4 {
 /**
  * @param root: The root of binary tree.
  * @return: Level order a list of lists of integer
  */
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
             if (level.size() == 0) {
                 break;
             }
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
