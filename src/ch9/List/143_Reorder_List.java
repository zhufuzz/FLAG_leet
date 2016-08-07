package leet_List;
/*Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn,
reorder it to: L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­
You must do this in-place without altering the nodes' values.
For example,Given {1,2,3,4}, reorder it to {1,4,2,3}.*/

public class 143_Reorder_List {
    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next; head.next = newHead;
            newHead = head; head = temp;
        }
        return newHead;
    }
    private void merge(ListNode head1, ListNode head2) {
        int index = 0;
        ListNode dummy = new ListNode(0);
        while (head1 != null && head2 != null) {
            if (index % 2 == 0) {
                dummy.next = head1;
                head1 = head1.next;
            } else {
                dummy.next = head2;
                head2 = head2.next;
            }
            dummy = dummy.next;
            index ++;
        }
        if (head1 != null) {
            dummy.next = head1;
        } else {
            dummy.next = head2;
        }
    }
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next; slow = slow.next;
        }
        return slow;
    }
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {return;}
        ListNode mid = findMiddle(head);
        ListNode tail = reverse(mid.next);
        mid.next = null;
        merge(head, tail);
    }
}