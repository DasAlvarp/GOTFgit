package com.alvarpq.GOTF.coreGame.hexEnchant;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
public abstract class HexEnchantment
{
	private String name;
	private int row, column;
	private Player owner;
	public HexEnchantment(String name, int row, int column)
	{
		this.name = name;
		this.row = row;
		this.column = column;
		owner = Player.NONE;
	}
	//override for buffs on other units
	public abstract void applyPresence(BoardHalf mySide, BoardHalf opponentsSide);
	public String getName()
	{
		return name;
	}
	public void setRow(int row)
	{
		this.row = row;
	}
	public void setColumn(int column)
	{
		this.column = column;
	}
	public int getRow()
	{
		return row;
	}
	public int getColumn()
	{
		return column;
	}
	public Player getOwner()
	{
		return owner;
	}
	public void setOwner(Player owner)
	{
		this.owner = owner;
	}
	@Override
	public String toString()
	{
		return "name: "+getName()+", row: "+row+", column: "+column;
	}
}
