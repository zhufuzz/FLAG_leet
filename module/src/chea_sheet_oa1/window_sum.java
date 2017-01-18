package chea_sheet_oa1;
//window sum
import java.util.ArrayList;
import java.util.List;

public class window_sum {

  //SOL 1 sliding window
  //runtime is O(nk)
  public static List<Integer> getSum1(List<Integer> arr, int k) {
    List<Integer> rst = new ArrayList<Integer>();
    if (arr == null || arr.size() == 0 || k <= 0) {
      return rst;
    }
    //use two pointers to maintain the window size
    int left = 0;
    int right = left + k - 1;
    //sum up the values within the window
    while (right < arr.size()) {
      int sum = 0;
      for (int i = right; i >= left; i--) {
        sum += arr.get(i);
      }
      rst.add(sum);
      left++;
      right++;
    }
    return rst;
  }
  
  public static List<Integer> getSum3(List<Integer> arr, int k) {
    List<Integer> rst = new ArrayList<Integer>();
    //k > arr.size() ?
    if (arr == null || arr.size() == 0 || k == 0) {
      return rst;
    }
    int sum = 0;
    for (int i = 0; i < k; i++) {
      sum = sum + arr.get(i);
    }
    rst.add(sum);
    for (int i = k; i <= arr.size() - 1; i++) {
      sum = sum + arr.get(i) - arr.get(i - k);
      rst.add(sum);
    }
    return rst;
  }
  
  
  //SOL 2
  //runtime is O(nk), n is the size of arr, space used is O(1)
  public static List<Integer> getSum2(List<Integer> arr, int k) {
    List<Integer> rst = new ArrayList<Integer>();
    //consider the corner case
    if (arr == null || arr.size() == 0 || k <= 0) {
      return rst;
    }
    //use a variable to track the tail index when moving window
    int cnt = 0;
    for (int i = 0; i < arr.size(); i++) {
      cnt++;
      if (cnt >= k) {
      int sum = 0;
      //Once finish sum up the values within window
      for (int j = i; j >= i - k + 1; j--) {
        sum += arr.get(j);
      }
      rst.add(sum);
      }
    }
    return rst;
  } 

}
