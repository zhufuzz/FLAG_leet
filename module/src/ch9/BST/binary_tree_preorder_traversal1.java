package ch9.BST;

import java.util.*;

/*Binary Tree Preorder Traversal
http://www.cnblogs.com/yuzhangcmu/p/4141530.html
Given a binary tree, return the preorder traversal of its nodes' values.
Have you met this question in a real interview? Yes
ExampleGiven:
    1
   / \
  2   3
 / \
4   5  return [1,2,4,5,3].
For example: Given binary tree {1,#,2,3}, 
 1 
   \ 
     2 
    / 
  3   return [1,2,3]. 
 Note: Recursive solution is trivial, could you do it iteratively?*/
//Version 0: Non-Recursion (Recommend)
public class binary_tree_preorder_traversal1 {
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
