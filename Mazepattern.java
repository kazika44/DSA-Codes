package backtracking;

import java.util.ArrayList;
import java.util.Collection;

public class Mazepattern {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean board[][]= {{true,true,true},
							{true,false,true},
							{true,true,true}};
		
		boolean board1[][]= {{true,true,true,true},
							{true,true,false,true},
							{true,true,true,true},
							{true,true,true,true}};
//			System.out.println(mazepatternretDiag("",3,3));
		System.out.println(mazepatternrestriction(board1,"",0,0));
		
	}
	public static void mazepattern(String p,int row , int col)
	{
		
		if(row==1 && col==1)
		{
			System.out.println(p);
			return;
		}
		if(row>1)
			mazepattern(p+"D",row-1,col);
		if(col>1)
			mazepattern(p+"R",row,col-1);
	}
	public static ArrayList<String> mazepatternret(String p,int row , int col)
	{
		
		if(row==1 && col==1)
		{
			ArrayList<String> list=new ArrayList<>();
			list.add(p);
			return list;
		}
		ArrayList<String> newlist= new ArrayList<>();
		if(row>1)
			newlist.addAll(mazepatternret(p+"D",row-1,col));
		if(col>1)
			newlist.addAll(mazepatternret(p+"R",row,col-1));
		
		
		return newlist;
	}
	public static ArrayList<String> mazepatternretDiag(String p,int row , int col)
	{
		
		if(row==1 && col==1)
		{
			ArrayList<String> list=new ArrayList<>();
			list.add(p);
			return list;
		}
		ArrayList<String> newlist= new ArrayList<>();
		if(row>1)
			newlist.addAll(mazepatternretDiag(p+"V",row-1,col));
		if(row>1 && col>1)
			newlist.addAll(mazepatternretDiag(p+"D",row-1,col-1));
		if(col>1)
			newlist.addAll(mazepatternretDiag(p+"H",row,col-1));
		
		
		return newlist;
	}
	
	public static ArrayList<String> mazepatternrestriction(boolean [][] maze,String p,int row , int col)
	{
		
		if(row==maze.length-1 && col==maze[0].length-1)
		{
			ArrayList<String> list=new ArrayList<>();
			list.add(p);
			return list;
		}
		ArrayList<String> newlist= new ArrayList<>();
		if(!maze[row][col])
		{
			return newlist;
		}
		if(row<maze.length-1)
			newlist.addAll(mazepatternrestriction(maze,p+"D",row+1,col));
		if(col<maze[0].length-1)
			newlist.addAll(mazepatternrestriction(maze,p+"R",row,col+1));
		
		
		return newlist;
	}
}
