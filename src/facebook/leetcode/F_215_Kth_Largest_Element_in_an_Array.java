package facebook.leetcode;
//Divide and Conquer, Heap
import java.util.*;

/*Find the kth largest element in an unsorted array. 
 * Note that it is the kth largest element in the sorted order, 
 * not the kth distinct element.
 * 
For example, Given [3,2,1,5,6,4] and k = 2, return 5.
Note: You may assume k is always valid, 1 ≤ k ≤ array's length.*/

//http://www.jiuzhang.com/solutions/kth-largest-element/
//http://www.programcreek.com/2014/05/leetcode-kth-largest-element-in-an-array-java/
//https://leetcode.com/discuss/88174/easy-to-understand-java-solution
  
public class F_215_Kth_Largest_Element_in_an_Array {
  
	public int findKthLargest(int[] nums, int k) {
	  int len = nums.length;
	  
    // if(len == 0) return 0; //we get to assume k is always valid
	  
    Queue<Integer> pq = new PriorityQueue<>(nums.length, new Comparator<Integer>(){
                                    public int compare(Integer a, Integer b) {
                                        return Integer.compare(b, a);
                                    }
                            });
    for(int num : nums)
        pq.offer(num);

    int kth = 0;
    
    for(int i = 0; i < k; i++)
        kth = pq.poll();

    return kth;
	}
}