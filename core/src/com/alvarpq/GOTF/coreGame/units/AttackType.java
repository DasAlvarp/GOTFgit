package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.coreGame.event.UnitDamagedByUnitEvent;
import com.alvarpq.GOTF.coreGame.event.UnitDamagedEvent;
import com.alvarpq.GOTF.coreGame.event.UnitKilledByUnitEvent;
/**
 * This interface defines the different attack types a unit can have.
 */
public interface AttackType
{
	/**
	 * The function used to make a unit attack.
	 * @param unit the unit to attack with
	 * @param mySide the unit's side
	 * @param opponentsSide the side of the unit's opponent
	 */
	public void attack(Unit unit, Side mySide, Side opponentsSide);
	/**
	 * The normal attack type. Used as default in all units.
	 */
	class Normal implements AttackType
	{
		@Override
		public void attack(Unit unit, Side mySide, Side opponentsSide)
		{
			boolean unitHit = false;
			for(int i=0;i<opponentsSide.getHalf().numberOfColumns();i++)
			{
				if(opponentsSide.getHalf().getUnitAt(unit.getRow(), i)!=null)
				{
					opponentsSide.getHalf().getUnitAt(unit.getRow(), i).damage(unit.getAttack());
					mySide.dispatchEvent(new UnitDamagedByUnitEvent(opponentsSide.getHalf().getUnitAt(unit.getRow(), i), unit, unit.getAttack(), mySide, opponentsSide));
					mySide.dispatchEvent(new UnitDamagedEvent(opponentsSide.getHalf().getUnitAt(unit.getRow(), i), unit.getAttack(), mySide, opponentsSide));
					if(opponentsSide.getHalf().getUnitAt(unit.getRow(), i).getHealth()<=0)
					{
						opponentsSide.getHalf().removeUnit(unit.getRow(), i);
						mySide.dispatchEvent(new UnitKilledByUnitEvent(opponentsSide.getHalf().getUnitAt(unit.getRow(), i), unit, mySide, opponentsSide));
					}
					unitHit = true;
					break;
				}
			}
			if(!unitHit)
			{
				opponentsSide.getHalf().setIdol(unit.getRow(), opponentsSide.getHalf().getIdolAt(unit.getRow())-unit.getAttack());
				if(opponentsSide.getHalf().getIdolAt(unit.getRow())<0)
				{
					opponentsSide.getHalf().setIdol(unit.getRow(), 0);
				}
			}
		}
		@Override
		public String toString()
		{
			return "Normal";
		}
	}
	/**
	 * An attack type which makes a unit continue attacking with it's remaining attack after destroying an enemy.
	 */
	class Relentless implements AttackType
	{
		@Override
		public void attack(Unit unit, Side mySide, Side opponentsSide)
		{
			int attackLeft = unit.getAttack();
			for(int i=0;i<opponentsSide.getHalf().numberOfColumns();i++)
			{
				if(opponentsSide.getHalf().getUnitAt(unit.getRow(), i)!=null)
				{
					opponentsSide.getHalf().getUnitAt(unit.getRow(), i).damage(attackLeft);
					mySide.dispatchEvent(new UnitDamagedByUnitEvent(opponentsSide.getHalf().getUnitAt(unit.getRow(), i), unit, attackLeft, mySide, opponentsSide));
					mySide.dispatchEvent(new UnitDamagedEvent(opponentsSide.getHalf().getUnitAt(unit.getRow(), i), attackLeft, mySide, opponentsSide));
					attackLeft = 0;
					if(opponentsSide.getHalf().getUnitAt(unit.getRow(), i).getHealth()<0)
					{
						attackLeft-=opponentsSide.getHalf().getUnitAt(unit.getRow(), i).getHealth();
						opponentsSide.getHalf().removeUnit(unit.getRow(), i);
						mySide.dispatchEvent(new UnitKilledByUnitEvent(opponentsSide.getHalf().getUnitAt(unit.getRow(), i), unit, mySide, opponentsSide));
					}
					else if(opponentsSide.getHalf().getUnitAt(unit.getRow(), i).getHealth()==0)
					{
						opponentsSide.getHalf().removeUnit(unit.getRow(), i);
						mySide.dispatchEvent(new UnitKilledByUnitEvent(opponentsSide.getHalf().getUnitAt(unit.getRow(), i), unit, mySide, opponentsSide));
						break;
					}
					else
					{
						break;
					}
				}
			}
			if(attackLeft>0)
			{
				opponentsSide.getHalf().setIdol(unit.getRow(), opponentsSide.getHalf().getIdolAt(unit.getRow())-attackLeft);
				if(opponentsSide.getHalf().getIdolAt(unit.getRow())<0)
				{
					opponentsSide.getHalf().setIdol(unit.getRow(), 0);
				}
			}
		}
		@Override
		public String toString()
		{
			return "Relentless";
		}
	}
	/**
	 * An attack type which makes a unit unable to attack.
	 */
	class NoAttack implements AttackType
	{
		@Override
		public void attack(Unit unit, Side mySide, Side opponentsSide)
		{
		}
		@Override
		public String toString()
		{
			return "Does not attack";
		}
	}
	/**
	 * An attack type which makes a unit increase resources and earth.
	 */
	class IncreaseEarth implements AttackType
	{
		@Override
		public void attack(Unit unit, Side mySide, Side opponentsSide)
		{
			mySide.setMaximumResources(mySide.getMaximumResources()+1);
			mySide.getMaximumElements().add(Element.EARTH);
		}
		@Override
		public String toString()
		{
			return "Does not attack";
		}
	}
}