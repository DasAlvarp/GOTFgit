package com.alvarpq.GOTF.coreGame.units;

import com.alvarpq.GOTF.coreGame.board.BoardHalf;

public abstract class Unit
{
	protected String name;
	//Only change in unit constructors
	protected int cardAttack, cardCountdown, cardHealth;
	//Change when unit is damaged/healed, and when units has its countdown decreased/increased
	protected int selfAttack, selfCountdown, selfHealth;
	//Only change through updateUnits
	protected int attack, countdown, health;
	protected boolean hasMoved = false;
	
	public void resetToCard()
	{
		selfAttack = cardAttack;
		selfCountdown = cardCountdown;
		selfHealth = cardHealth;
	}
	
	public void updateUnits(BoardHalf mySide, BoardHalf opponentsSide, int row, int column)
	{
		attack+=selfAttack;
		countdown+=selfCountdown;
		health+=selfHealth;
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
					opponentsSide.getUnits()[row][i].health -= attack;
					opponentsSide.getUnits()[row][i].onDamageTaken(opponentsSide, mySide, row, i, row, column);
					if(opponentsSide.getUnits()[row][i].health>=0)
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
				opponentsSide.getIdols()[row] -= attack;
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
	//Only use getters and setters when protected members are not accesible
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getCardAttack()
	{
		return cardAttack;
	}
	public void setCardAttack(int cardAttack)
	{
		this.cardAttack = cardAttack;
	}
	public int getCardCountdown()
	{
		return cardCountdown;
	}
	public void setCardCountdown(int cardCountdown)
	{
		this.cardCountdown = cardCountdown;
	}
	public int getCardHealth()
	{
		return cardHealth;
	}
	public void setCardHealth(int cardHealth)
	{
		this.cardHealth = cardHealth;
	}
	public int getSelfAttack()
	{
		return selfAttack;
	}
	public void setSelfAttack(int selfAttack)
	{
		this.selfAttack = selfAttack;
	}
	public int getSelfCountdown()
	{
		return selfCountdown;
	}
	public void setSelfCountdown(int selfCountdown)
	{
		this.selfCountdown = selfCountdown;
	}
	public int getSelfHealth()
	{
		return selfHealth;
	}
	public void setSelfHealth(int selfHealth)
	{
		this.selfHealth = selfHealth;
	}
	public int getAttack()
	{
		return attack;
	}
	public void setAttack(int attack)
	{
		this.attack = attack;
	}
	public int getCountdown()
	{
		return countdown;
	}
	public void setCountdown(int countdown)
	{
		this.countdown = countdown;
	}
	public int getHealth()
	{
		return health;
	}
	public void setHealth(int health)
	{
		this.health = health;
	}
	public boolean isHasMoved()
	{
		return hasMoved;
	}
	public void setHasMoved(boolean hasMoved)
	{
		this.hasMoved = hasMoved;
	}
}
