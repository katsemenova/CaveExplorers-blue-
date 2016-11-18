package caveExplorer;

public class TamannaCode {
	public static int AliceRow = 0;
	public static int AliceCol = 0;
	public static String[][] display = TamannaViolettaRoom.contents;
	public static final int ROWS = 10;
	public static final int COLUMNS = 10;
	public static final int NUMBER_OF_BOULDERS = 6;
	
	public static void placeBoulders(){
		//display = new String[ROWS][COLUMNS];
	
		int counter = 0;
		while(counter < NUMBER_OF_BOULDERS){
		    int randRow = (int)(Math.random() * 8) + 1; //1-8
		    int randColumn = (int)(Math.random() * 9) + 1; //1-9
		    if (display[randRow][randColumn] == " "){
		        display[randRow][randColumn] = "O";
		        counter++;
		    }
		    
		}
		placeCats();
	}

	public static void placeCats() {
		/*
		 the game starts with boulders already in place
		 place one cat for now
		 
		 when Alice encounters the cat "A" meets "M", then ask a riddle and multiply and go to random places		
		 */
		
		int randRow = (int)(Math.random() * 3) + 1; //1-3
		int randColumn = (int)(Math.random() * 9) + 1; //1-9
		if (display[randRow][randColumn] == " " && !(display[randRow][randColumn] == "O")) {
			display[randRow][randColumn] = "M";
		}
	}
}
