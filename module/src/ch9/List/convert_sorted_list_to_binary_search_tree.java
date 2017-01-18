package ch9.List;
/*Convert Sorted List to Balanced BST
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
Have you met this question in a real interview? Yes
Example
               2
1->2->3  =>   / \
             1   3       
*/
class TreeNode {
      int val;TreeNode left;      TreeNode right;
      TreeNode(int val) {this.val = val; left = null; right = null;}
}
public class convert_sorted_list_to_binary_search_tree {
    private ListNode current;
    private int getListLength(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
    public TreeNode sortedListToBST(ListNode head) {
        int size;
        current = head;
        size = getListLength(head);
        return sortedListToBSTHelper(size);
    }
    public TreeNode sortedListToBSTHelper(int size) {
        if (size <= 0) {
            return null;
        }
        TreeNode left = sortedListToBSTHelper(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBSTHelper(size - 1 - size / 2);
        root.left = left;
        root.right = right;
        return root;
    }
}