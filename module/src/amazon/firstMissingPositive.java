package amazon;
//http://blog.csdn.net/kenden23/article/details/17099987

public class firstMissingPositive{
    public int firstMissingPositive2(int A[], int n) {  
        for (int i=0; i<n; i++)  
        {  
            if (A[i] > 0 && A[i] < n)  
            {  
                if (A[A[i]-1] != A[i])  
                {  
                    swap(A[A[i]-1], A[i]);  
                    i--;  
                }  
            }  
        }  
  
        for (int j=0; j<n; ++j)  
            if (A[j]-1 != j)  
                return j+1;  
  
        return n+1;   
    }

	private void swap(int i, int j) {
		
	}  
}