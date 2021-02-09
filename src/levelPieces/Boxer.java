// Author: Justin Orji
// Author: Gregory Manley
//
// Boxer
package levelPieces;
// HIT 
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
import gameEngine.Player;

public class Boxer extends GamePiece implements Moveable{
	// Class variable declarations and constructor
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
	
	// Required Interaction result for this class. When player is within one space, they get hit.
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		if(playerLocation == location - 1 || playerLocation == location + 1) {
			return InteractionResult.HIT;
		}
		else return InteractionResult.NONE;
	}

	
	// Also a moveable piece. If the player is within six spaces, then it moves towards it.
	// Note here: I believe that the way the player move and this move are coded are fundamentally
	// different. The player is able to move anywhere and essentially overwrite the symbol at that position,
	// whereas for this to move, it requires that the space it moves into is null. I think that the player leaves
	// behind some kind of residual object-thing (very technical, I know) that prevents the boxer from moving. 
	// I noticed this when I tested the move by jumping over the boxer. Once jumped over, the boxer could not chase after
	// the player although it could still punch when the player was within distance.
	@Override 
	public void move(Drawable[] gameBoard, int playerLocation) {
		// Local variables to track location
		int oldLocation, newLocation;
		oldLocation = location;
		
		// If player is within 6 spaces, follow
		if(playerLocation - location >= 1 && playerLocation - location <= 6) {
			newLocation = oldLocation + 1;
			// As long as location is null, move to the right
			if(gameBoard[newLocation] == null) {
				gameBoard[newLocation] = gameBoard[oldLocation];
				location = newLocation;
				gameBoard[oldLocation] = null;
		}
		else if(location - playerLocation >= 1 && location - playerLocation <= 6) {
			newLocation = oldLocation - 1;
			// As long as location is null, move to the left
			if(gameBoard[newLocation] == null) {
				gameBoard[newLocation] = gameBoard[oldLocation];
				location = newLocation;
				gameBoard[oldLocation] = null;
			}
			}
		}
	}
}
