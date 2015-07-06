package com.alvarpq.GOTF.coreGame;
import com.alvarpq.GOTF.coreGame.units.IlmireRotEater;
import com.alvarpq.GOTF.coreGame.units.KinfolkBrave;
public class MainTest
{
	public static void main(String[] args)
	{
		Game game = new Game();
		game.half1.addUnit(new IlmireRotEater(1, 1));
		game.half1.addUnit(new KinfolkBrave(0, 0));
		game.half1.addUnit(new KinfolkBrave(3, 0));
		game.half1.addUnit(new KinfolkBrave(2, 0));
		game.half1.getUnitAt(0, 0).damage(game.half1, game.half2, 2);
		game.half1.getUnitAt(3, 0).damage(game.half1, game.half2, 2);
		System.out.println(game.half1.getUnitAt(1, 1).getHealth());
	}
}
