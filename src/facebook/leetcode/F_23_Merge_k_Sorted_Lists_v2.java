package facebook.leetcode;
// version 2: Heap
//Merge k sorted linked lists and return it as one sorted list. 
//Analyze and describe its complexity.
import java.util.*;
//https://leetcode.com/discuss/85566/java-easy-version-to-understand-two-methods

public class F_23_Merge_k_Sorted_Lists_v2 {
    public ListNode mergeKLists(ListNode[] lists) {
      if (lists == null || lists.length == 0)        return null;
      if (lists.length == 1)                         return lists[0];
      
      PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
          public int compare(ListNode o1, ListNode o2) {
              return o1.val - o2.val;
          }
      });
      
      ListNode dummy = new ListNode(0);
      ListNode tail = dummy;
      dummy.next = null;
      
      for (ListNode node : lists) {
            if (node != null)
              heap.offer(node);
      }
    
      while (!heap.isEmpty()) {
          ListNode p = heap.poll();
          tail.next = p;
          tail = tail.next;
          p = p.next;
          if (p != null) heap.offer(p);
      }
      
      tail.next = null;
      
      return dummy.next;
    }
}
