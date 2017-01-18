package ch9.Array;
/*Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.
Follow up: Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?*/
// http://blog.csdn.net/xudli/article/details/48896549
public class Ch9_289_Game_of_Life {
    public void gameOfLife(int[][] board) {
        if(board==null || board.length==0 
            || board[0]==null || board[0].length==0) return;        
        int m = board.length;        int n = board[0].length;        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int x = getLiveNum(board, i, j);
                if(board[i][j] == 0) { if(x==3) board[i][j]+=10;
                } else { if(x==2 || x==3) board[i][j]+=10;     
                }
            }
        }        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] /= 10; 
            }
        }
    }
    
    private int getLiveNum(int[][] board, int x, int y) {
        int c=0;
        for(int i=x-1; i<=x+1; i++) {
            for(int j=y-1; j<=y+1; j++) {
                if(i<0 || j<0 || i>board.length-1 
                    || j>board[0].length-1 || (i==x && j==y)) continue;
                if(board[i][j]%10==1) c++;
            }
        }
        return c;
    }
}