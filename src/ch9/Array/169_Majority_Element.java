package leet_Array;
/*Given an array of size n, find the majority element. The majority element is the element that appears more than  [n/2] imes.

You may assume that the array is non-empty and the majority element always exist in the array.*/

public class 169_Majority_Element {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        int count = 0, candidate = -1;
        for (int i = 0; i < nums.size(); i++) {
            if (count == 0) {
                candidate = nums.get(i);
                count = 1;
            } else if (candidate == nums.get(i)) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}