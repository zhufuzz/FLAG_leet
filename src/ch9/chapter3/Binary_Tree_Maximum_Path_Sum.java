package ch9.chapter3;
/*Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

Have you met this question in a real interview? Yes
Example
Given the below binary tree:

  1
 / \
2   3
return 6.

Tags 
Divide and Conquer Dynamic Programming Recursion
Related Problems 
Medium Binary Tree Maximum Path Sum II 42 %
Easy Minimum Path Sum 34 %*/
public class Binary_Tree_Maximum_Path_Sum {

}

class Binary_Tree_Maximum_Path_Sum1 {
    private class ResultType {
        // singlePath: 从root往下走到任意点的最大路径，这条路径可以不包含任何点
        // maxPath: 从树中任意到任意点的最大路径，这条路径至少包含一个点
        int singlePath, maxPath; 
        ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        }
        // Divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        // Conquer
        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        singlePath = Math.max(singlePath, 0);

        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);

        return new ResultType(singlePath, maxPath);
    }

    public int maxPathSum(TreeNode root) {
        ResultType result = helper(root);
        return result.maxPath;
    }
}


// Version 2:
// SinglePath也定义为，至少包含一个点。
class Binary_Tree_Maximum_Path_Sum2 {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    private class ResultType {
        int singlePath, maxPath;
        ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
        // Divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        // Conquer
        int singlePath =
            Math.max(0, Math.max(left.singlePath, right.singlePath)) + root.val;

        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath,
                           Math.max(left.singlePath, 0) + 
                           Math.max(right.singlePath, 0) + root.val);

        return new ResultType(singlePath, maxPath);
    }

    public int maxPathSum(TreeNode root) {
        ResultType result = helper(root);
        return result.maxPath;
    }

}


class ResultType3{
	int root2Any, any2Any;
	ResultType3(int root2Any, int any2Any){
		this.root2Any = root2Any;
		this.any2Any = any2Any;
	}
}

//Ch9 2016summer code
class Binary_Tree_Maximum_Path_Sum3{
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
		int any2Any = Math.max(left.any2Any, right.any2Any);
		any2Any = Math.max(any2Any, 
				Math.max(0, left.root2Any)
				+ Math.max(0, right.root2Any)
				+ root.val);
		return new ResultType3(root2Any, any2Any);
	}
	public int maxPathSu(TreeNode root){
		ResultType3 result = helper(root);
		return result.any2Any;
	}
}