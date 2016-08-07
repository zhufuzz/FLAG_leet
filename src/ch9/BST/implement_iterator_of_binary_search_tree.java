package ch9.BST;import java.util.*;

/*http://www.cnblogs.com/yuzhangcmu/p/4197346.html
Design an iterator over a binary search tree with the following properties:
1.	Elements are visited in ascending order (i.e. an inorder traversal)
2.	next() and hasNext() queries run in O(1) time in average.
For example:
For the following binary search tree, inorder traversal by using iterator is [1, 6, 10, 11, 12]
      10
    /     \
 1          11
    \           \
       6           12 */
public class implement_iterator_of_binary_search_tree {
    private Stack<TreeNode> stack = new Stack<>();
    private TreeNode curt;
    
    // @param root: The root of binary tree.
    public implement_iterator_of_binary_search_tree(TreeNode root) {
        curt = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        return (curt != null || !stack.isEmpty());
    }
    
    //@return: return next node
    public TreeNode next() {
        while (curt != null) {
            stack.push(curt);
            curt = curt.left;
        }
        
        curt = stack.pop();
        TreeNode node = curt;
        curt = curt.right;
        
        return node;
    }
}