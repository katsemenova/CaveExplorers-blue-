package caveExplorer;

public class CardJf {
	private String symbol;
	private boolean flippedOpen;
	private String numIdentifier;
	private boolean learned;
	
	
	public CardJf(String symbol,String number){
		this.symbol = symbol;
		this.numIdentifier = number;
		flippedOpen =false;
		learned=false;
		//System.out.println(symbol+" and "+ numIdentifier);
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public boolean getLearned() {
		return learned;
	}

	public void setLearned(boolean learned) {
		this.learned = learned;
	}

	public boolean isFlippedOpen() {
		return flippedOpen;
	}

	public void setFlippedOpen(boolean flippedOpen) {
		this.flippedOpen = flippedOpen;
	}

	public String getNumIdentifier() {
		
		return numIdentifier;
	}

	public void setNumIdentifier(String numIdentifier) {
		this.numIdentifier = numIdentifier;
	}
}