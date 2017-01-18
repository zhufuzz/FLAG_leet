package ch9J.chapter3_BianryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public //version 4: BFS, queue with dummy node
class _16Binary_Tree_Level_Order_Traversal_Q_DummyNode {
	 /**
	  * @param root: The root of binary tree.
	  * @return: Level order a list of lists of integer
	  */
	 public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
	     ArrayList<ArrayList<Integer>> result = new ArrayList<>();
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
