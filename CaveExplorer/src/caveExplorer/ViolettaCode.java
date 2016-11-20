package caveExplorer;

public class ViolettaCode {
	public static int AliceRow = 0;
	public static int AliceCol = 0;
	public static String[][] display = TamannaViolettaRoom.contents;
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
			if(right && AliceCol < display[0].length - 1 && !display[AliceRow][AliceCol + 1].equals("O")){
				display[AliceRow][AliceCol] = ">";
				AliceCol++; 
			}
			else if(!right && AliceCol > 0 && !display[AliceRow][AliceCol - 1].equals("O")){
				display[AliceRow][AliceCol] = "<";
				AliceCol--; 
			}
//			else if(display[AliceRow+1][AliceCol].equals("O")){
//				
//			}
			else{
				display[AliceRow][AliceCol] = "v";
				AliceRow++;
				right = !right;
			}
			if(display[AliceRow][AliceCol].equals("M")){
				TamannaViolettaRoom.drawGrid();
				if(!TamannaCode.catRiddle()){
					moveAliceBack();
					numberOfMoves = 0;
				}
				System.out.println("Wrong");
			}
			
			if(TamannaViolettaRoom.endGame(AliceRow, AliceCol)){
				System.out.println("You've reached the end. Congrats loser");
				TamannaViolettaRoom.endGame = true;
				numberOfMoves = 0;
			}
			else{
				display[AliceRow][AliceCol] = "A";
				numberOfMoves--; 
			}
		}
		TamannaViolettaRoom.drawGrid();
		
		//this is so that Tamanna can access Alice's location
		TamannaViolettaRoom.MainAliceCol = AliceCol;
		TamannaViolettaRoom.MainAliceRow = AliceRow;
	}


	private static void moveAliceBack() {
		int tempRow = AliceRow / 2; 
		int tempCol = AliceCol / 2;
		display[AliceRow][AliceCol] = " ";
		for(int row = AliceRow; row > tempRow; row--){
			for(int col = 0; col < display[row].length; col++){
				if(!display[row][col].equals("O") && !display[row][col].equals("M")){
					display[row][col] = " ";
				}
			}
		}
		if(tempRow % 2 == 0){
			right = true;
		}
		else{
			right = false;
		}
		if(right){
			for(int col = display[tempRow].length - 1; col > tempCol; col--){
				if(!display[tempRow][col].equals("O") && !display[tempRow][col].equals("M")){
					display[tempRow][col] = " ";
				}
			}
		}
		else{
			for(int col = 0; col < tempCol; col++){
				if(!display[tempRow][col].equals("O") && !display[tempRow][col].equals("M")){
					display[tempRow][col] = " ";
				}
			}
		}
		AliceRow = tempRow;
		AliceCol = tempCol;
		
	}

	private static boolean catRiddle() {
		// TODO Auto-generated method stub
		return false;
	}
		
}
