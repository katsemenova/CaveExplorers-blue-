package caveExplorer;

import java.util.Scanner;

public class WendyDotBoxPlayer implements Player{

	public static Scanner input = new Scanner(System.in);
	public static String cheat = "Donut";
 
	public void makeMove() {
		// TODO Auto-generated method stub
		while(WendyZhengRoom.whosmove.equals("P") && WendyZhengRoom.checkGameFinish() == false ) 
		{
			if(input.nextLine().equals(cheat))
			{
				cheat();
				break;
			} 
			else
			{ 
				System.out.println("Where is your next move's row?");
				int row = checkNum();
				while(row == -1)
				{
					System.out.println("Please try a number");
					row = checkNum();
				}
				while(row > WendyZhengRoom.board.length)
				{
					System.out.println("Please pick a row within 0 and 3");
					row = input.nextInt();
				}
			
				System.out.println("Where is your next move's column?");
				int col = checkNum();
				while(col == -1)
				{
					System.out.println("Please try a number");
					col = checkNum();
				}
				while(col > WendyZhengRoom.board[0].length)
				{
					System.out.println("Please pick a col within 0 and 3");
					col = input.nextInt();
				}
		
				System.out.println("What is your next move's direction? (north,east,south,west)");
				int dir = whatDir(CaveExplorer.in.nextLine().toLowerCase());
				while(dir < 0)
				{
					System.out.println("Please enter a valid direction ");
					dir = whatDir(CaveExplorer.in.nextLine().toLowerCase());
				}
			
				checkMove(row,col,dir);
			}
				
		}
	}

	private void cheat() {
		// TODO Auto-generated method stub
		WendyZhengRoom.gameFinished = true;
		WendyZhengRoom.cheat = true;
	}

	private int checkNum()
	{
		String something = input.nextLine();
		for(int i = 0; i < WendyZhengRoom.board.length; i++)
		{
			if(something.equals("" + i))
			{
				return i;
			}
		}
		return -1;
	}
	private void checkMove(int row, int col, int dir) {
		// TODO Auto-generated method stub
		if(!WendyZhengRoom.board[row][col].sides[dir])
		{
			WendyZhengRoom.addSharedSide(row, col, dir);
			
			if(!WendyZhengRoom.board[row][col].testForSquare())
			{
				WendyZhengRoom.whosmove = "Q"; 
			}
			else
			{
				WendyZhengRoom.displayField(WendyZhengRoom.board);
			}
		}
		else
		{
			System.out.println("This move is not available. Please try again <--press enter-->");
			CaveExplorer.in.nextLine();
			makeMove();
		}
	}

	private int whatDir(String input2) {
		// TODO Auto-generated method stub
		if(input2.equals("north"))
		{
			return 0;
		}
		if(input2.equals("east")) 
		{
			return 1;
		}
		if(input2.equals("south"))
		{
			return 2;
		}
		if(input2.equals("west"))
		{
			return 3;
		}
		return -1;
	}



}
