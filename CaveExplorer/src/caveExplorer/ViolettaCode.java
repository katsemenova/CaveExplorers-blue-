package caveExplorer;

public class ViolettaCode {
	public static int AliceRow = 0;
	public static int AliceCol = 0;
	public static String[][] display = TamannaViolettaRoom.contents;
	public static boolean right = true;
	public static boolean catEncounter = false;
	private static final String[] ENCOUNTER = {"The Cheshire Cat appears unexpectedly", "He is blocking your path", "'You thought you could slip away from me, Alice?'"};
	
	
	public static void playAlice(){
		int numberOfMoves = (int)(Math.random() * 6) + 1;
		String[] output = new String[1];
		output[0] = "The Chesire Cat is allowing you to move " + numberOfMoves + " spaces.";
		TamannaViolettaRoom.readSequence(output);
		moveAlice(numberOfMoves);
	}


	private static void moveAlice(int numberOfMoves) {
		while(numberOfMoves > 0){
			//get new position
			if(right && AliceCol < display[0].length - 1 && !display[AliceRow][AliceCol + 1].equals("O")){
				display[AliceRow][AliceCol] = ">";
				AliceCol++; 
			}
			else if(!right && AliceCol > 0 && !display[AliceRow][AliceCol - 1].equals("O")){
				display[AliceRow][AliceCol] = "<";
				AliceCol--; 
			}
			else if(display[AliceRow+1][AliceCol].equals("O")){
				sideStepBoulder();
			}
			else{
				display[AliceRow][AliceCol] = "v";
				AliceRow++;
				right = !right;
			}
			
			//check new position status
			if(display[AliceRow][AliceCol].equals("M")){
				TamannaViolettaRoom.drawGrid();
				catEncounter = true;
				if(!TamannaCode.catRiddle()){
					moveAliceBack();
					numberOfMoves = 0;
				}
			}
			
			if(TamannaViolettaRoom.endGame(AliceRow, AliceCol)){
				//System.out.println("You've reached the end. Congrats loser");
				TamannaViolettaRoom.endGame = true;
				numberOfMoves = 0;
			}
			else{
				display[AliceRow][AliceCol] = "A";
				numberOfMoves--; 
			}
		}
		if(!catEncounter && AliceRow >= 5){
			TamannaViolettaRoom.readSequence(ENCOUNTER);
			catPlay(numberOfMoves);
		}
		TamannaViolettaRoom.drawGrid();
		
		//this is so that Tamanna can access Alice's location
		TamannaViolettaRoom.MainAliceCol = AliceCol;
		TamannaViolettaRoom.MainAliceRow = AliceRow;
	}

	public static void catPlay(int numberOfMoves){
		catEncounter = true;
		if(!TamannaCode.catRiddle()){
			moveAliceBack();
			numberOfMoves = 0;
		}
	}
	
	private static void sideStepBoulder(){
		boolean down = false;
		if(right){
			display[AliceRow][AliceCol] = "<";
			while(!down){
				AliceCol--;
				if(display[AliceRow + 1][AliceCol].equals("O")){
					display[AliceRow][AliceCol] = "<";
				}
				else{
					display[AliceRow][AliceCol] = "v";
					AliceRow++;
					right = !right;
					down = true;
				}
			}	
		}
		else{
			display[AliceRow][AliceCol] = ">";
			while(!down){
				AliceCol++;
				if(display[AliceRow + 1][AliceCol].equals("O")){
					display[AliceRow][AliceCol] = ">";
				}
				else{
					display[AliceRow][AliceCol] = "v";
					AliceRow++;
					down = true;
				}
			}
		}
	}


	private static void moveAliceBack() {
		int tempRow = AliceRow / 2; 
		int tempCol = AliceCol / 2;
		display[AliceRow][AliceCol] = " ";
		for(int row = AliceRow; row > -1; row--){
			for(int col = 0; col < display[row].length; col++){
				if(!display[row][col].equals("O") && !display[row][col].equals("M")){
					display[row][col] = " ";
				}
			}
		}
		AliceRow = tempRow;
		AliceCol = tempCol;
		
	}	
}
