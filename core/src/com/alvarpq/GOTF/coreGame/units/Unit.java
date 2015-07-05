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
	protected int row, column;
	public Unit(String name, int cardAttack, int cardCountdown, int cardHealth, int row, int column)
	{
		this.name = name;
		this.cardAttack = cardAttack;
		this.cardCountdown = cardCountdown;
		this.cardHealth = cardHealth;
		resetToCard();
		this.row = row;
		this.column = column;
	}
	public void resetToCard()
	{
		selfAttack = cardAttack;
		selfCountdown = cardCountdown;
		selfHealth = cardHealth;
	}
	public void updateUnits(BoardHalf mySide, BoardHalf opponentsSide)
	{
		attack+=selfAttack;
		countdown+=selfCountdown;
		health+=selfHealth;
	}
	public boolean move(BoardHalf mySide, BoardHalf opponentsSide, int destinationRow, int destinationColumn)
	{
		if(mySide.getUnitAt(destinationRow, destinationColumn)==null&&BoardHalf.isAdjacent(row, column, destinationRow, destinationColumn))
		{
			mySide.addUnit(this);
			mySide.removeUnit(row, column);
			mySide.updateUnits(opponentsSide);
			opponentsSide.updateUnits(mySide);
			return true;
		}
		return false;
	}
	public boolean attack(BoardHalf mySide, BoardHalf opponentsSide)
	{
			boolean unitHit = false;
			for(int i=0;i<opponentsSide.numberOfColumns();i++)
			{
				if(opponentsSide.getUnitAt(row, i)!=null)
				{
					opponentsSide.getUnitAt(row, i).health -= attack;
					opponentsSide.getUnitAt(row, i).onDamageTaken(opponentsSide, mySide, this);
					if(opponentsSide.getUnitAt(row, i).health>=0)
					{
						opponentsSide.getUnitAt(row, i).onDestroyed(opponentsSide, mySide, this);
						opponentsSide.removeUnit(row, i);
					}
					unitHit = true;
					break;
				}
			}
			if(!unitHit)
			{
				opponentsSide.setIdol(row, opponentsSide.getIdol(row)-attack);
				if(opponentsSide.getIdol(row)<0)
				{
					opponentsSide.setIdol(row, 0);
				}
			}
			mySide.updateUnits(opponentsSide);
			opponentsSide.updateUnits(mySide);
		return false;
	}
	
	public void onDamageTaken(BoardHalf mySide, BoardHalf opponentsSide, Unit attacker){};
	public void onDamageGiven(BoardHalf mySide, BoardHalf opponentsSide, Unit defender){};
	public void onDestroyed(BoardHalf mySide, BoardHalf opponentsSide, Unit attacker){};
	public void onUnitKilled(BoardHalf mySide, BoardHalf opponentsSide, Unit defender){};
	public void onCountdownDecreased(BoardHalf mySide, BoardHalf opponentsSide){};
	public void onCountdownIncreased(BoardHalf mySide, BoardHalf opponentsSide){};
	public void onMove(BoardHalf mySide, BoardHalf opponentsSide, int oldRow, int oldColumn){}
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
	public int getRow()
	{
		return row;
	}
	public void setRow(int row)
	{
		this.row = row;
	}
	public int getColumn()
	{
		return column;
	}
	public void setColumn(int column)
	{
		this.column = column;
	}
}
