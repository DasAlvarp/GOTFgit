package com.alvarpq.GOTF.coreGame;
import java.util.Arrays;
import java.util.Scanner;
import com.alvarpq.GOTF.cards.Card;
import com.alvarpq.GOTF.cards.Deck;
import com.alvarpq.GOTF.cards.KinfolkBraveCard;
import com.alvarpq.GOTF.cards.Spark;
import com.alvarpq.GOTF.cards.UselessContraptionCard;
import com.alvarpq.GOTF.requirement.TileRequirement;
import com.alvarpq.GOTF.requirement.Requirement;
import com.alvarpq.GOTF.requirement.RequirementType;
public class ConsoleGOTF
{
	public static void main(String[] args)
	{	
		Scanner input = new Scanner(System.in);
		Deck deck1 = new Deck(Arrays.asList(new Card[]{new KinfolkBraveCard(), new KinfolkBraveCard(), new KinfolkBraveCard()
		, new UselessContraptionCard(), new UselessContraptionCard(),new UselessContraptionCard()}), true);
		Deck deck2 = new Deck(Arrays.asList(new Card[]{new KinfolkBraveCard(), new KinfolkBraveCard(), new KinfolkBraveCard()
		, new Spark(), new Spark(), new Spark()}), true);
		Game game = new Game(deck1, deck2);
		game.start(3);
		while(!game.getSide(Player.PLAYER1).hasLost()&&!game.getSide(Player.PLAYER2).hasLost())
		{
			System.out.println(game.getCurrentPlayer()+"'s turn");
			for(int i=0;i<5;i++)
			{
				if(i%2==0)
				{
					StringBuilder side1 = new StringBuilder();
					StringBuilder side2 = new StringBuilder();
					for(int j=2;j>=0;j--)
					{
						if(game.getSide(Player.PLAYER1).getHalf().getUnitAt(i, j)==null)
						{
							if((i*3+j+1)<10)
							{
								side1.append("0"+(i*3+j+1)+"  ");
							}
							else
							{
								side1.append((i*3+j+1)+"  ");
							}
						}
						else
						{
							side1.append(game.getSide(Player.PLAYER1).getHalf().getUnitAt(i, j).getName().substring(0, 2)+"  ");
						}
					}
					for(int j=0;j<3;j++)
					{
						if(game.getSide(Player.PLAYER2).getHalf().getUnitAt(i, j)==null)
						{
							if((i*3+j+1)<10)
							{
								side2.append("  0"+(i*3+j+1));
							}
							else
							{
								side2.append("  "+(i*3+j+1));
							}
						}
						else
						{
							side2.append("  "+game.getSide(Player.PLAYER2).getHalf().getUnitAt(i, j).getName().substring(0, 2));
						}
					}
					System.out.println(side1+" "+side2);
				}
				else
				{
					StringBuilder side1 = new StringBuilder();
					StringBuilder side2 = new StringBuilder();
					for(int j=2;j>=0;j--)
					{
						if(game.getSide(Player.PLAYER1).getHalf().getUnitAt(i, j)==null)
						{
							if((i*3+j+1)<10)
							{
								side1.append("  0"+(i*3+j+1));
							}
							else
							{
								side1.append("  "+(i*3+j+1));
							}
						}
						else
						{
							side1.append("  "+game.getSide(Player.PLAYER1).getHalf().getUnitAt(i, j).getName().substring(0, 2));
						}
					}
					for(int j=0;j<3;j++)
					{
						if(game.getSide(Player.PLAYER2).getHalf().getUnitAt(i, j)==null)
						{
							if((i*3+j+1)<10)
							{
								side2.append("0"+(i*3+j+1)+"  ");
							}
							else
							{
								side2.append((i*3+j+1)+"  ");
							}
						}
						else
						{
							side2.append(game.getSide(Player.PLAYER2).getHalf().getUnitAt(i, j).getName().substring(0, 2)+"  ");
						}
					}
					System.out.println(side1+" "+side2);
				}
			}
			System.out.print("Hand: "+game.getSide(game.getCurrentPlayer()).getDeck().getHand().get(0).getName().substring(0, 3));
			for(int i=1;i<game.getSide(game.getCurrentPlayer()).getDeck().getHand().size();i++)
			{
				System.out.print(", "+game.getSide(game.getCurrentPlayer()).getDeck().getHand().get(i).getName().substring(0, 3));
			}
			System.out.println();
			System.out.print("> ");
			String[] command = input.nextLine().split(" ");
			if(command[0].equalsIgnoreCase("end"))
			{
				game.endTurn();
				game.startTurn();
			}
			else if(command[0].equalsIgnoreCase("play"))
			{
				for(Card card:game.getSide(game.getCurrentPlayer()).getDeck().getHand())
				{
					if(command[1].equalsIgnoreCase(card.getName().substring(0, 3)))
					{
						for(Requirement requirement:card.getRequirements())
						{
							if(requirement.getType()==RequirementType.OWN_EMPTY_TILE)
							{
								System.out.print("(1-15)> ");
								while(true)
								{
									try
									{
										int tileNumber = Integer.parseInt(input.nextLine());
										int row = (tileNumber-1)/3;
										int column = (tileNumber-1)%3;
										if(game.getSide(game.getCurrentPlayer()).getHalf().getUnitAt(row, column)==null)
										{
											((TileRequirement)requirement).setTile(row, column);
											break;
										}
									}
									catch(NumberFormatException exception){	}
								}
							}
						}
						card.play(game.getSide(game.getCurrentPlayer()).getHalf(), game.getSide(game.getCurrentPlayer().otherPlayer()).getHalf());
						break;
					}
				}
			}
		}
		input.close();
	}
}
