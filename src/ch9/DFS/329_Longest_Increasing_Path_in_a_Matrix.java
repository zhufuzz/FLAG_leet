package DFS;//https://www.hrwhisper.me/leetcode-longest-increasing-path-matrix/
/*Given an integer matrix, find the length of the longest increasing path.
From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
Example 1:
nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
] Return 4  The longest increasing path is [1, 2, 6, 9].
Example 2:
nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4  The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.*/
public class 329_Longest_Increasing_Path_in_a_Matrix {
    int []dx = { 1 , -1, 0 , 0  };
    int []dy = { 0 , 0 , 1 , -1 };
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dis = new int [m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs( i, j, m, n, matrix, dis));
            }
        }
        return ans;
    }
 
    int dfs(int x, int y, int m,int n,int[][] matrix, int[][] dis) {
        if (dis[x][y] != 0) return dis[x][y];
 
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < m && ny < n && matrix[nx][ny] > matrix[x][y]) {
                dis[x][y] = Math.max(dis[x][y], dfs(nx, ny, m, n, matrix, dis));
            }
        }
        return ++dis[x][y];
    }
}