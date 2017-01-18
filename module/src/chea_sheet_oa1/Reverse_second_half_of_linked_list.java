package chea_sheet_oa1;
//e.g. 1-2-3-4-5-6 change to 1-2-3-6-5-4, 1-2-3-4-5 change to 1-2-5-4-3
//time O(n), space O(1)
public class Reverse_second_half_of_linked_list {
  public static JNode reorder1(JNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return head;
    }
    JNode fast = head.next;
    JNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    JNode pre = slow.next;
    JNode cur = pre.next;
    while (cur != null) {
      pre.next = cur.next;
      cur.next = slow.next;
      slow.next = cur;
      cur = pre.next;
    }
    return head;
  }
  
  public static JNode reorder2(JNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    JNode pre = findMidPre(head);
    JNode right = pre.next;
    pre.next = null;
    right = reverse(right);
    pre.next = right;
    return head;
  }
  
  public static JNode reverse(JNode node) {
    if (node == null) {
      return node;
    }
    JNode dummy = new JNode(0);
    while (node != null) {
      JNode tmp = node.next;
      node.next = dummy.next;
      dummy.next = node;
      node = tmp;
    }
    return dummy.next;
  }
  
  public static JNode findMidPre(JNode node) {
    if (node == null) {
      return node;
    }
    JNode fast = node.next;
    JNode slow = node;
    while (fast != null && fast.next != null &&
      fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }
  
  public static class JNode {
    int val;
    JNode next;
    JNode(int x) {
      val = x;
    }
  }
}
