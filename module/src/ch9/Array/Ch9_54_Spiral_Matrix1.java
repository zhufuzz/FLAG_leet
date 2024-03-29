package ch9.Array;
import java.util.*; 
/*Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
For example, Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].*/

// version 1
public class Ch9_54_Spiral_Matrix1{
public ArrayList<Integer> spiralOrder(int[][] matrix) {
	ArrayList<Integer> rst = new ArrayList<Integer>();
	if(matrix == null || matrix.length == 0)  return rst;
	
	int rows = matrix.length;
	int cols = matrix[0].length;
	int count = 0;
	
	while(count * 2 < rows && count * 2 < cols){
		for(int i = count; i < cols-count; i++)
			rst.add(matrix[count][i]);            
		
		for(int i = count+1; i< rows-count; i++)
			rst.add(matrix[i][cols-count-1]);
		// if only one row /col remains
		if(rows - 2 * count == 1 || cols - 2 * count == 1)  
			break;
		
		for(int i = cols-count-2; i>=count; i--)
			rst.add(matrix[rows-count-1][i]);
		
		for(int i = rows-count-2; i>= count+1; i--)
			rst.add(matrix[i][count]);
		
		count++;
	}
	return rst;
}
}