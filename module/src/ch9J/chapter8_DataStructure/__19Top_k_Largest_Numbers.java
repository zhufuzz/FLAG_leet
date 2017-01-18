package ch9J.chapter8_DataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class __19Top_k_Largest_Numbers {
/*
 * @param nums an integer array
 * @param k an integer
 * @return the top k largest numbers in array
 */
public int[] topk(int[] nums, int k) {
    // Write your code here
    quickSort(nums, 0, nums.length - 1, k);

    List<Integer> result = new ArrayList<Integer>();
    for (int i = 0; i < k && i < nums.length; ++i)
        result.add(nums[i]);

    Collections.sort(result, Collections.reverseOrder());
    int[] topk = new int[k];
    for (int i = 0; i < k; ++i)
        topk[i] = result.get(i);

    return topk;
}

private void quickSort(int[] A, int start, int end, int k) {
    if (start >= k || end < k)
        return;

    if (start >= end) {
        return;
    }
    
    int left = start, right = end;
    // key point 1: pivot is the value, not the index
    Random rand =new Random(end - start + 1);
    int index = rand.nextInt(end - start + 1) + start;
    int pivot = A[index];

    // key point 2: every time you compare left & right, it should be 
    // left <= right not left < right
    while (left <= right) {
        // key point 3: A[left] < pivot not A[left] <= pivot
        while (left <= right && A[left] > pivot) {
            left++;
        }
        // key point 3: A[right] > pivot not A[right] >= pivot
        while (left <= right && A[right] < pivot) {
            right--;
        }

        if (left <= right) {
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
            
            left++;
            right--;
        }
    }
    
    quickSort(A, start, right, k);
    quickSort(A, left, end, k);
}
}

/*Given an integer array, find the top k largest numbers in it.

Have you met this question in a real interview? Yes
Example
Given [3,10,1000,-99,4,100] and k = 3.
Return [1000, 100, 10].

Tags 
Heap Priority Queue
Related Problems 
Medium Top k Largest Numbers II 26 %
Medium Top K Frequent Words 16 %*/