package ch9.Array;

import java.util.ArrayList;
import java.util.List;
/*Given a matrix of m x n elements (m rows, n columns), 
 * return all elements of the matrix in spiral order.
For example, Given the following matrix:
[ [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]]
You should return [1,2,3,6,9,8,7,4,5].*/

public class _54_Spiral_Matrix3 {
    /**
     * @param matrix a matrix of m x n elements
     * @return an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        
        // check corner case
        if (matrix == null || matrix.length == 0) {
            return order;
        }
        int n = matrix.length;
        
        if (matrix[0] == null || matrix[0].length == 0) {
            return order;
        }
        int m = matrix[0].length;
        
        int direction = Direction.RIGHT;
        int[] cursor = new int[]{0, 0};
        
        for (int i = 0; i < n * m; i++) {
            order.add(matrix[cursor[0]][cursor[1]]);
            // mark the visited position as -1
            matrix[cursor[0]][cursor[1]] = -1;
            int[] nextCursor = Direction.move(cursor, direction);
            // if outside of matrix or marked before, turn right
            if (nextCursor[0] < 0 || nextCursor[0] >= n ||
                  nextCursor[1] < 0 || nextCursor[1] >= m ||
                  matrix[nextCursor[0]][nextCursor[1]] == -1) {
                direction = Direction.turnRight(direction);
                nextCursor = Direction.move(cursor, direction);
            }
            cursor = nextCursor;
        }
        
        return order;
    }
}