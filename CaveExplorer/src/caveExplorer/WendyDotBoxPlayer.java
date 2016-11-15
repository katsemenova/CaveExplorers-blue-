package caveExplorer;

public class WendyDotBoxPlayer{

	static int input = CaveExplorer.in.nextInt();
	public static int boxes = 0;
 
	public static void playerTurn() {
		// TODO Auto-generated method stub
		while(WendyZhengRoom.whosmove.equals("P")) 
		{
			System.out.println("Where is your next move's row?");
			int row = input;

		
			System.out.println("Where is your next move's column?");
			int col = input;
	
		
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

	private static void checkMove(int row, int col, int dir) {
		// TODO Auto-generated method stub
		if(WendyZhengRoom.board[row][col].sides[dir])
		{
			WendyZhengRoom.addSharedSide(row, col, dir);
			if(!WendyZhengRoom.board[row][col].testForSquare())
			{
				WendyZhengRoom.whosmove = "Q";
			}
		}
		else
		{
			System.out.println("This move is not available. Please try again");
			CaveExplorer.in.nextLine();
			playerTurn();
		}
	}

	private static int whatDir(String input2) {
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
