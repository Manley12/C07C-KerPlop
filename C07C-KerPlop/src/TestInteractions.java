// Author: Justin Orji
// Author: Gregory Manley
//
// TestInteractions

// Static imports
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

// import jupiter
import org.junit.jupiter.api.Test;

// Import game code
import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.Boxer;
import levelPieces.Shinobi;
import levelPieces.NetherPortal;
import levelPieces.Ambrosia;
import levelPieces.Statue;

class TestInteractions {

	//
	// Test that Shinobi kills player if player is at same location
	// 
	@Test
	void testShinobi() {
		// Setup gameBoard and gamePiece and place on Board
		int i;
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Shinobi shinobiOne = new Shinobi('S', "Shinobi", 10);
		gameBoard[10] = shinobiOne;
		
		// Kills player if on same space
		assertEquals(InteractionResult.KILL, shinobiOne.interact(gameBoard, 10));
		
		// Ensure no interaction if not on same space
		for (i = 0; i < 10; i++) {
			assertEquals(InteractionResult.KILL, shinobiOne.interact(gameBoard, i));
		}
		for (i = 11;  i < GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.KILL, shinobiOne.interact(gameBoard, i));
		}
	}
	
	//
	// Test that Ambrosia gives player a point when player is at same location 
	//
	@Test
	void testAmbrosia() {
		// Setup gameBoard and gamePiece and place on Board
		int i;
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Ambrosia ambrosiaOne = new Ambrosia('A', "Ambrosia", 10);
		gameBoard[10] = ambrosiaOne;
		
		// Gives player point if on same space
		assertEquals(InteractionResult.GET_POINT, ambrosiaOne.interact(gameBoard, 10));
		
		// Ensure no points are given if the player is elsewhere
		for (i = 0; i < 10; i++) {
			assertEquals(InteractionResult.NONE, ambrosiaOne.interact(gameBoard, i));
		}
		for (i = 11;  i < GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, ambrosiaOne.interact(gameBoard, i));
		}
	}
	
	//
	// Test that Nether Portal advances player when player is at same location
	//
	@Test
	void testNetherPortal() {
		// Setup gameBoard and gamePiece and place on board
		int i;
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		NetherPortal nether = new NetherPortal('N', "Nether Portal", 10);
		gameBoard[10] = nether;
		
		// Advances player when player is at the same spot
		assertEquals(InteractionResult.ADVANCE, nether.interact(gameBoard, 10));
		
		// Ensure that the player is not advanced elsewhere
		for (i = 0; i < 10; i++) {
			assertEquals(InteractionResult.NONE, nether.interact(gameBoard, i));
		}
		for (i = 11;  i < GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, nether.interact(gameBoard, i));
		}
	}
	
	//
	// Test that Boxer hits player when player is next to it (on either side)
	//
	@Test
	void testBoxer() {
		// Setup gameBoard and gamePiece and place on board
		int i;
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Boxer boxerOne = new Boxer('B', "Boxer", 10);
		gameBoard[10] = boxerOne;
		
		// Hits player when player is to the immediate left or right of piece
		assertEquals(InteractionResult.HIT, boxerOne.interact(gameBoard, 9));
		assertEquals(InteractionResult.HIT, boxerOne.interact(gameBoard, 11));
		
		// Ensure that the boxer does not hit at other locations
		for (i = 0; i < 9; i++) {
			assertEquals(InteractionResult.NONE, boxerOne.interact(gameBoard, i));
		}
			assertEquals(InteractionResult.NONE, boxerOne.interact(gameBoard, 10));
		for (i = 12;  i < GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, boxerOne.interact(gameBoard, i));
		}
	}
	
	//
	// Test that statue does nothing to player.
	//
	@Test
	void testStatue() {
		// Setup gameBoard and gamePiece and place on board
		int i;
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Statue statue = new Statue('S', "Statue", 10);
		gameBoard[10] = statue;
		
		// Ensure that the interaction is none for ALL spaces
		for (i = 0; i< GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, statue.interact(gameBoard, i));
		}
	}

}
