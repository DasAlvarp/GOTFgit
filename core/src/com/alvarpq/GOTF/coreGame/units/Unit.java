package com.alvarpq.GOTF.coreGame.units;
import java.util.LinkedList;
import java.util.List;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.effect.Effect;
import com.alvarpq.GOTF.coreGame.effect.Presence;
public abstract class Unit
{
	/**
	 * The name of the unit.
	 */
	private String name;
	/**
	 * The filename of the unit's image.
	 */
	private String image;
	/**
	 * The base countdown of the unit.
	 */
	private int baseCountdown;
	/**
	 * The maximum health of the unit.
	 */
	private int maximumHealth;
	/**
	 * The base move of the unit.
	 */
	private int baseMove;
	/**
	 * The base targetable value of the unit.
	 */
	private boolean baseTargetable;
	/**
	 * The attack of the unit.
	 */
	private int attack;
	/**
	 * The countdown of the unit.
	 */
	private int countdown;
	/**
	 * The health of the unit.
	 */
	private int health;
	/**
	 * The move of the unit.
	 */
	private int move;
	/**
	 * The targetable value of the unit.
	 */
	private boolean targetable;
	/**
	 * The unit's subtypes.
	 */
	private String[] subtypes;
	/**
	 * The row of the unit.
	 */
	private int row;
	/**
	 * The column of the unit.
	 */
	private int column;
	/**
	 * The owner of the unit.
	 */
	private Player owner;
	/**
	 * The attack type of the unit.
	 */
	private AttackType attackType;
	/**
	 * The move type of the unit.
	 */
	private MoveType moveType;
	/**
	 * The effects currently applied to the unit.
	 */
	private List<Effect> effects;
	/**
	 * Instantiates a new unit.
	 * @param name the name of the unit
	 * @param image the filename of the unit's image
	 * @param attack the attack of the unit
	 * @param baseCountdown the base countdown of the unit
	 * @param maxiumumHealth the maximum health of the unit
	 * @param baseMove the base move of the unit
	 * @param baseTargetable the base targetable value of the unit
	 * @param subtypes the unit's subtypes
	 * @param row the row of the unit
	 * @param column the column of the unit
	 */
	public Unit(String name, String image, int attack, int baseCountdown, int maximumHealth, int baseMove, boolean baseTargetable, String[] subtypes, int row, int column)
	{
		super();
		this.name = name;
		this.image = image;
		this.baseCountdown = baseCountdown;
		this.maximumHealth = maximumHealth;
		this.baseMove = baseMove;
		this.baseTargetable = baseTargetable;
		this.attack = attack;
		countdown = baseCountdown;
		health = maximumHealth;
		move = baseMove;
		this.targetable = baseTargetable;
		this.subtypes = subtypes;
		this.row = row;
		this.column = column;
		owner = Player.NONE;
		attackType = new AttackType.Normal();
		moveType = new MoveType.Normal();
		effects = new LinkedList<Effect>();
	}
	/**
	 * Resets the unit's countdown.
	 */
	public void resetCountdown()
	{
		countdown = baseCountdown;
	}
	/**
	 * Makes the unit count down.
	 */
	public boolean countDown()
	{
		if(countdown>0)
		{
			countdown--;
			return true;
		}
		return false;
	}
	/**
	 * Resets the unit's move.
	 */
	public void resetMove()
	{
		move = baseMove;
	}
	/**
	 * Changes the unit's countdown.
	 * @param amount the amount to change the countdown with
	 */
	public void changeCountdown(int amount)
	{
		countdown+=amount;
	}
	/**
	 * Heals the unit.
	 * @param amount the amount to heal with
	 */
	public void heal(int amount)
	{
		health+=amount;
		if(health>maximumHealth)
		{
			health = maximumHealth;
		}
	}
	/**
	 * Damages the unit.
	 * @param amount the amount to damage with
	 */
	public void damage(int amount)
	{
		health-=amount;
	}
	/**
	 * Changes the unit's move.
	 * @param amount the amount to change move with
	 */
	public void changeMove(int amount)
	{
		move+=amount;
	}
	/**
	 * Applies an effect to the unit.
	 * @param effect the effect to apply
	 */
	public void applyEffect(Effect effect)
	{
		effects.add(effect);
		attack+=effect.attackChange();
		baseCountdown+=effect.baseCountdownChange();
		health+=effect.healthChange();
		maximumHealth+=effect.healthChange();
		baseMove+=effect.baseMoveChange();
		if(effect.untargetable())
		{
			targetable = false;
		}
	}
	/**
	 * Removes an effect from the unit.
	 * @param index the index of the effect to remove.
	 */
	public void removeEffect(int index)
	{
		attack-=effects.get(index).attackChange();
		baseCountdown-=effects.get(index).baseCountdownChange();
		health-=effects.get(index).healthChange();
		maximumHealth-=effects.get(index).healthChange();
		baseMove-=effects.get(index).baseMoveChange();
		if(effects.get(index).untargetable())
		{
			targetable = baseTargetable;
		}
		effects.remove(index);
	}
	/**
	 * Applies all the unit's effects to it.
	 */
	public void applyAllEffects()
	{
		for(Effect effect:effects)
		{
			attack+=effect.attackChange();
			baseCountdown+=effect.baseCountdownChange();
			health+=effect.healthChange();
			maximumHealth+=effect.healthChange();
			baseMove+=effect.baseMoveChange();
			if(effect.untargetable())
			{
				targetable = false;
			}
		}
	}
	/**
	 * Removes all the unit's presence effects.
	 */
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
				if(effects.get(i).untargetable())
				{
					targetable = baseTargetable;
				}
				effects.remove(i);
				i--;
			}
		}
	}
	/**
	 * Returns the unit's name.
	 * @return the unit's name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * Returns the filename of the unit's image.
	 * @return the filename of the unit's image
	 */
	public String getImage()
	{
		return image;
	}
	/**
	 * Returns the unit's base countdown.
	 * @return the unit's base countdown
	 */
	public int getBaseCountdown()
	{
		return baseCountdown;
	}
	/**
	 * Returns the unit's maximum health.
	 * @return the unit's health
	 */
	public int getMaximumHealth()
	{
		return maximumHealth;
	}
	/**
	 * Returns the unit's base move.
	 * @return the unit's base move
	 */
	public int getBaseMove()
	{
		return baseMove;
	}
	/**
	 * Returns the unit's base targetable value.
	 * @return the unit's base targetable value
	 */
	public boolean getBaseTargetable()
	{
		return baseTargetable;
	}
	/**
	 * Returns the unit's attack.
	 * @return the unit's attack
	 */
	public int getAttack()
	{
		return attack;
	}
	/**
	 * Returns the unit's countdown.
	 * @return the unit's countdown
	 */
	public int getCountdown()
	{
		return countdown;
	}
	/**
	 * Returns the unit's health.
	 * @return the unit's health
	 */
	public int getHealth()
	{
		return health;
	}
	/**
	 * Returns the unit's move.
	 * @return the unit's move
	 */
	public int getMove()
	{
		return move;
	}
	/**
	 * Returns the unit's targetable value.
	 * @return the unit's targetable value
	 */
	public boolean getTargetable()
	{
		return targetable;
	}
	/**
	 * Returns the unit's subtypes.
	 * @return the unit's subtypes
	 */
	public String[] getSubtypes()
	{
		return subtypes;
	}
	/**
	 * Sets the unit's row.
	 * @param row the unit's new row
	 */
	public void setRow(int row)
	{
		this.row = row;
	}
	/**
	 * Sets the unit's column.
	 * @param column the unit's new column
	 */
	public void setColumn(int column)
	{
		this.column = column;
	}
	/**
	 * Returns the unit's row.
	 * @return the unit's row
	 */
	public int getRow()
	{
		return row;
	}
	/**
	 * Returns the unit's column.
	 * @return the unit's column
	 */
	public int getColumn()
	{
		return column;
	}
	/**
	 * Returns the unit's owner.
	 * @return the unit's owner
	 */
	public Player getOwner()
	{
		return owner;
	}
	/**
	 * Sets the unit's owner.
	 * @param owner the unit's new owner
	 */
	public void setOwner(Player owner)
	{
		this.owner = owner;
	}
	/**
	 * Returns the unit's attack type.
	 * @return the unit's attack type
	 */
	public AttackType getAttackType()
	{
		return attackType;
	}
	/**
	 * Sets the unit's attack type.
	 * @param attackType the unit's new attack type
	 */
	public void setAttackType(AttackType attackType)
	{
		this.attackType = attackType;
	}
	/**
	 * Returns the unit's move type.
	 * @return the unit's move type
	 */
	public MoveType getMoveType()
	{
		return moveType;
	}
	/**
	 * Sets the unit's move type.
	 * @param attackType the unit's new move type
	 */
	public void setMoveType(MoveType moveType)
	{
		this.moveType = moveType;
	}
	/**
	 * Returns the unit as a String.
	 * @return the unit as a String
	 */
	@Override
	public String toString()
	{
		return "name: "+getName()+", baseCountdown: "+baseCountdown+", maximumHealth: "+maximumHealth+", baseMove: "+baseMove+", attack: "+attack+", countdown: "+countdown+", health: "+health+", move: "+move+", row: "+row+", column: "+column+", attackType: "+attackType;
	}
}
