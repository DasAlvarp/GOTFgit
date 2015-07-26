package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.event.UnitHasAttackedEvent;
public abstract class Coward
{
	public static void onUnitHasAttacked(UnitHasAttackedEvent event, Unit attackUnit)
	{
		if(event.getAttackUnit()==attackUnit)
		{
			event.getMySide().getHalf().removeUnit(attackUnit);
			if(attackUnit.getCard()!=null)
			{
				event.getMySide().getDeck().getDiscardPile().remove(attackUnit.getCard());
				event.getMySide().getDeck().getHand().add(attackUnit.getCard());
			}
		}
	}
}
