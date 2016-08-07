package chea_sheet_oa1;


//Definition for singly-linked list. 
class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
    val = x;
  }
}

public class merge_two_linked_list {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        cur.next = l1;
        l1 = l1.next;
      } else {
        cur.next = l2;
        l2 = l2.next;
      }
      cur = cur.next;
    }
    
    if (l1 != null) {
      cur.next = l1;
    } else {
      cur.next = l2;
    }
    
    return dummy.next;
  }
}
