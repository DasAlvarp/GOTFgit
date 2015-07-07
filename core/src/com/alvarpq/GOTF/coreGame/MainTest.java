package com.alvarpq.GOTF.coreGame;
import com.alvarpq.GOTF.cards.Card;
import com.alvarpq.GOTF.cards.UselessContraptionCard;
import com.alvarpq.GOTF.coreGame.hexEnchant.Hill;
public class MainTest
{
	public static void main(String[] args)
	{
		Game game = new Game();
		game.half1.addHexEnchant(new Hill(0, 0));
		Card test = new UselessContraptionCard();
		test.inputHex(Player.PLAYER1, 0, 0);
		test.play(game.half1, game.half1);
		game.half1.move(0, 0, 0, 1);
		System.out.println(game.half1.getUnitAt(0, 0).getHealth());
	}
}
