package com.alvarpq.GOTF.coreGame;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.coreGame.cards.Card;
import com.alvarpq.GOTF.coreGame.cards.Deck;
import com.alvarpq.GOTF.coreGame.event.Event;
import com.alvarpq.GOTF.coreGame.event.Listener;
import com.alvarpq.GOTF.coreGame.event.TurnEndedEvent;
import com.alvarpq.GOTF.coreGame.event.TurnEndedListener;
import com.alvarpq.GOTF.coreGame.event.UnitDamagedByUnitEvent;
import com.alvarpq.GOTF.coreGame.event.UnitDamagedByUnitListener;
import com.alvarpq.GOTF.coreGame.event.UnitDamagedEvent;
import com.alvarpq.GOTF.coreGame.event.UnitDamagedListener;
import com.alvarpq.GOTF.coreGame.event.UnitKilledByUnitEvent;
import com.alvarpq.GOTF.coreGame.event.UnitKilledByUnitListener;
import com.alvarpq.GOTF.coreGame.event.UnitKilledEvent;
import com.alvarpq.GOTF.coreGame.event.UnitKilledListener;
public class Side
{
	/**
	 * The board half belonging to this side.
	 */
	private BoardHalf half;
	/**
	 * The deck belonging to this side.
	 */
	private Deck deck;
	/**
	 * The maximum resources for this side.
	 */
	private int maximumResources;
	/**
	 * The current resources for this side.
	 */
	private int resources;
	/**
	 * The maximum elements for this side.
	 */
	private List<Element> maximumElements;
	/**
	 * The current elements for this side.
	 */
	private List<Element> elements;
	/**
	 * Whether this side has sacrificed this turn or not.
	 */
	private boolean hasSacrificed;
	/**
	 * The owner of this side.
	 */
	private Player owner;
	/**
	 * This sides temporary event listeners.
	 */
	private List<Listener> listeners;
	/**
	 * The game this side belongs to.
	 */
	private Game game;
	/**
	 * Instantiates a new Side.
	 * @param half this side's BoardHalf
	 * @param deck this side's deck
	 * @param owner this side's owner
	 */
	public Side(BoardHalf half, Deck deck, Player owner)
	{
		this.half = half;
		this.deck = deck;
		maximumResources = 0;
		resources = 0;
		maximumElements = new LinkedList<Element>();
		elements = new LinkedList<Element>();
		hasSacrificed = false;
		this.owner = owner;
		listeners = new LinkedList<Listener>();
	}
	/**
	 * Sets this side's parent game.
	 * @param g this side's new parent game
	 */
	public void setParentGame(Game g)
	{
		game = g;
	}
	/**
	 * Returns this side's parent game.
	 * @return this side's parent game
	 */
	public Game getParentGame()
	{
		return game;
	}
	public void resetElements()
	{
		resources = maximumResources;
		elements = new LinkedList<Element>(maximumElements);
		hasSacrificed = false;
	}
	/**
	 * Sacrifice the card in hand with the specified index for cards.
	 * @param indexInHand the index in hand of the card to sacrifice
	 */
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
	/**
	 * Sacrifice a card for cards.
	 * @param card the card to sacrifice
	 */
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
	/**
	 * Sacrifice the card in hand with the specified index for the specified element.
	 * @param indexInHand the index in hand of the card to sacrifice
	 * @param element the element to sacrifice for
	 */
	public boolean sacrificeForElements(int indexInHand, Element element)
	{
		if(!hasSacrificed&&deck.getHand().get(indexInHand).getElementCost().contains(element))
		{
			deck.discardCard(indexInHand);
			maximumResources++;
			resources++;
			maximumElements.add(element);
			elements.add(element);
			hasSacrificed = true;
			return true;
		}
		return false;
	}
	/**
	 * Sacrifice a card for the specified element.
	 * @param card the card to sacrifice
	 * @param element the element to sacrifice for
	 */
	public boolean sacrificeForElements(Card card, Element element)
	{
		if(!hasSacrificed&&card.getElementCost().contains(element)&&deck.discardCard(card))
		{
			maximumResources++;
			resources++;
			maximumElements.add(element);
			elements.add(element);
			hasSacrificed = true;
			return true;
		}
		return false;
	}
	/**
	 * Returns whether this side can pay for the card with specified index in hand.
	 * @param indexInHand the index in hand of the card to check if this side can pay for
	 * @return whether this side can pay for the card with specified index in hand
	 */
	public boolean canPayFor(int indexInHand)
	{
		if(resources>=deck.getHand().get(indexInHand).getResourceCost())
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
	/**
	 * Returns whether this side can pay for the specified card.
	 * @param card the card to check if this side can pay for
	 * @return whether this side can pay for the specified card
	 */
	public boolean canPayFor(Card card)
	{
		if(deck.getHand().contains(card)&&resources>=card.getResourceCost())
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
	/**
	 * Pays for the card with specified index in hand.
	 * @param indexInHand the index in hand of the card to pay for
	 * @return whether the card was payed for
	 */
	public boolean payForCard(int indexInHand)
	{
		if(resources>=deck.getHand().get(indexInHand).getResourceCost())
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
			resources-=deck.getHand().get(indexInHand).getResourceCost();
			elements = tempElements;
			return true;
		}
		return false;
	}
	/**
	 * Pays for the specified card
	 * @param card the card to pay for
	 * @return whether the card was payed for
	 */
	public boolean payForCard(Card card)
	{
		if(deck.getHand().contains(card)&&resources>=card.getResourceCost())
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
			resources-=card.getResourceCost();
			elements = tempElements;
			return true;
		}
		return false;
	}
	/**
	 * Returns this side's board half.
	 * @return this side's board half
	 */
	public BoardHalf getHalf()
	{
		return half;
	}
	/**
	 * Returns this side's deck.
	 * @return this side's deck
	 */
	public Deck getDeck()
	{
		return deck;
	}
	/**
	 * Returns this side's maximum resources.
	 * @return this side's parent game
	 */
	public int getMaximumResources()
	{
		return maximumResources;
	}
	/**
	 * Returns this side's current resources.
	 * @return this side's current resources
	 */
	public int getResources()
	{
		return resources;
	}
	/**
	 * Sets this side's current resources.
	 * @param resources this side's new current resources
	 */
	public void setResources(int resources)
	{
		this.resources = resources;
	}
	/**
	 * Returns this side's maximum elements.
	 * @return this side's maximum elements
	 */
	public List<Element> getMaximumElements()
	{
		return maximumElements;
	}
	/**
	 * Returns this side's current elements.
	 * @return this side's current elements
	 */
	public List<Element> getElements()
	{
		return elements;
	}
	public int getMaximumElement(Element element)
	{
		int toReturn = 0;
		for(Element element2:maximumElements)
		{
			if(element2==element)
			{
				toReturn++;
			}
		}
		return toReturn;
	}
	public int getElement(Element element)
	{
		int toReturn = 0;
		for(Element element2:elements)
		{
			if(element2==element)
			{
				toReturn++;
			}
		}
		return toReturn;
	}
	/**
	 * Returns this side's owner.
	 * @return this side's owner
	 */
	public Player getOwner()
	{
		return owner;
	}
	/**
	 * Dispatches an event to all listeners.
	 * @param event the event to dispatch.
	 */
	public void dispatchEvent(Event event)
	{
		half.dispatchEvent(event);
		if(event instanceof UnitKilledByUnitEvent)
		{
			Iterator<Listener> iterator = listeners.iterator();
			while(iterator.hasNext())
			{
				Listener listener = iterator.next();
				if(listener instanceof UnitKilledByUnitListener)
				{
					((UnitKilledByUnitListener)listener).onUnitKilledByUnit((UnitKilledByUnitEvent)event);
					iterator.remove();
				}
			}
			event.invertSides();
			iterator = game.getSide(owner.otherPlayer()).listeners.iterator();
			while(iterator.hasNext())
			{
				Listener listener = iterator.next();
				if(listener instanceof UnitKilledByUnitListener)
				{
					((UnitKilledByUnitListener)listener).onUnitKilledByUnit((UnitKilledByUnitEvent)event);
					iterator.remove();
				}
			}
		}
		else if(event instanceof UnitKilledEvent)
		{
			Iterator<Listener> iterator = listeners.iterator();
			while(iterator.hasNext())
			{
				Listener listener = iterator.next();
				if(listener instanceof UnitKilledListener)
				{
					((UnitKilledListener)listener).onUnitKilled((UnitKilledEvent)event);
					iterator.remove();
				}
			}
			event.invertSides();
			iterator = game.getSide(owner.otherPlayer()).listeners.iterator();
			while(iterator.hasNext())
			{
				Listener listener = iterator.next();
				if(listener instanceof UnitKilledListener)
				{
					((UnitKilledListener)listener).onUnitKilled((UnitKilledEvent)event);
					iterator.remove();
				}
			}
		}
		else if(event instanceof UnitDamagedByUnitEvent)
		{
			Iterator<Listener> iterator = listeners.iterator();
			while(iterator.hasNext())
			{
				Listener listener = iterator.next();
				if(listener instanceof UnitDamagedByUnitListener)
				{
					((UnitDamagedByUnitListener)listener).onUnitDamagedByUnit((UnitDamagedByUnitEvent)event);
					iterator.remove();
				}
			}
			event.invertSides();
			iterator = game.getSide(owner.otherPlayer()).listeners.iterator();
			while(iterator.hasNext())
			{
				Listener listener = iterator.next();
				if(listener instanceof UnitDamagedByUnitListener)
				{
					((UnitDamagedByUnitListener)listener).onUnitDamagedByUnit((UnitDamagedByUnitEvent)event);
					iterator.remove();
				}
			}
		}
		else if(event instanceof UnitDamagedEvent)
		{
			Iterator<Listener> iterator = listeners.iterator();
			while(iterator.hasNext())
			{
				Listener listener = iterator.next();
				if(listener instanceof UnitDamagedListener)
				{
					((UnitDamagedListener)listener).onUnitDamaged((UnitDamagedEvent)event);
					iterator.remove();
				}
			}
			event.invertSides();
			iterator = game.getSide(owner.otherPlayer()).listeners.iterator();
			while(iterator.hasNext())
			{
				Listener listener = iterator.next();
				if(listener instanceof UnitDamagedListener)
				{
					((UnitDamagedListener)listener).onUnitDamaged((UnitDamagedEvent)event);
					iterator.remove();
				}
			}
		}
		else if(event instanceof TurnEndedEvent)
		{
			Iterator<Listener> iterator = listeners.iterator();
			while(iterator.hasNext())
			{
				Listener listener = iterator.next();
				if(listener instanceof TurnEndedListener)
				{
					((TurnEndedListener)listener).onTurnEnded((TurnEndedEvent)event);
					iterator.remove();
				}
			}
			event.invertSides();
			iterator = game.getSide(owner.otherPlayer()).listeners.iterator();
			while(iterator.hasNext())
			{
				Listener listener = iterator.next();
				if(listener instanceof TurnEndedListener)
				{
					((TurnEndedListener)listener).onTurnEnded((TurnEndedEvent)event);
					iterator.remove();
				}
			}
		}
		event.invertSides();
	}
	public void listenOnce(Listener listener)
	{
		listeners.add(listener);
	}
}