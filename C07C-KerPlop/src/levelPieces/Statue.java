// Author: Justin Orji
// Author: Gregory Manley
//
// Statue
package levelPieces;
// NONE
import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Statue extends GamePiece{
	// Declaration of variables and constructor.
	private char symbol; 
	private String name;
	private int location;
	public Statue(char symbol, String name, int location) {
		super(symbol, name, location);
		// TODO Auto-generated constructor stub
		this.symbol = symbol;
		this.name = name;
		this.location = location;
	}
	
	// Interaction that does nothing. Perhaps the statue is nice to look at??
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		return InteractionResult.NONE;
	}

}
