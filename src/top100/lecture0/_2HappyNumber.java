package top100.lecture0;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;


class Happy {
	HashMap<Integer, Boolean> cache;
	public Happy() {
		cache = new HashMap<Integer, Boolean>();
		cache.put(1, true);
	}
	
	int transform(int n) {
		int sum = 0;
		while (n != 0) {
			sum += Math.pow(n%10, 2);
			n /= 10;
		}
		return sum;
	}
	
	boolean isHappy(int n) {
		LinkedList<Integer> steps = new LinkedList<Integer>();
		cache.put(1, true);
		while (cache.containsKey(n) == false) {
			cache.put(n, false);
			steps.add(n);
			n = transform(n);
		}
		System.out.println("Cal Complexity" + steps.size());
		if (cache.get(n) == true) {
			steps.forEach(temp -> cache.remove(temp));
			return true;
		}
		else return false;
	}
}	

public class _2HappyNumber {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner in = new Scanner(new File("input.txt"));
		int n = in.nextInt();
		while(n != -1) {
			Happy happy = new Happy();
			System.out.println(happy.isHappy(n));
			n = in.nextInt();
		}
		in.close();
	}
}

