package com.alvarpq.GOTF.coreGame.cards.vorgasminingcorporation;
import java.util.Arrays;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation.GoblinWarrior;
public class GoblinWarriorCard extends UnitCard
{
	public GoblinWarriorCard()
	{
		super(110105, "Goblin Warrior", 2, Arrays.asList(new Resource[]{Resource.EARTH}), new UnitFactory(GoblinWarrior.class));
	}
}