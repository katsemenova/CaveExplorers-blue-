package caveExplorer;

public class MemoryKsJf extends CaveRoomPd8 {

	public CardKsJb[][] cards;
	public String[][] learnedCards; //will be length 12, the first [] is the number, the second[] is the symbol 
	public String[] symbols={"#","#","@","@","*","*","?","?","!","!","%","%"};
	public MemoryKsJf(String description) {
		super(description);
		// TODO Auto-generated constructor stub
		drawCards();
	}
	private void drawCards() {
		cards = new CardKsJb[3][4];
		int count=1;
		for(int row=0;row<cards.length;row++){
			for(int col=0;col<cards[row].length;col++){
				String sym=setSymbol();
				String countToString=""+count;
				cards[row][col]=new CardKsJb(countToString,sym);
				count++;
			}
		}
	}
	private String setSymbol() {
		int num=(int)(Math.random()*12);
		String result = null;
		boolean isValid=false;
		while(!isValid){
			if(symbols[num].equals("")){
				num=(int)(Math.random()*12);
			}else{
				result=symbols[num];
				symbols[num]="";
			}	
		}
		return result;
		
	}
	public void enter(){
		super.enter(); //done to make sure that the X is moved in the actual thing
		
	}
	
	public void interpretAction(String input){
		
	}
	
	private boolean isValid(String input) {
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
