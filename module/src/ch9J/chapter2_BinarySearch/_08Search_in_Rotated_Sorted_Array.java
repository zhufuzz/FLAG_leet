package ch9J.chapter2_BinarySearch;

public class _08Search_in_Rotated_Sorted_Array {
	 public int search(int[] A, int target) {
	    if (A == null || A.length == 0) {
	        return -1;
	    }
	
	    int start = 0;
	    int end = A.length - 1;
	    int mid;
	    
	    while (start + 1 < end) {
	        mid = start + (end - start) / 2;
	        if (A[mid] == target) {
	            return mid;
	        }
	        
	        // USE START TO COMPARE !!!!
	        if (A[start] < A[mid]) {
	            // situation 1, red line
	            if (A[start] <= target && target <= A[mid]) {
	                end = mid;
	            } else {
	                start = mid;
	            }
	        } else {
	            // situation 2, green line
	            if (A[mid] <= target && target <= A[end]) {
	                start = mid;
	            } else {
	                end = mid;
	            }
	        }
	    } // while
	    
	    if (A[start] == target) {
	        return start;
	    }
	    if (A[end] == target) {
	        return end;
	    }
	    return -1;
	  }
}

/*
 * Suppose a sorted array is rotated at some pivot 
 * unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the 
array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Have you met this question in a real interview? Yes
Example
For [4, 5, 1, 2, 3] and target=1, return 2.

For [4, 5, 1, 2, 3] and target=0, return -1.

Challenge 
O(logN) time

Tags 
Binary Search Sorted Array Array LinkedIn Uber Facebook
Related Problems 
Medium Search in Rotated Sorted Array II 39 %
Easy Search a 2D Matrix 27 %
 * 
 * */
