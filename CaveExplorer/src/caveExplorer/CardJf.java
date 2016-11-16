package caveExplorer;

public class CardJf {
	private String symbol;
	private boolean flippedOpen;
	private String numIdentifier;
	
	public CardJf(String symbol,String number){
		this.symbol = symbol;
		this.numIdentifier = number;
		flippedOpen =false;
		//System.out.println(symbol+" and "+ numIdentifier);
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public boolean isFlippedOpen() {
		return flippedOpen;
	}

	public void setFlippedOpen(boolean flippedOpen) {
		this.flippedOpen = flippedOpen;
	}

	public String getNumIdentifier() {
		System.out.println("the num is" +numIdentifier);
		return numIdentifier;
	}

	public void setNumIdentifier(String numIdentifier) {
		this.numIdentifier = numIdentifier;
	}
}