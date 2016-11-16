package caveExplorer;

public class MemoryKsJf implements Playable {
	
	public boolean userWon;
	public static MemoryAiKat Ai;
	public static MemorySetUpJf setup;
	
	public MemoryKsJf() {
			
		
	}
	
	public void play(){
		MemorySetUpJf.initialize();
		
		gameMode();
	}

	
	private void gameMode() {
//		while(!gameDone){
//			if(playerMove){
//				//runJenniber's
//			}else{
//				//MemoryAiKat();
//			}
//		}
	}
	public void enter(){
		//super.enter(); //done to make sure that the X is moved in the actual thing
		
	}
	public void interpretAction(String input){
		
	}
	
	protected static boolean isValid(String input) {
		String[] validKeys={"1","2","3","4","5","6","7","8","9","10","11","12"};
		String ignore="";
		for(int i=0;i<13;i++){
			for(int j=0;j<13;j++){
				if(i==j)
					ignore = "do nothing";
				else if(input.equals(validKeys[i]+"_"+validKeys[j]))
					return true;
			}
		}
		
		return false;
	}
	
//	public static int rowNum(int blockNum, int rowLength){
//		int row=blockNum/rowLength;
//		if(blockNum%rowLength==0){
//			row--;
//		}
//		return row;
//	}
//	public static int colNum(int blockNum, int colLength){
//		int col=blockNum%colLength;
//		if(col==0){
//			col=colLength;
//		}
//		col--;
//		return col;
//	}
}