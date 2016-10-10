package ch9S.chapter6_DP2;

public class _2BackpackII {
	/**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        int[] f = new int[m+1];
        for (int i = 0; i <=m ; ++i) f[i] = 0;
        int n = A.length , i, j;
        for(i = 0; i < n; i++){
            for(j = m; j >= A[i]; j--){
                if (f[j] < f[j - A[i]] + V[i])
                    f[j] = f[j - A[i]] + V[i];
            }
        }
        return f[m];
    }
    
    //////////////////////////
    
    public int backPackII_2(int m, int[] A, int V[]) {
    		int n = A.length;
    		int[][] f = new int[n + 1][m + 1];
    		for (int i= 1; i <= n; i++) {
    			for (int j = 1; j <= m; j++) {
    				f[i][j] = f[i - 1][j];
    				if (j >= A[i - 1]) {
    					f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - A[i - 1]]+ V[i - 1]);
    				}
    			}
    		}
    		return f[n][m];
    }
    
    
}
