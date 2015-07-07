package com.alvarpq.GOTF.coreGame;

import com.alvarpq.GOTF.coreGame.board.BoardHalf;

public enum Player
{
	PLAYER1, PLAYER2, NONE;
	private BoardHalf board;
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
	
	public BoardHalf getBoard(){
		return board;
	}
	
	public void setBoard(BoardHalf board){
		this.board=board;
	}
}
