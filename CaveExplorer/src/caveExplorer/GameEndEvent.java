package caveExplorer;

public class GameEndEvent implements Playable {

	private static final String[] SEQUENCE={"<You slowly exit the castle>"};
	public GameEndEvent() {
	}

	public void play(){
		readSequence(SEQUENCE);
	}
	
	public static void readSequence(String[] seq){
		for(String s:seq){
			CaveExplorer.print(s);
			CaveExplorer.print("-----Press Enter------");
			CaveExplorer.in.nextLine();
		}
	}

}
