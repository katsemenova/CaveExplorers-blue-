package caveExplorer;

public class GameStartEvent implements Playable {
	
	private static final String[] SEQUENCE_1={"<A little yellow mouse with brown stripes and a lighting shaped tale runs up to you>",
			"Hi. I can see you are not from here.","Do you like puzzles?",""};
	private static final String[] SEQUENCE_2={"You will have so much fun playing my 2-D games","Take this map."};
	public GameStartEvent() {
		// TODO Auto-generated constructor stub
	}

	public void play(){
		readSequence(SEQUENCE_1);
		System.out.println("Come On, tell me you like puzzles say yes");
		while(CaveExplorer.in.nextLine().toLowerCase().indexOf("yes")<0){
			CaveExplorer.print("Say yes, you know you like puzzles");
		}
		readSequence(SEQUENCE_2);
		CaveExplorer.inventory.setHasMap(true);

	}
	public static void readSequence(String[] seq){
		for(String s:seq){
			CaveExplorer.print(s);
			CaveExplorer.print("-----Press Enter------");
			CaveExplorer.in.nextLine();
		}
	}
}
