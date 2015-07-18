package com.alvarpq.GOTF.coreGame.cards;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import com.alvarpq.GOTF.coreGame.cards.unused.*;
public class CardFactory 
{
	Map<Integer, Class<? extends Card>> cards = new HashMap<Integer, Class<? extends Card>>();
	public CardFactory()
	{
		cards.put(new DarkYounglingCard().getID(), DarkYounglingCard.class);
		cards.put(new ExampleSpellCard().getID(), ExampleSpellCard.class);
		cards.put(new ExampleUnitCard().getID(), ExampleUnitCard.class);
		cards.put(new JumpingWhaleCard().getID(), JumpingWhaleCard.class);
		cards.put(new PenanceOfTheGods().getID(), PenanceOfTheGods.class);
		cards.put(new ProtectorOfWhalesCard().getID(), ProtectorOfWhalesCard.class);
		cards.put(new TunnelGuardCard().getID(), TunnelGuardCard.class);
	}
	public Card createCard(int cardId) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException
	{
		if(cards.get(cardId)!=null)
		{
			return (Card)cards.get(cardId).getConstructors()[0].newInstance();
		}
		return null;
	}
}
