package backtracking;

public class Maze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println(maze(3,3));
	}
	public static int maze(int row , int col)
	{
		if(row==1 || col==1)
		{
			return 1;
		}
		int count=0;
		int right=maze(row,col-1);
		int down=maze(row-1,col);
		count=right+down;
		return count;
		
	}

}
