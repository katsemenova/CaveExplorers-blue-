package caveExplorer;

public class WendyDotBoxPlayer{

	
	public void makeMove() {
		// TODO Auto-generated method stub
		String move = WendyZhengRoom.whosmove;
		while(move.toLowerCase().equals("p"))
		{
			playerTurn();
		}
		
	}
 
	private void playerTurn() {
		// TODO Auto-generated method stub
		System.out.println("Where is your next move?");
	
		
	}

}
