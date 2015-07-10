package com.alvarpq.GOTF.coreGame;
import java.util.Arrays;
import java.util.Scanner;
import com.alvarpq.GOTF.coreGame.cards.Card;
import com.alvarpq.GOTF.coreGame.cards.Deck;
import com.alvarpq.GOTF.coreGame.cards.real.PenanceOfTheGods;
import com.alvarpq.GOTF.requirement.TileRequirement;
import com.alvarpq.GOTF.requirement.Requirement;
import com.alvarpq.GOTF.requirement.RequirementType;
import com.alvarpq.GOTF.requirement.RowRequirement;
import com.alvarpq.GOTF.requirement.UnitRequirement;

//I am alvaro. I have come to comment your code and press space and enter a lot.

public class ConsoleGOTF
{
	private static Scanner input;
	/*
	 * Returns the Row number a tile is on. Takes a tile number.
	 */
	public static int tileNumberToRow(int tileNumber)
	{
		if(tileNumber > 15)
		{
			tileNumber -= 15;
		}
		return (tileNumber - 1) / 3;
	}
	
	//Returns a column number based off of a tile number
	public static int tileNumberToColumn(int tileNumber)
	{
		if(tileNumber > 15)
		{
			tileNumber -= 15;
		}
		return (tileNumber - 1) % 3;
	}
	
	
	//Returns the player that controls a tile, based on its number.
	public static Player tileNumberToSide(int tileNumber)
	{
		if(tileNumber<=15)
		{
			return Player.PLAYER1;
		}
		return Player.PLAYER2;
	}
	
	
	//Returns the proper tile number based on the controlling player, row and column.
	public static int toTileNumber(Player side, int row, int column)
	{
		if(side == Player.NONE)
		{
			return -1;
		}
		else if(side == Player.PLAYER1)
		{
			return row * 3 + column + 1;
		}
		else
		{
			return 15 + row * 3 + column + 1;
		}
	}
	
	
	//returns total cost of a unit, in string form
	public static String costString(Card card)
	{
		String toReturn = card.getThresholdCost() + "Threshold";
		int air = 0;
		int earth = 0;
		int fire = 0;
		int water = 0;
		for(Resource resource:card.getResourceCost())
		{
			switch(resource)
			{
				case AIR:	air++; 
							break;
				case EARTH:	earth++;
							break;
				case FIRE: 	fire++; 
							break;
				case WATER: water++;
							break;
			}
		}
		if(air > 0)
		{
			toReturn += " " + air + "Air";
		}
		if(earth > 0)
		{
			toReturn += " " + earth + "Earth";
		}
		if(fire > 0)
		{
			toReturn += " " + fire + "Fire";
		}
		if(water > 0)
		{
			toReturn += " " + water + "Water";
		}
		return toReturn;
	}
	
	//returns your current resources and total resources, in string form.
	public static String resourcesString(Side side)
	{
		String toReturn = side.getThreshold() + "/" + side.getMaximumThreshold() + "Threshold";
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
			
			//have you considered making this switch statement a private method?
			switch(resource)
			{
				case AIR:	air++; 
							break;
				case EARTH: earth++; 
							break;
				case FIRE:	fire++;
							break;
				case WATER: water++;
							break;
			}
		}
		
