package jike;

import java.util.Random;

import org.junit.Test;

public class Course03one_TestInverse {
/**
 * 测试对象数组的逆置
 */
@Test
public void testPerson(){
	Course03one_Person[] array=new Course03one_Person[6];
	for(int i=0;i<6;i++){
		array[i]=new Course03one_Person(i, "name"+i);
	}
	Course03one_InverseArray<Course03one_Person> ia =
			new Course03one_InverseArray<Course03one_Person>();
	ia.printArray(array);
	ia.inverse(array);
	ia.printArray(array);
}
/**
 * 测试整型数组的逆置
 */
@Test
public void testInteger(){
	Integer[] array=new Integer[7];
	Random ra=new Random();
	for(int i=0;i<7;i++){
		array[i]=ra.nextInt(10);
	}
	Course03one_InverseArray<Integer> ia=new Course03one_InverseArray<Integer>();
	ia.printArray(array);
	ia.inverse(array);
	ia.printArray(array);
}
}
