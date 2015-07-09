package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
public interface MoveType
{
	public static final Normal NORMAL = new Normal();
	public static final Immovable IMMOVABLE = new Immovable();
	public boolean move(Unit unit, int row, int column, BoardHalf myHalf, BoardHalf opponentsHalf, Unit[][] myHalfUnits);
	class Normal implements MoveType
	{
		@Override
		public boolean move(Unit unit, int row, int column, BoardHalf myHalf, BoardHalf opponentsHalf, Unit[][] myHalfUnits)
		{
			if(unit.getMove()>0&&myHalf.getUnitAt(row, column)==null&&BoardHalf.isAdjacent(unit.getRow(), unit.getColumn(), row, column))
			{
				unit.changeMove(-1);
				myHalfUnits[row][column] = unit;
				myHalfUnits[unit.getRow()][unit.getColumn()] = null;
				unit.setRow(row);
				unit.setColumn(column);
				return true;
			}
			return false;
		}
		@Override
		public String toString()
		{
			return "Normal";
		}
	}
	class Immovable implements MoveType
	{
		@Override
		public boolean move(Unit unit, int row, int column, BoardHalf myHalf, BoardHalf opponentsHalf, Unit[][] myHalfUnits)
		{
			return false;
		}
		@Override
		public String toString()
		{
			return "Immovable";
		}
	}
}
