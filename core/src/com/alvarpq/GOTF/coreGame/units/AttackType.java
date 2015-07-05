package com.alvarpq.GOTF.coreGame.units;

import com.alvarpq.GOTF.coreGame.board.BoardHalf;

public interface AttackType
{
	public static final Normal NORMAL = new Normal();
	public Unit attack(Unit unit, BoardHalf mySide, BoardHalf opponentsSide);
	class Normal implements AttackType
	{
		@Override
		public Unit attack(Unit unit, BoardHalf mySide, BoardHalf opponentsSide)
		{
			Unit unitHit = null;
			for(int i=0;i<opponentsSide.numberOfColumns();i++)
			{
				if(opponentsSide.getUnitAt(unit.getRow(), i)!=null)
				{
					opponentsSide.getUnitAt(unit.getRow(), i).changeHealth(mySide, opponentsSide, -unit.getAttack());
					unitHit = opponentsSide.getUnitAt(unit.getRow(), i);
					break;
				}
			}
			if(unitHit!=null)
			{
				opponentsSide.setIdol(unit.getRow(), opponentsSide.getIdolAt(unit.getRow())-unit.getAttack());
				if(opponentsSide.getIdolAt(unit.getRow())<0)
				{
					opponentsSide.setIdol(unit.getRow(), 0);
				}
			}
			return unitHit;
		}
	}
}
