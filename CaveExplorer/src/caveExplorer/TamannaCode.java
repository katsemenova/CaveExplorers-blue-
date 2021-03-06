package caveExplorer;
import java.util.Scanner;

public class TamannaCode {
	public static int randRow;
	public static int randCol;
	
	static Scanner input;
	static String user;
	
	public static boolean met = false;
	public static String[][] display = TamannaViolettaRoom.contents;

	public static final int NUMBER_OF_TREES = 6;
	private static final String[] ENCOUNTER = {"Oh no, you have stumbled across "
			+ "the Cheshire cat!", "In order to pass him, you will need to answer "
					+ "his riddle correctly.", "If you do not answer him correctly, "
							+ "you will be moved back half the distance from the "
							+ "starting point and there will be two cats placed "
							+ "on the grid.", "Good luck, Alice."};
	private static final String[] RECAP = {"We meet again Alice. Let's see if you can"
			+ " get this right."};
	private static int randomNum;
	
	private static String[][] riddles = {
			{"Why didn't the skeleton cross the road?","he didn't have the guts"},
			{"What is a witch's favorite subject at school?","spelling"},
			{"They say you can fear me, and they are not wrong. I am the Ultimate \n stalker and "
					+ "though you can always see me you'll never be able to \n flee from me. What am I?",
					"a shadow"},
			{"Divine as I may seem, up hold my golden. You defend me without a \n moments notice, "
					+ "but you're always afraid to break me. A word of caution \n to the wise, "
					+ "control me or you'll spend an eternity kneeling and \n never rise only left "
					+ "to question. Who am I?","pride"},
			{"What is yours, but others use it more than you do?","my name"},
			{"The more you have of it, the less you see. What is it?","darkness"},
			{"What gets wetter and wetter, the more it dries?","a towel"},
			{"Love and I don't always see eye to eye. But when we become \n the proper mixture "
					+ "we are truly a love mixture. Caution to those who \n indulge, "
					+ "flames of a whirlwind do enclose. Left without a \n goodbye, only to ask "
					+ "who am I? ","lust"}
	};
	
	public static void catConvo(){
		if(!met){
			readSequence(ENCOUNTER);
			met = true;
		}
		else{
			readSequence(RECAP);
		}
	}
	
	public static void placeBoulders(){
		int counter = 0;
		while(counter < NUMBER_OF_TREES){
		    randRow = (int)(Math.random() * 8) + 1;
		    randCol = (int)(Math.random() * 8) + 1;
		    if (checkNearbySpaces(randRow, randCol) && display[randRow][randCol].equals(" ")){
		        display[randRow][randCol] = "O";
		        counter++;
		    }
		}
		placeCats();
	}

	private static boolean checkNearbySpaces(int randRow2, int randCol2) {
		if(display[randRow2][randCol2 + 1].equals(" ") && 
				display[randRow2][randCol2 - 1].equals(" ") && 
				display[randRow2 + 1][randCol2].equals(" ") && 
				display[randRow2 - 1][randCol2].equals(" ")){
					return true;
		}
		return false;
	}

	public static void placeCats() {
		int randomRow = (int)(Math.random() * 3) + 1; //1-3
		int randColumn = (int)(Math.random() * 8) + 1; //1-8
		if (checkNearbySpaces(randomRow, randColumn) && 
				display[randomRow][randColumn].equals(" ") && 
				!(display[randomRow][randColumn].equals("O"))){
			display[randomRow][randColumn] = "M";
		}
	}

	public static void multiplyCat(){
		int newCats = 0;
		
		while (newCats != 2){
			int randomRow = (int)(Math.random() * 8) + 1; //1-8
			int randColumn = (int)(Math.random() * 8) + 1; //1-8
			if (checkNearbySpaces(randomRow, randColumn) &&
					display[randomRow][randColumn].equals(" ") && 
					!(display[randomRow][randColumn].equals("O")) 
					&& !(display[randomRow][randColumn].equals("M"))){
						display[randomRow][randColumn] = "M";
						newCats++;
			}
		}
	}	
	
	public static String userInput(){
		input = new Scanner(System.in);
		user = "";
		
		String userInput = input.nextLine();
		return userInput;
	}
	
	public static boolean catRiddle(){
		catConvo();
		randomNum = (int)(Math.random() * 8);
		
		CaveExplorer.print("The riddle is " + "' " + riddles[randomNum][0] + " '");
		user = userInput().toLowerCase();
		String answer = riddles[randomNum][1];
		
		if(user.equals(answer) || user.equals("cheat")){
			System.out.println("That was correct.");
			return true;
		}
		else{
			System.out.println("That was incorrect.");
			multiplyCat();
			return false;
		}
	}
	
	public static void readSequence(String[] seq){
		for(String s:seq){
			CaveExplorer.print(s);
			CaveExplorer.print("-----Press Enter------");
			CaveExplorer.in.nextLine();
		}
	}
}
