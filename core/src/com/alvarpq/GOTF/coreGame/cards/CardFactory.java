package com.alvarpq.GOTF.coreGame.cards;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import com.alvarpq.GOTF.coreGame.cards.unused.DarkYounglingCard;
import com.alvarpq.GOTF.coreGame.cards.unused.ExampleSpellCard;
import com.alvarpq.GOTF.coreGame.cards.unused.ExampleUnitCard;
import com.alvarpq.GOTF.coreGame.cards.unused.JumpingWhaleCard;
import com.alvarpq.GOTF.coreGame.cards.unused.PenanceOfTheGods;
import com.alvarpq.GOTF.coreGame.cards.unused.ProtectorOfWhalesCard;
import com.alvarpq.GOTF.coreGame.cards.unused.TunnelGuardCard;
import com.alvarpq.GOTF.coreGame.cards.vorgasminingcorporation.GoblinGuardCard;
import com.alvarpq.GOTF.coreGame.cards.vorgasminingcorporation.GoblinPyromancerCard;
import com.alvarpq.GOTF.coreGame.cards.vorgasminingcorporation.GoblinWarriorCard;
import com.alvarpq.GOTF.coreGame.cards.vorgasminingcorporation.RedDevilCard;
import com.alvarpq.GOTF.coreGame.cards.vorgasminingcorporation.StoneGiantCard;
import com.alvarpq.GOTF.coreGame.cards.vorgasminingcorporation.TamedDemonCard;
/**
 * A class for instantiating cards from ids.
 */
public class CardFactory 
{
	/**
	 * The map with all the cards.
	 */
	private static final Map<Integer, Class<? extends Card>> cards = newCardMap();
	/**
	 * Instantiates and returns a map with all cards and their ids.
	 * @return a map with all cards and their ids
	 */
	private static Map<Integer, Class<? extends Card>> newCardMap()
	{
		Map<Integer, Class<? extends Card>> cards = new HashMap<Integer, Class<? extends Card>>();
		addCard(new DarkYounglingCard(), cards);
		addCard(new ExampleSpellCard(), cards);
		addCard(new ExampleUnitCard(), cards);
		addCard(new JumpingWhaleCard(), cards);
		addCard(new PenanceOfTheGods(), cards);
		addCard(new ProtectorOfWhalesCard(), cards);
		addCard(new TunnelGuardCard(), cards);
		addCard(new GoblinGuardCard(), cards);
		addCard(new GoblinPyromancerCard(), cards);
		addCard(new GoblinWarriorCard(), cards);
		addCard(new RedDevilCard(), cards);
		addCard(new StoneGiantCard(), cards);
		addCard(new TamedDemonCard(), cards);
		return cards;
	}
	/**
	 * Adds a card to the list.
	 * @param card the card to add
	 * @param cards the map to add the card into
	 */
	private static void addCard(Card card, Map<Integer, Class<? extends Card>> cards)
	{
		cards.put(card.getID(), card.getClass());
	}
	/**
	 * Instantiates and returns a card with specified id.
	 * @param cardId the id of the card to create
	 * @return the created card
	 */
	public static Card createCard(int cardId) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException
	{
		if(cards.get(cardId)!=null)
		{
			return (Card)cards.get(cardId).getConstructors()[0].newInstance();
		}
		return null;
	}
}
