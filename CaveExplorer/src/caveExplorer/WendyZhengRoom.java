package caveExplorer;

public class WendyZhengRoom extends CaveRoomPd8 implements Playable{
	
	private static final String[] SEQ_1 = {"You have been trapped by the Red Queen and her card soldiers!","The queen refuses to let you leave this room", "To unlock the doors and leave, you need to take over the room against the Red Queen's card guards"};
	private static final String[] SEQ_2 = {"You have taken over the dimensional room and returned back to where you were", "Now that you have beat the Red Queen, the doors are now unlocked"};
	private static final String[] SEQ_3 = {"YOu have already been in this room"};
	private static boolean gameFinished = false;
	public static WZSquare[][] board = new WZSquare[4][4];
	public static String whosmove = "P";

	public WendyZhengRoom(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}
	
	public void enter()
	{
		super.enter();
		System.out.println("You are locked in this room");
		if(gameFinished == false)
		{
			readSequence(SEQ_1);
			play();
			readSequence(SEQ_2);
		}
		else
		{
			readSequence(SEQ_3);
			super.leave();
			
		}	
	}
	
	public void interpretAction(String input) {
		while(!isValid(input)){
			CaveExplorer.print("Please enter 'w','a','s', or 'a'");
			input = CaveExplorer.in.nextLine().toLowerCase();
		}
		String[] keys={"w","d","s","a"};
		int indexFound=-1;
		
		for(int i=0;i<keys.length;i++){
			if(keys[i].equals(input)){
				indexFound=i;
				break;
			}
		}
	}

	private boolean isValid(String input) {
		String[] validKeys={"w","a","s","d"};
		for(String key:validKeys){
			if(input.toLowerCase().equals(key))
				return true; 
		}
		return false;
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		
		//Person interaction
		//AI interaction
		//board display dashed lines --> solid lines computer square: X player square: O
		//logic 
		//board = 4*4 
		//inputs? row col Dir OR ask for row, ask for col, ask for dir
		//logic + constraints: line drawn already? how to win? boxed? detection of gameover? keep scoring?
		//cheatcode
		
		for(int row=0;row<board.length;row++){
			for(int col=0;col<board[row].length;col++){
				board[row][col]=new WZSquare(row, col);
			}
		} 
		displayField(board);
			// TODO Auto-generated method stub
			
			if(WendyZhengRoom.whosmove.equals("P"))
			{
				WendyDotBoxPlayer.playerTurn();
			}
			else
			{
				
			}
			
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
		
		/*String boardDis = "*";
		for (WZSquare[] row : board )
		{
			for(int textRow = 0; textRow < 2; textRow ++)
			{
				for(WZSquare square : row)
				{
					if (textRow == 0)
					{
						if(square.sides[0] == false)
						{
							boardDis += "   ";
						}
					} 
					else
					{
						boardDis += "---";
					}
					boardDis += "*";
				}
			}
		}*/ 
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


	
}
	


