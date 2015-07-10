package com.alvarpq.GOTF.coreGame.board;
import java.util.LinkedList;
import java.util.List;
import com.alvarpq.GOTF.coreGame.Game;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.event.UnitDamagedByUnitEvent;
import com.alvarpq.GOTF.coreGame.event.UnitDamagedByUnitListener;
import com.alvarpq.GOTF.coreGame.event.UnitDamagedEvent;
import com.alvarpq.GOTF.coreGame.event.UnitDamagedListener;
import com.alvarpq.GOTF.coreGame.event.UnitEvent;
import com.alvarpq.GOTF.coreGame.event.UnitKilledByUnitEvent;
import com.alvarpq.GOTF.coreGame.event.UnitKilledByUnitListener;
import com.alvarpq.GOTF.coreGame.event.UnitKilledEvent;
import com.alvarpq.GOTF.coreGame.event.UnitKilledListener;
import com.alvarpq.GOTF.coreGame.hexEnchant.HexEnchantment;
import com.alvarpq.GOTF.coreGame.units.Unit;
import com.alvarpq.GOTF.entity.EntityManager;
public class BoardHalf
{
	//Do not change directly unless needed
	private Unit[][] units;
	private HexEnchantment[][] hexEnchantments;
	private int[] idols;
	private Player owner;
	private Game game;
	public BoardHalf(int rows, int columns, int idolHealth, Player owner)
	{
		units = new Unit[rows][columns];
		hexEnchantments = new HexEnchantment[rows][columns];
		idols = new int[rows];
		for(int i = 0; i < idols.length;i++)
		{
			setIdol(i, idolHealth);
		}
		this.owner = owner;
	}
	public BoardHalf(Unit[][] units, int[] idols)
	{
		this.units = units;
		this.idols = idols;
	}
	
	public void setParentGame(Game g){
		game=g;
	}
	
	public Game getParentGame(){
		return game;
	}
	public void update()
	{
		for(Unit unit:getUnits())
		{
			unit.clearPresenceEffects();
		}
		for(Unit unit:getUnits())
		{
			unit.applyPresence(game.getSide(owner), game.getSide(owner.otherPlayer()));
		}
		for(HexEnchantment hexEnchant:getHexEnchantments())
		{
			hexEnchant.applyPresence(game.getSide(owner), game.getSide(owner.otherPlayer()));
		}
		for(Unit unit:game.getSide(owner).getHalf().getUnits())
		{
			unit.clearPresenceEffects();
		}
		for(Unit unit:game.getSide(owner.otherPlayer()).getHalf().getUnits())
		{
			unit.applyPresence(game.getSide(owner), game.getSide(owner.otherPlayer()));
		}
		for(HexEnchantment hexEnchant:game.getSide(owner.otherPlayer()).getHalf().getHexEnchantments())
		{
			hexEnchant.applyPresence(game.getSide(owner), game.getSide(owner.otherPlayer()));
		}
		boolean newUpdate = false;
		for(int i=0;i<numberOfRows();i++)
		{
			for(int j=0;j<numberOfColumns();j++)
			{
				if(getUnitAt(i, j)!=null&&getUnitAt(i, j).getHealth()<=0)
				{
					dispatchEvent(new UnitKilledEvent(getUnitAt(i, j), game.getSide(owner), game.getSide(owner.otherPlayer())));
					units[i][j] = null;
					newUpdate = true;
				}
				if(game.getSide(owner.otherPlayer()).getHalf().getUnitAt(i, j)!=null&&game.getSide(owner.otherPlayer()).getHalf().getUnitAt(i, j).getHealth()<=0)
				{
					dispatchEvent(new UnitKilledEvent(game.getSide(owner.otherPlayer()).getHalf().getUnitAt(i, j), game.getSide(owner), game.getSide(owner.otherPlayer())));
					game.getSide(owner.otherPlayer()).getHalf().units[i][j] = null;
					newUpdate = true;
				}
			}
		}
		if(newUpdate)
		{
			update();
		}
	}
	public void allAttack()
	{
		for(int i=0;i<numberOfRows();i++)
		{
			rowAttack(i);
		}
	}
	public void rowAttack(int row)
	{
		for(int i=0;i<numberOfColumns();i++)
		{
			if(getUnitAt(row, i)!=null&&getUnitAt(row, i).getCountdown()==0)
			{
				attack(getUnitAt(row, i));
			}
		}
	}
	public void allCountDown()
	{
		for(Unit unit:getUnits())
		{
			unit.countDown();
		}
		update();
	}
	public void allResetMove()
	{
		for(Unit unit:getUnits())
		{
			unit.resetMove();
		}
		update();
	}
	public Unit getUnitAt(int row, int column)
	{
		return units[row][column];
	}
	public List<Unit> getUnits()
	{
		List<Unit> toReturn = new LinkedList<Unit>();
		for(int i=0;i<numberOfRows();i++)
		{
			for(int j=0;j<numberOfColumns();j++)
			{
				if(getUnitAt(i, j)!=null)
				{
					toReturn.add(getUnitAt(i, j));
				}
			}
		}
		return toReturn;
	}
	public void addUnit(Unit unit)
	{
		units[unit.getRow()][unit.getColumn()] = unit;
		unit.setOwner(owner);
		EntityManager.addEntity(unit);
		update();
	}
	public void removeUnit(int row, int column)
	{
		getUnitAt(row, column).setOwner(Player.NONE);
		units[row][column] = null;
		update();
	}
	public HexEnchantment getHexEnchantmentAt(int row, int column)
	{
		return hexEnchantments[row][column];
	}

