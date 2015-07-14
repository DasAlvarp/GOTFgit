package com.alvarpq.GOTF.coreGame.cards;
import com.alvarpq.GOTF.coreGame.cards.real.*;

import java.util.ArrayList;
/*
 * this thing just makes an instance of each card exist. It shouldn't affect anything, but it makes loading decks easier.
 * There pretty much HAS to be a better way to do this, but...eh.
 */


public class CardExistor 
{

	ArrayList<Card> cardList = new ArrayList<Card>();
	
	
	
	public CardExistor()
	{
		cardList.add(new DarkYounglingCard());
		cardList.add(new ExampleSpellCard());
		cardList.add(new ExampleUnitCard());
		cardList.add(new JumpingWhaleCard());
		cardList.add(new PenanceOfTheGods());
		cardList.add(new ProtectorOfWhalesCard());
		cardList.add(new TunnelGuardCard());
	}
	
	
	
	
	public Card getCard(int cardId)
	{
		for(int x = 0; x < cardList.size(); x++)
		{
			if(cardId == cardList.get(x).getID());
			{
				return cardList.get(x);
			}
		}
		return null;

	}
}
