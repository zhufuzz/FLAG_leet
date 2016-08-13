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

 class Preorder_Traversal2 {
  public ArrayList<Integer> preorderTraversal(TreeNode root) {
      ArrayList<Integer> result = new ArrayList<Integer>();
      traverse(root, result);
      return result;
  }
  // 1递归定义：把root为跟的preorder加入result里面
  private void traverse(TreeNode root, ArrayList<Integer> result) {
	// 3.递归的出口：极端小的问题
	  // 以root为null还是leaf作为出口？
      if (root == null) {
          return;
      }
   
   // 2.如何拆分为更小的情况（如何扒皮）。一边走一边构造。
      result.add(root.val);
      traverse(root.left, result);
      traverse(root.right, result);
  }
}

//Version 2: Divide & Conquer
//递归的定义：找到root为根的preorder并return
 class Preorder_Traversal3 {
  public ArrayList<Integer> preorderTraversal(TreeNode root) {
      ArrayList<Integer> result = new ArrayList<Integer>();
   // 递归的出口
      // null or leaf
      if (root == null) {
          return result;
      }
      // 递归的拆解：left，right
   // 先divide，再想每个具体做什么
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

