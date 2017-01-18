package mianjing3;

public class halfList {
  
  class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
  public static ListNode reverseSecondHalfList(ListNode head) {
    if (head == null || head.next == null)  return head;
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    ListNode pre = slow.next;
    ListNode cur = pre.next;
    while (cur != null) {
      pre.next = cur.next;
      cur.next = slow.next;
      slow.next = cur;
      cur = pre.next;
    }
    return head;
  }

}
