package ch9.List;
//109. Convert Sorted List to Binary Search Tree My Submissions Question

public class Ch9_109_Convert_Sorted_List_to_Binary_Search_Tree {
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