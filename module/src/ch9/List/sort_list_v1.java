package ch9.List;
/*Sort List  http://www.cnblogs.com/yuzhangcmu/p/4131885.html
Sort a linked list in O(n log n) time using constant space complexity.
Have you met this question in a real interview? Yes
Example Given 1-3->2->null, sort it to 1->2->3->null.*/
// version 1: Merge Sort
public class sort_list_v1 {            
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }    
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        if (head1 != null) {
            tail.next = head1;
        } else {
            tail.next = head2;
        }
        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMiddle(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        return merge(left, right);
    }
}
