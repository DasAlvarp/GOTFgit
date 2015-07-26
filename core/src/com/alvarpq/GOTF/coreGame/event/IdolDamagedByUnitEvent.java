package com.alvarpq.GOTF.coreGame.event;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.coreGame.units.Unit;
/**
 * For handling when idols are damaged by units.
 */
public class IdolDamagedByUnitEvent extends Event
{
	/**
	 * The row of the damaged idol.
	 */
	private int damagedRow;
	/**
	 * The side of the damaged idol.
	 */
	private Player damagedSide;
	/**
	 * The damager.
	 */
	private Unit damager;
	/**
	 * The amount of damage.
	 */
	private int amount;
	/**
	 * Instantiates a new UnitDamagedByUnitEvent.
	 * @param damagedRow the row of the damaged idol
	 * @param damagedSide the side of the damaged Idol
	 * @param damager the unit that dealt the damage
	 * @param amount the amount of damage dealt
	 * @param mySide the side of the event receiver
	 * @param opponentsSide the opponents side of the event receiver
	 */
	public IdolDamagedByUnitEvent(int damagedRow, Player damagedSide, Unit damager, int amount, Side mySide, Side opponentsSide)
	{
		super(mySide, opponentsSide);
		this.damagedRow = damagedRow;
		this.damagedSide = damagedSide;
		this.damager = damager;
		this.amount = amount;
	}
	/**
	 * Returns the row of the damaged idol.
	 * @return the row of the damaged idol
	 */
	public int getDamagedRow()
	{
		return damagedRow;
	}
	/**
	 * Returns the side of the damaged idol.
	 * @return the side of the damaged idol
	 */
	public Player getDamagedSide()
	{
		return damagedSide;
	}
	/**
	 * Returns the damager.
	 * @return the damager
	 */
	public Unit getDamager()
	{
		return damager;
	}
	/**
	 * Returns the amount of damage.
	 * @return the amount of damage
	 */
	public int getAmount()
	{
		return amount;
	}
}