package caveExplorer;

public class Door {
	private boolean open;
	private boolean locked;
	private String description;
	private String details;
	
	public Door(){
		open=true;
		locked=false;
		description="door";
		details=" ";
	}
//getters and setters
	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	public static String toDirection(int dir) {
		String[] strings = {"the North","the East","the South", "the West"};
		return strings[dir];
	
	}
	
	
}
