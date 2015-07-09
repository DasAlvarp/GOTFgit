package com.alvarpq.GOTF.coreGame;
import java.util.Arrays;
import com.alvarpq.GOTF.cards.Card;
import com.alvarpq.GOTF.cards.Deck;
import com.alvarpq.GOTF.cards.KinfolkBraveCard;
import com.alvarpq.GOTF.cards.Spark;
import com.alvarpq.GOTF.requirement.TileRequirement;
import com.alvarpq.GOTF.requirement.UnitRequirement;
public class MainTest
{
	public static void main(String[] args)
	{
		Game game = new Game(new Deck(Arrays.asList(new Card[]{new KinfolkBraveCard(), new KinfolkBraveCard()}), false),
		new Deck(Arrays.asList(new Card[]{new Spark(), new Spark()}), false));
		game.getSide(Player.PLAYER1).getDeck().drawHand(2);
		game.getSide(Player.PLAYER2).getDeck().drawHand(2);
		game.getSide(game.getCurrentPlayer()).sacrificeForResources(0, Resource.AIR);
		((TileRequirement)game.getSide(game.getCurrentPlayer()).getDeck().getHand().get(0).getRequirements()[0]).setTile(0, 0);
		game.playCard(game.getCurrentPlayer(), 0);
		System.out.println(game.getSide(game.getCurrentPlayer()).getHalf().getUnitAt(0, 0));
		game.endTurn();
		game.getSide(game.getCurrentPlayer()).sacrificeForResources(0, Resource.AIR);
		((UnitRequirement)game.getSide(game.getCurrentPlayer()).getDeck().getHand().get(0).getRequirements()[0]).setUnit(game.getSide(game.getCurrentPlayer()).getHalf().getUnitAt(0, 0));
		game.playCard(game.getCurrentPlayer(), 0);
		System.out.println(game.getSide(game.getCurrentPlayer()).getHalf().getUnitAt(0, 0));
	}
}
