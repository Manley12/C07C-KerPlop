package levelPieces;
// ADVANCE
import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class NetherPortal extends GamePiece{
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

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		return null;
	}

} 
  