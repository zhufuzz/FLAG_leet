package facebook.leetcode;
//Binary Search

/*Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

Hint:

Expected runtime complexity is in O(log n) and the input is sorted.*/

//https://www.hrwhisper.me/leetcode-h-index-h-index-ii/
//http://blog.csdn.net/sbitswc/article/details/48675791

public class F_275_H_Index2 {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int start = 0;
        int end = len-1;
        while(start<=end) {
            int mid = start + (end-start)/2;
            if(citations[mid] == len-mid) return len-mid;
            else if (citations[mid] < len-mid) start = mid+1;
            else end = mid-1;
        }
        return len-start;
    }
}