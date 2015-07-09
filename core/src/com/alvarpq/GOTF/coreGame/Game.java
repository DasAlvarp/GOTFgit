package com.alvarpq.GOTF.coreGame;
import java.util.Random;
import com.alvarpq.GOTF.cards.Deck;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
public class Game
{
	/*When a user tries to play a card by clicking on it do the following:
	Call side(1 or 2 depending on which player tries to play the card).hasResources(indexOfCardInHand or the card)to see if sufficient resources exist
	Then start ask the user for input to the card's requirements (the requirements are found by calling side(1 or 2 depending on which player tries to play the card).getDeck().getHand().get(indexOfCardInHand or the card).getRequirements())
	Use the requirements types to determine what input they need, then send them that input throught either setTile for tile requirements or setUnit for unit requirements
	When all the requirements of the card are fullfilled (check with card.isReady()) just call side(1 or 2 depending on which player tries to play the card).playCard(indexOfCardInHand or the card)*/
	public Side side1;
	public Side side2;
	Player currentPlayer;
	private static final Random random = new Random();
	public Game(Deck deck1, Deck deck2)
	{
		side1 = new Side(new BoardHalf(5, 3, 8, Player.PLAYER1), deck1);
		side2 = new Side(new BoardHalf(5, 3, 8, Player.PLAYER2), deck2);
		BoardHalf.createBoard(side1.getHalf(), side2.getHalf());
		currentPlayer = Player.values()[random.nextInt(2)];
	}
	//Call directly after endTurn
	public void startTurn()
	{
		if(currentPlayer==Player.PLAYER1)
		{
			side1.resetResources();
			side1.getHalf().allCountDown();
		}
		else
		{
			side2.resetResources();
			side2.getHalf().allCountDown();
		}
	}
	//Call when user presses end turn button
	public void endTurn()
	{
		if(currentPlayer==Player.PLAYER1)
		{
			side1.getHalf().allAttack();
		}
		else
		{
			side2.getHalf().allAttack();
		}
		currentPlayer = currentPlayer.otherPlayer();
	}
}
