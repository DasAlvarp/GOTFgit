package com.alvarpq.GOTF.coreGame;
import java.util.Arrays;
import com.alvarpq.GOTF.cards.Card;
import com.alvarpq.GOTF.cards.Deck;
import com.alvarpq.GOTF.cards.UselessContraptionCard;
import com.alvarpq.GOTF.requirement.TileRequirement;
public class MainTest
{
	public static void main(String[] args)
	{
		Game game = new Game(new Deck(Arrays.asList(new Card[]{new UselessContraptionCard(), new UselessContraptionCard()}), false),
		new Deck(Arrays.asList(new Card[]{new UselessContraptionCard(), new UselessContraptionCard()}), false));
		game.getSide(Player.PLAYER1).getDeck().drawHand(2);
		game.getSide(Player.PLAYER2).getDeck().drawHand(2);
		game.getSide(game.getCurrentPlayer()).sacrificeForResources(0, Resource.AIR);
		((TileRequirement)game.getSide(game.getCurrentPlayer()).getDeck().getHand().get(0).getRequirements()[0]).setTile(0, 0);
		game.playCard(game.getCurrentPlayer(), 0);
	}
}
