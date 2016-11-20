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

	}
	public void enter(){
		//super.enter(); //done to make sure that the X is moved in the actual thing
		
	}
	public void interpretAction(String input){
		
	}
	
	protected static boolean isValid(String input) {
		String[] validKeys={"1","2","3","4","5","6","7","8","9","10","11","12"};
		String ignore="";
		for(int i=0;i<13;i++){
			for(int j=0;j<13;j++){
				if(i==j)
					ignore = "do nothing";
				else if(input.equals(validKeys[i]+"_"+validKeys[j]))
					return true;
			}
		}
		return false;
	}
}
