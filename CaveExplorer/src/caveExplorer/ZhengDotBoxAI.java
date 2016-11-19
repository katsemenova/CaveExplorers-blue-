package caveExplorer;

public class ZhengDotBoxAI implements Player{
	
	private boolean completedSquare;
	private boolean madeMove;
	
	public ZhengDotBoxAI() {
		
	}
	
	public void makeMove() 
	{
		do
		{
			completedSquare = false;
			
			if(!WendyZhengRoom.checkGameFinish())
			{
				madeMove = false;
			
				completeSquare();
				
				if(!madeMove)
					logicalMove();
				if(!madeMove)
					randomMove();
			}
			
		}while(completedSquare);
		
		WendyZhengRoom.whosmove = "P";
	}
	
	private int[] getOpenSides(WZSquare square) {
		
		int sides = numberOfSides(square);
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
					addSide(row, col);
					completedSquare = true;
					
					//System.out.println("complete");
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
			
			if(sides != 4)
			{
				addSide(randRow, randCol);
				madeMove = true;
				
				//System.out.println("random");
			}
				 
		}while(!madeMove);
	}
	
	private void logicalMove()
	{
		boolean madeMove = false;
		int tries = 0;
		
		do
		{
			int randRow = (int)(Math.random() * WendyZhengRoom.board.length);
			int randCol = (int)(Math.random() * WendyZhengRoom.board[0].length);
			
			int sides = numberOfSides(WendyZhengRoom.board[randRow][randCol]);
			
			if(sides != 4 && sides != 2)
			{
				for(int i = 0; i < sides; i++)
				{
					int[] targetSides = getOpenSides(WendyZhengRoom.board[randRow][randCol]);
					int side = targetSides[i];
					int shareRow = randRow;
					int shareCol = randCol;
					
					if(side == 0)
						shareRow--;
					if(side == 1)
						shareCol++;
					if(side == 2)
						shareRow++;
					if(side == 3)
						shareCol--;
					
					if(shareRow >= 0 && shareRow < WendyZhengRoom.board.length && shareCol >= 0 && shareCol < WendyZhengRoom.board[0].length)
					{
						if(numberOfSides(WendyZhengRoom.board[shareRow][shareCol]) != 2)
						{
							addSide(randRow, randCol, side);
							madeMove = true;
							break;
						}
					}
					else
					{
						addSide(randRow, randCol, side);
						madeMove = true;
						break;
					}
				}
				//System.out.println("logical");
			}
			else
			{
				tries++;
				
				if(tries > 20)
					madeMove = true;
			}
		}while(!madeMove);
	}
	
	private void addSide(int row, int col)
	{
		int[] targetSides = getOpenSides(WendyZhengRoom.board[row][col]);
		System.out.println("The queen added a " + toDirection(targetSides[0]) + " card to row: " + row + ", col: " +col);
		WendyZhengRoom.addSharedSide(row, col, targetSides[0]);
		madeMove = true;
	}
	
	private void addSide(int row, int col, int side)
	{
		System.out.println("The queen added a " + toDirection(side) + " card to row: " + row + ", col: " +col);
		WendyZhengRoom.addSharedSide(row, col, side);
		madeMove = true;
	}
	
	private String toDirection(int dir)
	{
		if(dir == 0)
			return "North";
		if(dir == 1)
			return "East";
		if(dir == 2)
			return "South";
		if(dir == 3)
			return "West";
		
		return null;
	}
}
