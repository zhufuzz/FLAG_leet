package ch9J.chapter5_DP2;
/*
 * Given two words word1 and word2, find the minimum number of steps 
 * required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Have you met this question in a real interview? Yes
Example
Given word1 = "mart" and word2 = "karma", return 3.

Tags 
String Dynamic Programming
Related Problems 
Medium Longest Common Subsequence
 */

/*
 * ￼￼Edit Distance
• state: f[i][j]表示A的前i个字符最少要用几次编辑可以变成B的前j个字符
• function: f[i][j] = MIN(f[i-1][j]+1, f[i][j-1]+1, f[i-1][j-1]) 
					// A[i - 1] == B[j - 1]
• 					= MIN(f[i-1][j]+1, f[i][j-1]+1, f[i-1][j-1]+1) 
					// A[i - 1] != B[j - 1]
• initialize: f[i][0] = i, f[0][j] = j
• answer: f[n][m]
￼￼￼
 */
public class _5Edit_Distance {
public int minDistance(String word1, String word2) {
    int n = word1.length();
    int m = word2.length();
    
    int[][] dp = new int[n+1][m+1];
    for(int i=0; i< m+1; i++){
        dp[0][i] = i; //一次delete
    }
    for(int i=0; i<n+1; i++){
        dp[i][0] = i;//一次insert
    }
    
    
    for(int i = 1; i<n+1; i++){
        for(int j=1; j<m+1; j++){
            if(word1.charAt(i-1) == word2.charAt(j-1)){
                dp[i][j] = dp[i-1][j-1];
            }else{
                dp[i][j] = 1 + 
                		Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
            }
        }
    }
    return dp[n][m];
}
}
