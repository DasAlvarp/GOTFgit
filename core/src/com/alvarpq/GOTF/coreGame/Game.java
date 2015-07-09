package com.alvarpq.GOTF.coreGame;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import com.alvarpq.GOTF.cards.Card;
import com.alvarpq.GOTF.cards.Deck;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
public class Game
{
	/*When a user tries to play a card by clicking on it do the following:
	Call side(1 or 2 depending on which player tries to play the card).hasResources(indexOfCardInHand or the card)to see if sufficient resources exist
	Then start ask the user for input to the card's requirements (the requirements are found by calling side(1 or 2 depending on which player tries to play the card).getDeck().getHand().get(indexOfCardInHand or the card).getRequirements())
	Use the requirements types to determine what input they need, then send them that input throught either setTile for tile requirements or setUnit for unit requirements
	When all the requirements of the card are fullfilled (check with card.isReady()) just call playCard(player, indexOfCardInHand or the card)*/
	private Map<Player, Side> sides;
	private Player currentPlayer;
	private static final Random random = new Random();
	public Game(Deck deck1, Deck deck2)
	{
		sides = new HashMap<Player, Side>();
		sides.put(Player.PLAYER1, new Side(new BoardHalf(5, 3, 8, Player.PLAYER1), deck1));
		sides.put(Player.PLAYER2, new Side(new BoardHalf(5, 3, 8, Player.PLAYER2), deck2));
		BoardHalf.createBoard(sides.get(Player.PLAYER1).getHalf(), sides.get(Player.PLAYER2).getHalf());
		currentPlayer = Player.values()[random.nextInt(2)];
	}
	//Call directly after endTurn
	public void startTurn()
	{
		if(currentPlayer==Player.PLAYER1)
		{
			sides.get(Player.PLAYER1).resetResources();
			sides.get(Player.PLAYER1).getHalf().allCountDown();
			sides.get(Player.PLAYER1).getDeck().drawCards(1);
		}
		else
		{
			sides.get(Player.PLAYER2).resetResources();
			sides.get(Player.PLAYER2).getHalf().allCountDown();
			sides.get(Player.PLAYER2).getDeck().drawCards(1);
		}
	}
	//Call when user presses end turn button
	public void endTurn()
	{
		if(currentPlayer==Player.PLAYER1)
		{
			sides.get(Player.PLAYER1).getHalf().allAttack();
		}
		else
		{
			sides.get(Player.PLAYER2).getHalf().allAttack();
		}
		currentPlayer = currentPlayer.otherPlayer();
	}
	public Player getCurrentPlayer()
	{
		return currentPlayer;
	}
	public void setCurrentPlayer(Player currentPlayer)
	{
		this.currentPlayer = currentPlayer;
	}
	public Side getSide(Player owner)
	{
		return sides.get(owner);
	}
	//Call when user has inputed all needed data to play a card
	public boolean playCard(Player side, int indexInHand)
	{
		if(sides.get(side).getDeck().getHand().get(indexInHand).isReady()&&sides.get(side).payForCard(indexInHand))
		{
			return sides.get(side).getDeck().getHand().get(indexInHand).play(sides.get(side).getHalf(), sides.get(side.otherPlayer()).getHalf());
		}
		return false;
	}
	//Call when user has inputed all needed data to play a card
	public boolean playCard(Player side, Card card)
	{
		if(card.isReady()&&sides.get(side).payForCard(card))
		{
			return card.play(sides.get(side).getHalf(), sides.get(side.otherPlayer()).getHalf());
		}
		return false;
	}
}
