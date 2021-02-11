// Author: Justin Orji
// Author: Gregory Manley
//
// LevelSetup

package levelPieces;

import java.util.*;
import gameEngine.Drawable;
import gameEngine.Moveable;

public class LevelSetup implements Moveable {
	// get the gameBoard of type drawable to return to be printed to the console
	public Drawable[] getBoard() {

		return gameBoard;
	}

	// create the level
	public void createLevel(int levelNum, int boardSize) {
		// test to see which level to setup
		if (levelNum == 1) {
			// erase whereIsPieces and create random value array
			int[] randArray = {0, 0, 0};
			whereIsPieces = new int[3];
			
			for (int j = 0; j < 3; j++) {
				int randomNum = random.nextInt(20);
				
				randArray[j] = randomNum;
			}
			
			// Setup the pieces
			Boxer boxerOne = new Boxer('B', "Boxer", randArray[0]);
			Ambrosia ambrosia = new Ambrosia('A', "Ambrosia", randArray[1]); 
			NetherPortal netherPortal = new NetherPortal('N', "Nether Portal", randArray[2]);
			
			// Place the pieces on the gameBoard based upon the random values generated
			for (int i = 0; i < boardSize; i++) {
				if (i == randArray[0]) {
					gameBoard[i] = boxerOne;
					piecesOnBoard.add(boxerOne);
					whereIsPieces[0] = i;
				}
				if (i == randArray[1]) {
					gameBoard[i] = netherPortal;
					piecesOnBoard.add(netherPortal);
					whereIsPieces[1] = i;
				}
				if (i == randArray[2]) {
					gameBoard[i] = ambrosia;
					piecesOnBoard.add(ambrosia);
					whereIsPieces[2] = i;
				}
			}
		} else if (levelNum == 2) {
			// erase whereIsPieces and gameBoard and create random value array
			gameBoard = new Drawable[boardSize];
			whereIsPieces = new int[4];
			int[] randArray = {0, 0, 0, 0, 0};
			
			for (int j = 0; j < 5; j++) {
				int randomNum = random.nextInt(20);
				
				randArray[j] = randomNum;
			}
			
			// Setup the pieces
			Shinobi shinobiOne = new Shinobi('S', "Shinobi", randArray[0]);
			Statue statueOne = new Statue('S', "Statue", randArray[1]);
			Ambrosia ambrosiaTwo = new Ambrosia('A', "Ambrosia", randArray[2]);
			Joker jokerOne = new Joker();
			
			// Place the pieces on the gameBoard based upon the random values generated
			for (int i = 0; i < gameBoard.length; i++) {
				if (i == randArray[0]) {
					gameBoard[i] = shinobiOne;
					piecesOnBoard.add(shinobiOne);
					whereIsPieces[0] = i;
				}
				if (i == randArray[1]) {
					gameBoard[i] = statueOne;
					piecesOnBoard.add(statueOne);
					whereIsPieces[1] = i;
				}
				if (i == randArray[2]) {
					gameBoard[i] = ambrosiaTwo;
					piecesOnBoard.add(ambrosiaTwo);
					whereIsPieces[2] = i;
				}
				if (i == randArray[3]) {
					gameBoard[i] = jokerOne;
					//piecesOnBoard.add(jokerOne);
					whereIsPieces[3] = i;
				}
			}
		}
	}

	public ArrayList<Moveable> getMovingPieces(){
		// Create arraylist variable to return
		ArrayList<Moveable> list = new ArrayList<>();
		
		// Determine if the piecesOnBoard value at i is of type Moveable and if so add to list
		for (int i = 0; i < piecesOnBoard.size(); i++) {
			if (piecesOnBoard.get(i) instanceof Moveable) {
				list.add((Moveable) piecesOnBoard.get(i));
			}
		}
		
		return list;
	}

	public ArrayList<GamePiece> getInteractingPieces() {
		// Create arraylist variable to return
		ArrayList<GamePiece> list = new ArrayList<>();
		
		// Determine if the piecesOnBoard value at i is of type GamePiece and if so add to list
		for (int i = 0; i < piecesOnBoard.size(); i++) {
			if (piecesOnBoard.get(i) instanceof GamePiece) {
				list.add(piecesOnBoard.get(i));
			}
		}
		
		return list;
	}

	// Determine a random value at which to start player
	public int getPlayerStartLoc() {
		int randPlace = random.nextInt(20);
		
		return randPlace;
	}
	
	// Setup variable for file
	private Random random = new Random();
	private ArrayList<GamePiece> piecesOnBoard = new ArrayList<>();
	private int[] whereIsPieces;
	private Drawable[] gameBoard = {null, null, null, null, null, null, null, null, null, null, null, null,null, null, null, null, null, null, null, null};
	

	// Test override, no use
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		System.out.println("test");
	}

}
