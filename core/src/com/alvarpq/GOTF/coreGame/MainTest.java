package com.alvarpq.GOTF.coreGame;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.coreGame.units.KinfolkBrave;
public class MainTest
{
	public static void main(String[] args)
	{
		BoardHalf half1 = new BoardHalf(5, 3, 8);
		BoardHalf half2 = new BoardHalf(5, 3, 8);
		half1.addUnit(new KinfolkBrave(0, 0), half2);
		half2.addUnit(new KinfolkBrave(0, 2), half1);
		half1.getUnitAt(0, 0).attack(half1, half2);
		System.out.println(half2.getUnitAt(0, 2));
	}
}
