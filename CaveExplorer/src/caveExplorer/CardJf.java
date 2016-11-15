package caveExplorer;

public class CardJf {
	private static String symbol;
	private static boolean flippedOpen;
	private static String numIdentifier;
	
	
	public CardJf(){
		symbol = null;
		numIdentifier = null;
		flippedOpen =false;
		System.out.println(symbol+" and "+ numIdentifier);
	}

	public  String getSymbol() {
		return symbol;
	}

	public  void setSymbol(String symbol) {
		CardJf.symbol = symbol;
	}

	public boolean isFlippedOpen() {
		return flippedOpen;
	}

	public void setFlippedOpen(boolean flippedOpen) {
		CardJf.flippedOpen = flippedOpen;
	}

	public String getNumIdentifier() {
		System.out.println("the num is" +numIdentifier);
		return numIdentifier;
	}

	public void setNumIdentifier(String numIdentifier) {
		CardJf.numIdentifier = numIdentifier;
	}
}
