package ch9.Array;
/*Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
For example, given the following triangle
[     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
Note:Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.*/

//Version 2 : Memorize Search
public class Ch9_120_Triangle3 {
    private int n;
    private int[][] minSum;
    private int[][] triangle;

    private int search(int x, int y) {
        if (x >= n) {
            return 0;
        }
        if (minSum[x][y] != Integer.MAX_VALUE) {
            return minSum[x][y];
        }
        minSum[x][y] = Math.min(search(x + 1, y), search(x + 1, y + 1))
            + triangle[x][y];
        return minSum[x][y];
    }

    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }        
        this.n = triangle.length;
        this.triangle = triangle;
        this.minSum = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                minSum[i][j] = Integer.MAX_VALUE;
            }
        }
        return search(0, 0);
    }
} 