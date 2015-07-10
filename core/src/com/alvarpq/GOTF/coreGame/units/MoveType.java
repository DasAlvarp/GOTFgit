package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
public interface MoveType
{
	public static final Normal NORMAL = new Normal();
	public static final NotAdjacent NOT_ADJACENT = new NotAdjacent();
	public static final Immovable IMMOVABLE = new Immovable();
	public boolean move(Unit unit, int row, int column, BoardHalf mySide, BoardHalf opponentsSide, Unit[][] mySideUnits);
	class Normal implements MoveType
	{
		@Override
		public boolean move(Unit unit, int row, int column, BoardHalf mySide, BoardHalf opponentsSide, Unit[][] mySideUnits)
		{
			if(unit.getMove()>0&&mySide.getUnitAt(row, column)==null&&BoardHalf.isAdjacent(unit.getRow(), unit.getColumn(), row, column))
			{
				unit.changeMove(-1);
				mySideUnits[row][column] = unit;
				mySideUnits[unit.getRow()][unit.getColumn()] = null;
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
	class NotAdjacent implements MoveType
	{
		@Override
		public boolean move(Unit unit, int row, int column, BoardHalf mySide, BoardHalf opponentsSide, Unit[][] mySideUnits)
		{
			if(unit.getMove()>0&&mySide.getUnitAt(row, column)==null&&!BoardHalf.isAdjacent(unit.getRow(), unit.getColumn(), row, column))
			{
				unit.changeMove(-1);
				mySideUnits[row][column] = unit;
				mySideUnits[unit.getRow()][unit.getColumn()] = null;
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
		public boolean move(Unit unit, int row, int column, BoardHalf mySide, BoardHalf opponentsSide, Unit[][] mySideUnits)
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