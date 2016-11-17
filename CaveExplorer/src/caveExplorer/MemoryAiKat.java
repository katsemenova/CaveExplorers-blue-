package caveExplorer;

import java.util.Scanner;

public class MemoryAiKat extends MemoryKsJf implements Playable{
//move a lot of the code to main
	public CardJf[] learnedCards;
	public static Scanner in;
	public boolean playerMove;
	public boolean gameDone;
	public int cardOne;
	public int cardTwo;
	private CardJf cardObj1;
	private CardJf cardObj2;
	private int cardsLearned;
	public MemoryAiKat() {
		gameDone=false;
		playerMove=true;
		learnedCards = new CardJf[12];
		cardsLearned=0;
	}
	public void userMove(){
		cardOne=Integer.parseInt(userSelectCard());
		cardTwo=Integer.parseInt(userSelectCard());
		cardObj1=MemoryKsJf.getCard(cardOne);
		cardObj2=MemoryKsJf.getCard(cardTwo);
		checkMatch(cardObj1,cardObj2);
		addCardsLearned(cardObj1,cardObj2);
	}
	public void computerMove(){
		if(checkLearnedForPair()){
			setLearnedPair();
		}else{
			cardObj1=setRandomfromLearned();
			
		}
	}
	private boolean checkLearnedForPair() {
		// TODO Auto-generated method stub
		return false;
	}
	private void addCardsLearned(CardJf card1, CardJf card2) {
		for(int i=0;i<learnedCards.length;i++){
			if(learnedCards[i].getNumIdentifier()!=card1.getNumIdentifier()){
				learnedCards[cardsLearned]=card1;
				cardsLearned++;
				}
			if(learnedCards[i].getNumIdentifier()!=card2.getNumIdentifier()){
				learnedCards[cardsLearned]=card2;
				cardsLearned++;
			}
		}
	}
	private void checkMatch() {
		if(cardObj1.getSymbol().equals(cardObj2.getSymbol())){
			System.out.println("Damn it, you got a pair. My turn now");
			cardObj1.setFlippedOpen(true);
		}else{
			System.out.println("Haha, my turn");
		}
		playerMove=false;
		
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
