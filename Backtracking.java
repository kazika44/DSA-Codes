package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Backtracking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean board[][] = { 	{ true, false, true }, 
								{ true, true, true }, 
								{ true, true, true } };
		
		boolean board1[][] = {  { true, true, true, true }, 
								{ true, true, true, true }, 
								{ true, true, true, true },
								{ true, true, true, true } };
		
		int[][] path = new int[board.length][board[0].length];
//System.out.println(mazepatternretDiag("",3,3));
		backtrackingpath(board, "", 0, 0, path, 1);
	}

	private static ArrayList<String> backtracking(boolean[][] maze, String p, int row, int col) {

		if (row == maze.length - 1 && col == maze[0].length - 1) {
			ArrayList<String> list = new ArrayList<>();
			list.add(p);
			return list;
		}
		ArrayList<String> newlist = new ArrayList<>();
		if (!maze[row][col]) {
			return newlist;
		}
		// i am considering this block in my path
		maze[row][col] = false;
		if (row < maze.length - 1)
			newlist.addAll(backtracking(maze, p + "D", row + 1, col));
		if (col < maze[0].length - 1)
			newlist.addAll(backtracking(maze, p + "R", row, col + 1));
		if (row > 0)
			newlist.addAll(backtracking(maze, p + "U", row - 1, col));
		if (col > 0)
			newlist.addAll(backtracking(maze, p + "L", row, col - 1));

		// this line is where the function will be over
		// so before the function gets removed, also remove the changes that were made
		// by that function
		maze[row][col] = true;
		return newlist;
	}

	private static void backtrackingpath(boolean[][] maze, String p, int row, int col, int[][] path, int step) {

		if (row == maze.length - 1 && col == maze[0].length - 1) {
			path[row][col] = step;
			for (int[] arr: path) {
					System.out.println(Arrays.toString(arr));
			}
			System.out.println(p);
			System.out.println();
			return;
		}
		
//		ArrayList<String> newlist= new ArrayList<>();
		if (!maze[row][col]) {
			return;
		}
		// i am considering this block in my path
		maze[row][col] = false;
		path[row][col] = step;
		if (row < maze.length-1)
			backtrackingpath(maze, p + "D", row + 1, col, path, step + 1);
		if (col < maze[0].length-1)
			backtrackingpath(maze, p + "R", row, col + 1, path, step + 1);
		if (row > 0)
			backtrackingpath(maze, p + "U", row - 1, col, path, step + 1);
		if (col > 0)
			backtrackingpath(maze, p + "L", row, col - 1, path, step + 1);

		// this line is where the function will be over
		// so before the function gets removed, also remove the changes that were made
		// by that function
		maze[row][col] = true;
		path[row][col] = 0;

	}
	
	

}
