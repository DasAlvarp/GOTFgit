package com.alvarpq.GOTF.coreGame.cards;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import com.alvarpq.GOTF.coreGame.Player;
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
import com.alvarpq.GOTF.coreGame.cards.vorgasminingcorporation.VorgasFireBomb;
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
		addCard(new DarkYounglingCard(Player.NONE), cards);
		addCard(new ExampleSpellCard(Player.NONE), cards);
		addCard(new ExampleUnitCard(Player.NONE), cards);
		addCard(new JumpingWhaleCard(Player.NONE), cards);
		addCard(new PenanceOfTheGods(Player.NONE), cards);
		addCard(new ProtectorOfWhalesCard(Player.NONE), cards);
		addCard(new TunnelGuardCard(Player.NONE), cards);
		addCard(new GoblinGuardCard(Player.NONE), cards);
		addCard(new GoblinPyromancerCard(Player.NONE), cards);
		addCard(new GoblinWarriorCard(Player.NONE), cards);
		addCard(new RedDevilCard(Player.NONE), cards);
		addCard(new StoneGiantCard(Player.NONE), cards);
		addCard(new TamedDemonCard(Player.NONE), cards);
		addCard(new VorgasFireBomb(Player.NONE), cards);
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
	 * @param owner the owner of the card
	 * @return the created card
	 */
	public static Card createCard(int cardId, Player owner) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException
	{
		if(cards.get(cardId)!=null)
		{
			return (Card)cards.get(cardId).getConstructors()[0].newInstance(owner);
		}
		return null;
	}
}
