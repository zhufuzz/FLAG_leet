package ch9.BST;

/*
Binary Tree Maximum Path Sum
http://www.cnblogs.com/yuzhangcmu/p/4172855.html
Given a binary tree, find the maximum path sum.
The path may start and end at any node in the tree.
Have you met this question in a real interview? Yes
ExampleGiven the below binary tree:
  1
 / \
2   3
return 6.*/
public class binary_tree_maximum_path_sum {
    private class ResultType {
        // singlePath: 
        // maxPath: 
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