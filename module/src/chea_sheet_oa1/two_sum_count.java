package chea_sheet_oa1;
import java.util.HashMap;
import java.util.HashSet;
//Consider case: {3, 2, 4} target = 6, output {3, 3} {2, 4}
public class two_sum_count { 
  // SOL 1
  // time O(n), space O(n)
  public static int count1(int[] nums, int target) {
    // corner case
    if (nums == null || nums.length < 2) {
      return 0;
    }
    int cnt = 0;
    HashSet<Integer> hash = new HashSet<Integer>();
    for (int i = 0; i < nums.length; i++) {
      hash.add(nums[i]);
    }
    for (int i = 0; i < nums.length; i++) {
      if (hash.contains(target - nums[i])) {
        cnt++;
      }
    }
    return cnt;
  }
  
  //SOL 2
  //pairs don't count repeat
  public static int count2(int[] nums, int target) {
    if (nums == null || nums.length < 2) {
      return 0;
    }
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }
    int cnt = 0;
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        if (i != map.get(target - nums[i])) {
          cnt++;
          map.remove(nums[i]);
          map.remove(target - nums[i]);
        }
      }
    }
    return cnt;
  }
  
  //SOL 3
  //count the repeat
  public static int count3(int[] nums, int target) {
    if (nums == null || nums.length < 2) {
      return 0;
    }
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    int cnt = 0;
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        cnt += map.get(target - nums[i]);
      }
      if (!map.containsKey(nums[i])) {
        map.put(nums[i], 1);
      } else {
        map.put(nums[i], map.get(nums[i]) + 1);
      }
    }
    return cnt;
  }
}
