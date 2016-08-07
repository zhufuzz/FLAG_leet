package ch9.List;

/*
Reverse Linked List
Reverse a linked list.
Have you met this question in a real interview? Yes
Example
For linked list 1->2->3, the reversed linked list is 3->2->1
Challenge
Reverse it in-place and in one-pass*/
 // Definition for ListNode2.
  class ListNode2 {
      int val;
     ListNode2 next;
    ListNode2(int val) {
          this.val = val;
          this.next = null;
      }
  }
 
public class reverse_linked_list {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode2 reverse(ListNode2 head) {
        ListNode2 prev = null;
        while (head != null) {
            ListNode2 temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}