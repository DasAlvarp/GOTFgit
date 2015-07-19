package com.alvarpq.GOTF.coreGame;
import java.util.LinkedList;
import java.util.List;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.coreGame.cards.Card;
import com.alvarpq.GOTF.coreGame.cards.Deck;
public class Side
{
	private BoardHalf half;
	private Deck deck;
	private int maximumResource, resource;
	private List<Element> maximumElements, elements;
	private boolean hasSacrificed;
	private Player owner;
	private Game game;
	
	
	public Side(BoardHalf half, Deck deck)
	{
		this.half = half;
		this.deck = deck;
		maximumResource = 0;
		resource = 0;
		maximumElements = new LinkedList<Element>();
		elements = new LinkedList<Element>();
		hasSacrificed = false;
	}
	
	public void setParentGame(Game g)
	{
		game = g;
	}
	
	public Game getParentGame()
	{
		return game;
	}
	public void resetElements()
	{
		resource = maximumResource;
		elements = new LinkedList<Element>(maximumElements);
		hasSacrificed = false;
	}
	
	//Call when user sacrifices for cards
	public boolean sacrificeForCards(int indexInHand)
	{
		if(!hasSacrificed)
		{
			deck.discardCard(indexInHand);
			deck.drawCards(2);
			hasSacrificed = true;
			return true;
		}
		return false;
	}
	
	//Call when user sacrifices for cards
	public boolean sacrificeForCards(Card card)
	{
		if(!hasSacrificed)
		{
			deck.discardCard(card);
			deck.drawCards(2);
			hasSacrificed = true;
			return true;
		}
		return false;
	}
	
	//Call when user sacrifices for elements
	public boolean sacrificeForElements(int indexInHand, Element element)
	{
		if(!hasSacrificed&&deck.getHand().get(indexInHand).getElementCost().contains(element))
		{
			deck.discardCard(indexInHand);
			maximumResource++;
			resource++;
			maximumElements.add(element);
			elements.add(element);
			hasSacrificed = true;
			return true;
		}
		return false;
	}
	
	//Call when user sacrifices for cards
	public boolean sacrificeForElements(Card card, Element element)
	{
		if(!hasSacrificed&&card.getElementCost().contains(element)&&deck.discardCard(card))
		{
			maximumResource++;
			resource++;
			maximumElements.add(element);
			elements.add(element);
			hasSacrificed = true;
			return true;
		}
		return false;
	}
	
	//Call when user presses a card to play it, in order to see if sufficient elements exist
	public boolean hasElements(int indexInHand)
	{
		if(resource>=deck.getHand().get(indexInHand).getResourceCost())
		{
			List<Element> tempElements = new LinkedList<Element>(elements);
			for(Element element:deck.getHand().get(indexInHand).getElementCost())
			{
				if(tempElements.contains(element))
				{
					tempElements.remove(element);
				}
				else
				{
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	//Call when user presses a card to play it, in order to see if sufficient elements exist
	public boolean hasElements(Card card)
	{
		if(deck.getHand().contains(card)&&resource>=card.getResourceCost())
		{
			List<Element> tempElements = new LinkedList<Element>(elements);
			for(Element element:card.getElementCost())
			{
				if(tempElements.contains(element))
				{
					tempElements.remove(element);
				}
				else
				{
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	//Do not call unless you know what you are doing. But you can't know what your doing unless you call it. So there.
	public boolean payForCard(int indexInHand)
	{
		if(resource>=deck.getHand().get(indexInHand).getResourceCost())
		{
			List<Element> tempElements = new LinkedList<Element>(elements);
			for(Element element:deck.getHand().get(indexInHand).getElementCost())
			{
				if(tempElements.contains(element))
				{
					tempElements.remove(element);
				}
				else
				{
					return false;
				}
			}
			resource-=deck.getHand().get(indexInHand).getResourceCost();
			elements = tempElements;
			return true;
		}
		return false;
	}
	
	//Do not call unless you know what you are doing. See above.
	public boolean payForCard(Card card)
	{
		if(deck.getHand().contains(card)&&resource>=card.getResourceCost())
		{
			List<Element> tempElements = new LinkedList<Element>(elements);
			for(Element element:card.getElementCost())
			{
				if(tempElements.contains(element))
				{
					tempElements.remove(element);
				}
				else
				{
					return false;
				}
			}
			resource-=card.getResourceCost();
			elements = tempElements;
			return true;
		}
		return false;
	}
	
	public BoardHalf getHalf()
	{
		return half;
	}
	
	public Deck getDeck()
	{
		return deck;
	}
	
	public int getMaximumResource()
	{
		return maximumResource;
	}
	
	public int getResource()
	{
		return resource;
	}
	
	public List<Element> getMaximumElements()
	{
		return maximumElements;
	}
	
	public List<Element> getElements()
	{
		return elements;
	}
	
	public Player getOwner()
	{
		return owner;
	}
}