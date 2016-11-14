package caveExplorer;

public class CardJf {
	private static String symbol;
	private static boolean flippedOpen;
	private static String numIdentifier;
	
	
	public  CardJf(String num, String sym){
		symbol=sym;
		numIdentifier = num;
		flippedOpen =false;
	}

	public static String getSymbol() {
		return symbol;
	}

	public static void setSymbol(String symbol) {
		CardJf.symbol = symbol;
	}

	public static boolean isFlippedOpen() {
		return flippedOpen;
	}

	public static void setFlippedOpen(boolean flippedOpen) {
		CardJf.flippedOpen = flippedOpen;
	}

	public  String getNumIdentifier() {
		return numIdentifier;
	}

	public static void setNumIdentifier(String numIdentifier) {
		CardJf.numIdentifier = numIdentifier;
	}
}
