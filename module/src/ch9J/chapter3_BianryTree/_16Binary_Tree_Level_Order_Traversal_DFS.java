package ch9J.chapter3_BianryTree;

import java.util.ArrayList;


//version 2:  DFS
public class _16Binary_Tree_Level_Order_Traversal_DFS {
	/**
	* @param root: The root of binary tree.
	* @return: Level order a list of lists of integer
	*/
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
	   ArrayList<ArrayList<Integer>> results = new ArrayList<>();
	   
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
