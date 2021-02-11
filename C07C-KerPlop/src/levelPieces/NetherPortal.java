// Author: Justin Orji
// Author: Gregory Manley
//
// Nether Portal
package levelPieces;
// ADVANCE
import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class NetherPortal extends GamePiece{
	// Declaration of variables and constructor.
	private char symbol;
	private String name;
	private int location;
	public NetherPortal(char symbol, String name, int location) {
		super(symbol, name, location);
		// TODO Auto-generated constructor stub
		this.symbol = symbol;
		this.name = name;
		this.location = location;
	}
	
	// Interaction result function. When player is on top of nether, advance
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		if(playerLocation == location) return InteractionResult.ADVANCE;
		else return InteractionResult.NONE;
	}

} 
  