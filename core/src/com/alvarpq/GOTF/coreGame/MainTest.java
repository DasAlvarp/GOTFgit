package com.alvarpq.GOTF.coreGame;
import com.alvarpq.GOTF.coreGame.units.KinfolkBrave;
import com.alvarpq.GOTF.coreGame.units.RoyalSkirmisher;
public class MainTest
{
	public static void main(String[] args)
	{
		Game game = new Game();
		game.half1.addUnit(new RoyalSkirmisher(0, 0));
		game.half2.addUnit(new KinfolkBrave(0, 2));
		game.half2.addUnit(new KinfolkBrave(0, 1));
		game.endTurn();
		System.out.println(game.half2.getUnitAt(0, 2).getHealth());
	}
}
