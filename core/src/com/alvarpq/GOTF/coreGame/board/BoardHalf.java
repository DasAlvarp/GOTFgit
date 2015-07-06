package com.alvarpq.GOTF.coreGame.board;
import java.util.LinkedList;
import java.util.List;
import com.alvarpq.GOTF.coreGame.units.Unit;
public class BoardHalf
{
	//Do not change directly unless needed
	private Unit[][] units;
	private int[] idols;
	private BoardHalf opponentsSide;
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
	public void updateUnits()
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
		for(int i=0;i<numberOfRows();i++)
		{
			for(int j=0;j<numberOfColumns();j++)
			{
				if(getUnitAt(i, j)!=null&&getUnitAt(i, j).getHealth()<=0)
				{
					units[i][j] = null;
					newUpdate = true;
				}
				if(opponentsSide.getUnitAt(i, j)!=null&&opponentsSide.getUnitAt(i, j).getHealth()<=0)
				{
					opponentsSide.units[i][j] = null;
					newUpdate = true;
				}
			}
		}
		if(newUpdate)
		{
			updateUnits();
		}
	}
	public void allAttack()
	{
		for(int i=0;i<numberOfRows();i++)
		{
			rowAttack(i);
		}
	}
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
	public void addUnit(Unit unit)
	{
		units[unit.getRow()][unit.getColumn()] = unit;
		updateUnits();
	}
	public void removeUnit(int row, int column)
	{
		units[row][column] = null;
		updateUnits();
	}
	public boolean moveUnit(int row, int column, int destinationRow, int destinationColumn)
	{
		if(getUnitAt(row, column).getMove()>0&&getUnitAt(destinationRow, destinationColumn)==null&&BoardHalf.isAdjacent(row, column, destinationRow, destinationColumn))
		{
			getUnitAt(row, column).changeMove(this, opponentsSide, -1);
			units[destinationRow][destinationColumn] = getUnitAt(row, column);
			units[row][column] = null;
			getUnitAt(row, column).move(destinationRow, destinationColumn);
			updateUnits();
			return true;
		}
		return false;
	}
	public boolean moveUnit(Unit unit, int row, int column)
	{
		if(unit.getMove()>0&&getUnitAt(row, column)==null&&BoardHalf.isAdjacent(unit.getRow(), unit.getColumn(), row, column))
		{
			unit.changeMove(this, opponentsSide, -1);
			units[row][column] = unit;
			units[unit.getRow()][unit.getColumn()] = null;
			unit.move(row, column);
			updateUnits();
			return true;
		}
		return false;
	}
	public void attack(int row, int column)
	{
		getUnitAt(row, column).getAttackType().attack(getUnitAt(row, column), this, opponentsSide);
		updateUnits();
	}
	public void attack(Unit unit)
	{
		unit.getAttackType().attack(unit, this, opponentsSide);
		updateUnits();
	}
	public void resetCountdown(int row, int column)
	{
		getUnitAt(row, column).resetCountdown();
		updateUnits();
	}
	public void resetCountdown(Unit unit)
	{
		unit.resetCountdown();
		updateUnits();
	}
	public boolean countDown(int row, int column)
	{
		return getUnitAt(row, column).countDown();
	}
	public boolean countDown(Unit unit)
	{
		return unit.countDown();
	}
	public void resetMove(int row, int column)
	{
		getUnitAt(row, column).resetMove();
		updateUnits();
	}
	public void resetMove(Unit unit)
	{
		unit.resetMove();
		updateUnits();
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
	public static void createBoard(BoardHalf half1, BoardHalf half2)
	{
		half1.opponentsSide = half2;
		half2.opponentsSide = half1;
	}
}
