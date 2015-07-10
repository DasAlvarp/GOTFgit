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
import com.alvarpq.GOTF.requirement.UnitRequirement;
public class ConsoleGOTF
{
	public static int tileNumberToRow(int tileNumber)
	{
		if(tileNumber>15)
		{
			tileNumber -=15;
		}
		return (tileNumber-1)/3;
	}
	public static int tileNumberToColumn(int tileNumber)
	{
		if(tileNumber>15)
		{
			tileNumber -=15;
		}
		return (tileNumber-1)%3;
	}
	public static Player tileNumberToSide(int tileNumber)
	{
		if(tileNumber<=15)
		{
			return Player.PLAYER1;
		}
		return Player.PLAYER2;
	}
	public static int toTileNumber(Player side, int row, int column)
	{
		if(side==Player.NONE)
		{
			return -1;
		}
		else if(side==Player.PLAYER1)
		{
			return row*3+column+1;
		}
		else
		{
			return 15+row*3+column+1;
		}
	}
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
							if(toTileNumber(Player.PLAYER1, i, j)<10)
							{
								side1.append("0"+toTileNumber(Player.PLAYER1, i, j)+"  ");
							}
							else
							{
								side1.append(toTileNumber(Player.PLAYER1, i, j)+"  ");
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
							side2.append("  "+toTileNumber(Player.PLAYER2, i, j));
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
							if(toTileNumber(Player.PLAYER1, i, j)<10)
							{
								side1.append("  0"+toTileNumber(Player.PLAYER1, i, j));
							}
							else
							{
								side1.append("  "+toTileNumber(Player.PLAYER1, i, j));
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
							side2.append(toTileNumber(Player.PLAYER2, i, j)+"  ");
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
			else if(command[0].equalsIgnoreCase("sacrifice"))
			{
				for(Card card:game.getSide(game.getCurrentPlayer()).getDeck().getHand())
				{
					if(command[1].equalsIgnoreCase(card.getName().substring(0, 3))
				}
			}
			else if(command[0].equalsIgnoreCase("play"))
			{
				for(Card card:game.getSide(game.getCurrentPlayer()).getDeck().getHand())
				{
					if(command[1].equalsIgnoreCase(card.getName().substring(0, 3))&&game.getSide(game.getCurrentPlayer()).hasResources(card))
					{
						for(Requirement requirement:card.getRequirements())
						{
							if(requirement.getType()==RequirementType.TILE)
							{
								System.out.print("(1-30)> ");
								while(true)
								{
									try
									{
										int tileNumber = Integer.parseInt(input.nextLine());
										if(tileNumber>=1&&tileNumber<=30)
										{
											((TileRequirement)requirement).setTile(tileNumberToSide(tileNumber), tileNumberToRow(tileNumber), tileNumberToColumn(tileNumber));
											break;
										}
									}
									catch(NumberFormatException exception){	}
								}
							}
							else if(requirement.getType()==RequirementType.OWN_TILE)
							{
								System.out.print(game.getCurrentPlayer()==Player.PLAYER1?"(1-15)> ":"(16-30)> ");
								while(true)
								{
									try
									{
										int tileNumber = Integer.parseInt(input.nextLine());
										if(tileNumber>=1&&tileNumber<=30&&game.getCurrentPlayer()==tileNumberToSide(tileNumber))
										{
											((TileRequirement)requirement).setTile(tileNumberToSide(tileNumber), tileNumberToRow(tileNumber), tileNumberToColumn(tileNumber));
											break;
										}
			
									}
									catch(NumberFormatException exception){	}
								}
							}
							else if(requirement.getType()==RequirementType.OPPONENT_TILE)
							{
								System.out.print(game.getCurrentPlayer()==Player.PLAYER1?"(16-30)> ":"(1-15)> ");
								while(true)
								{
									try
									{
										int tileNumber = Integer.parseInt(input.nextLine());
										if(tileNumber>=1&&tileNumber<=30&&game.getCurrentPlayer().otherPlayer()==tileNumberToSide(tileNumber))
										{
											((TileRequirement)requirement).setTile(tileNumberToSide(tileNumber), tileNumberToRow(tileNumber), tileNumberToColumn(tileNumber));
											break;
										}
									}
									catch(NumberFormatException exception){	}
								}
							}
							else if(requirement.getType()==RequirementType.EMPTY_TILE)
							{
								System.out.print("(1-30)> ");
								while(true)
								{
									try
									{
										int tileNumber = Integer.parseInt(input.nextLine());
										if(tileNumber>=1&&tileNumber<=30&&game.getSide(tileNumberToSide(tileNumber)).getHalf().getUnitAt(tileNumberToRow(tileNumber), tileNumberToColumn(tileNumber))==null)
										{
											((TileRequirement)requirement).setTile(tileNumberToSide(tileNumber), tileNumberToRow(tileNumber), tileNumberToColumn(tileNumber));
											break;
										}
									}
									catch(NumberFormatException exception){	}
								}
							}
							else if(requirement.getType()==RequirementType.OWN_EMPTY_TILE)
							{
								System.out.print(game.getCurrentPlayer()==Player.PLAYER1?"(1-15)> ":"(16-30)> ");
								while(true)
								{
									try
									{
										int tileNumber = Integer.parseInt(input.nextLine());
										if(tileNumber>=1&&tileNumber<=30&&game.getCurrentPlayer()==tileNumberToSide(tileNumber)&&game.getSide(tileNumberToSide(tileNumber)).getHalf().getUnitAt(tileNumberToRow(tileNumber), tileNumberToColumn(tileNumber))==null)
										{
											((TileRequirement)requirement).setTile(tileNumberToSide(tileNumber), tileNumberToRow(tileNumber), tileNumberToColumn(tileNumber));
											break;
										}
									}
									catch(NumberFormatException exception){	}
								}
							}
							else if(requirement.getType()==RequirementType.OPPONENT_EMPTY_TILE)
							{
								System.out.print(game.getCurrentPlayer()==Player.PLAYER1?"(16-30)> ":"(1-15)> ");
								while(true)
								{
									try
									{
										int tileNumber = Integer.parseInt(input.nextLine());
										if(tileNumber>=1&&tileNumber<=30&&game.getCurrentPlayer().otherPlayer()==tileNumberToSide(tileNumber)&&game.getSide(tileNumberToSide(tileNumber)).getHalf().getUnitAt(tileNumberToRow(tileNumber), tileNumberToColumn(tileNumber))==null)
										{
											((TileRequirement)requirement).setTile(tileNumberToSide(tileNumber), tileNumberToRow(tileNumber), tileNumberToColumn(tileNumber));
											break;
										}
									}
									catch(NumberFormatException exception){	}
								}
							}
							else if(requirement.getType()==RequirementType.UNIT)
							{
								System.out.print("(1-30)> ");
								while(true)
								{
									try
									{
										int tileNumber = Integer.parseInt(input.nextLine());
										if(tileNumber>=1&&tileNumber<=30&&game.getSide(tileNumberToSide(tileNumber)).getHalf().getUnitAt(tileNumberToRow(tileNumber), tileNumberToColumn(tileNumber))!=null)
										{
											((UnitRequirement)requirement).setUnit(game.getSide(tileNumberToSide(tileNumber)).getHalf().getUnitAt(tileNumberToRow(tileNumber), tileNumberToColumn(tileNumber)));
											break;
										}
									}
									catch(NumberFormatException exception){	}
								}
							}
							else if(requirement.getType()==RequirementType.OWN_UNIT)
							{
								System.out.print(game.getCurrentPlayer()==Player.PLAYER1?"(1-15)> ":"(16-30)> ");
								while(true)
								{
									try
									{
										int tileNumber = Integer.parseInt(input.nextLine());
										if(tileNumber>=1&&tileNumber<=30&&game.getCurrentPlayer()==tileNumberToSide(tileNumber)&&game.getSide(tileNumberToSide(tileNumber)).getHalf().getUnitAt(tileNumberToRow(tileNumber), tileNumberToColumn(tileNumber))==null)
										{
											((UnitRequirement)requirement).setUnit(game.getSide(tileNumberToSide(tileNumber)).getHalf().getUnitAt(tileNumberToRow(tileNumber), tileNumberToColumn(tileNumber)));
											break;
										}
									}
									catch(NumberFormatException exception){	}
								}
							}
							else if(requirement.getType()==RequirementType.OPPONENT_UNIT)
							{
								System.out.print(game.getCurrentPlayer()==Player.PLAYER1?"(16-30)> ":"(1-15)> ");
								while(true)
								{
									try
									{
										int tileNumber = Integer.parseInt(input.nextLine());
										if(tileNumber>=1&&tileNumber<=30&&game.getCurrentPlayer().otherPlayer()==tileNumberToSide(tileNumber)&&game.getSide(tileNumberToSide(tileNumber)).getHalf().getUnitAt(tileNumberToRow(tileNumber), tileNumberToColumn(tileNumber))==null)
										{
											((UnitRequirement)requirement).setUnit(game.getSide(tileNumberToSide(tileNumber)).getHalf().getUnitAt(tileNumberToRow(tileNumber), tileNumberToColumn(tileNumber)));
											break;
										}
									}
									catch(NumberFormatException exception){	}
								}
							}
						}
						game.playCard(game.getCurrentPlayer(), card);
						break;
					}
				}
			}
		}
		input.close();
	}
}
