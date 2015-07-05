package com.alvarpq.GOTF.coreGame;

public class MainTest
{
	public static void main(String[] args)
	{
		BoardHalf half1 = new BoardHalf(5, 3, 8);
		BoardHalf half2 = new BoardHalf(5, 3, 8);
		half1.units[0][0] = new KinfolkBrave();
		half1.units[0][0].selfHealth = 0;
		half1.units[0][1] = new RoyalInfantryman();
		half1.updateUnits(half2);
		System.out.println(half1.units[0][0]);
		half1.units[0][0].move(half1, half2, 0, 0, 1, 0);
		System.out.println(half1.units[1][0]);
	}
}
