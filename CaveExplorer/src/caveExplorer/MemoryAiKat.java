package caveExplorer;

import java.util.Scanner;

public class MemoryAiKat extends MemoryKsJf implements Playable{
//move a lot of the code to main

	public static Scanner in;
	public static boolean playerMove;
	public static boolean gameDone;
	private static int cardOne;
	private static int cardTwo;
	private static int userPairs;
	private static int compPairs;
	
	public static void initialize() {
		setUserPairs(0);
		setCompPairs(0);
		gameDone=false;
		playerMove=true;
		in=new Scanner(System.in);
	}
	/*
	 * This method works with how the user selects their cards and testing if the card r the same
	 */
	public static void userMove(){
		//selects which card num to flip
		cardOne=Integer.parseInt(userSelectCard());
		int[] index1=getIndexOfCardNum(cardOne);
		accessCard(index1[0],index1[1]).setLearned(true);
		
		System.out.println("Card number " + cardOne+" has the symbol " + accessCard(index1[0],index1[1]).getSymbol());
		
		cardTwo=Integer.parseInt(userSelectCard());
		while(cardTwo==cardOne){
			System.out.println("You can't choose the same card twice silly goose. Chose a different card.");
			cardTwo=Integer.parseInt(userSelectCard());
		}
		int[] index2=getIndexOfCardNum(cardTwo);
		accessCard(index2[0],index2[1]).setLearned(true);

		System.out.println("Card number " + cardTwo+" has the symbol " + accessCard(index2[0],index2[1]).getSymbol());
		
		if(checkMatch(accessCard(index1[0],index1[1]),accessCard(index2[0],index2[1]))){
			accessCard(index1[0],index1[1]).setFlippedOpen(true);
			accessCard(index2[0],index2[1]).setFlippedOpen(true);
			setUserPairs(getUserPairs() + 1);
			System.out.println("\nYou got a pair. Don't worry...hehe...I'll catch up.");
		}else{
			System.out.println("\nHaha, you didn't get a pair.");
			moveCards(cardOne,cardTwo);
		}
		playerMove=false;
		
	}
	
	private static CardJf accessCard(int i, int j) {
		return MemoryKsJf.cards[i][j];
	}
	
	private static String userSelectCard(){
		System.out.println("Please type the digit of the card you are selecting");
		String input =in.nextLine();
		if(input=="cheat"){
			for(int r=0;r<MemoryAiKat.cards.length;r++){
				for(int c=0;c<MemoryAiKat.cards[r].length;c++){
					
				}
			}
		}else{
			while(!MemoryKsJf.isValid(input)){
				System.out.println("That's not a valid card. Type the digit of the card you are selecting.");
				input =in.nextLine();
			}
			int[] index= getIndexOfCardNum(Integer.parseInt(input));
			
			while(accessCard(index[0],index[1]).isFlippedOpen()){
				System.out.println("That's not a valid card. Type the digit of the card you are selecting, \n make sure it's not flipped open.");
				input =in.nextLine();
				index= getIndexOfCardNum(Integer.parseInt(input));
			}
		}
		return input;
	}

	/*
	 * Used to find the index of the card in the card array based on the card's number identifier
	 */
	private static int[] getIndexOfCardNum(int card) {
		int[] arr=new int[2];
		for(int r=0;r<MemoryKsJf.cards.length;r++){
			for(int c=0;c<MemoryKsJf.cards[r].length;c++){
				if(Integer.parseInt(accessCard(r,c).getNumIdentifier())==card){
					arr[0]=r;
					arr[1]=c;
				}
			}
		}
		return arr;
	}
	/*
	 * has to do with computer's logic to make a move
	 */
	public static void computerMove(){
		String[] arr= setLearnedPairIndex();
		int[] index1;
		int[] index2;
		
		/*
		 * The arr array returns the two number identifiers
		 * if there is a matching pair
		 * if there are no matching then it will return {"",""}; so the if statement tests 
		 * that if out of the learned cards(cards that have been previously flipped over the cards "learned" boolean
		 * is true, this is a sure way that the computer will select cards that he remembered
		 * just as if playing with a person
		 * 
		 */
		if(!arr[1].equals("")&&!arr[0].equals("")){
			index1=getIndexOfCardNum(Integer.parseInt(arr[0]));
			index2=getIndexOfCardNum(Integer.parseInt(arr[1]));
			accessCard(index1[0],index1[1]).setFlippedOpen(true);
			accessCard(index2[0],index2[1]).setFlippedOpen(true);
			
			System.out.println("Hahaha! You see I got a pair. Cards " + accessCard(index1[0],index1[1]).getNumIdentifier()+
					" and "+accessCard(index2[0],index2[1]).getNumIdentifier()+" both had " + accessCard(index1[0],index1[1]).getSymbol()+
					". Your turn again.");
			setCompPairs(getCompPairs()+1);
			playerMove=true;
			/*
			 * the else is also smart. It selects an already learned card, and a random to raise chances of getting 
			 * a pair
			 */
			
		}else{
			int cardNum1=getNumIdentFromLearned();
			int cardNum2=(int)(Math.random()*12);
			index1 = getIndexOfCardNum(cardNum1);
			index2=getIndexOfCardNum(cardNum2);
			
			while(cardNum1==cardNum2||accessCard(index2[0],index2[1]).isFlippedOpen()){
					
				cardNum2=(int)(Math.random()*12);
				index2=getIndexOfCardNum(cardNum2);
				}		
			
			if(checkMatch(accessCard(index2[0],index2[1]),accessCard(index1[0],index1[1]))){
				setCompPairs(getCompPairs() + 1);
				System.out.println("\nMwahaaa! I got a match. Cards " + accessCard(index1[0],index1[1]).getNumIdentifier()+
					" and "+accessCard(index2[0],index2[1]).getNumIdentifier()+" both had " + accessCard(index1[0],index1[1]).getSymbol());
				
				accessCard(index1[0],index1[1]).setFlippedOpen(true);
				accessCard(index2[0],index2[1]).setFlippedOpen(true);
				setCompPairs(getCompPairs()+1);
			}else{
				System.out.println("I chose cards " + accessCard(index1[0],index1[1]).getNumIdentifier()+
						" and "+accessCard(index2[0],index2[1]).getNumIdentifier()+". Card "+accessCard(index1[0],index1[1]).getNumIdentifier()+
						" had "+ accessCard(index1[0],index1[1]).getSymbol()+". Card "+accessCard(index2[0],index2[1]).getNumIdentifier()+
						" had "+ accessCard(index2[0],index2[1]).getSymbol());
				System.out.println("\nUghh, I didn't get a pair");
			}
			accessCard(index2[0],index2[1]).setLearned(true);
			accessCard(index1[0],index1[1]).setLearned(true);
			playerMove=true;
		}
	}
		
	
	/*
	 * returns the value of a card that's already been flipped over, used for computer
	 */
	private static int getNumIdentFromLearned() {
		int[] learnedNum=new int[12];
		boolean[] learnedCardExcists=new boolean[12];
		int i=0;
		
		for(int r=0;r<MemoryKsJf.cards.length;r++){
			for(int c=0;c<MemoryKsJf.cards[r].length;c++){
				if(accessCard(r,c).getLearned()&&!accessCard(r,c).isFlippedOpen()){
					learnedNum[i]=Integer.parseInt(accessCard(r,c).getNumIdentifier());
					learnedCardExcists[i]=true;
					i++;
				}
			}
		}
		
		int cardNum=(int)(Math.random()*12);
		if(allFalse(learnedCardExcists)){
			///CardJf cardObj;
			cardNum=(int)(Math.random()*12);
			int[] index=getIndexOfCardNum(cardNum);

			while(accessCard(index[0],index[1]).isFlippedOpen()){
				cardNum=(int)(Math.random()*12);
				index=getIndexOfCardNum(cardNum);	
			}
			return cardNum;
		}else{
			while(!learnedCardExcists[cardNum]){
				cardNum=(int)(Math.random()*12);
			}
		}
		return learnedNum[cardNum];
	}
	
