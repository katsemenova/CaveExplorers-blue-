package caveExplorer;

public class CardKsJb {
	private static String symbol;
	private static boolean flippedOpen;
	private static String numIdentifier;
	
	
	public CardKsJb(String num, String sym){
		symbol=sym;
		numIdentifier = num;
		flippedOpen =false;
	}

	public static String getSymbol() {
		return symbol;
	}

	public static void setSymbol(String symbol) {
		CardKsJb.symbol = symbol;
	}

	public static boolean isFlippedOpen() {
		return flippedOpen;
	}

	public static void setFlippedOpen(boolean flippedOpen) {
		CardKsJb.flippedOpen = flippedOpen;
	}

	public static String getNumIdentifier() {
		return numIdentifier;
	}

	public static void setNumIdentifier(String numIdentifier) {
		CardKsJb.numIdentifier = numIdentifier;
	}
}
