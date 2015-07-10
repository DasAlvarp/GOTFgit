package com.alvarpq.GOTF.coreGame;
import java.util.Arrays;
import com.alvarpq.GOTF.cards.Card;
import com.alvarpq.GOTF.cards.Deck;
import com.alvarpq.GOTF.cards.KinfolkBraveCard;
import com.alvarpq.GOTF.cards.Spark;
import com.alvarpq.GOTF.cards.UselessContraptionCard;
public class ConsoleGOTF
{
	public static void main(String[] args)
	{
		Deck deck1 = new Deck(Arrays.asList(new Card[]{new KinfolkBraveCard(), new KinfolkBraveCard(), new KinfolkBraveCard()
		, new UselessContraptionCard(), new UselessContraptionCard(),new UselessContraptionCard()}), true);
		Deck deck2 = new Deck(Arrays.asList(new Card[]{new KinfolkBraveCard(), new KinfolkBraveCard(), new KinfolkBraveCard()
		, new Spark(), new Spark(), new Spark()}), true);
		Game game = new Game(deck1, deck2);
		while(!game.getSide(Player.PLAYER1).hasLost()&&!game.getSide(Player.PLAYER2).hasLost());
		{
			
		}
	}
}
