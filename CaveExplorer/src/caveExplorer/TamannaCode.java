package caveExplorer;
import java.util.Scanner;

public class TamannaCode {
	static Scanner input;
	static String user;
	
	public static boolean met = false;
	public static String[][] display = TamannaViolettaRoom.contents;

	public static final int NUMBER_OF_BOULDERS = 6;
	private static final String[] ENCOUNTER = {"Oh no, you have stumbled across "
			+ "the Cheshire cat!", "In order to pass him, you will need to answer "
					+ "his riddle correctly.", "If you do not answer him correctly, "
							+ "you will be moved back half the distance from the "
							+ "starting point and there will be two cats placed "
							+ "on the grid.", "Good luck, Alice."};
	private static final String[] RECAP = {"We meet again Alice. Let's see if you can"
			+ "get this right as well."};
	private static int randomNum;
	
	private static String[][] riddles = {
			{"Why didn’t the skeleton cross the road?","he didn’t have the guts"},
			{"What is a witch’s favorite subject at school?","spelling"},
			{"They say you can fear me, and they are not wrong. I am the Ultimate stalker and "
					+ "though you can always see me you’ll never be able to flee from me. What am I?",
					"a shadow"},
			{"Divine as I may seem, up hold my golden. You defend me without a moments notice, "
					+ "but you’re always afraid to break me. A word of caution to the wise, "
					+ "control me or you’ll spend an eternity kneeling and never rise only left "
					+ "to question. Who am I?","pride"},
			{"What is yours, but others use it more than you do?","my name"},
			{"The more you have of it, the less you see. What is it?","darkness"},
			{"What gets wetter and wetter, the more it dries?","a towel"},
			{"Love and I don’t always see eye to eye. But when we become the proper mixture "
					+ "we are truly a love mixture. Caution to those who indulge, "
					+ "flames of a whirlwind do enclose. Left without a goodbye, only to ask "
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
		while(counter < NUMBER_OF_BOULDERS){
		    int randRow = (int)(Math.random() * 8) + 1; //1-8
		    int randColumn = (int)(Math.random() * 8) + 1; //1-8
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
		if (display[randRow][randColumn].equals(" ") && !(display[randRow][randColumn].equals("O"))){
			display[randRow][randColumn] = "M";
		}
	}
	
	public static void multiplyCat(){
		int newCats = 0;
		
		while (newCats != 2){
			int randRow = (int)(Math.random() * 5) + 4; //4-8
			int randColumn = (int)(Math.random() * 8) + 1; //1-8
			if (display[randRow][randColumn].equals(" ") && 
					!(display[randRow][randColumn].equals("O")) 
					&& !(display[randRow][randColumn].equals("M"))){
						display[randRow][randColumn] = "M";
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
		
		if(answer.equals(user)){
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
