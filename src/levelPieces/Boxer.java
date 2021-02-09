package levelPieces;
// HIT 
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
import gameEngine.Player;

public class Boxer extends GamePiece implements Moveable{
	private char symbol; 
	private String name;
	private int location;
	public Boxer(char symbol, String name, int location) {
		super(symbol, name, location);
		// TODO Auto-generated constructor stub
		this.symbol = symbol;
		this.name = name;
		this.location = location;
	}
	

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		if(playerLocation == location - 1 || playerLocation == location + 1) {
			return InteractionResult.HIT;
		}
		else return InteractionResult.NONE;
	}


	@Override 
	public void move(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		if(playerLocation - location >= 1 && playerLocation - location <= 6) {
			location++;
		}
		else if(location - playerLocation >= 1 && location - playerLocation <= 6) {
			location--;
		}
	}

}
