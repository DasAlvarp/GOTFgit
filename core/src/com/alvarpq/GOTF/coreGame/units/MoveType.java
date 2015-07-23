package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
/**
 * This interface defines the different move types a unit can have.
 */
public interface MoveType
{
	/**
	 * The function used to move a unit.
	 * @param unit the unit to move
	 * @param row the row to move the unit to
	 * @param column the column to move the unit to
	 * @param mySide the unit's side
	 * @param opponentsSide the side of the unit's opponent
	 * @param mySideUnits all the units on the unit's side
	 * @return whether the unit has moved or not
	 */
	public boolean move(Unit unit, int row, int column, Side mySide, Side opponentsSide, Unit[][] mySideUnits);
	/**
	 * The function used to check if a unit can move.
	 * @param unit the unit to move
	 * @param row the row to move the unit to
	 * @param column the column to move the unit to
	 * @param mySide the unit's side
	 * @param opponentsSide the side of the unit's opponent
	 * @param mySideUnits all the units on the unit's side
	 * @return whether the unit can move or not
	 */
	public boolean canMove(Unit unit, int row, int column, Side mySide, Side opponentsSide, Unit[][] mySideUnits);
	/**
	 * The normal move type. Used as default in all units.
	 */
	class Normal implements MoveType
	{
		@Override
		public boolean move(Unit unit, int row, int column, Side mySide, Side opponentsSide, Unit[][] mySideUnits)
		{
			if(unit.getMove()>0&&mySide.getHalf().getUnitAt(row, column)==null&&BoardHalf.isAdjacent(unit.getRow(), unit.getColumn(), row, column))
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
		public boolean canMove(Unit unit, int row, int column, Side mySide, Side opponentsSide, Unit[][] mySideUnits)
		{
			if(unit.getMove()>0&&mySide.getHalf().getUnitAt(row, column)==null&&BoardHalf.isAdjacent(unit.getRow(), unit.getColumn(), row, column))
			{
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
	/**
	 * A move type which makes a unit only being able to move to non-adjacent tiles.
	 */
	class NonAdjacent implements MoveType
	{
		@Override
		public boolean move(Unit unit, int row, int column, Side mySide, Side opponentsSide, Unit[][] mySideUnits)
		{
			if(unit.getMove()>0&&mySide.getHalf().getUnitAt(row, column)==null&&!BoardHalf.isAdjacent(unit.getRow(), unit.getColumn(), row, column))
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
		public boolean canMove(Unit unit, int row, int column, Side mySide, Side opponentsSide, Unit[][] mySideUnits)
		{
			if(unit.getMove()>0&&mySide.getHalf().getUnitAt(row, column)==null&&!BoardHalf.isAdjacent(unit.getRow(), unit.getColumn(), row, column))
			{
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
	/**
	 * A move type which makes a unit unable to move.
	 */
	class Immovable implements MoveType
	{
		@Override
		public boolean move(Unit unit, int row, int column, Side mySide, Side opponentsSide, Unit[][] mySideUnits)
		{
			return false;
		}
		@Override
		public boolean canMove(Unit unit, int row, int column, Side mySide, Side opponentsSide, Unit[][] mySideUnits)
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