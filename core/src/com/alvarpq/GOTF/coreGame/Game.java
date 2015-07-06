package com.alvarpq.GOTF.coreGame;
import java.util.Random;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
public class Game
{
	final BoardHalf half1 = new BoardHalf(5, 3, 8);
	final BoardHalf half2 = new BoardHalf(5, 3, 8);
	boolean startingPlayer;
	private static final Random random = new Random();
	public Game()
	{
		startingPlayer = random.nextBoolean();
	}
	public void endTurn()
	{
		if(startingPlayer)
		{
			half1.allAttack();
		}
		else
		{
			half2.allAttack();
		}
	}
}
