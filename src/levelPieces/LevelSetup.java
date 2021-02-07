package levelPieces;

import java.util.ArrayList;
import gameEngine.Drawable;
import gameEngine.Moveable;

public class LevelSetup implements Moveable {
	public Drawable[] getBoard() {

		return gameBoard;
	}

	public void createLevel(int levelNum) {
		if (levelNum == 0) {
			//create gameboard from template
			final Boxer test = new Boxer('B', "Boxer", 5);
			piecesOnBoard.add(test);
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

	final Boxer test = new Boxer('B', "Boxer", 5);
	private ArrayList<GamePiece> piecesOnBoard;
	private Drawable[] gameBoard = {test, null, null, null, null};

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		System.out.println("test");
	}

}
