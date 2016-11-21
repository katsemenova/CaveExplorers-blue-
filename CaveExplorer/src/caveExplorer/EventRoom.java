package caveExplorer;

public class EventRoom extends CaveRoomPd8 {
	
	private boolean eventHappened;
	private Playable event;
	
	public EventRoom(String description, Playable event) {
		super(description);
		eventHappened=false;
		this.event = event;
		
	}
	public void enter(){
		//make all normal things happen
		super.enter();
		if(!eventHappened){
			event.play();
			eventHappened=true;
			if(event instanceof Completable){
				if(!((Completable)event).didComplete()){
					eventHappened=false;
				}
		}
	}
	}
	

}
