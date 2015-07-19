package com.alvarpq.GOTF.coreGame;
/**
 * An enumerator for handling ownership of cards, units, sides and board halves.
 */
public enum Player
{
	/**
	 * Player 1
	 */
	PLAYER1,
	/**
	 * Player 2
	 */
	PLAYER2,
	/**
	 * No player
	 */
	NONE;
	/**
	 * Returns the other player
	 * @return the other player
	 */
	public Player otherPlayer()
	{
		if(this == PLAYER1)
		{
			return PLAYER2;
		}
		if(this == PLAYER2)
		{
			return PLAYER1;
		}
		return NONE;
	}
}
