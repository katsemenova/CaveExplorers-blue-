package caveExplorer;

public class ViolettaCode {
	public static int AliceRow = 0;
	public static int AliceCol = 0;
	public static String[][] display;
	public static boolean right = true;
	
	public static void playAlice(){
		int numberOfMoves = (int)(Math.random() * 6) + 1;
		String[] output = new String[1];
		output[0] = "The Chesire Cat is allowing you to move " + numberOfMoves + " spaces.";
		TamannaViolettaRoom.readSequence(output);
		moveAlice(numberOfMoves);
	}


	private static void moveAlice(int numberOfMoves) {
		while(numberOfMoves > 0){
			if(right && AliceCol < display[0].length && !display[AliceRow][AliceCol].equals("O")){
				display[AliceRow][AliceCol] = ">";
				AliceCol++; //is this right
			}
			else if(AliceCol > 0 && !display[AliceRow][AliceCol].equals("O")){
				display[AliceRow][AliceCol] = "<";
				AliceCol--; //is this right
			}
			else{
				display[AliceRow][AliceCol] = "v";
				AliceRow++;
				right = true;
			}
			if(display[AliceRow][AliceCol].equals("M")){
				if(!TamannaCatRiddle()){
					moveAliceBack();
					numberOfMoves = 0;
				}
			}
			numberOfMoves--; 
		}
	}


	private static void moveAliceBack() {
		// TODO Auto-generated method stub
		
	}


	private static boolean TamannaCatRiddle() {
		// TODO Auto-generated method stub
		return false;
	}
		
}
