package com.alvarpq.GOTF.coreGame;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;

import com.alvarpq.GOTF.coreGame.units.KinfolkBrave;
import com.alvarpq.GOTF.coreGame.units.RoyalInfantryman;
public class MainTest
{
	public static void main(String[] args)
	{
		BoardHalf half1 = new BoardHalf(5, 3, 8);
		BoardHalf half2 = new BoardHalf(5, 3, 8);
		half1.addUnit(new KinfolkBrave(0, 0));
		half1.getUnitAt(0, 0).setSelfHealth(0);
		half1.addUnit(new RoyalInfantryman(1, 1));
		half1.updateUnits(half2);
		System.out.println(half1.getUnitAt(0, 0));
	}
}
