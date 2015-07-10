package com.alvarpq.GOTF.coreGame;
import java.util.Arrays;
import java.util.Scanner;
import com.alvarpq.GOTF.cards.Card;
import com.alvarpq.GOTF.cards.Deck;
import com.alvarpq.GOTF.cards.ExampleUnitCard;
import com.alvarpq.GOTF.cards.real.DarkYounglingCard;
import com.alvarpq.GOTF.cards.real.PenanceOfTheGods;
import com.alvarpq.GOTF.cards.real.TunnelGuardCard;
import com.alvarpq.GOTF.cards.ExampleSpellCard;
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
	public static String costString(Card card)
	{
		String toReturn = card.getThresholdCost()+"Threshold";
		int air = 0;
		int earth = 0;
		int fire = 0;
		int water = 0;
		for(Resource resource:card.getResourceCost())
		{
			switch(resource)
			{
				case AIR: air++; break;
				case EARTH: earth++; break;
				case FIRE: fire++; break;
				case WATER: water++; break;
			}
		}
		if(air>0)
		{
			toReturn+=" "+air+"Air";
		}
		if(earth>0)
		{
			toReturn+=" "+earth+"Earth";
		}
		if(fire>0)
		{
			toReturn+=" "+fire+"Fire";
		}
		if(water>0)
		{
			toReturn+=" "+water+"Water";
		}
		return toReturn;
	}
	public static String resourcesString(Side side)
	{
		String toReturn = side.getThreshold()+"/"+side.getMaximumThreshold()+"Threshold";
		int air = 0;
		int earth = 0;
		int fire = 0;
		int water = 0;
		int maximumAir = 0;
		int maximumEarth = 0;
		int maximumFire = 0;
		int maximumWater = 0;
		for(Resource resource:side.getResources())
		{
			switch(resource)
			{
				case AIR: air++; break;
				case EARTH: earth++; break;
				case FIRE: fire++; break;
				case WATER: water++; break;
			}
		}
		for(Resource resource:side.getMaximumResources())
		{
			switch(resource)
			{
				case AIR: maximumAir++; break;
				case EARTH: maximumEarth++; break;
				case FIRE: maximumFire++; break;
				case WATER: maximumWater++; break;
			}
		}
		if(air>0||maximumAir>0)
		{
			toReturn+=" "+air+"/"+maximumAir+"Air";
		}
		if(earth>0||maximumEarth>0)
		{
			toReturn+=" "+earth+"/"+maximumEarth+"Earth";
		}
		if(fire>0||maximumFire>0)
		{
			toReturn+=" "+fire+"/"+maximumFire+"Fire";
		}
		if(water>0||maximumWater>0)
		{
			toReturn+=" "+water+"/"+maximumWater+"Water";
		}
		return toReturn;
	}
	public static void main(String[] args)
	{	
		Scanner input = new Scanner(System.in);
		Deck deck1 = new Deck(Arrays.asList(new Card[]{new DarkYounglingCard(), new DarkYounglingCard(), new TunnelGuardCard()
		, new TunnelGuardCard(), new UselessContraptionCard(), new PenanceOfTheGods()}), true);
		Deck deck2 = new Deck(Arrays.asList(new Card[]{new DarkYounglingCard(), new DarkYounglingCard(), new TunnelGuardCard()
		, new TunnelGuardCard(), new ExampleSpellCard(), new PenanceOfTheGods()}), true);
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
			System.out.print("Hand: "+game.getSide(game.getCurrentPlayer()).getDeck().getHand().get(0).getName().substring(0, 3)+"("+costString(game.getSide(game.getCurrentPlayer()).getDeck().getHand().get(0))+") ");
			for(int i=1;i<game.getSide(game.getCurrentPlayer()).getDeck().getHand().size();i++)
			{
				System.out.print(game.getSide(game.getCurrentPlayer()).getDeck().getHand().get(i).getName().substring(0, 3)+"("+costString(game.getSide(game.getCurrentPlayer()).getDeck().getHand().get(i))+") ");
			}
			System.out.println();
			System.out.println("Resources: "+resourcesString(game.getSide(game.getCurrentPlayer())));
			System.out.print("> ");
			String[] command = input.nextLine().split(" ");
			if(command[0].equalsIgnoreCase("end"))
			{
				game.endTurn();
				game.startTurn();
			}
			else if(command[0].equalsIgnoreCase("sacrifice"))
			{
				for(int i=0;i<game.getSide(game.getCurrentPlayer()).getDeck().getHand().size();i++)
				{
					if(command[1].equalsIgnoreCase(game.getSide(game.getCurrentPlayer()).getDeck().getHand().get(i).getName().substring(0, 3)))
					{
						boolean didSacrifice = false;
						if(command[2].equalsIgnoreCase("cards"))
						{
							didSacrifice = game.getSide(game.getCurrentPlayer()).sacrificeForCards(i);
						}
						else if(command[2].equalsIgnoreCase("air"))
						{
							didSacrifice = game.getSide(game.getCurrentPlayer()).sacrificeForResources(i, Resource.AIR);
						}
						else if(command[2].equalsIgnoreCase("earth"))
						{
							didSacrifice = game.getSide(game.getCurrentPlayer()).sacrificeForResources(i, Resource.EARTH);
						}
						else if(command[2].equalsIgnoreCase("fire"))
						{
							didSacrifice = game.getSide(game.getCurrentPlayer()).sacrificeForResources(i, Resource.FIRE);
						}
						else if(command[2].equalsIgnoreCase("water"))
						{
							didSacrifice = game.getSide(game.getCurrentPlayer()).sacrificeForResources(i, Resource.WATER);
						}
						if(!didSacrifice)
						{
							System.out.println("You have already sacrificed!");
						}
						break;
					}
				}
			}
			else if(command[0].equalsIgnoreCase("move"))
			{
				try
				{
					int tileNumber1 = Integer.parseInt(command[1]);
					int tileNumber2 = Integer.parseInt(command[2]);
					if(tileNumber1>=1&&tileNumber1<=30&&tileNumber2>=1&&tileNumber2<=30&&game.getCurrentPlayer()==tileNumberToSide(tileNumber1)&&game.getCurrentPlayer()==tileNumberToSide(tileNumber2))
					{
						game.getSide(tileNumberToSide(tileNumber1)).getHalf().move(tileNumberToRow(tileNumber1), tileNumberToColumn(tileNumber1), tileNumberToRow(tileNumber2), tileNumberToColumn(tileNumber2));
					}
				}
				catch(NumberFormatException exception){}
			}
			else if(command[0].equalsIgnoreCase("play"))
			{
				for(Card card:game.getSide(game.getCurrentPlayer()).getDeck().getHand())
				{
					if(command[1].equalsIgnoreCase(card.getName().substring(0, 3)))
					{
						if(game.getSide(game.getCurrentPlayer()).hasResources(card))
						{
							for(Requirement requirement:card.getRequirements())
							{
								if(requirement.getType()==RequirementType.TILE)
								{
									while(true)
									{
										try
										{
											System.out.print("(1-30)> ");
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
									while(true)
									{
										try
										{
											System.out.print(game.getCurrentPlayer()==Player.PLAYER1?"(1-15)> ":"(16-30)> ");
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
									while(true)
									{
										try
										{
											System.out.print(game.getCurrentPlayer()==Player.PLAYER1?"(16-30)> ":"(1-15)> ");
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
									while(true)
									{
										try
										{
											System.out.print(game.getCurrentPlayer()==Player.PLAYER1?"(1-15)> ":"(16-30)> ");
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
									while(true)
									{
										try
										{
											System.out.print(game.getCurrentPlayer()==Player.PLAYER1?"(16-30)> ":"(1-15)> ");
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
									while(true)
									{
										try
										{
											System.out.print("(1-30)> ");
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
									while(true)
									{
										try
										{
											System.out.print(game.getCurrentPlayer()==Player.PLAYER1?"(1-15)> ":"(16-30)> ");
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
									while(true)
									{
										try
										{
											System.out.print(game.getCurrentPlayer()==Player.PLAYER1?"(16-30)> ":"(1-15)> ");
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
						else
						{
							System.out.println("You don't have enough resources!");
							break;
						}
					}
				}
			}
		}
		input.close();
	}
}
