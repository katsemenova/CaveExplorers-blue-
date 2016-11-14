package caveExplorer;

public class ViolettaCode {
	
	public static int[] AliceLocation = {0,0}; //start location
	public static int AliceRow = 0;
	public static int AliceCol = 0;
	public static boolean[][] Boulder = new boolean[10][10]; //temp
	public static boolean[][] Cats;
	public static String[][] display;
	
	public static boolean MovingAroundBoulder;
	public static boolean Left;
	
	public static void playAlice(){
		int numberOfMoves = (int)(Math.random() * 6) + 1;
		System.out.println("The Cheshire Cat is allowing you to move " + numberOfMoves + " spaces");
		moveAlice(numberOfMoves);
	}
	
	public static void moveAlice(int numberOfMoves){
		while(numberOfMoves > 0){
			if(!Left){
				if(AliceCol < display[0].length - 1){
					if(!Boulder[AliceRow][AliceCol]){
						display[AliceRow][AliceCol] = ">";
						AliceCol += 1;
						display[AliceRow][AliceCol] = "A";
					}
					else{ //go around boulder
						MovingAroundBoulder = true;
						
					}
				}
			}
		}
	}
	
	public static void moveAliceBetter(int numberOfMoves){
		while(numberOfMoves > 0){
			if(Left){
				if(AliceCol > 0){//if i can move to the left
					if(!Boulder[AliceRow][AliceCol]){//and if there's no boulder in the way
						display[AliceRow][AliceCol] = "<";
						AliceCol += 1;
						if(Cats[AliceRow][AliceCol]){//if there's a cat in the new space
							if(!catRiddleTamanna()){ //Tamanna's code will return true if player gets the riddle right, false if not
								moveAliceBack();
								numberOfMoves = 0;
							}
						}
						display[AliceRow][AliceCol] = "A";
						numberOfMoves -= 1;
					}
					else{
						numberOfMoves = moveAroundBoulder(numberOfMoves);
					}
				}
				else{
					Left = true;
				}
			}
			if(!Left){
				if(AliceCol < display[0].length - 1){//if i can move to the right
					if(!Boulder[AliceRow][AliceCol]){//and if there's no boulder in the way
						display[AliceRow][AliceCol] = ">";
						AliceCol += 1;
						if(Cats[AliceRow][AliceCol]){//if there's a cat in the new space
							if(!catRiddleTamanna()){ //Tamanna's code will return true if player gets the riddle right, false if not
								moveAliceBack();
								numberOfMoves = 0;
							}
						}
						display[AliceRow][AliceCol] = "A";
						numberOfMoves -= 1;
					}
					else{
						numberOfMoves = moveAroundBoulder(numberOfMoves);
					}
				}
				else{
					Left = true;
					if(){
						
					}
					else{
						
					}
				}
			}
		}
	}
	
	private static int moveAroundBoulder(int numberOfMoves) {
		// TODO Auto-generated method stub
		return 2;
	}

	public static boolean catRiddleTamanna(){
		return true;
	}
	
	public static void moveAliceBack(){
		
	}
}
