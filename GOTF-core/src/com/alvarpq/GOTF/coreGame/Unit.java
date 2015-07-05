package com.alvarpq.GOTF.coreGame;

import com.alvarpq.GOTF.coreGame.board.BoardHalf;

public abstract class Unit
{
	protected String name;
	protected int cardAttack, cardCountdown, cardHealth, selfAttack, selfCountdown, selfHealth;
	private int attack;
	private int countdown;
	private int health;
	protected boolean hasMoved = false;
	public void resetToCard()
	{
		selfAttack = cardAttack;
		selfCountdown = cardCountdown;
		selfHealth = cardHealth;
	}
	public void updateUnits(BoardHalf mySide, BoardHalf opponentsSide, int row, int column)
	{
		this.setAttack(this.getAttack() + this.selfAttack);
		this.setCountdown(this.getCountdown() + this.selfCountdown);
		this.setHealth(this.getHealth() + this.selfHealth);
	}
	public boolean move(BoardHalf mySide, BoardHalf opponentsSide, int row, int column, int destinationRow, int destinationColumn)
	{
		if(mySide.getUnits()[destinationRow][destinationColumn]==null&&BoardHalf.isAdjacent(row, column, destinationRow, destinationColumn))
		{
			mySide.getUnits()[destinationRow][destinationColumn] = this;
			mySide.getUnits()[row][column] = null;
			mySide.updateUnits(opponentsSide);
			opponentsSide.updateUnits(mySide);
			return true;
		}
		return false;
	}
	public boolean attack(BoardHalf mySide, BoardHalf opponentsSide, int row, int column)
	{
			boolean unitHit = false;
			for(int i=0;i<opponentsSide.getUnits()[row].length;i++)
			{
				if(opponentsSide.getUnits()[row][i]!=null)
				{
					opponentsSide.getUnits()[row][i].setHealth(opponentsSide.getUnits()[row][i].getHealth()
							- this.getAttack());
					opponentsSide.getUnits()[row][i].onDamageTaken(opponentsSide, mySide, row, i, row, column);
					if(opponentsSide.getUnits()[row][i].getHealth()>=0)
					{
						opponentsSide.getUnits()[row][i].onDestroyed(opponentsSide, mySide, row, i, row, column);
						opponentsSide.getUnits()[row][i] = null;
					}
					unitHit = true;
					break;
				}
			}
			if(!unitHit)
			{
				opponentsSide.getIdols()[row] -= this.getAttack();
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
	public void onMove(BoardHalf mySide, BoardHalf opponentsSide, int row, int column, int oldRow, int oldColumn){}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getCountdown() {
		return countdown;
	}
	public void setCountdown(int countdown) {
		this.countdown = countdown;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	};
}