		for(Resource resource:side.getMaximumResources())
		{
			switch(resource)
			{
				case AIR:	maximumAir++;
							break;
				case EARTH:	maximumEarth++; 
							break;
				case FIRE:	maximumFire++;
							break;
				case WATER:	maximumWater++;
							break;
			}
		}
		if(air > 0 || maximumAir > 0)
		{
			toReturn += " " + air + "/" + maximumAir + "Air";
		}
		if(earth > 0 || maximumEarth > 0)
		{
			toReturn += " " + earth + "/" + maximumEarth + "Earth";
		}
		if(fire > 0 || maximumFire > 0)
		{
			toReturn += " " + fire + "/" + maximumFire + "Fire";
		}
		if(water > 0 || maximumWater > 0)
		{
			toReturn += " " + water + "/" + maximumWater + "Water";
		}
		return toReturn;
	}
	
	
	//Runs the damn thing. Lots of spaghetti code here, I'm not even gonna try.
	public static void main(String[] args)
	{	
		input = new Scanner(System.in);
		Deck deck1 = new Deck(Arrays.asList(new Card[]{new PenanceOfTheGods(), new PenanceOfTheGods()}), true);
		Deck deck2 = new Deck(Arrays.asList(new Card[]{new PenanceOfTheGods(), new PenanceOfTheGods()}), true);
		Game game = new Game(deck1, deck2);
		game.start(2);
		while(true)
		{
			System.out.println(game.getCurrentPlayer()+"'s turn");
			for(int i=0;i<5;i++)
			{
				StringBuilder side1 = new StringBuilder();
				if(game.getSide(Player.PLAYER1).getHalf().getIdolAt(i)<10)
				{
					side1.append("0"+game.getSide(Player.PLAYER1).getHalf().getIdolAt(i)+"  ");
				}
				else
				{
					side1.append(game.getSide(Player.PLAYER1).getHalf().getIdolAt(i)+"  ");
				}
				StringBuilder side2 = new StringBuilder();
				if(i%2==0)
				{
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
				}
				else
				{
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
				}
				if(game.getSide(Player.PLAYER2).getHalf().getIdolAt(i)<10)
				{
					side2.append("  0"+game.getSide(Player.PLAYER2).getHalf().getIdolAt(i));
				}
				else
				{
					side2.append("  "+game.getSide(Player.PLAYER2).getHalf().getIdolAt(i));
				}
				System.out.println(side1+" "+side2);
			}
			if(!game.getSide(game.getCurrentPlayer()).getDeck().getHand().isEmpty())
			{
				System.out.print("Hand: "+game.getSide(game.getCurrentPlayer()).getDeck().getHand().get(0).getName()+"("+costString(game.getSide(game.getCurrentPlayer()).getDeck().getHand().get(0))+") ");
				for(int i=1;i<game.getSide(game.getCurrentPlayer()).getDeck().getHand().size();i++)
				{
					System.out.print(game.getSide(game.getCurrentPlayer()).getDeck().getHand().get(i).getName()+"("+costString(game.getSide(game.getCurrentPlayer()).getDeck().getHand().get(i))+") ");
				}
			}
			else
			{
				System.out.print("Hand: ");
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
											if(tileNumber>=1&&tileNumber<=30&&
											game.getSide(tileNumberToSide(tileNumber)).getHalf().getUnitAt(tileNumberToRow(tileNumber), tileNumberToColumn(tileNumber))!=null
											&&game.getSide(tileNumberToSide(tileNumber)).getHalf().getUnitAt(tileNumberToRow(tileNumber), tileNumberToColumn(tileNumber)).getTargetable())
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
											if(tileNumber>=1&&tileNumber<=30&&
											game.getCurrentPlayer()==tileNumberToSide(tileNumber)&&
											game.getSide(tileNumberToSide(tileNumber)).getHalf().getUnitAt(tileNumberToRow(tileNumber), tileNumberToColumn(tileNumber))==null&&
											game.getSide(tileNumberToSide(tileNumber)).getHalf().getUnitAt(tileNumberToRow(tileNumber), tileNumberToColumn(tileNumber)).getTargetable())
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
											if(tileNumber>=1&&tileNumber<=30&&
											game.getCurrentPlayer().otherPlayer()==tileNumberToSide(tileNumber)&&
											game.getSide(tileNumberToSide(tileNumber)).getHalf().getUnitAt(tileNumberToRow(tileNumber), tileNumberToColumn(tileNumber))==null&&
											game.getSide(tileNumberToSide(tileNumber)).getHalf().getUnitAt(tileNumberToRow(tileNumber), tileNumberToColumn(tileNumber)).getTargetable())
											{
												((UnitRequirement)requirement).setUnit(game.getSide(tileNumberToSide(tileNumber)).getHalf().getUnitAt(tileNumberToRow(tileNumber), tileNumberToColumn(tileNumber)));
												break;
											}
										}
										catch(NumberFormatException exception){	}
									}
								}
								else if(requirement.getType()==RequirementType.ROW)
								{
									while(true)
									{
										try
										{
											System.out.print("(1-5)> ");
											int row = Integer.parseInt(input.nextLine());
											if(row>=1&&row<=5)
											{
												((RowRequirement)requirement).setRow(row-1);
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
	}
}
