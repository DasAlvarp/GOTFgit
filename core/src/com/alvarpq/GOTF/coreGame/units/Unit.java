package com.alvarpq.GOTF.coreGame.units;
import java.util.LinkedList;
import java.util.List;

import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.coreGame.effect.Effect;
import com.alvarpq.GOTF.coreGame.effect.Presence;
import com.alvarpq.GOTF.entity.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
public abstract class Unit extends Entity
{
	private String name;
	private int baseCountdown, maximumHealth, baseMove;
	private boolean baseTargetable;
	private int attack, countdown, health, move;
	private boolean targetable;
	private String[] subtypes;
	private int row, column;
	private Player owner;
	private AttackType attackType;
	private MoveType moveType;
	private List<Effect> effects;
	//Temp frame variable to do animations
	protected int frame=0;
	public Unit(String name, int attack, int baseCountdown, int maximumHealth, int baseMove, boolean baseTargetable, String[] subtypes, int row, int column)
	{
		super();
		this.name = name;
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
		attackType = AttackType.NORMAL;
		setMoveType(MoveType.NORMAL);
		effects = new LinkedList<Effect>();
	}
	//call BoardHalf.move instead
	//NEW METHOD~TO IMPLEMENT
	/*public Sprite getSprite() {
		// TODO Auto-generated method stub
		 return new Sprite(new Texture(Gdx.files.internal("noTexture.png")));
		
	}*/
	
	public Vector2 getLocation(){
		return new Vector2(owner.getBoard().getParentGame().getBoard().getP1()[row][column].getX(),owner.getBoard().getParentGame().getBoard().getP1()[row][column].getY());
	}
	//call BoardHalf.resetCountdown instead
	
	//override for self-buffs and buffs on other units
	public abstract void applyPresence(BoardHalf mySide, BoardHalf opponentsSide);
	public void resetCountdown()
	{
		countdown = baseCountdown;
	}
	public boolean countDown()
	{
		if(countdown>0)
		{
			countdown--;
			return true;
		}
		return false;
	}
	public void resetMove()
	{
		move = baseMove;
	}
	public void changeCountdown(int amount)
	{
		countdown+=amount;
	}
	public void heal(int amount)
	{
		health+=amount;
		if(health>maximumHealth)
		{
			health = maximumHealth;
		}
	}
	public void damage(int amount)
	{
		health-=amount;
	}
	public void changeMove(int amount)
	{
		move+=amount;
	}
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
	public String getName()
	{
		return name;
	}
	public int getBaseCountdown()
	{
		return baseCountdown;
	}
	public int getMaximumHealth()
	{
		return maximumHealth;
	}
	public int getBaseMove()
	{
		return baseMove;
	}
	public boolean getBaseTargetable()
	{
		return baseTargetable;
	}
	public int getAttack()
	{
		return attack;
	}
	public int getCountdown()
	{
		return countdown;
	}
	public int getHealth()
	{
		return health;
	}
	public int getMove()
	{
		return move;
	}
	public boolean getTargetable()
	{
		return targetable;
	}
	public String[] getSubtypes()
	{
		return subtypes;
	}
	public void setRow(int row)
	{
		this.row = row;
	}
	public void setColumn(int column)
	{
		this.column = column;
	}
	public int getRow()
	{
		return row;
	}
	public int getColumn()
	{
		return column;
	}
	public Player getOwner()
	{
		return owner;
	}
	public void setOwner(Player owner)
	{
		this.owner = owner;
	}
	public AttackType getAttackType()
	{
		return attackType;
	}
	public void setAttackType(AttackType attackType)
	{
		this.attackType = attackType;
	}
	public MoveType getMoveType()
	{
		return moveType;
	}
	public void setMoveType(MoveType moveType)
	{
		this.moveType = moveType;
	}
	@Override
	public String toString()
	{
		return "name: "+getName()+", baseCountdown: "+baseCountdown+", maximumHealth: "+maximumHealth+", baseMove: "+baseMove+", attack: "+attack+", countdown: "+countdown+", health: "+health+", move: "+move+", row: "+row+", column: "+column+", attackType: "+attackType;
	}
}
