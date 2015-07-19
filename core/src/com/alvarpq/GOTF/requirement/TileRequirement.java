package com.alvarpq.GOTF.requirement;

import com.alvarpq.GOTF.coreGame.Player;

public class TileRequirement implements Requirement
{
	/**
	 * The side of the targeted tile.
	 */
	private Player side;
	/**
	 * The row of the targeted tile, -1 before a tile has been targeted.
	 */
	private int row;
	/**
	 * The column of the targeted tile, -1 before a tile has been targeted.
	 */
	private int column;
	/**
	 * The type of tile that is required.
	 * @see RequirementType
	 */
	private RequirementType type;
	/**
	 * Instantiates a new TileRequirement.
	 * @param type the type of tile that is required
	 * @see RequirementType
	 */
	public TileRequirement(RequirementType type)
	{
		side = Player.NONE;
		row = -1;
		column = -1;
		this.type = type;
	}
	/**
	 * Returns the type of tile that is required.
	 * @return the type of tile that is required
	 * @see RequirementType
	 */
	@Override
	public RequirementType getType()
	{
		return type;
	}
	/**
	 * Returns whether the requirement has been fulfilled.
	 * @return whether the requirement has been fulfilled
	 */
	@Override
	public boolean isFulfilled()
	{
		return side!=Player.NONE&&row>=0&&column>=0;
	}
	/**
	 * Resets the requirement.
	 */
	@Override
	public void reset()
	{
		row = -1;
		column = -1;
	}
	/**
	 * Returns the side of the targeted tile.
	 * @return the side of the targeted tile
	 */
	public Player getSide()
	{
		return side;
	}
	/**
	 * Returns the row of the targeted tile.
	 * @return the row of the targeted tile
	 */
	public int getRow()
	{
		return row;
	}
	/**
	 * Returns the column of the targeted tile.
	 * @return the column of the targeted tile
	 */
	public int getColumn()
	{
		return column;
	}
	/**
	 * Sets the tile.
	 * @param side the side the tile is on
	 * @param row the tile's row
	 * @param column the tile's column
	 */
	public void setTile(Player side, int row, int column)
	{
		this.side = side;
		this.row = row;
		this.column = column;
	}
}