package ch9.BFS;
import java.util.*;
/*Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.*/

//http://bookshadow.com/weblog/2015/09/09/leetcode-perfect-squares/

public class Ch9_279_Perfect_Squares {
    public int numSquares(int n) {
        int dp[] = new int[n + 1];
      //仔细观察，不需要担心溢出
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i * i <= n; i++) {
            dp[i * i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);
            }
        }
        return dp[n];
    }
}