package ch9J.chapter6_LinkedList;

public class _07Rotate_List {
    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length ++;
            head = head.next;
        }
        return length;
    }
    
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        
        int length = getLength(head);
        n = n % length;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        ListNode tail = dummy;
        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        
        while (head.next != null) {
            tail = tail.next;
            head = head.next;
        }
        
        head.next = dummy.next;
        dummy.next = tail.next;
        tail.next = null;
        return dummy.next;
    }
}


/*
 * Given a list, rotate the list to the right by k places,
 *  where k is non-negative.

Have you met this question in a real interview? Yes
Example
Given 1->2->3->4->5 and k = 2, return 4->5->1->2->3.

Tags 
Basic Implementation Linked List
Related Problems 
Hard Reverse Nodes in k-Group 31 %
Easy Rotate String 20 %
 */