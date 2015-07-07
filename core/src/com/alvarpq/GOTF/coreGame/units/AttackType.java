package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.coreGame.event.UnitDamagedEvent;
import com.alvarpq.GOTF.coreGame.event.UnitKilledByUnitEvent;
public interface AttackType
{
	public static final Normal NORMAL = new Normal();
	public static final Relentless RELENTLESS = new Relentless();
	public static final NoAttack NO_ATTACK = new NoAttack();
	public void attack(Unit unit, BoardHalf mySide, BoardHalf opponentsSide);
	class Normal implements AttackType
	{
		@Override
		public void attack(Unit unit, BoardHalf mySide, BoardHalf opponentsSide)
		{
			boolean unitHit = false;
			for(int i=0;i<opponentsSide.numberOfColumns();i++)
			{
				if(opponentsSide.getUnitAt(unit.getRow(), i)!=null)
				{
					opponentsSide.getUnitAt(unit.getRow(), i).damage(unit.getAttack());
					mySide.dispatchEvent(new UnitDamagedEvent(opponentsSide.getUnitAt(unit.getRow(), i), unit.getAttack(), mySide, opponentsSide));
					if(opponentsSide.getUnitAt(unit.getRow(), i).getHealth()<=0)
					{
						mySide.dispatchEvent(new UnitKilledByUnitEvent(opponentsSide.getUnitAt(unit.getRow(), i), unit, mySide, opponentsSide));
					}
					unitHit = true;
					break;
				}
			}
			if(!unitHit)
			{
				opponentsSide.setIdol(unit.getRow(), opponentsSide.getIdolAt(unit.getRow())-unit.getAttack());
				if(opponentsSide.getIdolAt(unit.getRow())<0)
				{
					opponentsSide.setIdol(unit.getRow(), 0);
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
		public void attack(Unit unit, BoardHalf mySide, BoardHalf opponentsSide)
		{
			int attackLeft = unit.getAttack();
			for(int i=0;i<opponentsSide.numberOfColumns();i++)
			{
				if(opponentsSide.getUnitAt(unit.getRow(), i)!=null)
				{
					opponentsSide.getUnitAt(unit.getRow(), i).damage(attackLeft);
					mySide.dispatchEvent(new UnitDamagedEvent(opponentsSide.getUnitAt(unit.getRow(), i), attackLeft, mySide, opponentsSide));
					attackLeft = 0;
					if(opponentsSide.getUnitAt(unit.getRow(), i).getHealth()<0)
					{
						attackLeft-=opponentsSide.getUnitAt(unit.getRow(), i).getHealth();
						mySide.dispatchEvent(new UnitKilledByUnitEvent(opponentsSide.getUnitAt(unit.getRow(), i), unit, mySide, opponentsSide));
					}
					else if(opponentsSide.getUnitAt(unit.getRow(), i).getHealth()==0)
					{
						mySide.dispatchEvent(new UnitKilledByUnitEvent(opponentsSide.getUnitAt(unit.getRow(), i), unit, mySide, opponentsSide));
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
				opponentsSide.setIdol(unit.getRow(), opponentsSide.getIdolAt(unit.getRow())-attackLeft);
				if(opponentsSide.getIdolAt(unit.getRow())<0)
				{
					opponentsSide.setIdol(unit.getRow(), 0);
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
		public void attack(Unit unit, BoardHalf mySide, BoardHalf opponentsSide)
		{
		}
		@Override
		public String toString()
		{
			return "Does not attack";
		}
	}
}
