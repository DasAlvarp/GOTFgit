package com.alvarpq.GOTF.coreGame;
public enum Player
{
	PLAYER1, PLAYER2, NONE;
	public Player otherPlayer()
	{
		if(this==PLAYER1)
		{
			return PLAYER2;
		}
		if(this==PLAYER2)
		{
			return PLAYER1;
		}
		return NONE;
	}
}
