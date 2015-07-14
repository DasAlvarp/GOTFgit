package com.alvarpq.GOTF.coreGame.cards;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
public class Deck
{
	private Stack<Card> drawPile;
	private List<Card> discardPile;
	private List<Card> hand;
	private CardExistor fredTheEternal;//top notch variable naming when low on sleep.
	/*
	 * I'm adding a function to turn an int list into a deck. 
	 */
	public Deck(List<Integer> list)
	{
		List<Card> deck = new LinkedList<Card>();
		for(int x = 0; x < list.size(); x++)
		{
			Card temp = fredTheEternal.getCard(x);
			if(temp != null)
			{
				deck.add(temp);
			}
			else
			{
				//panic!
				System.out.println("SOMETHING BAD HAPPENED MAN YOUR BATTLE STATION, THE GAME IS SINKING GOD SAVE US NOW");
			}
		}
		
		drawPile = new Stack<Card>();
		for(Card card:deck)
		{
			drawPile.push(card);
		}
		
		shuffle();//has to be true, or else the methods start fighting, and nobody wants that to happen.
		
		discardPile = new LinkedList<Card>();
		hand = new LinkedList<Card>();
	}
	
	
	public Deck(List<Card> deck, boolean shuffle)
	{
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