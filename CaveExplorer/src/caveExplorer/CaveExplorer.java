package caveExplorer;

import java.util.Scanner;

public class CaveExplorer {
	public static CaveRoomPd8[][] caves;
	public static Scanner in;
	public static CaveRoomPd8 currentRoom;
	public static InventoryNockles inventory;
	public static boolean keyGameOne;
	public static boolean keyGameTwo;
	public static boolean keyGameThree;
	
	public static void main(String[] args){
		keyGameOne=false;
		keyGameTwo=false;
		keyGameThree=false;
		in=new Scanner(System.in);
		caves = new CaveRoomPd8[5][6];
		 
		for(int row=0;row<caves.length;row++){
			for(int col=0;col<caves[row].length;col++){
				caves[row][col]=new CaveRoomPd8("This room has coordinates "+row+" ,"+col);
			}
		}
		//jadd all Event rooms
		currentRoom = caves[4][4];

		caves[4][4].setConnection(CaveRoomPd8.EAST, caves[4][5],new Door());
		caves[3][1]=new EventRoom("This is where you found the first key", new MemoryKsJf());//cheat code = 
		caves[4][5]=new EventRoom("This is where you found the map", new GameStartEvent());
		caves[1][5]=new EventRoom("This is where you found the third key", new WendyZhengRoom());//cheat code = donut
		caves[2][0]=new EventRoom("This is where you found the second key", new TamannaViolettaRoom());//cheat code = cheat
		caves[0][1]=new EventRoom("This is the exit", new GameEndEvent());
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
