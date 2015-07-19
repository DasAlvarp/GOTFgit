package com.alvarpq.GOTF.coreGame;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.coreGame.cards.Card;
import com.alvarpq.GOTF.coreGame.cards.Deck;
import com.alvarpq.GOTF.gui.BoardDraw;
public class Game
{
	private Map<Player, Side> sides;
	private Player currentPlayer;
	private static final Random random = new Random();
	BoardDraw boardDraw;
	public Game(Deck deck1, Deck deck2)
	{
		sides = new HashMap<Player, Side>();
		sides.put(Player.PLAYER1, new Side(new BoardHalf(5, 3, 8, Player.PLAYER1), deck1));
		sides.put(Player.PLAYER2, new Side(new BoardHalf(5, 3, 8, Player.PLAYER2), deck2));
		sides.get(Player.PLAYER1).setParentGame(this);
		sides.get(Player.PLAYER2).setParentGame(this);
		sides.get(Player.PLAYER1).getHalf().setParentGame(this);
		sides.get(Player.PLAYER2).getHalf().setParentGame(this);
		currentPlayer = Player.values()[random.nextInt(2)];
		//boardDraw=new BoardDraw(); 
	}
	public BoardDraw getBoard(){
		return boardDraw;
	}
	
	public void update(){
		boardDraw.update();
	}
	
	//Call to start game
	public void start(int handSize)
	{
		sides.get(Player.PLAYER1).getDeck().drawHand(handSize);
		sides.get(Player.PLAYER2).getDeck().drawHand(handSize);
	}
	//Call directly after endTurn
	public void startTurn()
	{
		if(currentPlayer==Player.PLAYER1)
		{
			sides.get(Player.PLAYER1).resetElements();
			sides.get(Player.PLAYER1).getHalf().allResetMove();
			sides.get(Player.PLAYER1).getHalf().allCountDown();
			sides.get(Player.PLAYER1).getDeck().drawCards(1);
		}
		else
		{
			sides.get(Player.PLAYER2).resetElements();
			sides.get(Player.PLAYER2).getHalf().allResetMove();
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
			if(sides.get(side).getDeck().getHand().get(indexInHand).play(sides.get(side), sides.get(side.otherPlayer())))
			{
				sides.get(side).getDeck().discardCard(indexInHand);
				return true;
			}
			return false;
		}
		return false;
	}
	//Call when user has inputed all needed data to play a card
	public boolean playCard(Player side, Card card)
	{
		if(card.isReady()&&sides.get(side).payForCard(card))
		{
			if(card.play(sides.get(side), sides.get(side.otherPlayer())))
			{
				sides.get(side).getDeck().discardCard(card);
				return true;
			}
			return false;
		}
		return false;
	}
}