	public List<HexEnchantment> getHexEnchantments()
	{
		List<HexEnchantment> toReturn = new LinkedList<HexEnchantment>();
		for(int i=0;i<numberOfRows();i++)
		{
			for(int j=0;j<numberOfColumns();j++)
			{
				if(getHexEnchantmentAt(i, j)!=null)
				{
					toReturn.add(getHexEnchantmentAt(i, j));
				}
			}
		}
		return toReturn;
	}
	public void addHexEnchantment(HexEnchantment hexEnchant)
	{
		hexEnchantments[hexEnchant.getRow()][hexEnchant.getColumn()] = hexEnchant;
		hexEnchant.setOwner(owner);
		update();
	}
	public void removeHexEnchantment(int row, int column)
	{
		getHexEnchantmentAt(row, column).setOwner(Player.NONE);
		hexEnchantments[row][column] = null;
		update();
	}
	public boolean move(int row, int column, int destinationRow, int destinationColumn)
	{
		boolean toReturn = getUnitAt(row, column).getMoveType().move(getUnitAt(row, column), destinationRow, destinationColumn, game.getSide(owner), game.getSide(owner.otherPlayer()), units);
		update();
		return toReturn;
	}
	public boolean move(Unit unit, int row, int column)
	{
		boolean toReturn = unit.getMoveType().move(unit, row, column, game.getSide(owner), game.getSide(owner.otherPlayer()), units);
		update();
		return toReturn;
	}
	public void attack(int row, int column)
	{
		getUnitAt(row, column).getAttackType().attack(getUnitAt(row, column), game.getSide(owner), game.getSide(owner.otherPlayer()));
		update();
	}
	public void attack(Unit unit)
	{
		unit.getAttackType().attack(unit, game.getSide(owner), game.getSide(owner.otherPlayer()));
		resetCountdown(unit);
		update();
	}
	public void resetCountdown(int row, int column)
	{
		getUnitAt(row, column).resetCountdown();
		update();
	}
	public void resetCountdown(Unit unit)
	{
		unit.resetCountdown();
		update();
	}
	public boolean countDown(int row, int column)
	{
		boolean toReturn = getUnitAt(row, column).countDown();
		update();
		return toReturn;
	}
	public boolean countDown(Unit unit)
	{
		boolean toReturn = unit.countDown();
		update();
		return toReturn;
	}
	public void resetMove(int row, int column)
	{
		getUnitAt(row, column).resetMove();
		update();
	}
	public void resetMove(Unit unit)
	{
		unit.resetMove();
		update();
	}
	public void changeCountdown(int row, int column, int amount)
	{
		getUnitAt(row, column).changeCountdown(amount);
		update();
	}
	public void changeCountdown(Unit unit, int amount)
	{
		unit.changeCountdown(amount);
		update();
	}
	public void heal(int row, int column, int amount)
	{
		getUnitAt(row, column).heal(amount);
		update();
	}
	public void heal(Unit unit, int amount)
	{
		unit.heal(amount);
		update();
	}
	public void damage(int row, int column, int amount, Unit damager)
	{
		getUnitAt(row, column).damage(amount);
		if(damager!=null)
		{
			dispatchEvent(new UnitDamagedByUnitEvent(getUnitAt(row, column), damager, amount, game.getSide(owner), game.getSide(owner.otherPlayer())));
		}
		dispatchEvent(new UnitDamagedEvent(getUnitAt(row, column), amount, game.getSide(owner), game.getSide(owner.otherPlayer())));
		update();
	}
	public void damage(Unit unit, int amount, Unit damager)
	{
		unit.damage(amount);
		if(damager!=null)
		{
			dispatchEvent(new UnitDamagedByUnitEvent(unit, damager, amount, game.getSide(owner), game.getSide(owner.otherPlayer())));
		}
		dispatchEvent(new UnitDamagedEvent(unit, amount, game.getSide(owner), game.getSide(owner.otherPlayer())));
		update();
	}
	public void changeMove(int row, int column, int amount)
	{
		getUnitAt(row, column).changeMove(amount);
		update();
	}
	public void changeMove(Unit unit, int amount)
	{
		unit.changeMove(amount);
		update();
	}
	public int getIdolAt(int row)
	{
		return idols[row];
	}
	public void setIdol(int row, int value)
	{
		idols[row] = value;
	}
	public int numberOfRows()
	{
		return units.length;
	}
	public int numberOfColumns()
	{
		return units[0].length;
	}
	public Player getOwner()
	{
		return owner;
	}
	public void dispatchEvent(UnitEvent event)
	{
		if(event instanceof UnitKilledByUnitEvent)
		{
			for(Unit unit:getUnits())
			{
				if(unit instanceof UnitKilledByUnitListener)
				{
					((UnitKilledByUnitListener)unit).onUnitKilledByUnit((UnitKilledByUnitEvent)event);
				}
			}
			event.invertSides();
			for(Unit unit:game.getSide(owner.otherPlayer()).getHalf().getUnits())
			{
				if(unit instanceof UnitKilledByUnitListener)
				{
					((UnitKilledByUnitListener)unit).onUnitKilledByUnit((UnitKilledByUnitEvent)event);
				}
			}
		}
		else if(event instanceof UnitKilledEvent)
		{
			for(Unit unit:getUnits())
			{
				if(unit instanceof UnitKilledListener)
				{
					((UnitKilledListener)unit).onUnitKilled((UnitKilledEvent)event);
				}
			}
			event.invertSides();
			for(Unit unit:game.getSide(owner.otherPlayer()).getHalf().getUnits())
			{
				if(unit instanceof UnitKilledListener)
				{
					((UnitKilledListener)unit).onUnitKilled((UnitKilledEvent)event);
				}
			}
		}
		else if(event instanceof UnitDamagedByUnitEvent)
		{
			for(Unit unit:getUnits())
			{
				if(unit instanceof UnitDamagedByUnitListener)
				{
					((UnitDamagedByUnitListener)unit).onUnitDamagedByUnit((UnitDamagedByUnitEvent)event);
				}
			}
			event.invertSides();
			for(Unit unit:game.getSide(owner.otherPlayer()).getHalf().getUnits())
			{
				if(unit instanceof UnitDamagedByUnitListener)
				{
					((UnitDamagedByUnitListener)unit).onUnitDamagedByUnit((UnitDamagedByUnitEvent)event);
				}
			}
		}
		else if(event instanceof UnitDamagedEvent)
		{
			for(Unit unit:getUnits())
			{
				if(unit instanceof UnitDamagedListener)
				{
					((UnitDamagedListener)unit).onUnitDamaged((UnitDamagedEvent)event);
				}
			}
			event.invertSides();
			for(Unit unit:game.getSide(owner.otherPlayer()).getHalf().getUnits())
			{
				if(unit instanceof UnitDamagedListener)
				{
					((UnitDamagedListener)unit).onUnitDamaged((UnitDamagedEvent)event);
				}
			}
		}
	}
	public static boolean isAdjacent(int row1, int column1, int row2, int column2)
	{
		if(row1==row2)
		{
			if(Math.abs(column1-column2)==1)
			{
				return true;
			}
			return false;
		}
		if(Math.abs(row1-row2)==1)
		{
			if(row1%2==0)
			{
				if(column2==column1+1||column2==column1)
				{
					return true;
				}
				return false;
			}
			if(column1==column2+1||column1==column2)
			{
				return true;
			}
			return false;
		}
		return false;
	}
}
