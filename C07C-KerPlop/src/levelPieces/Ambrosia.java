// Author: Justin Orji
// Author: Gregory Manley
//
// Ambrosia
package levelPieces;
// GET POINT
import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Ambrosia extends GamePiece{
	// Declaration of variables and constructor.
	private char symbol;
	private String name;
	private int location;
	private boolean awarded = false;
	public Ambrosia(char symbol, String name, int location) {
		super(symbol, name, location);
		// TODO Auto-generated constructor stub
		this.symbol = symbol;
		this.name = name;
		this.location = location;
	}
	
	// Interaction result to gain a point. As long as the player has not already 
	// touched the ambrosia, award them a point.
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		if(playerLocation == location && awarded == false) {
			awarded = true;
			return InteractionResult.GET_POINT;
		}else return InteractionResult.NONE;
	}
}
