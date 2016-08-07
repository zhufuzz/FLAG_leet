package ch9.List;

/*
Linked List Cycle

Given a linked list, determine if it has a cycle in it.



Have you met this question in a real interview? Yes
Example
Given -21->10->4->5, tail connects to node index 1, return true
*/

public class linked_list_cycle {
    public Boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast, slow;
        fast = head.next;
        slow = head;
        while (fast != slow) {
            if(fast==null || fast.next==null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
        } 
        return true;
    }
}