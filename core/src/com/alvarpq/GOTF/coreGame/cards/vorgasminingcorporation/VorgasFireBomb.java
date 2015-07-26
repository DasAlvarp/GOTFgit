package com.alvarpq.GOTF.coreGame.cards.vorgasminingcorporation;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.coreGame.cards.SpellCard;
import com.alvarpq.GOTF.requirement.Requirement;
import com.alvarpq.GOTF.requirement.RequirementType;
import com.alvarpq.GOTF.requirement.UnitRequirement;
public class VorgasFireBomb extends SpellCard
{
	private UnitRequirement target;
	public VorgasFireBomb(Player owner)
	{
		super(110107, "Vorgas' Fire Bomb", 3, new Element[]{Element.EARTH, Element.FIRE}, owner);
		target = new UnitRequirement(RequirementType.UNIT);
		setRequirements(new Requirement[]{target});
	}
	@Override
	public boolean play(Side mySide, Side opponentsSide)
	{
		if(isReady())
		{
			if(target.getUnit().getOwner()==mySide.getOwner())
			{
				mySide.getHalf().damage(target.getUnit(), 4, null);
			}
			else if(target.getUnit().getOwner()==opponentsSide.getOwner())
			{
				opponentsSide.getHalf().damage(target.getUnit(), 4, null);
			}
			reset();
			return true;
		}
		return false;
	}
}
