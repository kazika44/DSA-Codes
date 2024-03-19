package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nqueenleet {
	public static void main(String []args)
	{
		int n=4;
		boolean [][]board=new boolean[n][n];
		List<List<String>> newlist=new ArrayList<>();
		char[][]path=new char[n][n];
		for (int i = 0; i < n; ++i)
		      Arrays.fill(path[i], '.');
		
				newlist=queens(board,0,path,newlist);
				System.out.println(newlist.toString());
		
		
	}
	static List<List<String>> queens(boolean[][] board, int row,char[][] path,List<List<String>> ans) {
        if (row == board.length) {
//            System.out.println();
        	ans.add(display(path));
			return ans;
        }

        // placing the queen and checking for every row and col
        for (int col = 0; col < board.length; col++) {
            // place the queen if it is safe
            if(isSafe(board, row, col)) {
                board[row][col] = true;
                path[row][col]='Q';
				queens(board, row + 1,path, ans);
                board[row][col] = false;
                path[row][col]='.';
            }
            
        }

        return ans;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // check vertical row
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // diagonal left
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if(board[row-i][col-i]) {
                return false;
            }
        }

        // diagonal right
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if(board[row-i][col+i]) {
                return false;
            }
        }

        return true;
    }

    private static List<String> display(char[][] board) {
    	List<String> list=new ArrayList<>();
        for(int i=0;i<board.length;i++) {
            list.add(String.valueOf(board[i]));
            }
		return list;
        }
    }

