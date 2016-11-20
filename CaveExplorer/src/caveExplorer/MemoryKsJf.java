package caveExplorer;

public class MemoryKsJf implements Playable {
	
	public boolean userWon;
	public static MemoryAiKat Ai;
	public static MemorySetUpJf setup;
	public static CardJf[][] cards;
	private static final String[] INTRO_GAME={"Hahaha! Welcome Alice! You're finally here! I've been waiting for you.","If you want to continue exploring the castle, you have to play a game with me.", "In this game, we each take turns to match two cards that contain the same symbol.","If the cards  don't match, the order of the cards will be switched.","The game will end ONLY when ALL the cards are matched.","Since your Alice, I'll let you go first."};
	
	public MemoryKsJf() {
		
	}

	public void play(){
		MemoryAiKat.initialize();
		playScript();
		MemorySetUpJf.initialize();
		
		gameMode();
	}
	
	public void playScript(){
		readSequence(INTRO_GAME);
		System.out.println("Are you ready?");
		while(CaveExplorer.in.nextLine().toLowerCase().indexOf("yes")<0){
			CaveExplorer.print("I will not let you continue until you are ready.");
		}

	}
	public static void readSequence(String[] seq){
		for(String s:seq){
			CaveExplorer.print(s);
			CaveExplorer.print("-----Press Enter------");
			CaveExplorer.in.nextLine();
		}
	}

	public static CardJf getCard(int number){
		for(int row=0;row<MemorySetUpJf.cards.length;row++){
			for(int col=0;col<MemorySetUpJf.cards[row].length;col++){
				int tempCard=Integer.parseInt(MemorySetUpJf.cards[row][col].getNumIdentifier());
				if(number==tempCard){
					return MemorySetUpJf.cards[row][col];
				}
			}
		}
		return null;
	}
	private void gameMode() {
		while(cardsLeft()){
			if(MemoryAiKat.playerMove==true){
				MemoryAiKat.userMove();
			}
			else{
				MemoryAiKat.computerMove();
			}	
			MemorySetUpJf.updateMap();
			MemorySetUpJf.print(MemorySetUpJf.map);
		}
		if(MemoryAiKat.getUserPairs()<MemoryAiKat.getCompPairs()){
			System.out.println("Hahahaha I won, if you want to get the key play again...and win");
		}
		else if(MemoryAiKat.getUserPairs()>=MemoryAiKat.getCompPairs()){
			System.out.println("Ugh I have to practice. You won, here is your key");
		}
	}
	private boolean cardsLeft() {
		for(int r=0;r<cards.length;r++){
			for(int c=0;c<cards[r].length;c++){
				if(!cards[r][c].isFlippedOpen())
					return true;
			}
		}
		return false;
	}

	public void enter(){
		//super.enter(); //done to make sure that the X is moved in the actual thing
		
	}
	public void interpretAction(String input){
		
	}
	
	protected static boolean isValid(String input) {
		String[] validKeys={"1","2","3","4","5","6","7","8","9","10","11","12"};
		for(String key:validKeys){
			if(input.toLowerCase().equals(key))
				return true; 
		}
		return false;
	}
}
