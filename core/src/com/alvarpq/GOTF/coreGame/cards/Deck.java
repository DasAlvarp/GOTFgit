package com.alvarpq.GOTF.coreGame.cards;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
public class Deck
{
	private Stack<Card> drawPile;
	private List<Card> discardPile;
	private List<Card> hand;
	public static final CardFactory cards = new CardFactory();
	public Deck(List<Integer> deckIds, boolean shuffle) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException
	{
		List<Card> deck = new LinkedList<Card>();
		for(int cardId:deckIds)
		{
			Card tempCard = cards.createCard(cardId);
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
	public void shuffle()
	{
		Stack<Card> shuffledDrawPile = new Stack<Card>();
		while(drawPile.size()>0)
		{
			shuffledDrawPile.add(drawPile.remove((int)((Math.random()*drawPile.size()))));
		}
		drawPile = shuffledDrawPile;
	}
	
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
	public void discardCard(int index)
	{
		discardPile.add(hand.remove(index));
	}
	public boolean discardCard(Card card)
	{
		if(hand.remove(card))
		{
			discardPile.add(card);
			return true;
		}
		return false;
	}
	public List<Card> getDiscardPile()
	{
		return discardPile;
	}
	public List<Card> getHand()
	{
		return hand;
	}
}