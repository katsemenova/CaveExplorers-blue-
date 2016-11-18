package caveExplorer;

//import arrays.CaveRoomPd8;
//import arrays.Playable;
//import arrays.coordinates;

public class TamannaViolettaRoom implements Playable{
	
	public static boolean played = false;
	public static int MainAliceRow = 0; //i renamed them main to distinguish from my use of them in my code
	public static int MainAliceCol = 0;
	public static boolean endGame = false;
	
	public TamannaViolettaRoom(){
		
	}
	
	private static final String[] INTRO = {"You have stumbled upon the dwellings of the Cheshire Cat.", "He occupies this part of Wonderland and will bother with you with riddles until you reach the end.", "Be wary, do not answer his riddles incorrectly or else he will send you backwards.", "He will only permit you to walk a certain amount of steps at a time."};
	private static final String[] RECAP = {"Answer all of the riddle correctly or else you will never leave."};
	
	public static String[][] contents; 
	
	//boulder = "O"
	//Alice = "A"
	//cat = "M"
	//cat does not appear behind Alice, only in frontt
	
	public void play(){
		if(!played){
			readSequence(INTRO);
			played = true;
		}
		else{
			readSequence(RECAP);
		}
		contents = new String[10][10];
		initializeGrid();
		
		TamannaCode.placeBoulders();
		//TamannaCode.placeCats();
		drawGrid();
	
		//Tamanna.class.place boulders
		//Tamanna place first cat
		
		while(!endGame){
			ViolettaCode.playAlice();
		}
	
	}
	
	public static void initializeGrid(){
		for(int row = 0; row < contents.length; row++){
			for(int col = 0; col < contents[row].length; col++){
				contents[row][col] = " ";
			}
		}
		contents[0][0] = "A";
		contents[9][0] = "X";
	}
	
	public static void drawGrid(){
		int row = contents.length;
		int col = contents[0].length;
		for(int c = 0; c < col; c++){
			System.out.print(" _ _ _");
		}
		for(int r = 0; r < row; r++){
			System.out.print("\n");
			for(int i = 0; i < 3; i++){
				if(i == 2){
					for(int c = 0; c < col; c++){
						System.out.print("|_ _ _");
					}
					System.out.print("|");
				}
				else{
					for(int c = 0; c < col; c++){
						if(i == 1){
							System.out.print("|  " + contents[r][c] + "  ");
						}
						else{
							System.out.print("|     ");
						}
					}
				System.out.print("| \n");
				}
			}
		}
		System.out.print("| \n");
	}
	
	public static void tvCheatCode(){
		
	}
	
	public static boolean endGame(int row, int col){
		if(col == 0 && row == 9){
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
