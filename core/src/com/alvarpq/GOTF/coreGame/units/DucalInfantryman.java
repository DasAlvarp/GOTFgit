package com.alvarpq.GOTF.coreGame.units;

import com.alvarpq.GOTF.coreGame.board.BoardHalf;

public class DucalInfantryman extends Unit
{
	public DucalInfantryman()
	{
		name = "Ducal Infantryman";
		cardAttack = 1;
		cardCountdown = 2;
		cardHealth = 3;
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
