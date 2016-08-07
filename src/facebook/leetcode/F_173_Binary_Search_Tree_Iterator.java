package facebook.leetcode;
//Tree, Stack, Design
import java.util.Stack;
/*Implement an iterator over a binary search tree (BST). 
 * Your iterator will be initialized with the root node of a BST.
Calling next() will return the next smallest number in the BST.
Note: next() and hasNext() should run in average O(1) time and uses O(h) memory,
 where h is the height of the tree.*/

public class BSTIterator {
  Stack<TreeNode> stack=new Stack<>();
  public BSTIterator(TreeNode root) {
      inorderTravel(root);
  }
  /** @return whether we have a next smallest number */
  public boolean hasNext() {
      return !stack.isEmpty();
  }
  /** @return the next smallest number */
  public int next() {
      return stack.pop().val;   
  }
  public void inorderTravel(TreeNode root){
      if(root==null) return;
      inorderTravel(root.right);
      stack.push(root);
      inorderTravel(root.left);
  }  
  
  //////////////  
  
  Stack<TreeNode> stack2=new Stack<>();
  public BSTIterator2(TreeNode root) {
      while(root!=null){
          stack2.push(root);
          root=root.left;
      }
  }
  /** @return whether we have a next smallest number */
  public boolean hasNext2() {
      return !stack2.isEmpty();
  }
  /** @return the next smallest number */
  public int next2() {
      TreeNode result=stack2.pop();
      TreeNode temp=result.right;
      while(temp!=null){
          stack2.push(temp);
          temp=temp.left;
      }
      return result.val;
  }
}