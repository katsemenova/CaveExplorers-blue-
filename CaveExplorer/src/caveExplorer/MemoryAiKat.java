package caveExplorer;

import java.util.Scanner;

public class MemoryAiKat extends MemoryKsJf implements Playable{

	public String[][] learnedCards;
	public static Scanner in;
	public boolean playerMove;
	public boolean gameDone;
	public int cardOne;
	public int cardTwo;
	public MemoryAiKat() {
		gameDone=false;
		playerMove=true;
	}
	public void userMove(){
		cardOne=Integer.parseInt(userSelectCard());
		cardTwo=Integer.parseInt(userSelectCard());
	}
	private String userSelectCard(){
		System.out.println("Please type the digit of the first card you are selecting");
		String input =in.nextLine();
		while(!MemoryKsJf.isValid(input)){
			System.out.println("That's not a valid input. Please type the digit of the first card you are selecting");
			input =in.nextLine();
		}
		return input;
	}
}
