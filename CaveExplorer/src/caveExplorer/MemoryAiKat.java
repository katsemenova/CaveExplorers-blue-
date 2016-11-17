package caveExplorer;

import java.util.Scanner;

public class MemoryAiKat extends MemoryKsJf implements Playable{
//move a lot of the code to main

	public static Scanner in;
	public boolean playerMove;
	public boolean gameDone;
	private int cardOne;
	private int cardTwo;
	private CardJf cardObj1;
	private CardJf cardObj2;
	private int userPairs;
	private int compPairs;
	
	public MemoryAiKat() {
		userPairs=0;
		compPairs=0;
		gameDone=false;
		playerMove=true;
	}
	
	public void userMove(){
		//selects which card num to flip
		cardOne=Integer.parseInt(userSelectCard());
		int[] index1=getIndexOfCardNum(cardOne);
		cardObj1=MemoryKsJf.cards[index1[0]][index1[1]];
		MemoryKsJf.cards[index1[0]][index1[1]].setLearned(true);
		
		System.out.println("Card number" + cardOne+"has the symbol" + cardObj1.getSymbol());
		
		int[] index2=getIndexOfCardNum(cardTwo);
		cardObj2=MemoryKsJf.cards[index2[0]][index2[1]];
		cardTwo=Integer.parseInt(userSelectCard());
		MemoryKsJf.cards[index2[0]][index2[1]].setLearned(true);;
		
		System.out.println("Card number" + cardTwo+"has the symbol" + cardObj2.getSymbol());
		
		if(checkMatch()){
			MemoryKsJf.cards[index1[0]][index1[1]].setFlippedOpen(true);
			MemoryKsJf.cards[index2[0]][index2[1]].setFlippedOpen(true);
		}	
	}
	private int[] getIndexOfCardNum(int card) {
		int[] arr=new int[2];
		for(int r=0;r<4;r++){
			for(int c=0;c<3;c++){
				if(Integer.parseInt(MemoryKsJf.cards[r][c].getNumIdentifier())==card){
					arr[0]=r;
					arr[1]=c;
				}
			}
		}
		return arr;
	}

	public void computerMove(){
		int[] arr= setLearnedPair();
		int[] index1;
		int[] index2;
		
		if(arr[0]!=0&&arr[1]!=0){
			index1=getIndexOfCardNum(arr[0]);
			index2=getIndexOfCardNum(arr[1]);
			
			cardObj1=MemoryKsJf.cards[index1[0]][index1[1]];
			cardObj2=MemoryKsJf.cards[index2[0]][index2[1]];
			
			MemoryKsJf.cards[index1[0]][index1[1]].setFlippedOpen(true);
			MemoryKsJf.cards[index2[0]][index2[1]].setFlippedOpen(true);
			System.out.println("Hahaha! You see I got a pair. Cards " + cardObj1.getNumIdentifier()+
					" and "+cardObj1.getNumIdentifier()+" both had " + cardObj1.getSymbol()+". Your turn again.");
			
		}else{
			cardObj1=setRandomfromLearned();
			index2=getIndexOfCardNum(arr[1]);
			cardObj2
			
		}
	}
	private CardJf setRandomfromLearned() {
		int[] learnedNum=new int[12];
		
		for(int r=0;r<MemoryKsJf.cards.length;r++){
			for(int c=0;c<MemoryKsJf.cards[r].length;c++){
				if(MemoryKsJf.cards[r][c].getLearned()&&!MemoryKsJf.cards[r][c].isFlippedOpen()){
					learnedSym[i]=MemoryKsJf.cards[r][c].getSymbol();
					learnedNum[i]=Integer.parseInt(MemoryKsJf.cards[r][c].getNumIdentifier());
				}
			}
		}
		return card;
		
	}

	private int[] setLearnedPair() {
		String[] learnedSym=new String[12];
		int[] learnedNum=new int[12];
		int[] pairNum=new int[2];
		int i=0;
		
		for(int r=0;r<MemoryKsJf.cards.length;r++){
			for(int c=0;c<MemoryKsJf.cards[r].length;c++){
				if(MemoryKsJf.cards[r][c].getLearned()&&!MemoryKsJf.cards[r][c].isFlippedOpen()){
					learnedSym[i]=MemoryKsJf.cards[r][c].getSymbol();
					learnedNum[i]=Integer.parseInt(MemoryKsJf.cards[r][c].getNumIdentifier());
				}
			}
		}
		
		for(int j=0;j<learnedSym.length;j++){
			for(int k=0;k<learnedSym.length;k++){
				if(j!=k&&learnedSym[j].equals(learnedSym[k]))
					pairNum[0]=learnedNum[j];
					pairNum[1]=learnedNum[k];
			}
		}
		return pairNum;
	}
	
	private boolean checkMatch() {
		if(cardObj1.getSymbol().equals(cardObj2.getSymbol())){
			System.out.println("Damn it, you got a pair. My turn now");
			userPairs++;
			return true;
		}else{
			System.out.println("Haha, my turn");
			return false;
		}
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
