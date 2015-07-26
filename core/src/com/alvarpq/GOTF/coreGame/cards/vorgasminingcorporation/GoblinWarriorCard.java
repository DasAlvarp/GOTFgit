package com.alvarpq.GOTF.coreGame.cards.vorgasminingcorporation;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation.GoblinWarrior;
public class GoblinWarriorCard extends UnitCard
{
	public GoblinWarriorCard(Player owner)
	{
		super(110103, "Goblin Warrior", 2, new Element[]{Element.EARTH}, owner, new UnitFactory(GoblinWarrior.class));
	}
}
