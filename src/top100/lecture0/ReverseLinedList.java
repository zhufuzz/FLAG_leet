package top100.lecture0;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import com.sun.org.apache.bcel.internal.generic.IREM;

class Node {
	int value;
	Node next;
	Node () {
		next = null;
	}
}

class Iteration{
	Node reverse(Node head){
		Node pre = null;
		Node current = head;
		Node next = null;
		while (current != null) {
			current.next = pre;
			pre = current;
			current = next;
		}
		return pre;
	}
	void display (Node head){
		while (head != null){
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}
}

class Recursion {
	Node reverse (Node head){
		//Ending process
		if (head == null && head.next == null) return head;
		
		Node newTail = head.next;
		
		//Divide&Conquer
		Node newHead = reverse(head.next);
		return newHead;
		
		//Combination
	}
}

public class ReverseLinedList {
	public static void main (String[] args) throws FileNotFoundException{
		Scanner in = new Scanner(new File("input.txt"));
		int n = in.nextInt();
		while (n != -1) {
			Node head = null;
			Node tail = null;
			while (n-- != 0) {
				Node ptr = new Node();
				ptr.value = in.nextInt();
				if (head == null) head = ptr;
				else tail.next = ptr;
				tail = ptr;
			}
			//Iteration itr = new Iteration();
			//itr.display(head);
			//Node newHead = itr.reverse(head);
			///itr.display(head);
			
			Recursion rec = new Recursion();
			//head.display();
			rec.reverse(head);
			//newHead.display();
			
		}
		in.close();
	}
}

