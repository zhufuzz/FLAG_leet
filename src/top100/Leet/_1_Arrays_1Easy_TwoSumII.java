package top100.Leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class _1_Arrays_1Easy_TwoSumII {
	//<number, frequency>
	private final Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	//Maintain a list to for iteration in find, to avoid iterate the map, which can be really slow
	private final List<Integer> list = new ArrayList<Integer>();
	public void add(int number) {
		list.add(number);
		Integer frequency = map.get(number);
		if(frequency == null) {
			map.put(number, 1);
		} else {
			map.put(number, frequency + 1);
		}
	}
	
	public boolean find (int value) {
		for (int curKey : list) {
			int target = value - curKey;
			Integer count = map.get(target);
			if (count != null) {
				if (curKey != target || (curKey ==target && count >= 2)) {
					return true;
				}
			}
		}
		return false;
	}
}
