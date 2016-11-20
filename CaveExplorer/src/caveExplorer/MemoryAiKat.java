package caveExplorer;

import java.util.Scanner;

public class MemoryAiKat extends MemoryKsJf implements Playable{
//move a lot of the code to main

	public static Scanner in;
	public static boolean playerMove;
	public static boolean gameDone;
	private static int cardOne;
	private static int cardTwo;
	private static CardJf cardObj1;
	private static CardJf cardObj2;
	private static int userPairs;
	private static int compPairs;
	
	public static void initialize() {
		setUserPairs(0);
		setCompPairs(0);
		gameDone=false;
		playerMove=true;
		in=new Scanner(System.in);
	}
	
	public static void userMove(){
		//selects which card num to flip
		cardOne=Integer.parseInt(userSelectCard());
		int[] index1=getIndexOfCardNum(cardOne);
		cardObj1=MemoryKsJf.cards[index1[0]][index1[1]];
		MemoryKsJf.cards[index1[0]][index1[1]].setLearned(true);
		
		System.out.println("Card number " + cardOne+" has the symbol " + cardObj1.getSymbol());
		
		cardTwo=Integer.parseInt(userSelectCard());
		int[] index2=getIndexOfCardNum(cardTwo);
		cardObj2=MemoryKsJf.cards[index2[0]][index2[1]];
		MemoryKsJf.cards[index2[0]][index2[1]].setLearned(true);;
		
		System.out.println("Card number " + cardTwo+" has the symbol " + cardObj2.getSymbol());
		
		if(checkMatch()){
			MemoryKsJf.cards[index1[0]][index1[1]].setFlippedOpen(true);
			MemoryKsJf.cards[index2[0]][index2[1]].setFlippedOpen(true);
			System.out.println("\nYou got a pair");
			setUserPairs(getUserPairs() + 1);
		}else{
			System.out.println("\nHaha, you didn't get a pair.");
		}
		playerMove=false;
	}
	private static int[] getIndexOfCardNum(int card) {
		int[] arr=new int[2];
		for(int r=0;r<MemoryKsJf.cards.length;r++){
			for(int c=0;c<MemoryKsJf.cards[r].length;c++){
				if(Integer.parseInt(MemoryKsJf.cards[r][c].getNumIdentifier())==card){
					arr[0]=r;
					arr[1]=c;
				}
			}
		}
		return arr;
	}

	public static void computerMove(){
		String[] arr= setLearnedPairIndex();
		int[] index1;
		int[] index2;
		
		if(!arr[1].equals("")&&!arr[0].equals("")){
			System.out.println("not random");
			index1=getIndexOfCardNum(Integer.parseInt(arr[0]));
			index2=getIndexOfCardNum(Integer.parseInt(arr[1]));
			
			cardObj1=MemoryKsJf.cards[index1[0]][index1[1]];
			cardObj2=MemoryKsJf.cards[index2[0]][index2[1]];
			
			MemoryKsJf.cards[index1[0]][index1[1]].setFlippedOpen(true);
			MemoryKsJf.cards[index2[0]][index2[1]].setFlippedOpen(true);
			System.out.println("Hahaha! You see I got a pair. Cards " + cardObj1.getNumIdentifier()+
					" and "+cardObj2.getNumIdentifier()+" both had " + cardObj1.getSymbol()+". Your turn again.");
			
		}else{
			//settingCards
			System.out.println("random");
			index1 = getIndexOfCardNum(getNumIdentFromLearned());
			cardObj1=MemoryKsJf.cards[index1[0]][index1[1]];
			
			index2=getIndexOfCardNum((int)(Math.random()*12));
			cardObj2=MemoryKsJf.cards[index2[0]][index2[1]];
			
			while(cardObj2.isFlippedOpen()){
				index2=getIndexOfCardNum((int)(Math.random()*12));
				cardObj2=MemoryKsJf.cards[index2[0]][index2[1]];
			}
			if(checkMatch()){
				setCompPairs(getCompPairs() + 1);
				System.out.println("\nMwahaaa! I got a match. Cards " + cardObj1.getNumIdentifier()+
					" and "+cardObj2.getNumIdentifier()+" both had " + cardObj1.getSymbol());
				MemoryKsJf.cards[index2[0]][index2[1]].setFlippedOpen(true);
				MemoryKsJf.cards[index1[0]][index1[1]].setFlippedOpen(true);
				MemoryKsJf.cards[index2[0]][index2[1]].setLearned(true);
				MemoryKsJf.cards[index1[0]][index1[1]].setLearned(true);
			}else{
				System.out.println("I chose cards " + cardObj1.getNumIdentifier()+
						" and "+cardObj2.getNumIdentifier()+". Card "+cardObj1.getNumIdentifier()+
						" had "+ cardObj1.getSymbol()+". Card "+cardObj2.getNumIdentifier()+
						" had "+ cardObj2.getSymbol());
				System.out.println("\nUghh, I didn't get a pair");
			}
		}
		playerMove=true;
	}
	private static int getNumIdentFromLearned() {
		int[] learnedNum=new int[12];
		boolean[] learnedCardExcists=new boolean[12];
		int i=0;
		for(int r=0;r<MemoryKsJf.cards.length;r++){
			for(int c=0;c<MemoryKsJf.cards[r].length;c++){
				if(MemoryKsJf.cards[r][c].getLearned()&&!MemoryKsJf.cards[r][c].isFlippedOpen()){
					learnedNum[i]=Integer.parseInt(MemoryKsJf.cards[r][c].getNumIdentifier());
					learnedCardExcists[i]=true;
					i++;
				}
			}
		}
		
		int cardNum=(int)(Math.random()*12);
		while(!learnedCardExcists[cardNum]){
			cardNum=(int)(Math.random()*12);
		}
		return learnedNum[cardNum];
		
	}

