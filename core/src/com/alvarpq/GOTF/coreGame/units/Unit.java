package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
public abstract class Unit
{
	//The name of the unit
	private String name;
	//The values depicted on the card the unit was created from
	private int cardAttack, cardCountdown, cardHealth, cardMove;
	//The current values without buffs, debuffs
	private int selfAttack, selfCountdown, selfHealth, selfMove;
	//The current values with buffs, debuffs
	private int attack, countdown, health, move;
	//The unit's position
	private int row, column;
	//The unit's attack type
	private AttackType attackType;
	//Constructor for use within subclasses
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
		attackType = AttackType.NORMAL;
	}
	//Reset the self-values to their original values
	public void resetToCard()
	{
		selfAttack = cardAttack;
		selfCountdown = cardCountdown;
		selfHealth = cardHealth;
		selfMove = cardMove;
	}
	//To not ever call this function
	public void beforeUpdateUnits()
	{
		attack = 0;
		countdown = 0;
		health = 0;
		move = 0;
	}
	//Override this function to make units with depending attack values and units that buff other units, when overriding it always call super.
	public void updateUnits(BoardHalf mySide, BoardHalf opponentsSide)
	{
		updateAttack(selfAttack);
		updateCountdown(selfCountdown);
		updateHealth(selfHealth);
		updateMove(selfMove);
	}
	//Moves the unit
	public boolean move(BoardHalf mySide, BoardHalf opponentsSide, int row, int column)
	{
		return mySide.moveUnit(opponentsSide, getRow(), getColumn(), row, column);
	}
	//Makes the unit attack
	public void attack(BoardHalf mySide, BoardHalf opponentsSide)
	{
		attackType.attack(this, mySide, opponentsSide);
		mySide.updateUnits(opponentsSide);
		opponentsSide.updateUnits(mySide);
	}
	//Resets the countdown of the unit to the value depicted on the card
	public void resetCountdown(BoardHalf mySide, BoardHalf opponentsSide)
	{
		selfCountdown = cardCountdown;
		mySide.updateUnits(opponentsSide);
		opponentsSide.updateUnits(mySide);
	}
	//Counts the unit down by one
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
	//Changes the unit's current countdown
	public void changeCountdown(BoardHalf mySide, BoardHalf opponentsSide, int amount)
	{
		selfCountdown+=amount;
		mySide.updateUnits(opponentsSide);
		opponentsSide.updateUnits(mySide);
	}
	//Damages or heals the unit
	public void changeHealth(BoardHalf mySide, BoardHalf opponentsSide, int amount)
	{
		selfHealth+=amount;
		mySide.updateUnits(opponentsSide);
		opponentsSide.updateUnits(mySide);
	}
	//Makes the unit lose or regain movement points
	public void changeMove(BoardHalf mySide, BoardHalf opponentsSide, int amount)
	{
		selfMove+=amount;
		mySide.updateUnits(opponentsSide);
		opponentsSide.updateUnits(mySide);
	}
	//Use to buff/debuff attack inside updateUnits
	public void updateAttack(int amount)
	{
		attack+=amount;
	}
	//Use to buff/debuff countdown inside updateUnits
	public void updateCountdown(int amount)
	{
		countdown+=amount;
	}
	//Use to buff/debuff health inside updateUnits
	public void updateHealth(int amount)
	{
		health+=amount;
	}
	//Use to buff/debuff movement points inside updateUnits
	public void updateMove(int amount)
	{
		move+=amount;
	}
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
	public AttackType getAttackType()
	{
		return attackType;
	}
	public void setAttackType(AttackType attackType)
	{
		this.attackType = attackType;
	}
}
