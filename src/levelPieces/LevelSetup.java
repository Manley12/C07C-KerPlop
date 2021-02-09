package levelPieces;

import java.util.*;
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
			whereIsPieces = new int[3];
			
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
			gameBoard = new Drawable[boardSize];
			int[] randArray = {0, 0, 0, 0, 0};
			
			for (int j = 0; j < 5; j++) {
				int randomNum = random.nextInt(20);
				
				randArray[j] = randomNum;
			}
			
			Shinobi shinobiOne = new Shinobi('S', "Shinobi", randArray[0]);
			Statue statueOne = new Statue('S', "Statue", randArray[1]);
			Ambrosia ambrosiaTwo = new Ambrosia('A', "Ambrosia", randArray[2]);
			Joker jokerOne = new Joker();
			
			piecesOnBoard.add(shinobiOne);
			
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
		ArrayList<Moveable> list = new ArrayList<>();
		
		for (int i = 0; i < piecesOnBoard.size(); i++) {
			if (piecesOnBoard.get(i) instanceof Moveable) {
				list.add((Moveable) piecesOnBoard.get(i));
			}
		}
		
		return list;
	}

	public ArrayList<GamePiece> getInteractingPieces() {
		ArrayList<GamePiece> list = new ArrayList<>();
		
		for (int i = 0; i < piecesOnBoard.size(); i++) {
			if (piecesOnBoard.get(i) instanceof GamePiece) {
				list.add(piecesOnBoard.get(i));
			}
		}
		
		return list;
	}

	public int getPlayerStartLoc() {
		int randPlace = random.nextInt(20);
		int i = 0;
		int j = 0;
		boolean unique = false;
		
		/* Accidentally creating infinite loop here
		 * do {
			for (i = 0; i < whereIsPieces.length; i++) {
				if (randPlace != whereIsPieces[i] ) {
					j++;
				}
			}
			if (j == whereIsPieces.length) {
				unique = false;
				
			} else {
				randPlace = random.nextInt(20);
			}
		} while (unique != true);*/
		
		return randPlace;
	}
	
	private Random random = new Random();
	private ArrayList<GamePiece> piecesOnBoard = new ArrayList<>();
	private int[] whereIsPieces;
	private Drawable[] gameBoard = {null, null, null, null, null, null, null, null, null, null, null, null,null, null, null, null, null, null, null, null};
	

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		System.out.println("test");
	}

}
