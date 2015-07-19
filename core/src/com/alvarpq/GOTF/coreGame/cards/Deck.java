package com.alvarpq.GOTF.coreGame.cards;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
/**
 * A class for handling a deck.
 */
public class Deck
{
	/**
	 * The draw pile.
	 */
	private Stack<Card> drawPile;
	/**
	 * The discard pile.
	 */
	private List<Card> discardPile;
	/**
	 * The hand.
	 */
	private List<Card> hand;
	/**
	 * Instantiates a new Deck.
	 * @param deckIds a list of the ids of the cards to add to the deck
	 * @param shuffle whether the deck should be shuffled or not
	 */
	public Deck(List<Integer> deckIds, boolean shuffle) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException
	{
		List<Card> deck = new LinkedList<Card>();
		for(int cardId:deckIds)
		{
			Card tempCard = CardFactory.createCard(cardId);
			if(tempCard!=null)
			{
				deck.add(tempCard);
			}
		}
		drawPile = new Stack<Card>();
		for(Card card:deck)
		{
			drawPile.push(card);
		}
		if(shuffle)
		{
			shuffle();
		}
		discardPile = new LinkedList<Card>();
		hand = new LinkedList<Card>();
	}
	/**
	 * Shuffles the deck.
	 */
	public void shuffle()
	{
		Stack<Card> shuffledDrawPile = new Stack<Card>();
		while(drawPile.size()>0)
		{
			shuffledDrawPile.add(drawPile.remove((int)((Math.random()*drawPile.size()))));
		}
		drawPile = shuffledDrawPile;
	}
	/**
	 * Draws cards into the hand until it has reached the specified hand size.
	 * @param handSize the the hand size after the function execution
	 */
	public void drawHand(int handSize)
	{
		while(hand.size()<handSize)
		{
			if(drawPile.size()==0)
			{
				for(Card card:discardPile)
				{
					drawPile.push(card);
				}
				if(drawPile.size()==0)
				{
					break;
				}
				shuffle();
			}
			hand.add(drawPile.pop());
		}
	}
	/**
	 * Draws a specified amount of cards into the hand.
	 * @param amount the amount of cards to draw
	 */
	public void drawCards(int amount)
	{
		for(int i=0;i<amount;i++)
		{
			if(drawPile.size()==0)
			{
				for(Card card:discardPile)
				{
					drawPile.push(card);
				}
				if(drawPile.size()==0)
				{
					break;
				}
				shuffle();
			}
			hand.add(drawPile.pop());
		}
	}
	/**
	 * Discards the card with specified index in hand
	 * @param index the index of the card to discard
	 */
	public void discardCard(int index)
	{
		discardPile.add(hand.remove(index));
	}
	/**
	 * Discards the specified card.
	 * @param card the card to discard
	 * @return whether the card was discarded
	 */
	public boolean discardCard(Card card)
	{
		if(hand.remove(card))
		{
			discardPile.add(card);
			return true;
		}
		return false;
	}
	/**
	 * Returns the discard pile.
	 * @return the discard pile
	 */
	public List<Card> getDiscardPile()
	{
		return discardPile;
	}
	/**
	 * Returns the hand.
	 * @return the hand
	 */
	public List<Card> getHand()
	{
		return hand;
	}
}