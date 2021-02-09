// Author: Justin Orji
// Author: Gregory Manley
//
// Shinobi
package levelPieces;

import java.util.*;
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Shinobi extends GamePiece implements Moveable{
	// Declaration of variables and constructor.
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
	
	// Interaction result to kill. If the player is within 4 spaces, the shinobi can assassinate.
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		if(playerLocation >= location - 4 || playerLocation <= location + 4) return InteractionResult.KILL;
		else return InteractionResult.NONE;
	}
	
	// Move function. This is a randomized function, so as long as the space is null,
	// the shinobi will be able to move there.
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		Random random = new Random();
		int randomPosition = random.nextInt(20);
		int oldPosition = location;
		if(gameBoard[randomPosition] == null) {
			gameBoard[randomPosition] = gameBoard[oldPosition];
			location = randomPosition;	
			gameBoard[oldPosition] = null;
		}	
	}

}
