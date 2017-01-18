package ch9.List;
/*Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?*/

public class Ch9_141_Linked_List_Cycle {
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