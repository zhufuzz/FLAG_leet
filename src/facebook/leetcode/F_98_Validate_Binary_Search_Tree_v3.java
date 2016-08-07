package facebook.leetcode;

/*Given a binary tree, determine if it is a valid binary search tree (BST).
Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
confused what "{1,#,2,3}" means?*/

//We take advantages on the constraint of the range for the value in a BST.

//https://leetcode.com/discuss/88786/very-short-and-concise-java-solution-easy-to-understand

public class F_98_Validate_Binary_Search_Tree_v3 {
  
  public boolean isValidBST(TreeNode root) {
    return validateRange(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean validateRange(TreeNode root, long min, long max) {
    
      if (root == null) return true;
      
      if (!(root.val > min && root.val < max)) return false;
      
      return validateRange(root.left,   min,        root.val) 
          && validateRange(root.right,  root.val,   max);
  }
  
  
  //////
  
  
  public boolean isValidBST2(TreeNode root) {
    return isValidBST2(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }
  private boolean isValidBST2(TreeNode root, long min, long max) {
      return root==null ||
          (root.val<max &&
           root.val>min &&
           isValidBST2(root.left, min, root.val) && 
           isValidBST2(root.right, root.val, max));
  }
}