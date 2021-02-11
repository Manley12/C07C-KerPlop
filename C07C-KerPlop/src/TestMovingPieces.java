// Author: Justin Orji
// Author: Gregory Manley
//
// TestMovingPeices
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.Boxer;
import levelPieces.Shinobi;
import levelPieces.Statue;

class TestMovingPieces {

	@Test
	void testShinobi() {
		// Declare and initiate board and shinobi to arbitrary position
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Shinobi shinobiOne = new Shinobi('S', "Naruto", 10);
		gameBoard[10] = shinobiOne;
		
		// Declare and initialize test values for shinobi placement
		int count1 = 0;
		int count6 = 0;
		int count18 = 0;
		int count11 = 0;
		
		// Fill game board with objects so the shinobi can't step there
		// Shinobi starts at ten, and we assume the player is at 5
		for(int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			if(i == 1 || i == 5 || i == 18 || i == 10 || i == 11 || i == 6) continue;
			else {
				gameBoard[i] = new Statue('T',"Statue",i);
			}
		}
		
		// Main loop to test movement, essentially the same as the example with a few exceptions
		// Conditional for valid locations also includes the players location as well as the starting
		// location of the shinobi
		for(int i = 0; i < 200; i++) {
			shinobiOne.move(gameBoard, 5);
			int location = shinobiOne.getLocation();
			
			if (location != 1 && location != 6 && location != 11 && location != 18 && location != 10 && location != 5)
				fail("Invalid square selected");
			// counters to ensure every valid option is chosen
			if (location == 1) count1++;
			if (location == 6) count6++;
			if (location == 18) count18++;
			if (location == 11) count11++;
		}
		assert(count1 > 10);
		assert(count6 > 10);
		assert(count18 > 10);
		assert(count11 > 10);
	}
	
	@Test
	void testBoxer() {
		// Declare and initiate board and shinobi to arbitrary position
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Boxer boxerOne = new Boxer('S', "Mike Tyson", 10);
		gameBoard[10] = boxerOne;
		
		// Fill invalid spaces with statues
		// The player will be placed at 4 and 16
		for(int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			if(i < 4 || i > 16) gameBoard[i] = new Statue('S', "Raphael", i);
		}
		
		// Declaration of testing variables 
		int countLeft = 0;
		int countRight = 0;
		int location = 0;
		
		// For loops to test if boxer is going onto correct spaces
		// and not move onto the player's space
		for(int i = 0; i < 5; i++) {
			boxerOne.move(gameBoard, 4);
			location = boxerOne.getLocation();
			
			if(location != 10 && location != 9 && location != 8 && location != 7 && location != 6 && location != 5) {
				fail("Boxer Left Invalid square selected " + boxerOne.getLocation());
			}
			if(location == 10 || location == 9 || location == 8 || location == 7 || location == 6 || location == 5) countLeft++;
		}
		for(int i = 0; i < 5; i++) {
			boxerOne.move(gameBoard, 4);
			location = boxerOne.getLocation();
			
			if(location != 10 && location != 11 && location != 12 && location != 13 && location != 14 && location != 15) {
				fail("Boxer Right Invalid square selected " + boxerOne.getLocation());
			}
			if(location == 10 || location == 11 || location == 12 || location == 13 || location == 14 || location == 15) countRight++;
		}
		assert(countLeft == 5);
		assert(countRight == 5);
	}

}
