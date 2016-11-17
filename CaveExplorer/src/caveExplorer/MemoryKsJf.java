package caveExplorer;

public class MemoryKsJf implements Playable {
	
	public boolean userWon;
	public static MemoryAiKat Ai;
	public static MemorySetUpJf setup;
	public static CardJf[][] cards;
	
	public MemoryKsJf() {
			
		
	}
	
	public void play(){
		MemorySetUpJf.initialize();
		
		gameMode();
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
