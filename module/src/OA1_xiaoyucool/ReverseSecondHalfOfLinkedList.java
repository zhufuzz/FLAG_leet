package OA1_xiaoyucool;

public class ReverseSecondHalfOfLinkedList{

	static class ListNode{
		ListNode next;
		int val;
		public ListNode(int val){
			this.val = val;
		}
	}

	public static ListNode reverseSecondHalf(ListNode head){
		if(head == null || head.next == null || head.next.next == null){
			return head;
		}
		ListNode runner = head;
		ListNode walker = head;

		while(runner.next.next != null){
			runner = runner.next.next;
			walker = walker.next;
		}
		ListNode pre = null;
		ListNode secHalf = walker.next;
		while(secHalf != null){
			ListNode next = secHalf.next;
			secHalf.next = pre;
			pre = secHalf;
			secHalf = next;
		}
		walker.next = pre;
		return head;
	}

	public static String printList(ListNode head){
		StringBuilder sb = new StringBuilder();
		while(head != null){
			if(sb.length() == 0){
				sb.append(head.val);
			}else{
				sb.append("->").append(head.val);
			}
			head = head.next;
		}
		return sb.toString();
	}

	public static void main(String[] args){
		ListNode head = new ListNode(1);
		ListNode cur = head;
		for(int i = 2;i<=8;i++){
			cur.next = new ListNode(i);
			cur=cur.next;
		}
		System.out.println("The Original String is "+printList(head));
		ListNode newHead = reverseSecondHalf(head);
		//System.out.println("The Original String is "+printList(head));
		System.out.println("The New String is "+printList(newHead));

	}
}