package mianjing3;

public class Subtree {
  class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int val){
      this.val = val;
    }
  }
  public boolean isSubTree(TreeNode T1, TreeNode T2) {
    if (T2 == null) return true;
    if (T1 == null) return false;
    return (isSameTree(T1,T2) || isSubTree(T1.left, T2) || isSubTree(T1.right, T2));
  }
  public boolean isSameTree(TreeNode T1, TreeNode T2) {
    if (T1 == null && T2 == null) return true;
    if (T1 == null || T2 == null) return false;
    if (T1.val != T2.val) return false;
    return (isSameTree(T1.left, T2.left) && isSameTree(T1.right, T2.right));
  }
}
