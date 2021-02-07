package gameEngine;

/**
 * Interacting with a game piece must yield one of these results.
 * 
 * @author Mark Baldwin
 * @author Cyndi Rader
 * 
 */
public enum InteractionResult {
	HIT("Hit", 0), KILL("Kill", 1), ADVANCE("Advance", 2), GET_POINT("Get_point", 3), NONE("None", 4);

	
	private InteractionResult (final String name, final int numValue) {
		
	}
}
