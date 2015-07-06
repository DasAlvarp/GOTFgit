package com.alvarpq.GOTF.coreGame;
import java.util.Random;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
public class Game
{
	public final BoardHalf half1 = new BoardHalf(5, 3, 8, Player.PLAYER1);
	public final BoardHalf half2 = new BoardHalf(5, 3, 8, Player.PLAYER2);
	Player currentPlayer;
	private static final Random random = new Random();
	public Game()
	{
		BoardHalf.createBoard(half1, half2);
		currentPlayer = Player.values()[random.nextInt(2)];
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
