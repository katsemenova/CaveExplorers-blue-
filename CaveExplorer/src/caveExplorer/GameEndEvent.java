package caveExplorer;

public class GameEndEvent implements Playable {

	private static final String[] SEQUENCE={"<You slowly exit the castle>","<Entering a forest with thick fog, you follow the only path you can see in front of you>","<While walking, you realize that you are slowly feeling more and more drowsy>","<You feel the darkness enveloping you>", "<Suddenly, you find yourself waking up, having left Wonderland and your adventure through the castle behind>"};
	public GameEndEvent() {
	}

	public void play(){
		readSequence(SEQUENCE);
		System.out.println("The End");
	}
	
	public static void readSequence(String[] seq){
		for(String s:seq){
			CaveExplorer.print(s);
			CaveExplorer.print("-----Press Enter------");
			CaveExplorer.in.nextLine();
		}
	}

}
