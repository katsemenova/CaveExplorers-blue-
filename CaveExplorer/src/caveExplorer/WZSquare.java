package caveExplorer;

public class WZSquare {
	
	public boolean[] sides = new boolean[4];
	//0 NORTH, 1 EAST, 2 SOUTH, 3 WEST
	public String conquorer = " ";
	//NONE = " ", PLAYER = "P", QUEEN = "Q"
	
	public int row;
	public int col;
	
	public WZSquare(int row, int col)
	{
		this.row = row;
		this.col = col;
	}
	
	public void addSide(int side)
	{
		sides[side] = true;
	}
}
 