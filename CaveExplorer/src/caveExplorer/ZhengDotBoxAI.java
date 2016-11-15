package caveExplorer;

public class ZhengDotBoxAI{
	
	boolean completedSquare;
	
	public ZhengDotBoxAI() {
		
	}
	
	public void makeMove() 
	{
		completedSquare = false;
		
		do
		{
			completeSquare();
			logicalMove();
			randomMove();
			
		}while(completedSquare);
		
		WendyZhengRoom.whosmove = "P";
	}
	
	private int[] getOpenSides(WZSquare square, int sides) {
		int[] openSides = new int[4-sides];
		int idx = 0;
		for(int i = 0; i < square.sides.length; i++)
			if(!square.sides[i])
			{
				openSides[idx] = i;
				idx++;
			}
				
		return openSides;
	}

	private int numberOfSides(WZSquare square)
	{
		int sides = 0;
		for(boolean side: square.sides)
			if(side)
				sides++;
		
		return sides;
	}
	
	private void completeSquare()
	{
		for(int row=0;row<WendyZhengRoom.board.length;row++)
			for(int col=0;col<WendyZhengRoom.board[row].length;col++)
			{
				int sides = numberOfSides(WendyZhengRoom.board[row][col]);
				
				if(sides == 3)
				{
					addSide(row, col, sides);
					completedSquare = true;
					break;
				}
			}
	}
	
	private void randomMove()
	{
		boolean madeMove = false;
		
		do
		{
			int randRow = (int)(Math.random() * WendyZhengRoom.board.length);
			int randCol = (int)(Math.random() * WendyZhengRoom.board[0].length);
			
			int sides = numberOfSides(WendyZhengRoom.board[randRow][randCol]);
			
			if(sides != 0)
			{
				addSide(randRow, randCol, sides);
				madeMove = true;
			}
				
		}while(!madeMove);
		
		completedSquare = false;
	}
	
	private void logicalMove()
	{
		
	}
	
	private void addSide(int row, int col, int sides)
	{
		int[] targetSides = getOpenSides(WendyZhengRoom.board[row][col], sides);
		WendyZhengRoom.addSharedSide(row, col, targetSides[0]);
	}
}
