package Amazon_zhu;
import java.lang.reflect.Array;
import java.util.*;
public class TwoSum {
  /*
   * check whether the array contains two int can add up to target
   * */
  public boolean twoSum1(int[] array, int target){
    //check input
    if(array == null || array.length < 2){
      return false;
    }    
    HashSet<Integer> hashset = new HashSet<Integer>();
    for(int i = 0; i < array.length; i++){
      if(hashset.contains(target - array[i])){
        return true;
      }else{
        hashset.add(array[i]);
      }
    }//end-for
    return false;
  }
  
  /*
   * follow up - leetcode, return index
   * assume one solution
   * */
  public int[] twoSum2(int[] numbers, int target){
    int[] res = new int[2];
    if(numbers == null || numbers.length < 2){
      throw new IllegalArgumentException("invalid");
    }
    HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
    for(int i = 0; i < numbers.length; i++){
      int diff = target - numbers[i];
      if(hashmap.containsKey(diff)){
        res[0] = hashmap.get(diff) + 1;
        res[1] = i + 1;
        return res;
      }
      hashmap.put(numbers[i], i);
    }
    return null;
  }
  
  /*
   * follow up: do not allow duplicates
   * [7, 2, 2, 2, 9. 10, 2, 2, 11, 9, 1]target 9, just one solution
   * */
  public List<List<Integer>> twoSum3(int[] numbers, int target){
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if(numbers == null || numbers.length < 2){
      return res;
    }
    HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
    HashSet<Integer> hashset = new HashSet<Integer>();
    for(int i = 0; i < numbers.length; i++){
      if(hashset.contains(numbers[i])){
        continue;
      }
      int diff = target - numbers[i];
      if(hashmap.containsKey(diff)){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(hashmap.get(diff) + 1);
        list.add(i + 1);
        res.add(list);
        hashset.add(diff);
        hashset.add(numbers[i]);
      }
      hashmap.put(numbers[i], i);
    }
    return res;
  }
  
  /*
   * follow up, do not allow to use hashmap
   * do not allow duplicates
   * return value not index
   * */
  public List<List<Integer>> twoSum4(int[] numbers, int target){
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if(numbers == null || numbers.length < 2){
      return res;
    }
    Arrays.sort(numbers);//Arrays!!! with s
    int start = 0;
    int end = numbers.length - 1;
    while(start < end){
      int sum = numbers[start] + numbers[end];
      if(sum == target){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(numbers[start]);
        list.add(numbers[end]);
        res.add(list);
        //update pointer
        start++;
        end--;
        //avoid duplicates
        while(start < end && numbers[start] == numbers[start - 1]){
          start++;
        }
        while(start < end && numbers[end] == numbers[end + 1]){//end  + 1?
          end--;
        }
      }else if(sum < target){
        sum++;
      }else{
        end--;
      }
    }
    return res;    
  }
  
  /*
   * follow up: need duplicates
   * */
  public List<List<Integer>> twoSum5(int[] numbers, int target){
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if(numbers == null || numbers.length < 2){
      return res;
    }
    Arrays.sort(numbers);
    ArrayList<Integer> path = new ArrayList<Integer>();
    dfs(res, path, numbers, target, 0);
    return res;
  }
  
  private void dfs(List<List<Integer>> res, ArrayList<Integer> path, 
      int[] numbers, int target, int pos){
    if(path.size() == 2){
      if(target == 0){
        res.add(new ArrayList<Integer>(path));//bug here
      }
      return;
    }
    for(int i = pos; i < numbers.length; i++){
      path.add(numbers[i]);
      dfs(res, path, numbers, target - numbers[i], i + 1);
      path.remove(path.size() - 1);
    }
  } 
  
  public static void main (String[] args){
    int[] nums = {1, 1, 1, 3, 3, 3};
    TwoSum ins = new TwoSum();
    System.out.println(ins.twoSum2(nums, 4));
  }  
}
