package com.alvarpq.GOTF.coreGame.units;
import java.util.LinkedList;
import java.util.List;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.coreGame.effect.Effect;
import com.alvarpq.GOTF.coreGame.effect.Presence;
public abstract class Unit
{
	private String name;
	private int baseCountdown, maximumHealth, baseMove;
	private int attack, countdown, health, move;
	private int row, column;
	private AttackType attackType;
	private List<Effect> effects;
	public Unit(String name, int attack, int baseCountdown, int maximumHealth, int baseMove, int row, int column)
	{
		this.name = name;
		this.baseCountdown = baseCountdown;
		this.maximumHealth = maximumHealth;
		this.baseMove = baseMove;
		this.attack = attack;
		countdown = baseCountdown;
		health = maximumHealth;
		move = baseMove;
		this.row = row;
		this.column = column;
		attackType = AttackType.NORMAL;
		effects = new LinkedList<Effect>();
	}
	//override for self-buffs and buffs on other units
	public abstract void applyPresence(BoardHalf mySide, BoardHalf opponentsSide);
	//call BoardHalf.move instead
	public void move(int row, int column)
	{
		this.row = row;
		this.column = column;
	}
	//call BoardHalf.resetCountdown instead
	public void resetCountdown()
	{
		countdown = baseCountdown;
	}
	//call BoardHalf.countDown instead
	public boolean countDown()
	{
		if(countdown>0)
		{
			countdown--;
			return true;
		}
		return false;
	}
	//call BoardHalf.resetMove instead
	public void resetMove()
	{
		move = baseMove;
	}
	//Changes the unit's current countdown
	public void changeCountdown(BoardHalf mySide, BoardHalf opponentsSide, int amount)
	{
		countdown+=amount;
		mySide.updateUnits();
	}
	//Heals the unit
	public void heal(BoardHalf mySide, BoardHalf opponentsSide, int amount)
	{
		health+=amount;
		if(health>maximumHealth)
		{
			health = maximumHealth;
		}
		mySide.updateUnits();
	}
	//Damages the unit
	public void damage(BoardHalf mySide, BoardHalf opponentsSide, int amount)
	{
		health-=amount;
		mySide.updateUnits();
	}
	//Only use inside AttackType attack function
	public void attackDamage(int amount)
	{
		health-=amount;
	}
	//Makes the unit lose or regain movement points
	public void changeMove(BoardHalf mySide, BoardHalf opponentsSide, int amount)
	{
		move+=amount;
		mySide.updateUnits();
	}
	public void applyEffect(Effect effect)
	{
		effects.add(effect);
		attack+=effect.attackChange();
		baseCountdown+=effect.baseCountdownChange();
		health+=effect.healthChange();
		maximumHealth+=effect.healthChange();
		baseMove+=effect.baseMoveChange();
	}
	public void removeEffect(int index)
	{
		attack-=effects.get(index).attackChange();
		baseCountdown-=effects.get(index).baseCountdownChange();
		health-=effects.get(index).healthChange();
		maximumHealth-=effects.get(index).healthChange();
		baseMove-=effects.get(index).baseMoveChange();
		effects.remove(index);
	}
	public void applyAllEffects()
	{
		for(Effect effect:effects)
		{
			attack+=effect.attackChange();
			baseCountdown+=effect.baseCountdownChange();
			health+=effect.healthChange();
			maximumHealth+=effect.healthChange();
			baseMove+=effect.baseMoveChange();
		}
	}
	public void clearPresenceEffects()
	{
		for(int i=0;i<effects.size();i++)
		{
			if(effects.get(i) instanceof Presence)
			{
				attack-=effects.get(i).attackChange();
				baseCountdown-=effects.get(i).baseCountdownChange();
				health-=effects.get(i).healthChange();
				maximumHealth-=effects.get(i).healthChange();
				baseMove-=effects.get(i).baseMoveChange();
				effects.remove(i);
				i--;
			}
		}
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
	@Override
	public String toString()
	{
		return "name: "+getName()+", baseCountdown: "+baseCountdown+", maximumHealth: "+maximumHealth+", baseMove: "+baseMove+", attack: "+attack+", countdown: "+countdown+", health: "+health+", move: "+move+", row: "+row+", column: "+column+", attackType: "+attackType;
	}
}
