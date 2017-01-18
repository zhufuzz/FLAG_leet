package ch9J.chapter3_BianryTree;

//version 2: Traverse
class _04Maximum_Depth_of_Binary_Tree_Traverse {
	/**
	* @param root: The root of binary tree.
	* @return: An integer.
	*/
	private int depth;//用了一个全局变量，不鼓励这么做
	
	public int maxDepth(TreeNode root) {
	   depth = 0;
	   helper(root, 1);
	   return depth;
	}
	
	private void helper(TreeNode node, int curtDepth) {
	   if (node == null) {
	       return;
	   }
	   if (curtDepth > depth) {
	       depth = curtDepth;
	   }
	   helper(node.left, curtDepth + 1);
	   helper(node.right, curtDepth + 1);
	}
}