	private static boolean allFalse(boolean[] arr) {
		for(int i=0;i<arr.length;i++){
			if(arr[i])
				return false;
		}
		return true;
	}
	//for computer finding a match
	private static String[] setLearnedPairIndex() {
		String[] learnedSym=new String[24];
		int[] learnedNum=new int[24];
		boolean[] excist=new boolean[24];
		String[] pairNum=new String[2];
		int i=0;
		
		for(int r=0;r<MemoryKsJf.cards.length;r++){
			for(int c=0;c<MemoryKsJf.cards[r].length;c++){
				if(accessCard(r,c).getLearned()&&!accessCard(r,c).isFlippedOpen()){
					learnedSym[i]=accessCard(r,c).getSymbol();
					learnedNum[i]=Integer.parseInt(accessCard(r,c).getNumIdentifier());
					excist[i]=true;
					i++;
				}
			}
		}
		pairNum[0]="";
		pairNum[1]="";
		for(int j=0;j<24;j++){
			for(int k=0;k<24;k++){
				if(j!=k&&excist[j]==true&&excist[k]==true&&learnedNum[j]!=learnedNum[k]&&learnedSym[j].equals(learnedSym[k])){
					pairNum[0]=""+learnedNum[j];
					pairNum[1]=""+learnedNum[k];
				}
			}
		}
		return pairNum;
	}
	
	private static boolean checkMatch(CardJf cardJf, CardJf cardJf2) {
		if(cardJf.getSymbol().equals(cardJf2.getSymbol())){
			return true;
		}else{
			return false;
		}
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
	
	public static void moveCards(int cardOne,int cardTwo){
		int[] index1=getIndexOfCardNum(cardOne);
		int[] index2=getIndexOfCardNum(cardTwo);
		CardJf temp;
		int rowOne=index1[0];
		int rowTwo=index2[0];
		//if in same row
		if(rowOne==rowTwo){
			temp = accessCard(index2[0],index2[1]);
			MemoryKsJf.cards[index2[0]][index2[1]]=accessCard(index2[0],index2[1]);
			MemoryKsJf.cards[index1[0]][index1[1]]=temp;
			
		}else{
			//if in diff rows
			if(rowOne==0||rowOne==2){
				shiftRight(rowOne);
			}else{
				shiftLeft(rowOne);
			}
			if(rowTwo==0||rowTwo==2){
				shiftRight(rowTwo);
			}else{
				shiftLeft(rowTwo);
			}
		}
		
	}
	private static void shiftRight(int row){
		int length = MemoryKsJf.cards[1].length;
        CardJf temp = accessCard(row,length-1);
        for (int k=length-1; k>=1; k--){
        	MemoryKsJf.cards[row][k] = accessCard(row,k-1);
        }
        MemoryKsJf.cards[row][0] = temp;
	}
	private static void shiftLeft(int row){
		int length = MemoryKsJf.cards[row].length;
		CardJf temp = accessCard(row,0);
        for (int k=0; k<length-1; k++){
        	MemoryKsJf.cards[row][k] = accessCard(row,k+1);
        }
        MemoryKsJf.cards[row][length-1] = temp;
	}
}
