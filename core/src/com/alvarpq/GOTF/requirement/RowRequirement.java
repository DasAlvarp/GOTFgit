package com.alvarpq.GOTF.requirement;
public class RowRequirement implements Requirement
{
	/**
	 * The targeted row.
	 */
	private int row;
	/**
	 * Instantiates a new RowRequirement.
	 */
	public RowRequirement()
	{
		row = -1;
	}
	/**
	 * Returns the type of this requirement.
	 * @return the type of this requirement
	 */
	@Override
	public RequirementType getType()
	{
		return RequirementType.ROW;
	}
	/**
	 * Returns whether this requirement is fulfilled.
	 * @return whether this requirement is fulfilled
	 */
	@Override
	public boolean isFulfilled()
	{
		return row!=-1;
	}
	/**
	 * Resets this requirement.
	 */
	@Override
	public void reset()
	{
		row = -1;
	}
	/**
	 * Returns the targeted row.
	 * @return the targeted row
	 */
	public int getRow()
	{
		return row;
	}
	/**
	 * Sets the targeted row.
	 * @param row the row to target
	 */
	public void setRow(int row)
	{
		this.row = row;
	}
}