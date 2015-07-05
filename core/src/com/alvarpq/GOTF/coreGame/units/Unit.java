package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
public abstract class Unit
{
	private String name;
	private int cardAttack, cardCountdown, cardHealth, cardMove;
	private int selfAttack, selfCountdown, selfHealth, selfMove;
	private int attack, countdown, health, move;
	private int row, column;
	public Unit(String name, int cardAttack, int cardCountdown, int cardHealth, int cardMove, int row, int column)
	{
		this.name = name;
		this.cardAttack = cardAttack;
		this.cardCountdown = cardCountdown;
		this.cardHealth = cardHealth;
		this.cardMove = cardMove;
		resetToCard();
		this.row = row;
		this.column = column;
	}
	//Resummoning it
	public void resetToCard()
	{
		selfAttack = cardAttack;
		selfCountdown = cardCountdown;
		selfHealth = cardHealth;
		selfMove = cardMove;
	}
	//Do not call
	public void beforeUpdateUnits()
	{
		attack = 0;
		countdown = 0;
		health = 0;
		move = 0;
	}
	//For overriding
	public void updateUnits(BoardHalf mySide, BoardHalf opponentsSide)
	{
		attack+=selfAttack;
		countdown+=selfCountdown;
		health+=selfHealth;
		move+=selfMove;
	}
	//For overriding
	public boolean move(BoardHalf mySide, BoardHalf opponentsSide, int row, int column)
	{
		return mySide.moveUnit(opponentsSide, getRow(), getColumn(), row, column);
	}
	//For overriding
	public boolean attack(BoardHalf mySide, BoardHalf opponentsSide)
	{
			boolean unitHit = false;
			for(int i=0;i<opponentsSide.numberOfColumns();i++)
			{
				if(opponentsSide.getUnitAt(row, i)!=null)
				{
					opponentsSide.getUnitAt(row, i).selfHealth -= attack;
					unitHit = true;
					break;
				}
			}
			if(!unitHit)
			{
				opponentsSide.setIdol(row, opponentsSide.getIdolAt(row)-attack);
				if(opponentsSide.getIdolAt(row)<0)
				{
					opponentsSide.setIdol(row, 0);
				}
			}
			mySide.updateUnits(opponentsSide);
			opponentsSide.updateUnits(mySide);
		return false;
	}
	//For overriding
	public void resetCountdown(BoardHalf mySide, BoardHalf opponentsSide)
	{
		selfCountdown = cardCountdown;
		mySide.updateUnits(opponentsSide);
		opponentsSide.updateUnits(mySide);
	}
	//For overriding
	public boolean countDown(BoardHalf mySide, BoardHalf opponentsSide)
	{
		if(countdown>0)
		{
			selfCountdown--;
			mySide.updateUnits(opponentsSide);
			opponentsSide.updateUnits(mySide);
			return true;
		}
		return false;
	}
	//Use inside updateUnits
	public void changeAttack(BoardHalf mySide, BoardHalf opponentsSide, int amount)
	{
		selfAttack+=amount;
		mySide.updateUnits(opponentsSide);
		opponentsSide.updateUnits(mySide);
	}
	//Use inside updateUnits
	public void changeCountdown(BoardHalf mySide, BoardHalf opponentsSide, int amount)
	{
		selfCountdown+=amount;
		mySide.updateUnits(opponentsSide);
		opponentsSide.updateUnits(mySide);
	}
	//Use inside updateUnits
	public void changeHealth(BoardHalf mySide, BoardHalf opponentsSide, int amount)
	{
		selfHealth+=amount;
		mySide.updateUnits(opponentsSide);
		opponentsSide.updateUnits(mySide);
	}
	//Use inside updateUnits
	public void changeMove(BoardHalf mySide, BoardHalf opponentsSide, int amount)
	{
		selfMove+=amount;
		mySide.updateUnits(opponentsSide);
		opponentsSide.updateUnits(mySide);
	}
	//For overriding
	public void onDamageTaken(BoardHalf mySide, BoardHalf opponentsSide, Unit attacker){};
	//For overriding
	public void onDamageGiven(BoardHalf mySide, BoardHalf opponentsSide, Unit defender){};
	//For overriding
	public void onDestroyed(BoardHalf mySide, BoardHalf opponentsSide, Unit attacker){};
	//For overriding
	public void onUnitKilled(BoardHalf mySide, BoardHalf opponentsSide, Unit defender){};
	//For overriding
	public void onCountdownDecreased(BoardHalf mySide, BoardHalf opponentsSide){};
	//For overriding
	public void onCountdownIncreased(BoardHalf mySide, BoardHalf opponentsSide){};
	//For overriding
	public void onMove(BoardHalf mySide, BoardHalf opponentsSide, int oldRow, int oldColumn){}
	//For overriding
	public String getName()
	{
		return name;
	}
	public int getAttack()
	{
		return attack;
	}
	public int getCountdown()
	{
		return countdown;
	}
	public int getMove()
	{
		return move;
	}
	public int getHealth()
	{
		return health;
	}
	public int getRow()
	{
		return row;
	}
	public int getColumn()
	{
		return column;
	}
}
