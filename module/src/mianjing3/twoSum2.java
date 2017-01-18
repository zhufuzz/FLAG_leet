package mianjing3;
import java.util.HashMap;

public class twoSum2 {
  public int[] twoSum(int[] nums, int target) {    
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); 
    for(int i = 0; i < nums.length; i++){
        int key = target - nums[i];
        if(hm.containsKey(key)){
            return new int[]{hm.get(key) + 1, i + 1};
        }
        hm.put(nums[i], i);
    }
    return new int[]{0 , 0};
  }
}
