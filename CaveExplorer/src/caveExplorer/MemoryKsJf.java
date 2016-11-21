package caveExplorer;

public class MemoryKsJf implements Playable {
	
	public boolean userWon;
	public static MemoryAiKat Ai;
	public static MemorySetUpJf setup;
	public static CardJf[][] cards;
	public static boolean wantCheat;
	private static final String[] INTRO_GAME={"Hahaha! Welcome Alice!",
			"You're finally here! I am the Mad Hatter and I've been waiting for you.",
			"If you want to continue exploring the castle, you have to play a game with me first.", 
			"In this game, we each take turns to match two cards that contain the same symbol.",
			"If the cards that you chose don't match, the order of the cards will be switched.",
			"The game will end ONLY when ALL the cards are matched.","Since your Alice, I'll let you go first."};
	public MemoryKsJf() {
		
	}

	public void play(){
		MemoryAiKat.initialize();
		playScript();
		if(wantCheat){
			System.out.println("Ugh I have to practice. You won, here is your key");
			CaveExplorer.keyGameOne=true;
		}
		else{
			MemorySetUpJf.initialize();
			gameMode();
		}
		
	}
	
	public void playScript(){
		readSequence(INTRO_GAME);
		System.out.println("Are you ready?");
		while(CaveExplorer.in.nextLine().toLowerCase().indexOf("yes")<0){
			CaveExplorer.print("I will not let you continue until you are ready. Type 'yes' when you are ready.");
		}

	}
	public static void readSequence(String[] seq){
		for(String s:seq){
			CaveExplorer.print(s);
			CaveExplorer.print("-----Press Enter------");
			String input = CaveExplorer.in.nextLine();
			if(input=="cheat"){
				wantCheat=true;
				System.out.println("check");
			}
				
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
		figureOutGameStatus();
	}
	private void replay(){
		for(int r=0;r<cards.length;r++){
			for(int c=0;c<cards[r].length;c++){
				System.out.println("replay for loop");
				cards[r][c].setFlippedOpen(false);
				cards[r][c].setLearned(false);
			}
		}
		MemorySetUpJf.resetCards();
		System.out.println("replay exit for loop");
		MemoryAiKat.setUserPairs(0);
		MemoryAiKat.setCompPairs(0);
		MemoryAiKat.playerMove=true;
		MemorySetUpJf.resetCards();
		MemorySetUpJf.updateMap();
		MemorySetUpJf.print(MemorySetUpJf.map);
		gameMode();
	}
	private void figureOutGameStatus(){
		if(MemoryAiKat.getUserPairs()<MemoryAiKat.getCompPairs()){
			System.out.println("Hahahaha I won, if you want to get the key play again...and win");
			System.out.println("We will play again NOW, HAHA, you can't leave until you win. Maybe you will never win?");
			replay();
		}
		else if(MemoryAiKat.getUserPairs()>=MemoryAiKat.getCompPairs()){
			System.out.println("Ugh I have to practice. You won, here is your key");
			CaveExplorer.keyGameOne=true;
		}
	}
	//do we use anywhere?
	protected static boolean cardsLeft() {
		for(int r=0;r<cards.length;r++){
			for(int c=0;c<cards[r].length;c++){
				if(!cards[r][c].isFlippedOpen())
					return true;
			}
		}
		return false;
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
