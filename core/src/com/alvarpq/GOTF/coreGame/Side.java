package com.alvarpq.GOTF.coreGame;
import java.util.LinkedList;
import java.util.List;
import com.alvarpq.GOTF.cards.Card;
import com.alvarpq.GOTF.cards.Deck;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
public class Side
{
	private BoardHalf half;
	private Deck deck;
	private int maximumThreshold, threshold;
	private List<Resource> maximumResources, resources;
	boolean hasSacrificed;
	public Side(BoardHalf half, Deck deck)
	{
		this.half = half;
		this.deck = deck;
		maximumThreshold = 0;
		threshold = 0;
		maximumResources = new LinkedList<Resource>();
		resources = new LinkedList<Resource>();
	}
	public void resetResources()
	{
		threshold = maximumThreshold;
		resources = new LinkedList<Resource>(maximumResources);
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
	//Call when user sacrifices for resources
	public boolean sacrificeForResources(int indexInHand, Resource resource)
	{
		if(!hasSacrificed)
		{
			deck.discardCard(indexInHand);
			maximumThreshold++;
			threshold++;
			maximumResources.add(resource);
			resources.add(resource);
			hasSacrificed = true;
			return true;
		}
		return false;
	}
	//Call when user sacrifices for cards
	public boolean sacrificeForResorces(Card card, Resource resource)
	{
		if(!hasSacrificed&&	deck.discardCard(card))
		{
			maximumThreshold++;
			threshold++;
			maximumResources.add(resource);
			resources.add(resource);
			hasSacrificed = true;
			return true;
		}
		return false;
	}
	//Call when user presses a card to play it, in order to see if sufficient resources exist
	public boolean hasResources(int indexInHand)
	{
		if(threshold>deck.getHand().get(indexInHand).getThresholdCost())
		{
			List<Resource> tempResources = new LinkedList<Resource>(resources);
			for(Resource resource:deck.getHand().get(indexInHand).getResourceCost())
			{
				if(tempResources.contains(resource))
				{
					tempResources.remove(resource);
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
	//Call when user presses a card to play it, in order to see if sufficient resources exist
	public boolean hasResources(Card card)
	{
		if(deck.getHand().contains(card)&&threshold>card.getThresholdCost())
		{
			List<Resource> tempResources = new LinkedList<Resource>(resources);
			for(Resource resource:card.getResourceCost())
			{
				if(tempResources.contains(resource))
				{
					tempResources.remove(resource);
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
	//Call when user has inputed all needed data to play a card
	public boolean playCard(int indexInHand, BoardHalf myHalf, BoardHalf opponentsHalf)
	{
		if(threshold>deck.getHand().get(indexInHand).getThresholdCost())
		{
			List<Resource> tempResources = new LinkedList<Resource>(resources);
			for(Resource resource:deck.getHand().get(indexInHand).getResourceCost())
			{
				if(tempResources.contains(resource))
				{
					tempResources.remove(resource);
				}
				else
				{
					return false;
				}
			}
			threshold-=deck.getHand().get(indexInHand).getThresholdCost();
			resources = tempResources;
			return deck.getHand().get(indexInHand).play(myHalf, opponentsHalf);
		}
		return false;
	}
	//Call when user has inputed all needed data to play a card
	public boolean playCard(Card card, BoardHalf myHalf, BoardHalf opponentsHalf)
	{
		if(deck.getHand().contains(card)&&threshold>card.getThresholdCost())
		{
			List<Resource> tempResources = new LinkedList<Resource>(resources);
			for(Resource resource:card.getResourceCost())
			{
				if(tempResources.contains(resource))
				{
					tempResources.remove(resource);
				}
				else
				{
					return false;
				}
			}
			threshold-=card.getThresholdCost();
			resources = tempResources;
			return card.play(myHalf, opponentsHalf);
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
	public int getMaximumThreshold()
	{
		return maximumThreshold;
	}
	public int getThreshold()
	{
		return threshold;
	}
	public List<Resource> getMaximumResources()
	{
		return maximumResources;
	}
	public List<Resource> getResources()
	{
		return resources;
	}
	
}