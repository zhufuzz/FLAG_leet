package ch9.List;

/*Reverse Linked List II
Reverse a linked list from position m to n.
Have you met this question in a real interview? Yes
Example Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.
Note Given m, n satisfy the following condition: 1 鈮� m 鈮� n 鈮� length of list.
Challenge Reverse it in-place and in one-pass*/
//Definition for ListNode
/* class ListNode {
      int val;
      ListNode next;
      ListNode(int val){
        this.val = val;
        next = null;
      }
  }*/

public class reverse_linked_list_ii {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n || head == null) {
            return head;
        }        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;        
        for (int i = 1; i < m; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }        
        ListNode premNode = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode, postnNode = mNode.next;
        for (int i = m; i < n; i++) {
            if (postnNode == null) {
                return null;
            }
            ListNode temp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = temp;
        }
        mNode.next = postnNode;
        premNode.next = nNode;        
        return dummy.next;
    }
}