package ch9S.chapter6_DP2;

public class _1Backpack {
	/**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
	
    public int backPack(int m, int[] A) {
        boolean f[][] = new boolean[A.length + 1][m + 1];
        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = false;
            }
        }
        f[0][0] = true;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j <= m; j++) {
                f[i + 1][j] = f[i][j];
                if (j >= A[i] && f[i][j - A[i]]) {
                    f[i + 1][j] = true;
                }
            } // for j
        } // for i
        
        for (int i = m; i >= 0; i--) {
            if (f[A.length][i]) {
                return i;
            }
        }
        return 0;
    }
    
    ////////////////////////////////////
    //lintcode 92
	//f[i][j]：前i个物品放到体积为j的包里，最大能放多少
    //f[i][j] = max(f[i - 1][j], f[i- 1][j - A[i]] + A[i])
    
    
    public int backPack_2(int m, int[] A) {
    		int n = A.length;
    		int[][] f = new int[n + 1][m + 1];
    		for (int i= 1; i <= n; i++) {
    			for (int j = 1; j <= m; j++) {
    				f[i][j] = f[i - 1][j];
    				if (j >= A[i - 1]) {
    					f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - A[i - 1]]+ A[i - 1]);
    				}
    			}
    		}
    		return f[n][m];
    }
    
    
    
}
