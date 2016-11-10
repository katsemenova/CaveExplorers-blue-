package caveExplorer;

public class WendyZhengRoom extends CaveRoomPd8 implements Playable{
	
	private static final String[] SEQ_1 = {""};
	private static final String[] SEQ_2 = {""};
	private static final String[] SEQ_3 = {""};
	private static boolean gameFinished = false;


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
		goToRoom(indexFound);
		
	}

	private void goToRoom(int indexFound) {
		if(borderingRooms[indexFound]!= null&&doors[indexFound]!=null&&doors[indexFound].isOpen()){
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom=borderingRooms[indexFound];
			CaveExplorer.currentRoom.enter();
			CaveExplorer.inventory.updateMap();
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
		

	}
	public static void readSequence(String[] seq){
		for(String s:seq){
			CaveExplorer.print(s);
			CaveExplorer.print("-----Press Enter------");
			CaveExplorer.in.nextLine();
		}
	}
}
	


