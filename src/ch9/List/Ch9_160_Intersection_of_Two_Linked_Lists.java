package ch9.List;
/*Write a program to find the node at which the intersection of two singly linked lists begins.
For example, the following two linked lists:
A:  a1 ¡ú a2
                       ¨K
               c1 ¡ú c2 ¡ú c3
                       ¨J            
B:b1 ¡ú b2 ¡ú b3
begin to intersect at node c1.
Notes:If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.*/
public class Ch9_160_Intersection_of_Two_Linked_Lists {
    /*** @param headA: the first list* @param headB: the second list* @return: a ListNode*/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }        
        // get the tail of list A.
        ListNode node = headA;
        while (node.next != null) {
            node = node.next;
        }
        node.next = headB;
        ListNode result = listCycleII(headA);
        node.next = null;
        return result;
    }
    
    private ListNode listCycleII(ListNode head) {
        ListNode slow = head, fast = head.next;
        
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            
            slow = slow.next;
            fast = fast.next.next;
        }        
        slow = head;
        fast = fast.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }        
        return slow;
    }
}