package backtracking;

public class Nknight {

	public static void main(String[] args) {
		int n=4;
		boolean [][] board=new boolean[n][n];
		System.out.println(knight(board, 0,0,4));

	}
	public static int knight(boolean [][]board,int row,int col,int knight)
	{
		if(knight==0)
		{
			display(board);
			System.out.println();
			return 1;
		}
		int count=0;
		if(row==board.length-1 && col==board.length)
		{
			return count;
		}
		if(col==board.length)
		{
			count+=knight(board,row+1,0,knight);
			return count;
		}
		if(isSafe(board,row,col))
		{
			board[row][col]=true;
			count+=knight(board,row,col+1,knight-1);
			board[row][col]=false;
		}
		count+=knight(board,row,col+1,knight);
		return count;
	}
	public static void display(boolean[][] board) {
		for(boolean[] row : board) {
            for(boolean element : row) {
                if (element) {
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
		
	}
	public static boolean isSafe(boolean[][] board, int row, int col) {
		
		if(isValid(board,row-2,col+1))
		{
			if(board[row-2][col+1])
			{
				return false;
			}
		}
		if(isValid(board,row-2,col-1))
		{
			if(board[row-2][col-1])
			{
				return false;
			}
		}
		if(isValid(board,row-1,col-2))
		{
			if(board[row-1][col-2])
			{
				return false;
			}
		}
		if(isValid(board,row-1,col+2))
		{
			if(board[row-1][col+2])
			{
				return false;
			}
		}
		
		return true;
	}
	public static boolean isValid(boolean[][] board, int row, int col) {
		
		if((row>=0 && row<board.length) && (col>=0 && col<board.length))
			return true;
		return false;
	}

}
