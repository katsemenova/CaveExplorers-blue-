package caveExplorer;

public class TamannaViolettaRoom extends CaveRoomPd8{
	
	
	public TamannaViolettaRoom(String description) {
		super(description);
		
	}
	
	public static void tvCheatCode(){
		
	}
	
	public static void readSequence(String[] seq){
		for(String s:seq){
			CaveExplorer.print(s);
			CaveExplorer.print("-----Press Enter------");
			CaveExplorer.in.nextLine();
		}
	}
	
	//storyline (together)
		//you have stumbled upon the dwellings of the Cheshire Cat.
		//He occupies this part of Wonderland and will bother with you with riddles until you reach the end
		//You will move a certain amount of steps at a time 
	
	//QUESTION: when Alice runs into the cat on her 2nd step, but she rolled a 5, what happens?
		//option: if she answers correctly she can move her full turn, if not then she goes halfway back to the starting point
	
	//create grid (10 x 10)? (together?)
	//place random things in way (what will we refer to them as to fit the theme?) (T)
	//place cat (such that is in the beginning of the grid) (T)
		//Alice rolls dice (what's a better way to call the dice for the theme?) (V)
		//Alice walks (V)
			//if Alice hits cat: ask riddle (T)
				//if Alice gets it wrong, move halfway back (V)
			//else: repeat dice roll
	
	//I think that's it?
}
