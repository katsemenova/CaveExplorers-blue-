package caveExplorer;

import java.util.Scanner;

public class CaveExplorer {
	public static CaveRoomPd8[][] caves;
	public static Scanner in;
	public static CaveRoomPd8 currentRoom;
	public static InventoryNockles inventory;
	
	public static void main(String[] args){
		in=new Scanner(System.in);
		caves = new CaveRoomPd8[5][6];
		 
		for(int row=0;row<caves.length;row++){
			for(int col=0;col<caves[row].length;col++){
				caves[row][col]=new CaveRoomPd8("This room has coordinates "+row+" ,"+col);
			}
		}
		//add all Event rooms
		currentRoom = caves[4][4];

		caves[4][4].setConnection(CaveRoomPd8.EAST, caves[4][5],new Door());
		//caves[3][4]=new EventRoom("This is where you found the first key", new MemoryKsJf());
		caves[2][5]=new EventRoom("This is where you found the second key", new WendyZhengRoom());
		//caves[1][0]=new EventRoom("This is where you found the third key", new );
		//caves[0][1]=new EventRoom("This is the exit", new );
		caves[4][5]=new EventRoom("This is where you found the map", new GameStartEvent());
		currentRoom.enter();
		inventory=new InventoryNockles(caves);
		startExploring();
	}

	private static void setAllDoors() {
		for(int row=0;row<caves.length;row++){
			for(int col=0;col<caves[0].length-1;col++){
				caves[row][col].setConnection(CaveRoomPd8.EAST, caves[row][col+1],new Door());
			}
		}
		//caves[0][0].setConnection(CaveRoomPd8.SOUTH, caves[1][0],new Door());
		for(int col=0;col<caves[0].length;col++){
			for(int row=0;row<(caves.length-1);row++){
				caves[row][col].setConnection(CaveRoomPd8.SOUTH, caves[row+1][col],new Door());
			}
		}
	}

	private static void startExploring() {
		while(true){
			print(inventory.getDescription());
			print(currentRoom.getDescription());
			print("What would you like to do?");
			String input =in.nextLine();
			
			act(input);
			
		}
	}
	private static void act(String input) {
		setAllDoors();
		currentRoom.interpretAction(input);
		
		
	}

	public static void print(String text){
		System.out.println(text);
	}
	
}
