package caveExplorer;

public class WendyZhengRoom implements Playable{
	//Person interaction
	//AI interaction
	//-board display dashed lines --> solid lines computer square: X player square: O 
	//-board = 4*4 
	//inputs? row col Dir OR ask for row, ask for col, ask for dir
	//logic + constraints: line drawn already? how to win? boxed? detection of gameover? keep scoring?
	//cheatcode
	
	private static final String[] SEQ_1 = {"You have been trapped by the Red Queen and her card soldiers!","The queen refuses to let you leave this room", "To unlock the doors and leave, you need to take over the room against the Red Queen's card guards"};
	private static final String[] SEQ_2 = {"You have won against the Queen", "Now that you have beat the Red Queen, the doors are now unlocked","And you have found the 3rd key"};
	private static final String[] SEQ_3 = {"You Lost!","Please try again to beat the Queen and leave this room"};
	private static final String[] SEQ_4 = {"You have already been in this room"};
	public static boolean gameFinished = false;
	public static WZSquare[][] board = new WZSquare[4][4];
	public static String whosmove = "P";
	
	private static WendyDotBoxPlayer player = new WendyDotBoxPlayer();
	private static ZhengDotBoxAI queen = new ZhengDotBoxAI();
	
	public WendyZhengRoom() {

	}
	
	public void play()
	{
		if(!gameFinished)
		{
			System.out.println("You are locked in this room");
	
			readSequence(SEQ_1);
			initializeBoard();
			
			playGame();
			
			if(checkPlayerWin())
				readSequence(SEQ_2);
			else
			{
				readSequence(SEQ_3);	 
				gameFinished = false;
				play();
			}
		}
		else
			readSequence(SEQ_4);
		
	}
	
	private void initializeBoard()
	{
		for(int row=0;row<board.length;row++)
			for(int col=0;col<board[row].length;col++)
				board[row][col]=new WZSquare(row, col);
	}
	
	public void playGame() {
		
		while(!gameFinished)
		{
			displayField(board);
			
			if(checkGameFinish())
			{
				gameFinished = true;
				CaveExplorer.keyGameThree = true;
			}	
			else
			{
				if(WendyZhengRoom.whosmove.equals("P"))
					player.makeMove();
				else
					queen.makeMove();
			}
		}
		//interpretAction(CaveExplorer.in.nextLine());
		
		
	}
	public static void readSequence(String[] seq){
		for(String s:seq){
			CaveExplorer.print(s);
			CaveExplorer.print("-----Press Enter------");
			CaveExplorer.in.nextLine();
		}
	}
	
	public static void displayField(WZSquare[][] board)
	{
		String display = "*";
		for(WZSquare square : board[0])
			if(square.sides[0] == false)
				display += "   *";
			else
				display += "---*";
		
		display += "\n";
		
		for (WZSquare[] row : board)
			for(int textRow = 0; textRow < 2; textRow ++)
			{
				for(WZSquare square : row)
				{
					String str = "";
					if(textRow == 0)
					{
						if(square.sides[3])
							str += "|";
						else
							str += " ";
						
						str += " "+ square.conquorer +" ";
					}
					else
					{
						if(square.col == 0) 
							str += "*";
						
						if(square.sides[2])
							str += "---*";
						else
							str += "   *";
					}
					display += str;
				}
				
				if(textRow == 0)
					if(row[3].sides[1])
						display += "|";
					else
						display += " ";
				
				display += "\n";	
			}
		System.out.println(display);
		//System.out.println("The Queen had made a move");
	}
	
	public static int oppositeDirection(int dir){
		return (dir+2)%4;
	}
	
	public static void addSharedSide(int row, int col, int side) {
		
		board[row][col].addSide(side);
		board[row][col].squareDec(whosmove);
		
		if(side == 0)
			row--;
		if(side == 1)
			col++;
		if(side == 2)
			row++;
		if(side == 3)
			col--;
		
		if(row >= 0 && row < board.length && col >= 0 && col < board[0].length)
		{
			board[row][col].addSide(oppositeDirection(side));
			board[row][col].squareDec(whosmove);
		}
	}

	public static boolean checkGameFinish()
	{
		for(int row=0;row<board.length;row++)
			for(int col=0;col<board[row].length;col++)
				if(!board[row][col].testForSquare())
					return false;
		 
		return true;
	}
	
	private static int countSquares(String player)
	{
		int squares = 0;
		
		for(int row=0;row<board.length;row++)
			for(int col=0;col<board[row].length;col++)
				if(board[row][col].conquorer.equals(player))
					squares++;
				
		return squares;
	}
	
	private static boolean checkPlayerWin()
	{
		int playerSquares = countSquares("P");
		int queenSquares = countSquares("Q");
		
		if(playerSquares > queenSquares)
			return true;
		
		return false;
	}
}
	


