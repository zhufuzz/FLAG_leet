package trytry;
import java.util.*;

import org.junit.Test;


public class tryDeque {
	Deque<Integer> deque = new ArrayDeque<Integer>();

	@Test
	public void test1(){
		deque.add(1);
		deque.add(2);
		deque.add(3);
		deque.add(4);
		System.out.println(deque);
		System.out.println(deque.pop());
		System.out.println(deque);
		System.out.println(deque.peek());
		System.out.println(deque.getFirst());
		System.out.println(deque);
		
		
	}
}
