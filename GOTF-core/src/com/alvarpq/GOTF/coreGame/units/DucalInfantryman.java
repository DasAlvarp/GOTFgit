package com.alvarpq.GOTF.coreGame.units;

import com.alvarpq.GOTF.coreGame.board.BoardHalf;

public class DucalInfantryman extends Unit
{
	public DucalInfantryman()
	{
		setName("Ducal Infantryman");
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
				mySide.getUnits()[row][i].setAttack(mySide.getUnits()[row][i].getAttack() + 1);
			}
		}
	}
}
