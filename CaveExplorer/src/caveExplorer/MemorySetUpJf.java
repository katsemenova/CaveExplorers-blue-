package caveExplorer;

public class MemorySetUpJf extends MemoryKsJf {
	
	public static String[] symbols={"~","~","@","@","*","*","?","?","!","!","%","%"};
	static String map[][];
	
	public MemorySetUpJf() {
		
	}
	public static void initialize(){
		drawCards();
		updateMap();
		print(map);
	}
	public static void updateMap(){
		//System.out.println("map");
		map = new String[7][4];
		int cardRow = 0;
		for(int row=0;row<map.length;row++){
			for(int col=0;col<map[row].length;col++){
				if(row%2==1){
					String display = getContent(cardRow, col);
					if(col==0){
						map[row][col]= "|"+display+" |";
					}else{
						map[row][col]= display+" |";
					}
					
				}
				else{
					map[row][col]= "----";
				}
			}
			if(row%2==1){
				cardRow++;
			}
		}
	}
	public static void print(String[][] pic){
		for(String[] row:pic){
			for(String col:row){
				
				System.out.print(col);
			}
			System.out.println("");
		}
	}
	private static void drawCards() {
		cards = new CardJf[3][4];
		int count=1;
		
		for(int row=0;row<cards.length;row++){
			for(int col=0;col<cards[row].length;col++){
				cards[row][col]=new CardJf(setSymbols(),""+count);
				count++;
			}
		}
		checkAdjCards();
	}
	
	public static void checkAdjCards(){
		while(adjCardSame()){
			int[] adjCards= getAdjCardsInts();	
			int row=adjCards[0];
			int col=adjCards[1];
			int rNum= (int)(Math.random()*cards.length);
			int cNum=(int)(Math.random()*cards[rNum].length);
			while(rNum==row){
				rNum= (int)(Math.random()*cards.length);
			}
			while(cNum==col || cNum==col-1){
				cNum=(int)(Math.random()*cards[rNum].length);
			}
			switchCards(row,col,rNum,cNum);
		}
	}
	
	private static int[] getAdjCardsInts(){
		int[] adjCards = new int[2];
		for(int row=0;row<cards.length;row++){
			for(int col=1;col<cards[row].length;col++){
					String cardBefore = cards[row][col-1].getSymbol();
					String card = cards[row][col].getSymbol();
					if(cardBefore.equals(card)){
						adjCards[0]=row;
						adjCards[1]=col;
						return adjCards;
					}
			}
		}
		return adjCards;
	}
	
	private static void switchCards(int row, int col, int rNum, int cNum) {
		String tempSymbol=cards[row][col].getSymbol();
		cards[row][col].setSymbol(cards[rNum][cNum].getSymbol());
		cards[rNum][cNum].setSymbol(tempSymbol);
	}
	
	private static boolean adjCardSame(){
		for(int row=0;row<cards.length;row++){
			for(int col=1;col<cards[row].length;col++){
					String cardBefore = cards[row][col-1].getSymbol();
					String card = cards[row][col].getSymbol();
					if(cardBefore.equals(card)){
						return true;
					}
			}
		}
		return false;
	}
	
	public static void resetCards(){
		for(int row=0;row<cards.length;row++){
			for(int col=0;col<cards[row].length;col++){
				cards[row][col].setSymbol(null);
				cards[row][col].setNumIdentifier(null);;
			}
		}
		
		String[] symbolArr={"~","~","@","@","*","*","?","?","!","!","%","%"};
		for(int i=0; i<symbolArr.length;i++){
			symbols[i]=symbolArr[i];
		}
		
		int count=1;
		for(int r=0;r<cards.length;r++){
			for(int c=0;c<cards[r].length;c++){
				cards[r][c].setSymbol(setSymbols());
				cards[r][c].setNumIdentifier(""+count);
				count++;
			}
		}
		checkAdjCards();
	}

	private static String setSymbols() {
		int num=(int)(Math.random()*12);
		String result;
		while(true){
			if(symbols[num].equals("")){
				num=(int)(Math.random()*12);
			}else{
				result=symbols[num];
				symbols[num]="";
				break;
			}	
		}
		return result;
		
	}
	
	public static String getContent(int row, int col){
		if(cards[row][col].isFlippedOpen()){
			return " "+cards[row][col].getSymbol();
		}
		else if(cards[row][col].getNumIdentifier().length()==1){
			return " "+cards[row][col].getNumIdentifier();
		}
		else{
			return cards[row][col].getNumIdentifier();
		}
	}
	
}
