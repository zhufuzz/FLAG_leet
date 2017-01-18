package OA1_xiaoyucool;

import java.util.*;

public class WindowSum{

	public static List<Integer> winSum(List<Integer> nums, int k){
		List<Integer> res = new ArrayList<Integer>();
		if(nums == null || nums.size() == 0 || k<=0){
			return res;
		}
		int sum = 0;
		int index = 0;
		while(index < nums.size() && index <k){
			sum += nums.get(index);
			index++;
		}
		res.add(sum);
		if(index <k){
			return res;
		}
		while(index < nums.size()){
			sum += nums.get(index);
			sum -= nums.get(index-k);
			res.add(sum);
			index++;
		}
		return res;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		List<Integer> nums = new ArrayList<Integer>();
		while(sc.hasNextInt()){
			nums.add(sc.nextInt());
		}
		sc.close();
		List<Integer> res = winSum(nums,3);
		for(Integer num : res){
			System.out.print(num);
		}

	}
}