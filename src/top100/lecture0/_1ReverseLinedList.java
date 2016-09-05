package top100.lecture0;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


class Node {
	int value;
	Node next;
	Node () {
		next = null;
	}
	
	void display (){
		Node head = this;
		while (head != null){
			System.out.print(head.value + " ");
			head = head.next;
			//head.next = null;
		}
		System.out.println();
	}
}

class Iteration{
	Node reverse(Node head){
		Node pre = null;
		Node current = head;
		Node next = null;
		while (current != null) {
			next = current.next;
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
			//head.next = null;
		}
		System.out.println();
	}

}

class Recursion {
	Node reverse (Node head){
		//Ending process
		if (head == null || head.next == null) return head;
		Node newTail = head.next;

		//Divide&Conquer
		Node newHead = reverse(head.next);
		
		//Combination
		newTail.next = head;
		head.next = null;
		return newHead;
	}
}

public class _1ReverseLinedList {
	
	Node head = null;
	Node tail = null;
	Scanner in;
	public static void main (String[] args) throws FileNotFoundException{
		Scanner in = new Scanner(new File("input.txt"));
		int n = in.nextInt();
		while (n != -1) {
			Node head = null;
			Node tail = null;
			
			while (n-- != 0) {
				Node ptr = new Node();
				ptr.value = in.nextInt();
				//这一行很重要，起始状态，第一次
				if (head == null) head = ptr;
				//不是第一次
				else tail.next = ptr;
				tail = ptr;
			}
			/*
			Iteration itr = new Iteration();
			itr.display(head);
			Node newHead = itr.reverse(head);
			itr.display(newHead);
			*/
			
			/**/
			Recursion rec = new Recursion();
			head.display();
			
			Node newHead = rec.reverse(head);
			newHead.display();
			
		}
		in.close();
	}
	@Before
	public void prepare() throws FileNotFoundException {
		in = new Scanner(new File("input.txt"));
		int n = in.nextInt();
		while (n != -1) {
			head = null;
			tail = null;
			while (n-- != 0) {
				Node ptr = new Node();
				ptr.value = in.nextInt();
				//这一行很重要，起始状态，第一次
				if (head == null) head = ptr;
				//不是第一次
				else tail.next = ptr;
				tail = ptr;
			}
		}
	}
	@Test
	public void testIteration() {
		Iteration itr = new Iteration();
		itr.display(head);
		Node newHead = itr.reverse(head);
		itr.display(newHead);
	}
	@Test
	public void testRecursion() {
		Recursion rec = new Recursion();
		head.display();
		Node newHead = rec.reverse(head);
		newHead.display();
	}
	@After
	public void after() {
		in.close();
	}
}

