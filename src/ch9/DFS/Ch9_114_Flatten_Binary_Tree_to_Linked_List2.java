package ch9.DFS;/*Given a binary tree, flatten it to a linked list in-place.For example,Given
         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6*/
public class Ch9_114_Flatten_Binary_Tree_to_Linked_List2 {
    /**   * @param root: a TreeNode, the root of the binary tree
     * @return: nothing     */
    public void flatten(TreeNode root) {
        flattenHelper(root);
    }    
    private TreeNode flattenHelper(TreeNode root) {
        if (root == null) {
            return null;
        }        
        if (root.left == null && root.right == null) {
            return root;
        }        
        if (root.left == null) {
            return flattenHelper(root.right);
        }        
        if (root.right == null) {
            root.right = root.left;
            root.left = null; // important!
            return flattenHelper(root.right);
        }        
        // Divide
        TreeNode leftLastNode = flattenHelper(root.left);
        TreeNode rightLastNode = flattenHelper(root.right);        
        // Conquer
        leftLastNode.right = root.right;
        root.right = root.left;
        root.left = null; // important!
        return rightLastNode;
    }
}