	private static String[] setLearnedPairIndex() {
		String[] learnedSym=new String[12];
		int[] learnedNum=new int[12];
		boolean[] excist=new boolean[12];
		String[] pairNum=new String[2];
		int i=0;
		
		for(int r=0;r<MemoryKsJf.cards.length;r++){
			for(int c=0;c<MemoryKsJf.cards[r].length;c++){
				if(MemoryKsJf.cards[r][c].getLearned()&&!MemoryKsJf.cards[r][c].isFlippedOpen()){
					learnedSym[i]=MemoryKsJf.cards[r][c].getSymbol();
					learnedNum[i]=Integer.parseInt(MemoryKsJf.cards[r][c].getNumIdentifier());
					excist[i]=true;
					i++;
				}
			}
		}
		pairNum[0]="";
		pairNum[1]="";
		for(int j=0;j<12;j++){
			for(int k=0;k<12;k++){
				if(j!=k&&excist[j]==true&&excist[k]==true&&learnedSym[j].equals(learnedSym[k])){
					pairNum[0]=""+learnedNum[j];
					pairNum[1]=""+learnedNum[k];
				}
	
			}
		}
		return pairNum;
	}
	
	private static boolean checkMatch() {
		if(cardObj1.getSymbol().equals(cardObj2.getSymbol())){
			return true;
		}else{
			return false;
		}
	}
	private static String userSelectCard(){
		System.out.println("Please type the digit of the card you are selecting");
		String input =in.nextLine();
		
		while(!MemoryKsJf.isValid(input)){
			System.out.println("That's not a valid card. Type the digit of the card you are selecting.");
			input =in.nextLine();
		}
		int[] index= getIndexOfCardNum(Integer.parseInt(input));
		
		while(MemoryKsJf.cards[index[0]][index[1]].isFlippedOpen()){
			index= getIndexOfCardNum(Integer.parseInt(input));
			System.out.println("That's not a valid card. Type the digit of the card you are selecting, \n make sure it's not flipped open.");
			input =in.nextLine();
		}
		return input;
	}

	public static int getUserPairs() {
		return userPairs;
	}

	public static void setUserPairs(int userPairs) {
		MemoryAiKat.userPairs = userPairs;
	}

	public static int getCompPairs() {
		return compPairs;
	}

	public static void setCompPairs(int compPairs) {
		MemoryAiKat.compPairs = compPairs;
	}
}
