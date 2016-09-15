package top100.Leet;

import amazon.ListNode;

public class _1_LinkedList_1Easy_RemoveNthNodeFromTail {
	public ListNode removeNthfromEnd(ListNode head, int n) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode dummy = new ListNode(0);
		ListNode slow = dummy;// Slow pointer
		ListNode fast = dummy;//Fast pointer
		dummy.next = head;
		while (n > 0) {
			fast = fast.next;
			n--;
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return dummy.next;
	}
}
