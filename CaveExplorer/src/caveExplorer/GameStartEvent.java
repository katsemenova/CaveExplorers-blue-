package caveExplorer;

public class GameStartEvent implements Playable {
	
	private static final String[] SEQUENCE_1={"<Oh no! You have fallen down a hole...>","Hi I'm the White Rabbit. I heard your name is Alice. Welcome to Wonderland.",
			"This is the Queen of Heart's land. If you want to leave you have to collect the three keys.", "She had her soldiers hide the keys throughout the castle.",
			"To get the keys, you have to play the minigames when you find them."};
	private static final String[] SEQUENCE_2={"Here is the map. Sadly I do not know where the games are located.","Go explore and find the keys. Best of luck, OH NO I'm late!."};
	public GameStartEvent() {
		// TODO Auto-generated constructor stub
	}

	public void play(){
		readSequence(SEQUENCE_1);
		System.out.println("Are you ready?");
		while(CaveExplorer.in.nextLine().toLowerCase().indexOf("yes")<0){
			CaveExplorer.print("I'll continue when you say 'yes' so I know you are ready.");
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
