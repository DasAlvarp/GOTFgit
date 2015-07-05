package com.alvarpq.GOTF.coreGame;
import java.util.Random;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.coreGame.units.Unit;
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
			for(Unit unit:half1.getUnits())
			{
				if(unit.getCountdown()==0)
				{
					unit.attack(half1, half2);
				}
			}
		}
	}
}
