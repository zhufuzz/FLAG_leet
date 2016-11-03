package jike;

import java.util.Comparator;

import org.junit.Test;

public class Course07_TestList {
@SuppressWarnings("unused")
@Test
public void testNode01(){
	ListNode<Integer> p4=new ListNode<Integer>(4, null);
	ListNode<Integer> p3=new ListNode<Integer>(3, p4);
	ListNode<Integer> p2=new ListNode<Integer>(2, p3);
	ListNode<Integer> p1=new ListNode<Integer>(1, p2);
}
@SuppressWarnings("unused")
@Test
public void testNode02(){
	ListNode<Integer> p1=new ListNode<Integer>(1, new ListNode<Integer>(2, 
			new ListNode<Integer>(3, new ListNode<Integer>(4, null))));
}
/**
 * 测试：单链表的功能
 */
@Test
public void testMiniList(){
	MiniList<Integer> list=new MiniList<Integer>();
	Integer[] array={0,1,2,3,4};
	list.arrayToList(array);
	list.printList();
	list.insert(2, 10);
	list.printList();
	list.remove(4);
	list.printList();
	list.set(3, 13);
	list.printList();
	System.out.println(list.get(4));
}
/**
 * 测试：逆序打印链表
 */
@Test
public void testPrintReverse(){
	MiniList<Integer> list=new MiniList<Integer>();
	Integer[] array={0,1,2,3,4};
	list.arrayToList(array);
	list.printList();
	list.printInverse();
	list.printInverseRecursive();
}
/**
 * 测试：获取链表的最大元素，整形
 */
@Test
public void testMaxInteger(){
	MiniList<Integer> list=new MiniList<Integer>();
	Integer[] array={3,4,1,2};
	list.arrayToList(array);
	System.out.println(list.getMax());
}
/**
 * 测试：获取链表的最大元素，整形普通类型
 */
@Test
public void testMaxPerson(){
	MiniList<Person> list=new MiniList<Person>();
	list.comp=new Comparator<Person>() {
		@Override
		public int compare(Person o1, Person o2) {
			return o2.getId()-o1.getId();
		}
	};
	Person[] array={new Person(3, "AAA"),
			new Person(2, "BBB"),
			new Person(1, "CCC"),
			new Person(4, "DDD")};
	list.arrayToList(array);
	System.out.println(list.getMax());
}
}
