package com.alvarpq.GOTF.coreGame;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.coreGame.units.KinfolkBrave;
import com.alvarpq.GOTF.coreGame.units.RoyalSkirmisher;
public class MainTest
{
	public static void main(String[] args)
	{
		BoardHalf half1 = new BoardHalf(5, 3, 8);
		BoardHalf half2 = new BoardHalf(5, 3, 8);
		BoardHalf.createBoard(half1, half2);
		half1.addUnit(new RoyalSkirmisher(0, 0));
		half2.addUnit(new KinfolkBrave(0, 2));
		half2.addUnit(new KinfolkBrave(0, 1));
		half1.attack(0, 0);
		System.out.println(half2.getUnitAt(0, 2).getHealth());
	}
}
