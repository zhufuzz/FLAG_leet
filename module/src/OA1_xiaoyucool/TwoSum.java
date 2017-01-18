package OA1_xiaoyucool;

//Two Sum Pairs
import java.util.*;
public class TwoSum{
  
	public static int twoSumDistinct(int[] nums,int target){
		if(nums ==  null || nums.length <=1){
			return 0;
		}
		int count = 0;
		//HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0;i<nums.length;i++){
			int diff = target-nums[i];
			if(!map.containsKey(diff)){
				map.put(nums[i],0);
			}else{
				if(map.get(diff) == 0){
					count++;
					map.put(diff,1);
				}
			}
		}
		return count;
	}

	public static void main(String[] args){
		int[] nums = {1,1,1};
		System.out.println(twoSumDistinct(nums,2));
	}
}