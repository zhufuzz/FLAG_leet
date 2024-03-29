package ch9.List;
/*Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.*/

// http://blog.csdn.net/xudli/article/details/46893277

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Ch9_237_Delete_Node_in_a_Linked_List {
    public void deleteNode(ListNode node) {
        //input check
        if(node==null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}