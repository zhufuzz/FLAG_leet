package OA1_xiaoyucool;

public class isSubTree{
	static class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		public TreeNode(int val){
			this.val = val;
		}
	}

	public static boolean solution(TreeNode root1,TreeNode root2){
		if(root2 == null){
			return true;
		}
		if(root1 == null){
			return false;
		}
		return isSameTree(root1,root2) || isSameTree(root1.left,root2)||isSameTree(root1.right,root2);
	}

	public static boolean isSameTree(TreeNode root1,TreeNode root2){
		if(root1 == root2){
			return true;
		}
		if(root1 == null || root2 == null){
			return false;
		}
		if(root1.val != root2.val){
			return false;
		}
		return isSameTree(root1.left,root2.left) && isSameTree(root1.right,root2.right);
	}
}