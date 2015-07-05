package com.alvarpq.GOTF.coreGame.units;

import com.alvarpq.GOTF.coreGame.board.BoardHalf;

public class RoyalInfantryman extends Unit
{
	public RoyalInfantryman()
	{
		setName("Royal Infantryman");
		setCardAttack(1);
		setCardCountdown(2);
		setCardHealth(3);
		resetToCard();
	}
	@Override
	public void updateUnits(BoardHalf mySide, BoardHalf opponentsSide, int row, int column)
	{
		super.updateUnits(mySide, opponentsSide, row, column);
		for(int i=0;i<mySide.getUnits()[row].length;i++)
		{
			if(i!=column&&mySide.getUnits()[row][i]!=null)
			{
				mySide.getUnits()[row][i].setHealth(mySide.getUnits()[row][i].getHealth() + 1);
			}
		}
	}
}