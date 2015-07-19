package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.Side;
/**
 * This interface should be implemented by units which need to apply buffs and debuffs to units.
 */
public interface PresenceApplier
{
	/**
	 * Override this function to apply buffs and debuffs to units.
	 * @param mySide the side of the applier
	 * @param opponentsSide the side of the applier's opponent
	 */
	public abstract void applyPresence(Side mySide, Side opponentsSide);
}
