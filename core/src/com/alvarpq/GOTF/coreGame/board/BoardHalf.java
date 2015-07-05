package com.alvarpq.GOTF.coreGame.board;

import com.alvarpq.GOTF.coreGame.units.Unit;

public class BoardHalf
{
	private Unit[][] units;
	private int[] idols;
	public BoardHalf(int rows, int columns, int idolHealth)
	{
		setUnits(new Unit[rows][columns]);
		setIdols(new int[rows]);
		for(int i=0;i<getIdols().length;i++)
		{
			getIdols()[i] = idolHealth;
		}
	}
	public void updateUnits(BoardHalf opponentsSide)
	{
		for(int i=0;i<getUnits().length;i++)
		{
			for(int j=0;j<getUnits()[i].length;j++)
			{
				if(getUnits()[i][j]!=null)
				{
					getUnits()[i][j].setAttack(0);
					getUnits()[i][j].setCountdown(0);
					getUnits()[i][j].setHealth(0);
				}
			}
		}
		for(int i=0;i<getUnits().length;i++)
		{
			for(int j=0;j<getUnits()[i].length;j++)
			{
				if(getUnits()[i][j]!=null)
				{
					getUnits()[i][j].updateUnits(this, opponentsSide, i, j);
				}
			}
		}
		boolean newUpdate = false;
		for(int i=0;i<getUnits().length;i++)
		{
			for(int j=0;j<getUnits()[i].length;j++)
			{
				if(getUnits()[i][j]!=null&&getUnits()[i][j].getHealth()<=0)
				{
					getUnits()[i][j].onDestroyed(this, opponentsSide, i, j, -1, -1);
					getUnits()[i][j] = null;
					newUpdate = true;
				}
			}
		}
		if(newUpdate)
		{
			updateUnits(opponentsSide);
			opponentsSide.updateUnits(this);
		}
	}
	public void attack(BoardHalf opponentsSide)
	{
		for(int i=0;i<getUnits().length;i++)
		{
			for(int j=0;j<getUnits()[i].length;j++)
			{
				if(getUnits()[i][j]!=null)
				{
					getUnits()[i][j].attack(this, opponentsSide, i, j);
				}
			}
		}
	}
	public BoardHalf(Unit[][] units, int[] idols)
	{
		this.setUnits(units);
		this.setIdols(idols);
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
	public Unit[][] getUnits() {
		return units;
	}
	public void setUnits(Unit[][] units) {
		this.units = units;
	}
	public int[] getIdols() {
		return idols;
	}
	public void setIdols(int[] idols) {
		this.idols = idols;
	}
}
