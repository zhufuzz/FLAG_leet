package ch9J.chapter3_BianryTree;

//Ch9 2016summer code
public class _9Binary_Tree_Maximum_Path_Sum_2016{
private class ResultType3{
	int root2Any, any2Any;
	ResultType3(int root2Any, int any2Any){
		this.root2Any = root2Any;
		this.any2Any = any2Any;
	}
}

public int maxPathSum(TreeNode root){
	ResultType3 result = helper(root);
	return result.any2Any;
}

private ResultType3 helper(TreeNode root){
	//illegal
	if (root == null){
		return new ResultType3 (Integer.MIN_VALUE, Integer.MIN_VALUE);
	}
	
	//Divide
	ResultType3 left = helper(root.left);
	ResultType3 right = helper(root.right);
	
	//conquer
	int root2Any = Math.max(0, Math.max(left.root2Any, right.root2Any))
				  		   + root.val;
	//3 any2any candidates
	int any2Any = Math.max(left.any2Any, right.any2Any);
	
	any2Any = Math.max(any2Any, 
						Math.max(0, left.root2Any)
						+ Math.max(0, right.root2Any)
						+ root.val);
	
	return new ResultType3(root2Any, any2Any);
}
}