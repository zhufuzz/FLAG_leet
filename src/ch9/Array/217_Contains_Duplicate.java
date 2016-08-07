package leet_Array;
/*Given an array of integers, find if the array contains any duplicates. 
Your function should return true if any value appears at least twice in the array, 
and it should return false if every element is distinct.*/

public class 217_Contains_Duplicate {
    public boolean containsDuplicate1(int[] nums) {
        if (nums == null || nums.length == 0){
            return false;
        }
        Boolean hasDup = false;
        HashMap hm = new HashMap();
        for (int i = 0; i < nums.length; i++){
            if (hm.containsKey(nums[i])){
                hasDup = true;
                break;
            }else{
                hm.put(nums[i], 1);
            }
        }
        return hasDup;
    }

    //http://www.programcreek.com/2014/05/leetcode-contains-duplicate-java/
    public boolean containsDuplicate2(int[] nums) {
    if(nums==null || nums.length==0)
        return false;
 
    HashSet<Integer> set = new HashSet<Integer>();
    for(int i: nums){
        if(!set.add(i)){
            return true;
        }
    }
 
    return false;
	}
}