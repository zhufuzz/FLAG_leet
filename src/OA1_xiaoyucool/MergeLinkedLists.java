package OA1_xiaoyucool;


public class MergeLinkedLists{
  
  static class ListNode{
    ListNode next;
    int val;
    public ListNode(int val){
      this.val = val;
    }
  }
  
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = l1;
        ListNode pre = fakeHead;
        
        while(l1 != null && l2 != null){
            if(l1.val>l2.val){
                ListNode next = l2.next;
                l2.next = pre.next;
                pre.next = l2;
                l2 = next;
                pre = pre.next;
            }else{
                l1 = l1.next;
                pre = pre.next;
            }
        }
       if(l2 != null){
           pre.next = l2;
       }
        return fakeHead.next;
    }
}