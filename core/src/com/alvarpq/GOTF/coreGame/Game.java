package com.alvarpq.GOTF.coreGame;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.coreGame.cards.Card;
import com.alvarpq.GOTF.server.CommandReader;
import com.alvarpq.GOTF.server.User;
public class Game
{
	//Readers take inputs from the client to the server and apply them to the game.
	private CommandReader reader;
	/**
	 * A map containing the game's two sides.
	 */
	private Map<Player, Side> sides;
	/**
	 * The current player.
	 */
	private Player currentPlayer;
	/**
	 * Used to determine starting player.
	 */
	private static final Random random = new Random();
	/**
	 * Instantiates a new Game.
	 * @param deck1 the first player's deck
	 * @param deck2 the second player's deck
	 */
	public Game(User u1, User u2)
	{
		reader=new CommandReader(this);
		sides = new HashMap<Player, Side>();
		sides.put(Player.PLAYER1, new Side(new BoardHalf(5, 3, 8, Player.PLAYER1), u1.getCurrentDeck(), Player.PLAYER1));
		sides.put(Player.PLAYER2, new Side(new BoardHalf(5, 3, 8, Player.PLAYER2), u2.getCurrentDeck(), Player.PLAYER2));
		sides.get(Player.PLAYER1).setParentGame(this);
		sides.get(Player.PLAYER2).setParentGame(this);
		sides.get(Player.PLAYER1).getHalf().setParentGame(this);
		sides.get(Player.PLAYER2).getHalf().setParentGame(this);
	}
	
	public CommandReader getReader(){
		return reader;
	}
	/**
	 * Starts the game with the given handSize.
	 * @param handSize the hand size to use
	 */
	public void start(int handSize)
	{
		sides.get(Player.PLAYER1).getDeck().drawHand(handSize);
		sides.get(Player.PLAYER2).getDeck().drawHand(handSize);
		currentPlayer = random.nextBoolean()?Player.PLAYER1:Player.PLAYER2; 
	}
	/**
	 * Starts the next turn. Only call directly after endTurn
	 */
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
	/**
	 * Ends the current turn.
	 */
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
	/**
	 * Returns the current player.
	 * @return the current player
	 */
	public Player getCurrentPlayer()
	{
		return currentPlayer;
	}
	/**
	 * Set the current player.
	 * @param currentPlayer the new current player
	 */
	public void setCurrentPlayer(Player currentPlayer)
	{
		this.currentPlayer = currentPlayer;
	}
	/**
	 * Gets owner's side.
	 * @param owner the owner of the side to get
	 * @return owner's side.
	 */
	public Side getSide(Player owner)
	{
		return sides.get(owner);
	}
	/**
	 * Plays a card with a certain index in a player's hand. Enough resources has to exist and the card has to be ready to be played.
	 * @param side the player who plays the card
	 * @param indexInHand the index in hand of the card to play
	 */
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
	/**
	 * Plays a card  in a player's hand. Enough resources has to exist and the card has to be ready to be played.
	 * @param side the player who plays the card
	 * @param card the card to play
	 */
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
