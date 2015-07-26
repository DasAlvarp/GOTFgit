package com.alvarpq.GOTF.coreGame.cards.vorgasminingcorporation;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.coreGame.cards.Card;
import com.alvarpq.GOTF.coreGame.cards.SpellCard;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.event.TurnEndedEvent;
import com.alvarpq.GOTF.coreGame.event.TurnEndedListener;
import com.alvarpq.GOTF.requirement.Requirement;
public class GoblinHiringContract extends SpellCard implements TurnEndedListener
{
	public List<Card> hiredGoblins;
	public List<Boolean> resourceCostDecreased;
	public List<Boolean> elementCostDecreased;
	public GoblinHiringContract(Player owner)
	{
		super(110110, "Goblin Hiring Contract", 1, new Element[]{Element.EARTH}, owner);
		setRequirements(new Requirement[]{});
		hiredGoblins = new LinkedList<Card>();
		resourceCostDecreased = new LinkedList<Boolean>();
		elementCostDecreased = new LinkedList<Boolean>();
	}
	@Override
	public boolean play(Side mySide, Side opponentsSide)
	{
		if(isReady())
		{
			for(Card card:mySide.getDeck().getHand())
			{
				try
				{
					if(card instanceof UnitCard&&Arrays.asList(((UnitCard)card).createUnit(-1, -1).getSubtypes()).contains("Goblin"))
					{
						boolean rcd = card.getResourceCost()>0;
						if(rcd)
						{
							card.setResourceCost(card.getResourceCost()-1);
						}
						boolean ecd = card.getElementCost().remove(Element.EARTH);
						if(rcd||ecd)
						{
							hiredGoblins.add(card);
							resourceCostDecreased.add(rcd);
							elementCostDecreased.add(ecd);
						}
					}
				}
				catch(InstantiationException e){e.printStackTrace();}
				catch(IllegalAccessException e){e.printStackTrace();}
				catch(IllegalArgumentException e){e.printStackTrace();}
				catch(InvocationTargetException e){e.printStackTrace();}
				catch(SecurityException e){e.printStackTrace();}
			}
			mySide.listenOnce(this);
			reset();
			return true;
		}
		return false;
	}
	@Override
	public void onTurnEnded(TurnEndedEvent event)
	{
		for(int i=0;i<hiredGoblins.size();i++)
		{
			if(resourceCostDecreased.get(i))
			{
				hiredGoblins.get(i).setResourceCost(hiredGoblins.get(i).getResourceCost()+1);
			}
			if(elementCostDecreased.get(i))
			{
				hiredGoblins.get(i).getElementCost().add(Element.EARTH);
			}
		}
		hiredGoblins.clear();
	}
}
