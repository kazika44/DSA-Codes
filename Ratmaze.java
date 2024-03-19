package backtracking;

public class Ratmaze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int board[][] = { 	{ 1, 0, 0, 0 }, 
							{ 1, 1, 0, 0 }, 
							{ 0, 1, 0, 0 },
							{ 1, 1, 1, 1}};
		ratmaze(board,0,0,"");
	}
	public static void ratmaze(int [][]board, int row , int col,String p)
	{
		if(board[row][col]==0)
		{
			return;
		}
		if(row==board.length-1 && col==board.length-1)
		{
			System.out.println(p);
			return;
		}
		if(board[row][col]==0)
		{
			return;
		}
		board[row][col]=0;
		if(col<board[0].length-1)
		{
			ratmaze(board,row,col+1,p+"R");
		}
		if(row<board.length-1)
		{
			ratmaze(board,row+1,col,p+"D");
		}
		if(row>0)
		{
			ratmaze(board,row-1,col,p+"U");
		}
		if(col>0)
		{
			ratmaze(board,row,col-1,p+"L");
		}
		board[row][col]=1;
	}

}
