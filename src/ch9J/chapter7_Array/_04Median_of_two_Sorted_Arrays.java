package ch9J.chapter7_Array;

public class _04Median_of_two_Sorted_Arrays {
public double findMedianSortedArrays(int A[], int B[]) {
    int len = A.length + B.length;
    if (len % 2 == 1) {
        return findKth(A, 0, B, 0, len / 2 + 1);
    }
    return (
        findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)
    ) / 2.0;
}

// find kth number of two sorted array
public static int findKth(int[] A, int A_start,
                          int[] B, int B_start,
                          int k){	
	//A is empty
	if (A_start >= A.length) {
		return B[B_start + k - 1];
	}
	//B is empty
	if (B_start >= B.length) {
		return A[A_start + k - 1];
	}

	if (k == 1) {
		return Math.min(A[A_start], B[B_start]);
	}
	//可以先默认把这两个都设成MAX_VALUE
	int A_key = A_start + k / 2 - 1 < A.length
	            ? A[A_start + k / 2 - 1]
	            : Integer.MAX_VALUE;
	int B_key = B_start + k / 2 - 1 < B.length
	            ? B[B_start + k / 2 - 1]
	            : Integer.MAX_VALUE; 
	
	if (A_key < B_key) {
		//give up half A 
		return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
	} else {
		return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
	}
}
}
