package com.alvarpq.GOTF.coreGame;

public abstract class Unit
{
	protected String name;
	protected int cardAttack, cardCountdown, cardHealth, selfAttack, selfCountdown, selfHealth, attack, countdown, health;
	protected boolean hasMoved = false;
	public void resetToCard()
	{
		selfAttack = cardAttack;
		selfCountdown = cardCountdown;
		selfHealth = cardHealth;
	}
	public void updateUnits(BoardHalf mySide, BoardHalf opponentsSide, int row, int column)
	{
		this.attack+=this.selfAttack;
		this.countdown+=this.selfCountdown;
		this.health+=this.selfHealth;
	}
	public boolean move(BoardHalf mySide, BoardHalf opponentsSide, int row, int column, int destinationRow, int destinationColumn)
	{
		if(mySide.units[destinationRow][destinationColumn]==null&&BoardHalf.isAdjacent(row, column, destinationRow, destinationColumn))
		{
			mySide.units[destinationRow][destinationColumn] = this;
			mySide.units[row][column] = null;
			mySide.updateUnits(opponentsSide);
			opponentsSide.updateUnits(mySide);
			return true;
		}
		return false;
	}
	public boolean attack(BoardHalf mySide, BoardHalf opponentsSide, int row, int column)
	{
			boolean unitHit = false;
			for(int i=0;i<opponentsSide.units[row].length;i++)
			{
				if(opponentsSide.units[row][i]!=null)
				{
					opponentsSide.units[row][i].health -= this.attack;
					opponentsSide.units[row][i].onDamageTaken(opponentsSide, mySide, row, i, row, column);
					if(opponentsSide.units[row][i].health>=0)
					{
						opponentsSide.units[row][i].onDestroyed(opponentsSide, mySide, row, i, row, column);
						opponentsSide.units[row][i] = null;
					}
					unitHit = true;
					break;
				}
			}
			if(!unitHit)
			{
				opponentsSide.idols[row] -= this.attack;
			}
			mySide.updateUnits(opponentsSide);
			opponentsSide.updateUnits(mySide);
		return false;
	}
	public void onDamageTaken(BoardHalf mySide, BoardHalf opponentsSide, int row, int column, int attackerRow, int attackerColumn){};
	public void onDamageGiven(BoardHalf mySide, BoardHalf opponentsSide, int row, int column, int defenderRow, int defenderColumn){};
	public void onDestroyed(BoardHalf mySide, BoardHalf opponentsSide, int row, int column, int attackerRow, int attackerColumn){};
	public void onUnitKilled(BoardHalf mySide, BoardHalf opponentsSide, int row, int column, int defenderRow, int defenderColumn){};
	public void onCountdownDecreased(BoardHalf mySide, BoardHalf opponentsSide, int row, int column){};
	public void onCountdownIncreased(BoardHalf mySide, BoardHalf opponentsSide, int row, int column){};
	public void onMove(BoardHalf mySide, BoardHalf opponentsSide, int row, int column, int oldRow, int oldColumn){};
}
