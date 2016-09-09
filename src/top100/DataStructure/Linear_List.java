package top100.DataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.List;

import org.junit.Before;
import org.junit.Test;



public class Linear_List {

	
	@Before
	public void before () {
		
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testArrayList () {
		ArrayList<Integer> arrl = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			arrl.add(i);
		}
		arrl.add(10);
		for (int i = 0; i <= 10; i++) {
			System.out.print(arrl.get(i) + " ");
		}
		System.out.println();
		Collection<Integer> c_LinkedList = new LinkedList<>();
		Collection<Integer> c_ArrayList = new ArrayList<>();
		Collection<Integer> c_Stack = new Stack<>();
		Collection<Integer> c_PriorityQueue = new PriorityQueue<>();
		
		Collection<Integer> c_HashSet = new HashSet<>();
		
		Collection<Integer> c_LinkedHashSet = new LinkedHashSet<>();
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testCollection() {
		Collection<Integer> c_LinkedList = new LinkedList<>();
		Collection<Integer> c_ArrayList = new ArrayList<>();
		Collection<Integer> c_Stack = new Stack<>();
		Collection<Integer> c_PriorityQueue = new PriorityQueue<>();
		
		Collection<Integer> c_HashSet = new HashSet<>();
		Collection<Integer> c_LinkedHashSet = new LinkedHashSet<>();
		boolean isAdd1 = c_LinkedList.add(1);
		c_LinkedList.add(2);
		c_LinkedList.add(3);
		System.out.println(c_LinkedList);
		boolean isAdd2 = c_ArrayList.addAll(c_LinkedList);
		System.out.println("equals: " + c_ArrayList.equals(c_LinkedList));
		c_ArrayList.add(4);
		System.out.println(c_ArrayList.containsAll(c_LinkedList));
		System.out.println(c_ArrayList);
		c_LinkedList.clear();
		System.out.println(c_LinkedList);
		System.out.println(c_ArrayList.contains(4));
		boolean isRemoved = c_ArrayList.remove(4);
		System.out.println(c_ArrayList);
		
		Object[] objArr = c_ArrayList.toArray();
		Integer[] intArr = c_ArrayList.toArray(new Integer[0]);
		System.out.println(intArr.length);
		//System.out.println(intArr);
		Iterator<Integer> itr = c_ArrayList.iterator();
		while (itr.hasNext()) {
			System.out.println("iterator: " + itr.next());
		}
		c_ArrayList.forEach(i -> System.out.println(i));
	
		
	}
	
	@Test
	public void testForEach() {
		List<Integer> arrl = new LinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			arrl.add(i);
		}
		arrl.forEach(hehe -> System.out.println(hehe));
		arrl.forEach(hehe -> hehe = 0);
		arrl.forEach(hehe -> System.out.println(hehe));
		int[] arr = new int[10];
		Arrays.stream(arr);
	}
	@Test
	public void testLinkedList(){
		LinkedList<Integer>  list = new LinkedList<>();
		 list.addFirst(1);
	}
	
}
