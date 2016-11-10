package caveExplorer;

public class WendyZhengRoom extends CaveRoomPd8 implements Playable{

	public WendyZhengRoom(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}
	
	public void enter()
	{
		super.enter();
		System.out.println("You are locked in this room");
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

}
