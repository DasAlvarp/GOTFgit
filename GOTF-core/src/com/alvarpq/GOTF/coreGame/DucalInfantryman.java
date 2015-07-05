package com.alvarpq.GOTF.coreGame;

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
		for(int i=0;i<mySide.units[row].length;i++)
		{
			if(i!=column&&mySide.units[row][i]!=null)
			{
				mySide.units[row][i].attack+=1;
			}
		}
	}
}
