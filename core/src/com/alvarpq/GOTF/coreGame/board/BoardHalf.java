package com.alvarpq.GOTF.coreGame.board;
import java.util.LinkedList;
import java.util.List;
import com.alvarpq.GOTF.coreGame.units.Unit;
public class BoardHalf
{
	//Do not change directly unless needed
	private Unit[][] units;
	private int[] idols;
	public BoardHalf(int rows, int columns, int idolHealth)
	{
		units = new Unit[rows][columns];
		idols = new int[rows];
		for(int i=0;i<idols.length;i++)
		{
			setIdol(i, idolHealth);
		}
	}
	public BoardHalf(Unit[][] units, int[] idols)
	{
		this.units = units;
		this.idols = idols;
	}
	public void updateUnits(BoardHalf opponentsSide)
	{
		for(Unit unit:getUnits())
		{
				if(unit!=null)
				{
					unit.clearPresenceEffects();
				}
		}
		for(Unit unit:getUnits())
		{
			if(unit!=null)
			{
				unit.applyPresence(this, opponentsSide);
			}
		}
		for(Unit unit:opponentsSide.getUnits())
		{
				if(unit!=null)
				{
					unit.clearPresenceEffects();
				}
		}
		for(Unit unit:opponentsSide.getUnits())
		{
			if(unit!=null)
			{
				unit.applyPresence(this, opponentsSide);
			}
		}
		boolean newUpdate = false;
		for(Unit unit:opponentsSide.getUnits())
		{
			if(unit.getHealth()<=0)
			{
				removeUnit(unit.getRow(), unit.getColumn(), opponentsSide);
				newUpdate = true;
			}
		}
		if(newUpdate)
		{
			updateUnits(opponentsSide);
		}
	}
	public void attack(BoardHalf opponentsSide)
	{
		for(int i=0;i<numberOfRows();i++)
		{
			for(int j=0;j<numberOfColumns();j++)
			{
				if(getUnitAt(i, j)!=null)
				{
					getUnitAt(i, j).attack(this, opponentsSide);
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
	public void addUnit(Unit unit, BoardHalf opponentsSide)
	{
		units[unit.getRow()][unit.getColumn()] = unit;
		updateUnits(opponentsSide);
		opponentsSide.updateUnits(this);
	}
	public void removeUnit(int row, int column, BoardHalf opponentsSide)
	{
		units[row][column] = null;
		updateUnits(opponentsSide);
		opponentsSide.updateUnits(this);
	}
	public boolean moveUnit(BoardHalf opponentsSide, int row, int column, int destinationRow, int destinationColumn)
	{
		if(getUnitAt(row, column).getMove()>0&&getUnitAt(destinationRow, destinationColumn)==null&&BoardHalf.isAdjacent(row, column, destinationRow, destinationColumn))
		{
			getUnitAt(row, column).changeMove(this, opponentsSide, -1);
			units[destinationRow][destinationColumn] = getUnitAt(row, column);
			units[row][column] = null;
			return true;
		}
		return false;
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
}
