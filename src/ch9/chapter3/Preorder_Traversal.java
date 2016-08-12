package ch9.chapter3;


import java.util.*;


/*
 * Given a binary tree, return the preorder traversal of its nodes' values.

Have you met this question in a real interview? Yes
Example
Given:

    1
   / \
  2   3
 / \
4   5
return [1,2,4,5,3].

Challenge 
Can you do it without recursion?

Tags 
Recursion Binary Tree Binary Tree Traversal Non Recursion
Related Problems 
Easy Binary Tree Postorder Traversal 39 %
Easy Binary Tree Inorder Traversal 39 %
 * */

//Version 0: Non-Recursion (Recommend)
public class Preorder_Traversal {
	public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> preorder = new ArrayList<Integer>();
        
        if (root == null) {
            return preorder;
        }
        
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            preorder.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        
        return preorder;
    }
}
//Version 1: Traverse
 class Solution2 {
  public ArrayList<Integer> preorderTraversal(TreeNode root) {
      ArrayList<Integer> result = new ArrayList<Integer>();
      traverse(root, result);
      return result;
  }
  // 把root为跟的preorder加入result里面
  private void traverse(TreeNode root, ArrayList<Integer> result) {
      if (root == null) {
          return;
      }

      result.add(root.val);
      traverse(root.left, result);
      traverse(root.right, result);
  }
}

//Version 2: Divide & Conquer
 class Solution3 {
  public ArrayList<Integer> preorderTraversal(TreeNode root) {
      ArrayList<Integer> result = new ArrayList<Integer>();
      // null or leaf
      if (root == null) {
          return result;
      }

      // Divide
      ArrayList<Integer> left = preorderTraversal(root.left);
      ArrayList<Integer> right = preorderTraversal(root.right);

      // Conquer
      result.add(root.val);
      result.addAll(left);
      result.addAll(right);
      return result;
  }
}

