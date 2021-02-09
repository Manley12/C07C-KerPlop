// Author: Justin Orji
// Author: Gregory Manley
//
// Joker
package levelPieces;

import gameEngine.Drawable;

public class Joker implements Drawable {
	// Declaration of variables
	private char symbol = 'J';
	
	// Like statue, this also does nothing. 
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.print('J');
	}

}
