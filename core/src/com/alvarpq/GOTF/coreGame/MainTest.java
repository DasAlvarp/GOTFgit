package com.alvarpq.GOTF.coreGame;
import com.alvarpq.GOTF.coreGame.units.KinfolkBrave;
import com.alvarpq.GOTF.coreGame.units.RoyalInfantryman;
import com.alvarpq.GOTF.coreGame.units.RoyalSkirmisher;
import com.alvarpq.GOTF.coreGame.units.Unit;
public class MainTest
{
	public static void main(String[] args)
	{
		Game game = new Game();
		game.half1.addUnit(new RoyalSkirmisher(0, 0));
		game.half1.addUnit(new RoyalSkirmisher(0, 1));
		game.half2.addUnit(new KinfolkBrave(0, 2));
		game.half2.addUnit(new RoyalInfantryman(0, 1));
		game.startTurn();
		for(Unit unit:game.half1.getUnits())
		{
			System.out.println(unit);
		}
		System.out.println();
		for(Unit unit:game.half2.getUnits())
		{
			System.out.println(unit);
		}
		System.out.println();
		System.out.println();
		game.endTurn();
		game.startTurn();
		for(Unit unit:game.half1.getUnits())
		{
			System.out.println(unit);
		}
		System.out.println();
		for(Unit unit:game.half2.getUnits())
		{
			System.out.println(unit);
		}
		System.out.println();
		System.out.println();
		game.endTurn();
		game.startTurn();
		for(Unit unit:game.half1.getUnits())
		{
			System.out.println(unit);
		}
		System.out.println();
		for(Unit unit:game.half2.getUnits())
		{
			System.out.println(unit);
		}
		System.out.println();
		System.out.println();
		game.endTurn();
		game.startTurn();
		for(Unit unit:game.half1.getUnits())
		{
			System.out.println(unit);
		}
		System.out.println();
		for(Unit unit:game.half2.getUnits())
		{
			System.out.println(unit);
		}
		System.out.println();
		System.out.println();
	}
}
