package com.alvarpq.GOTF.requirement;
/**
 * Defines the different requirement types.
 */
public enum RequirementType
{
	/**
	 * Any unit
	 */
	UNIT,
	/**
	 * Any of your units
	 */
	OWN_UNIT,
	/**
	 * Any opponent unit
	 */
	OPPONENT_UNIT,
	/**
	 * Any tile
	 */
	TILE,
	/**
	 * Any of your tiles
	 */
	OWN_TILE,
	/**
	 * Any opponent tile
	 */
	OPPONENT_TILE,
	/**
	 * Any empty tile
	 */
	EMPTY_TILE,
	/**
	 * Any of your empty tiles
	 */
	OWN_EMPTY_TILE,
	/**
	 * Any empty opponent tile
	 */
	OPPONENT_EMPTY_TILE,
	/**
	 * Any row
	 */
	ROW
}