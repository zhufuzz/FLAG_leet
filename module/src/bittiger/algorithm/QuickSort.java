package bittiger.algorithm;

import java.util.*;
//http://blog.csdn.net/fightforyourdream/article/details/21373279
public class QuickSort{

/**
 * Partition the array into two halves and return the index
 * of the pivot.
 *
 * @param array the array of values to be partitioned
 * @param start the starting index in the array to partition
 * @param end the ending index in the array to partition
 */
 private static int partition(int array[], int start, int end) {
    // set the pivot to the first element in the array
    int pivot = array[start];

    while (start < end) {
        // look for an element smaller than the pivot from the end
        while (start < end && array[end] >= pivot) {
            end--;
        }
        if (start < end) {  // found a smaller array
            array[start] = array[end];

            // now find an element larger than the pivot from
            // the start
            while (start < end && array[start] <= pivot) {
                start++;
            }

            if (start < end) {  // found a larger array
                array[end] = array[start];
            }
        }
    }

    // done, move the pivot back into the array
    array[start] = pivot;
    return start;
}


/**
 * Sort an array using quick sort.
 *
 * @param array the array of values to be sorted
 * @param low the start of the sorting region
 * @param high the end of the sorting region
 */
public static void quickSort(int array[], int low, int high) {
    if (low < high) {
        // partition the array into two halves (in place)
        // and get the index of the pivot (middle)
        int pivot = partition(array, low, high);
        quickSort(array, low, pivot-1);
        quickSort(array, pivot + 1, high);
    }
}


/**
 * Main method.
 *
 * @param args command line arguments.
 */
public static void main(String args[]) {
    
    int arrays[] = {1,0,-1,0,0};

    // Print out the initial array
    System.out.print("Initial: ");
    System.out.println(Arrays.toString(arrays));

    // Quicksort the array
    quickSort(arrays, 0, arrays.length-1);

    // Print out the sorted array
    System.out.print("Sorted: ");
    System.out.println(Arrays.toString(arrays));
}
}
