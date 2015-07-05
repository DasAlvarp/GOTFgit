package com.alvarpq.GOTF.coreGame;

public class BoardHalf
{
	protected Unit[][] units;
	protected int[] idols;
	public BoardHalf(int rows, int columns, int idolHealth)
	{
		units = new Unit[rows][columns];
		idols = new int[rows];
		for(int i=0;i<idols.length;i++)
		{
			idols[i] = idolHealth;
		}
	}
	public void updateUnits(BoardHalf opponentsSide)
	{
		for(int i=0;i<units.length;i++)
		{
			for(int j=0;j<units[i].length;j++)
			{
				if(units[i][j]!=null)
				{
					units[i][j].attack = 0;
					units[i][j].countdown = 0;
					units[i][j].health = 0;
				}
			}
		}
		for(int i=0;i<units.length;i++)
		{
			for(int j=0;j<units[i].length;j++)
			{
				if(units[i][j]!=null)
				{
					units[i][j].updateUnits(this, opponentsSide, i, j);
				}
			}
		}
		boolean newUpdate = false;
		for(int i=0;i<units.length;i++)
		{
			for(int j=0;j<units[i].length;j++)
			{
				if(units[i][j]!=null&&units[i][j].health<=0)
				{
					units[i][j].onDestroyed(this, opponentsSide, i, j, -1, -1);
					units[i][j] = null;
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
		for(int i=0;i<units.length;i++)
		{
			for(int j=0;j<units[i].length;j++)
			{
				if(units[i][j]!=null)
				{
					units[i][j].attack(this, opponentsSide, i, j);
				}
			}
		}
	}
	public BoardHalf(Unit[][] units, int[] idols)
	{
		this.units = units;
		this.idols = idols;
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
}
