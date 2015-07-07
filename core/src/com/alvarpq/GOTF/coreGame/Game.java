package com.alvarpq.GOTF.coreGame;
import java.util.Random;

import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.gui.BoardDraw;
public class Game
{
	public final BoardHalf half1 = new BoardHalf(5, 3, 8, Player.PLAYER1);
	public final BoardHalf half2 = new BoardHalf(5, 3, 8, Player.PLAYER2);
	Player currentPlayer;
	Player p1=Player.PLAYER1;
	Player p2=Player.PLAYER2;
	private static final Random random = new Random();
	BoardDraw boardDraw;
	public Game()
	{
		BoardHalf.createBoard(half1, half2);
		p1.setBoard(half1);
		p2.setBoard(half2);
		half1.setParentGame(this);
		half2.setParentGame(this);
		currentPlayer = Player.values()[random.nextInt(2)];
		boardDraw=new BoardDraw();
	}
	
	public BoardDraw getBoard(){
		return boardDraw;
	}
	public void startTurn()
	{
		if(currentPlayer==Player.PLAYER1)
		{
			half1.allCountDown();
		}
		else
		{
			half2.allCountDown();
		}
	}
	public void endTurn()
	{
		if(currentPlayer==Player.PLAYER1)
		{
			half1.allAttack();
		}
		else
		{
			half2.allAttack();
		}
		currentPlayer = currentPlayer.otherPlayer();
	}
}
