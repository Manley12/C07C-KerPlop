package levelPieces;
// KILL
import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Shinobi extends GamePiece {
	private char symbol;
	private String name;
	private int location;
	
	public Shinobi(char symbol, String name, int location) {
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
