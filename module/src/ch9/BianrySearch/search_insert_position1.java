package ch9.BianrySearch;
/*
search-insert-position
http://www.lintcode.com/problem/search-insert-position/

Given a sorted array and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.
 You may assume no duplicates in the array. Here are few examples. 
 [1,3,5,6], 5 鈫� 2 
 [1,3,5,6], 2 鈫� 1 
 [1,3,5,6], 7 鈫� 4 
 [1,3,5,6], 0 鈫� 0
*/

 // version 1: find the first position >= target
public class search_insert_position1 {
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int start = 0, end = A.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (A[start] >= target) {
            return start;
        } else if (A[end] >= target) {
            return end;
        } else {
            return end + 1;
        }
    }
}
