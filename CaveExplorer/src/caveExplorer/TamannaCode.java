package caveExplorer;
import java.util.Scanner;

public class TamannaCode {
	static Scanner input;
	static String user;

	public static String[][] display = TamannaViolettaRoom.contents;
	public static final int NUMBER_OF_BOULDERS = 6;
	private static final String[] ENCOUNTER = {"Oh no, you have stumbled across the Cheshire cat!", "In order to pass him, you will need to answer his riddle correctly.", "If you do not answer him correctly, you will be moved back half the distance from the starting point and there will be two cats placed on the grid.", "Good luck, Alice."};
	private static int randomNum;
	
	private static String[][] riddles = {
			{"Why didn’t the skeleton cross the road?","He didn’t have the guts"},
			{"What is a witch’s favorite subject at school?","Spelling"},
			{"They say you can fear me, and they are not wrong. I am the Ultimate stalker and "
					+ "though you can always see me you’ll never be able to flee from me. What am I?",
					"A shadow"},
			{"Divine as I may seem, up hold my golden. You defend me without a moments notice, "
					+ "but you’re always afraid to break me. A word of caution to the wise, "
					+ "control me or you’ll spend an eternity kneeling and never rise only left "
					+ "to question. Who am I?","Pride"},
			{"What is yours, but others use it more than you do?","My name"},
			{"The more you have of it, the less you see. What is it?","Darkness"},
			{"What gets wetter and wetter, the more it dries?","A towel"},
			{"Love and I don’t always see eye to eye. But when we become the proper mixture "
					+ "we are truly a love mixture. Caution to those who indulge, "
					+ "flames of a whirlwind do enclose. Left without a goodbye, only to ask "
					+ "who am I? ","Lust"}
	};
	
	public static void placeBoulders(){
		//display = new String[ROWS][COLUMNS];
	
		int counter = 0;
		while(counter < NUMBER_OF_BOULDERS){
		    int randRow = (int)(Math.random() * 8) + 1; //1-8
		    int randColumn = (int)(Math.random() * 9) + 1; //1-9
		    if (display[randRow][randColumn].equals(" ")){
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
		int randColumn = (int)(Math.random() * 8) + 1; //1-8
		if (display[randRow][randColumn].equals(" ") && !(display[randRow][randColumn].equals("O"))) {
			display[randRow][randColumn] = "M";
		}
	}
	
	public static void multiplyCat(){
		int count = 0;
		
		while (count < 2){
			int randRow = (int)(Math.random() * 3) + 1; //1-3
			int randColumn = (int)(Math.random() * 8) + 1; //1-8
			if (display[randRow][randColumn].equals(" ") && !(display[randRow][randColumn].equals("O")) 
					&& !(display[randRow][randColumn].equals("M"))) {
				display[randRow][randColumn] = "M";
			}
			count++;
		}
	}
	
	public static boolean TamannaCatRiddle(){
		readSequence(ENCOUNTER);
		randomNum = (int)(Math.random() * 8) + 1;
		
		CaveExplorer.print("The riddle is " + riddles[randomNum][0]);
		user = input.nextLine();
		
		if(user.equals(riddles[randomNum][1])){
			return true;
		}
		return false;
	}
	
	public static void readSequence(String[] seq){
		for(String s:seq){
			CaveExplorer.print(s);
			CaveExplorer.print("-----Press Enter------");
			CaveExplorer.in.nextLine();
		}
	}
}
