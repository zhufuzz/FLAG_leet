package facebook.leetcode;
//DP

/*There are a row of n houses, each house can be painted with one of 
 * the k colors. The cost of painting each house with a certain color 
 * is different. You have to paint all the houses such that no two adjacent
 *  houses have the same color.
The cost of painting each house with a certain color is represented by a n x k
 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; 
 costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.
 
Note: All costs are positive integers.
Follow up: Could you solve it in O(nk) runtime?*/

//http://www.cnblogs.com/airwindow/p/4804011.html

public class F_265_Paint_House2 {
    public int minCostII(int[][] costs) {
        if (costs == null)
            throw new IllegalArgumentException("costs is null");
        if (costs.length == 0)
            return 0;
        int len = costs.length;
        int k = costs[0].length;
        int min_1 = 0, min_2 = 0;
        int pre_min_1, pre_min_2;
        int[] dp = new int[k];
        for (int i = 0; i < len; i++) {
            pre_min_1 = min_1;
            pre_min_2 = min_2;
            min_1 = Integer.MAX_VALUE;
            min_2 = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                if (dp[j] != pre_min_1 || pre_min_1 == pre_min_2) {
                    dp[j] = pre_min_1 + costs[i][j];
                } else{
                    dp[j] = pre_min_2 + costs[i][j];
                }
                if (dp[j] <= min_1) {
                    min_2 = min_1;
                    min_1 = dp[j];
                } else if (dp[j] < min_2){
                    min_2 = dp[j];
                }
            }
        }
        return min_1;    
    }
}