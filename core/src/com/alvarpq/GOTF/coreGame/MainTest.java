package com.alvarpq.GOTF.coreGame;
import com.alvarpq.GOTF.coreGame.hexEnchant.Hill;
import com.alvarpq.GOTF.coreGame.units.UselessContraption;
public class MainTest
{
	public static void main(String[] args)
	{
		Game game = new Game();
		game.half1.addHexEnchant(new Hill(0, 0));
		game.half1.addUnit(new UselessContraption(0, 0));
		game.half1.move(0, 0, 0, 1);
		System.out.println(game.half1.getUnitAt(0, 0).getHealth());
	}
}
