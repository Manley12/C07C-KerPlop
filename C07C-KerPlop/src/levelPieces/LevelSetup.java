package levelPieces;

import java.util.*;
import java.util.ArrayList;
import gameEngine.Drawable;
import gameEngine.Moveable;

public class LevelSetup implements Moveable {
	public Drawable[] getBoard() {

		return gameBoard;
	}

	public void createLevel(int levelNum, int boardSize) {
		//System.out.println(levelNum);
		if (levelNum == 1) {
			// erase arraylist 
			//create gameboard from template
			//gameBoard = new Drawable[boardSize];
			int[] randArray = {0, 0, 0};
			
			for (int j = 0; j < 3; j++) {
				int randomNum = random.nextInt(20);
				
				randArray[j] = randomNum;
			}
			
			Boxer boxerOne = new Boxer('B', "Boxer", randArray[0]);
			Ambrosia ambrosia = new Ambrosia('A', "Ambrosia", randArray[1]); 
			NetherPortal netherPortal = new NetherPortal('N', "Nether Portal", randArray[2]);
			
			for (int i = 0; i < boardSize; i++) {
				//System.out.println(randArray[0] + randArray[1]);
				if (i == randArray[0]) {
					gameBoard[i] = boxerOne;
					piecesOnBoard.add(boxerOne);
				}
				if (i == randArray[1]) {
					gameBoard[i] = netherPortal;
					piecesOnBoard.add(netherPortal);
				}
				if (i == randArray[2]) {
					gameBoard[i] = ambrosia;
					piecesOnBoard.add(ambrosia);
				}
			}
		} else if (levelNum == 2) {
			gameBoard = new Drawable[boardSize];
			int[] randArray = {0, 0, 0, 0, 0};
			
			for (int j = 0; j < 5; j++) {
				int randomNum = random.nextInt(20);
				
				randArray[j] = randomNum;
			}
			
			Shinobi shinobiOne = new Shinobi('S', "Shinobi", randArray[0]);
			
			piecesOnBoard.add(shinobiOne);
			
			for (int i = 0; i < gameBoard.length; i++) {
				
			}
		}
	}

	public ArrayList<Moveable> getMovingPieces(){
		
		
		return null;
	}

	public ArrayList<GamePiece> getInteractingPieces() {
		
		
		return null;
	}

	public int getPlayerStartLoc() {
		return 1;
	}
	
	private Random random = new Random();
	private ArrayList<GamePiece> piecesOnBoard = new ArrayList<>();
	private Drawable[] gameBoard = {null, null, null, null, null, null, null, null, null, null, null, null,null, null, null, null, null, null, null, null};
	

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		System.out.println("test");
	}

}
