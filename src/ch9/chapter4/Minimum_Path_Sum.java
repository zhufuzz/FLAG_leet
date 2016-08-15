package ch9.chapter4;
/*
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Notice

You can only move either down or right at any point in time.

Have you met this question in a real interview? Yes
Example
Tags 
Dynamic Programming
Related Problems 
Easy Triangle 25 %
Medium Binary Tree Maximum Path Sum
 */

public class Minimum_Path_Sum {

}

class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int M = grid.length;
        int N = grid[0].length;
        int[][] sum = new int[M][N];

        sum[0][0] = grid[0][0];

        for (int i = 1; i < M; i++) {
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < N; i++) {
            sum[0][i] = sum[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
            }
        }

        return sum[M - 1][N - 1];
    }
}

/*
 * Minimum Path Sum
￼￼• state: f[x][y]从起点走到x,y的最短路径
• function: f[x][y] = min(f[x-1][y], f[x][y-1]) + A[x][y]
• intialize: f[i][0] = sum(0,0 ~ i,0)
• f[0][i] = sum(0,0 ~ 0,i)
• answer: f[n-1][m-1]
 */

//9ch summer 2016
class solution_minPathSum{
	public int minPathSum(int[][] grid){
		if(grid == null){
			return 0;
		}
		int n = grid.length;
		
		if(grid[0] == null){
			return 0;
		}
		int m = grid[0].length;
		int [][] f = new int[n][m];
		
		//initialize
		f[0][0] = grid[0][0];
		//f[0][0] = 1;// 不用动
		for(int i = 1; i< n ; i++){
			f[i][0] = f[i - 1][0] + grid[i][0];
			//f[i][0] = 1;
		}
		for(int i = 1; i < m; i++){
			f[0][i] = f[0][i - a] + grid[0][i];
			//f[0][i] = 1;
		}
		
		//dp
		for(int i = 1; i < n; i++){
			for(int j = 1; j < m; j++){
				f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
				//f[i][j] = f[i - 1][j] +f[i][j - 1];
			}
		}
		//answer
		return f[n - 1][m - 1];
	}
}