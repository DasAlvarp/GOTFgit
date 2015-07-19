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
import com.alvarpq.GOTF.coreGame.units.PresenceApplier;
import com.alvarpq.GOTF.coreGame.units.Unit;
public class BoardHalf
{
	/**
	 * The board half's units.
	 */
	private Unit[][] units;
	/**
	 * The board half's hex enchantments.
	 */
	private HexEnchantment[][] hexEnchantments;
	/**
	 * The board half's idols.
	 */
	private int[] idols;
	/**
	 * The board half's owner.
	 */
	private Player owner;
	/**
	 * The board half's game.
	 */
	private Game game;
	/**
	 * Instantiates a BoardHalf.
	 * @param rows the number of rows
	 * @param columns the number of columns
	 * @param owner the owner of the board half
	 */
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
	/**
	 * Sets the parent game.
	 * @param g the parent game
	 */
	public void setParentGame(Game g){
		game=g;
	}
	/**
	 * Gets the parent game.
	 * @return the parent game
	 */
	public Game getParentGame(){
		return game;
	}
	/**
	 * Updates all units and hexEnchantments.
	 */
	public void update()
	{
		for(Unit unit:getUnits())
		{
			unit.clearPresenceEffects();
		}
		for(Unit unit:getUnits())
		{
			if(unit instanceof PresenceApplier)
			{
				((PresenceApplier)unit).applyPresence(game.getSide(owner), game.getSide(owner.otherPlayer()));
			}
		}
		for(HexEnchantment hexEnchant:getHexEnchantments())
		{
			if(hexEnchant instanceof PresenceApplier)
			{
				((PresenceApplier)hexEnchant).applyPresence(game.getSide(owner), game.getSide(owner.otherPlayer()));
			}
		}
		for(Unit unit:game.getSide(owner.otherPlayer()).getHalf().getUnits())
		{
			unit.clearPresenceEffects();
		}
		for(Unit unit:game.getSide(owner.otherPlayer()).getHalf().getUnits())
		{
			if(unit instanceof PresenceApplier)
			{
				((PresenceApplier)unit).applyPresence(game.getSide(owner.otherPlayer()), game.getSide(owner));
			}
		}
		for(HexEnchantment hexEnchant:game.getSide(owner.otherPlayer()).getHalf().getHexEnchantments())
		{
			if(hexEnchant instanceof PresenceApplier)
			{
				((PresenceApplier)hexEnchant).applyPresence(game.getSide(owner.otherPlayer()), game.getSide(owner));
			}
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
	/**
	 * Makes all units with countdown zero attack.
	 */
	public void allAttack()
	{
		for(int i=0;i<numberOfRows();i++)
		{
			rowAttack(i);
		}
	}
	/**
	 * Makes all units on the specified row with countdown zero attack.
	 * @param row the row to make units attack on
	 */
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
	/**
	 * Makes all units count down.
	 */
	public void allCountDown()
	{
		for(Unit unit:getUnits())
		{
			unit.countDown();
		}
		update();
	}
	/**
	 * Makes all units reset their move.
	 */
	public void allResetMove()
	{
		for(Unit unit:getUnits())
		{
			unit.resetMove();
		}
		update();
	}
	/**
	 * Returns the unit at the specified position.
	 * @param row the row to get the unit at
	 * @param column the column to get the unit at
	 * @return the unit at the specified position
	 */
	public Unit getUnitAt(int row, int column)
	{
		return units[row][column];
	}
	/**
	 * Returns all units on the side.
	 * @return all units on the side
	 */
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
	/**
	 * Adds a unit to the side.
	 * @param unit the unit to add
	 */
	public void addUnit(Unit unit)
	{
		units[unit.getRow()][unit.getColumn()] = unit;
		unit.setOwner(owner);
		update();
	}
	/**
	 * Removes the unit at the specified position.
	 * @param row the row to remove the unit at
	 * @param column the column to remove the unit at
	 */
	public void removeUnit(int row, int column)
	{
		getUnitAt(row, column).setOwner(Player.NONE);
		units[row][column] = null;
		update();
	}
	/**
	 * Returns the hex enchantment at the specified position.
	 * @param row the row to get the hex enchantment at
	 * @param column the column to get the hex enchantment at
	 * @return the hex enchantment at the specified position
	 */
	public HexEnchantment getHexEnchantmentAt(int row, int column)
	{
		return hexEnchantments[row][column];
	}
	/**
	 * Returns all hex enchantments on the side.
	 * @return all hex enchantments on the side
	 */
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
	/**
	 * Adds a hex enchantment to the side.
	 * @param hexEnchant the hex enchantment to add
	 */
	public void addHexEnchantment(HexEnchantment hexEnchant)
	{
		hexEnchantments[hexEnchant.getRow()][hexEnchant.getColumn()] = hexEnchant;
		hexEnchant.setOwner(owner);
		update();
	}
	/**
	 * Removes the hex enchantment at the specified position.
	 * @param row the row to remove the hex enchantment at
	 * @param column the column to remove the hex enchantment at
	 */
	public void removeHexEnchantment(int row, int column)
	{
		getHexEnchantmentAt(row, column).setOwner(Player.NONE);
		hexEnchantments[row][column] = null;
		update();
	}
	/**
	 * Moves the unit at specified position to specified destination.
	 * @param row the row to move the unit from
	 * @param column the column to move the unit from
	 * @param destinationRow the row to move the unit to
	 * @param destinationColumn the column to move the unit to
	 */
	public boolean move(int row, int column, int destinationRow, int destinationColumn)
	{
		boolean toReturn = getUnitAt(row, column).getMoveType().move(getUnitAt(row, column), destinationRow, destinationColumn, game.getSide(owner), game.getSide(owner.otherPlayer()), units);
		update();
		return toReturn;
	}
	/**
	 * Moves the specified unit move to specified destination.
	 * @param unit the unit to move
	 * @param row the row to move the unit to
	 * @param column the column to move the unit to
	 * @return whether the unit was moved or not
	 */
	public boolean move(Unit unit, int row, int column)
	{
		boolean toReturn = unit.getMoveType().move(unit, row, column, game.getSide(owner), game.getSide(owner.otherPlayer()), units);
		update();
		return toReturn;
	}
	/**
	 * Makes the unit at specified position attack.
	 * @param row the row of the unit to attack
	 * @param column the column of the unit to attack
	 * @return whether the unit was moved or not
	 */
	public void attack(int row, int column)
	{
		getUnitAt(row, column).getAttackType().attack(getUnitAt(row, column), game.getSide(owner), game.getSide(owner.otherPlayer()));
		update();
	}
	/**
	 * Makes the unit at specified position attack.
	 * @param unit the unit to attack
	 */
	public void attack(Unit unit)
	{
		unit.getAttackType().attack(unit, game.getSide(owner), game.getSide(owner.otherPlayer()));
		resetCountdown(unit);
		update();
	}
	/**
	 * Resets the countdown of the unit at specified position.
	 * @param row the row of the unit which should have it's countdown reset
	 * @param column the column of the unit which should have it's countdown reset
	 */
	public void resetCountdown(int row, int column)
	{
		getUnitAt(row, column).resetCountdown();
		update();
	}
	/**
	 * Resets the countdown of the specified unit.
	 * @param unit the unit which should have it's countdown reset
	 */
	public void resetCountdown(Unit unit)
	{
		unit.resetCountdown();
		update();
	}
	/**
	 * Counts down the unit at specifed position.
	 * @param row the row of the unit to count down
	 * @param column the column of the unit to count down
	 * @return whether the unit did count down or not
	 */
	public boolean countDown(int row, int column)
	{
		boolean toReturn = getUnitAt(row, column).countDown();
		update();
		return toReturn;
	}
	/**
	 * Counts down the specified unit.
	 * @param unit the unit to count down
	 * @return whether the unit did count down or not
	 */
	public boolean countDown(Unit unit)
	{
		boolean toReturn = unit.countDown();
		update();
		return toReturn;
	}
	/**
	 * Resets the move of the unit at specified position.
	 * @param row the row of the unit which should have it's move reset
	 * @param column the column of the unit which should have it's move reset
	 */
	public void resetMove(int row, int column)
	{
		getUnitAt(row, column).resetMove();
		update();
	}
	/**
	 * Resets the move of the specified unit.
	 * @param unit the unit which should have it's move reset
	 */
	public void resetMove(Unit unit)
	{
		unit.resetMove();
		update();
	}
	/**
	 * Changes the countdown of the unit at specified position.
	 * @param row the row of the unit which should have it's countdown changed
	 * @param column the column of the unit which should have it's countdown changed
	 * @param amount the amount to change the countdown with
	 */
	public void changeCountdown(int row, int column, int amount)
	{
		getUnitAt(row, column).changeCountdown(amount);
		update();
	}
	/**
	 * Changes the countdown of the specified unit.
	 * @param unit the unit which should have it's countdown changed
	 * @param amount the amount to change countdown with
	 */
	public void changeCountdown(Unit unit, int amount)
	{
		unit.changeCountdown(amount);
		update();
	}
	/**
	 * Heals the unit at specified position.
	 * @param row the row of the unit to heal
	 * @param column the column of the unit to heal
	 * @param amount the amount to heal with
	 */
	public void heal(int row, int column, int amount)
	{
		getUnitAt(row, column).heal(amount);
		update();
	}
	/**
	 * Heals the specified unit.
	 * @param unit the unit to heal
	 * @param amount the amount to heal with
	 */
	public void heal(Unit unit, int amount)
	{
		unit.heal(amount);
		update();
	}
	/**
	 * Damages the unit at specified position.
	 * @param row the row of the unit to damage
	 * @param column the column of the unit to damage
	 * @param amount the amount to damage with
	 */
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
	/**
	 * Damages the specified unit.
	 * @param unit the unit to damage
	 * @param amount the amount to damage with
	 */
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
	/**
	 * Changes the move of the unit at specified position.
	 * @param row the row of the unit which should have it's move changed
	 * @param column the column of the unit which should have it's move changed
	 * @param amount the amount to change the move with
	 */
	public void changeMove(int row, int column, int amount)
	{
		getUnitAt(row, column).changeMove(amount);
		update();
	}
	/**
	 * Changes the move of the specified unit.
	 * @param unit the unit which should have it's move changed
	 * @param amount the amount to change move with
	 */
	public void changeMove(Unit unit, int amount)
	{
		unit.changeMove(amount);
		update();
	}
	/**
	 * Gets the idol at the specified row.
	 * @param row the row to get the idol at
	 * @return the idol at the specified row
	 */
	public int getIdolAt(int row)
	{
		return idols[row];
	}
	/**
	 * Sets the idol at the specified row to the specified value.
	 * @param row the row to set the idol at
	 * @param value the value to set the idol to
	 */
	public void setIdol(int row, int value)
	{
		idols[row] = value;
	}
	/**
	 * Returns the number of rows.
	 * @return the number of rows
	 */
	public int numberOfRows()
	{
		return units.length;
	}
	/**
	 * Returns the number of columns.
	 * @return the number of columns
	 */
	public int numberOfColumns()
	{
		return units[0].length;
	}
	/**
	 * Returns the owner of this board half.
	 * @return the owner of this board half
	 */
	public Player getOwner()
	{
		return owner;
	}
	/**
	 * Dispatches an event to all listeners.
	 * @param event the event to dispatch.
	 */
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
	/**
	 * Returns whether the specified positions are adjacent.
	 * @param row1 the first row
	 * @param column1 the first column
	 * @param row2 the second row
	 * @param column2 the second column
	 * @return whether the specified positions are adjacent
	 */
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
