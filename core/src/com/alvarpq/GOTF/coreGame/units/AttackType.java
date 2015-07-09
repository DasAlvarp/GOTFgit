package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.coreGame.event.UnitDamagedByUnitEvent;
import com.alvarpq.GOTF.coreGame.event.UnitDamagedEvent;
import com.alvarpq.GOTF.coreGame.event.UnitKilledByUnitEvent;
public interface AttackType
{
	public static final Normal NORMAL = new Normal();
	public static final Relentless RELENTLESS = new Relentless();
	public static final NoAttack NO_ATTACK = new NoAttack();
	public void attack(Unit unit, BoardHalf myHalf, BoardHalf opponentsHalf);
	class Normal implements AttackType
	{
		@Override
		public void attack(Unit unit, BoardHalf myHalf, BoardHalf opponentsHalf)
		{
			boolean unitHit = false;
			for(int i=0;i<opponentsHalf.numberOfColumns();i++)
			{
				if(opponentsHalf.getUnitAt(unit.getRow(), i)!=null)
				{
					opponentsHalf.getUnitAt(unit.getRow(), i).damage(unit.getAttack());
					myHalf.dispatchEvent(new UnitDamagedByUnitEvent(opponentsHalf.getUnitAt(unit.getRow(), i), unit, unit.getAttack(), myHalf, opponentsHalf));
					myHalf.dispatchEvent(new UnitDamagedEvent(opponentsHalf.getUnitAt(unit.getRow(), i), unit.getAttack(), myHalf, opponentsHalf));
					if(opponentsHalf.getUnitAt(unit.getRow(), i).getHealth()<=0)
					{
						myHalf.dispatchEvent(new UnitKilledByUnitEvent(opponentsHalf.getUnitAt(unit.getRow(), i), unit, myHalf, opponentsHalf));
					}
					unitHit = true;
					break;
				}
			}
			if(!unitHit)
			{
				opponentsHalf.setIdol(unit.getRow(), opponentsHalf.getIdolAt(unit.getRow())-unit.getAttack());
				if(opponentsHalf.getIdolAt(unit.getRow())<0)
				{
					opponentsHalf.setIdol(unit.getRow(), 0);
				}
			}
		}
		@Override
		public String toString()
		{
			return "Normal";
		}
	}
	class Relentless implements AttackType
	{
		@Override
		public void attack(Unit unit, BoardHalf myHalf, BoardHalf opponentsHalf)
		{
			int attackLeft = unit.getAttack();
			for(int i=0;i<opponentsHalf.numberOfColumns();i++)
			{
				if(opponentsHalf.getUnitAt(unit.getRow(), i)!=null)
				{
					opponentsHalf.getUnitAt(unit.getRow(), i).damage(attackLeft);
					myHalf.dispatchEvent(new UnitDamagedByUnitEvent(opponentsHalf.getUnitAt(unit.getRow(), i), unit, attackLeft, myHalf, opponentsHalf));
					myHalf.dispatchEvent(new UnitDamagedEvent(opponentsHalf.getUnitAt(unit.getRow(), i), attackLeft, myHalf, opponentsHalf));
					attackLeft = 0;
					if(opponentsHalf.getUnitAt(unit.getRow(), i).getHealth()<0)
					{
						attackLeft-=opponentsHalf.getUnitAt(unit.getRow(), i).getHealth();
						myHalf.dispatchEvent(new UnitKilledByUnitEvent(opponentsHalf.getUnitAt(unit.getRow(), i), unit, myHalf, opponentsHalf));
					}
					else if(opponentsHalf.getUnitAt(unit.getRow(), i).getHealth()==0)
					{
						myHalf.dispatchEvent(new UnitKilledByUnitEvent(opponentsHalf.getUnitAt(unit.getRow(), i), unit, myHalf, opponentsHalf));
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
				opponentsHalf.setIdol(unit.getRow(), opponentsHalf.getIdolAt(unit.getRow())-attackLeft);
				if(opponentsHalf.getIdolAt(unit.getRow())<0)
				{
					opponentsHalf.setIdol(unit.getRow(), 0);
				}
			}
		}
		@Override
		public String toString()
		{
			return "Relentless";
		}
	}
	class NoAttack implements AttackType
	{
		@Override
		public void attack(Unit unit, BoardHalf myHalf, BoardHalf opponentsHalf)
		{
		}
		@Override
		public String toString()
		{
			return "Does not attack";
		}
	}
}
