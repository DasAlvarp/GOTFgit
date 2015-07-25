package com.alvarpq.GOTF.gui;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Game;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.cards.Card;
import com.alvarpq.GOTF.coreGame.cards.Deck;
import com.alvarpq.GOTF.coreGame.units.Unit;
import com.alvarpq.GOTF.requirement.TileRequirement;
import com.alvarpq.GOTF.server.User;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
public class GameStage extends Stage
{
	//class for representing the position of a tile on the board (game position, not graphical position)
	class Position
	{
		public Player side;
		public int row;
		public int column;
		public Position(Player side, int row, int column)
		{
			this.side = side;
			this.row = row;
			this.column = column;
		}
		@Override
		public boolean equals(Object o)
		{
			if(o==null)
			{
				return false;
			}
			if(o instanceof Position)
			{
				Position temp = (Position)o;
				if(temp.side==side&&temp.row==row&&temp.column==column)
				{
					return true;
				}
				return false;
			}
			return false;
		}
	}
	//a tile's length
	private static final float LENGTH = 120;
	//a tile's height
	private static final float HEIGHT = 104;
	//a card's length
	private static final float CARD_LENGTH = 200;
	//a card's height
	private static final float CARD_HEIGHT = 300;
	//a idol's length
	private static final float IDOL_LENGTH = 80;
	//a idol's height
	private static final float IDOL_HEIGHT = 80;
	//the game this GameStage displays
	private Game game;
	//holds the font for drawing text
	private BitmapFont font;
	//the texture for the unselected tile
	private Texture defaultTile;
	//the animation for a highlighted tile
	private Animation highlightedTile;
	//the texture for a card
	private Texture card;
	//the texture for resource indicators
	private Texture resources;
	//the texture for idols
	private Texture idol;
	//Button spriteDrawables
	SpriteDrawable buttonUp;
	SpriteDrawable buttonDown;
	SpriteDrawable buttonUpSmall;
	SpriteDrawable buttonDownSmall;
	//all the tiles (graphical class for displaying tiles and corresponding units)
	private Tile[][] half1;
	private Tile[][] half2;
	//the graphical hands
	private Hand hand1;
	private Hand hand2;
	//the graphical resource indicators
	private Resources resources1;
	private Resources resources2;
	//the graphical idols
	private Idol[] idols1;
	private Idol[] idols2;
	//the end turn button
	private TextButton endTurn;
	//the sacrifice for cards button
	private TextButton sacCards;
	//the sacrifice for resources buttons
	private TextButton sacAir;
	private TextButton sacEarth;
	private TextButton sacFire;
	private TextButton sacWater;
	//the currently highlighted positions
	private List<Position> highlightedPositions;
	//the currently selected unit
	private Unit selectedUnit;
	//the currently selected card
	private Card selectedCard;
	public GameStage() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException
	{
		//sets the size of the stage to fill the whole window
		super(new FitViewport(1600, 900));
		//creates a new game and starts it with 5 in hand size
		game = new Game(new User(null, null, new Deck(110104, Player.PLAYER1, true)), new User(null, null, new Deck(110103, Player.PLAYER2, true)));
		game.start(5);
		//instantiates font
		font = new BitmapFont();
		font.setColor(Color.BLACK);
		//adds the background
		addActor(new GameBackground());
		//instantiates the unselected tile
		defaultTile = new Texture("BoardTile.png");
		//instantiates the highlighted tile animation
		highlightedTile = new Animation(0.125f, new TextureRegion(new Texture("gui/selectedTiles/selectedTile(0).png")),
    	new TextureRegion(new Texture("gui/selectedTiles/selectedTile(1).png")), new TextureRegion(new Texture("gui/selectedTiles/selectedTile(2).png")),
    	new TextureRegion(new Texture("gui/selectedTiles/selectedTile(3).png")), new TextureRegion(new Texture("gui/selectedTiles/selectedTile(4).png")),
    	new TextureRegion(new Texture("gui/selectedTiles/selectedTile(5).png")), new TextureRegion(new Texture("gui/selectedTiles/selectedTile(6).png")));
		highlightedTile.setPlayMode(PlayMode.LOOP_REVERSED);
    	//instantiates the card texture
    	card = new Texture("card.png");
    	//instantiates the resource indixator texture
    	resources = new Texture("resource.png");
    	//instantiates the idol texture
    	idol = new Texture("idol.png");
    	//instantiates button SpriteDrawables
    	buttonUp = new SpriteDrawable(new Sprite(new Texture("buttonUp.png")));
    	buttonDown = new SpriteDrawable(new Sprite(new Texture("buttonDown.png")));
    	buttonUpSmall = new SpriteDrawable(new Sprite(new Texture("buttonUpSmall.png")));
    	buttonDownSmall = new SpriteDrawable(new Sprite(new Texture("buttonDownSmall.png")));
    	//instantiates tile arrays
		setupTiles();
		//instantiates hands
		hand1 = new Hand(game.getSide(Player.PLAYER1).getDeck().getHand(), card, 0, 0, CARD_LENGTH, CARD_HEIGHT);
		hand2 = new Hand(game.getSide(Player.PLAYER2).getDeck().getHand(), card, 0, 0, CARD_LENGTH, CARD_HEIGHT);
		updateHands();
		//instantiates resource indicators
		Sprite temp = new Sprite(resources);
		temp.setBounds(getWidth()-100, 0, 100, 275);
		resources1 = new Resources(game.getSide(Player.PLAYER1), temp);
		addActor(resources1);
		temp = new Sprite(resources);
		temp.setBounds(getWidth()-100, getHeight()-275, 100, 275);
		resources2 = new Resources(game.getSide(Player.PLAYER2), temp);
		addActor(resources2);
		//instantiates buttons
		setupButtons();
		//instantiates the list of selected positions
		highlightedPositions = new LinkedList<Position>();
		//instantiates selected things
		selectedUnit = null;
		selectedCard = null;
	}
	@Override
	public boolean mouseMoved(int x, int y)
	{
		super.mouseMoved(x, y);
		if(selectedUnit==null)
		{
			//current mousemoved code to make sure the tile the mouse is over is highlighted, loops go through all tiles
			for(int i=0;i<5;i++)
	    	{
	    		for(int j=0;j<3;j++)
	    		{
	    			//is the mouse over player 1's tile at i, j, if true then highlight that tile
	    			if(half1[i][j].hasInsideBounds(x, getHeight()-y))
	    			{
	    				if(!highlightedPositions.contains(new Position(Player.PLAYER1, i, j)))
	    				{
	    					dehighlightAll();
	    				}
	    				highlightPosition(new Position(Player.PLAYER1, i, j));
	    				return false;
	    			}
	    			//same for player2
	    			if(half2[i][j].hasInsideBounds(x, getHeight()-y))
	    			{
	    				if(!highlightedPositions.contains(new Position(Player.PLAYER2, i, j)))
	    				{
	    					dehighlightAll();
	    				}
	    				highlightPosition(new Position(Player.PLAYER2, i, j));
	    				return false;
	    			}
	    		}
	    	}
			//in case the mouse is over no tile, deselect all tiles
			dehighlightAll();
		}
		return false;
	}
	@Override
	public boolean touchDown(int x, int y, int pointer, int button)
	{
		super.touchDown(x, y, pointer, button);
		if(game.getCurrentPlayer()==Player.PLAYER1)
		{
			Card clickedCard = hand1.cardClicked(x, (int)(getHeight()-y));
			if(clickedCard==selectedCard)
			{
				selectedCard = null;
				hand1.highlightIndex(-1);
			}
			else if(clickedCard!=null)
			{
				selectedCard = clickedCard;
				hand1.highlight(selectedCard);
			}
		}
		else if(game.getCurrentPlayer()==Player.PLAYER2)
		{
			Card clickedCard = hand2.cardClicked(x, (int)(getHeight()-y));
			if(clickedCard==selectedCard)
			{
				selectedCard = null;
				hand2.highlightIndex(-1);
			}
			else if(clickedCard!=null)
			{
				selectedCard = clickedCard;
				hand2.highlight(selectedCard);
			}
		}
		//current touch down funtion to select units and make them move
		for(int i=0;i<5;i++)
    	{
    		for(int j=0;j<3;j++)
    		{
    			//is the mouse over player 1's tile at i, j
    			if(half1[i][j].hasInsideBounds(x, getHeight()-y))
    			{
    				tileClicked(new Position(Player.PLAYER1, i, j));
    				break;
    			}
    			//same for player2
    			if(half2[i][j].hasInsideBounds(x, getHeight()-y))
    			{
    				tileClicked(new Position(Player.PLAYER2, i, j));
    				break;
    			}
    		}
    	}
		return false;
	}
	//what happens when a tile is clicked
	public void tileClicked(Position p)
	{
		//checks whether a playable card is selected or not, if not a unit can be moved
		if(selectedCard==null||!game.getSide(selectedCard.getOwner()).canPayFor(selectedCard))
		{
			//is there a unit at position
			if(game.getSide(p.side).getHalf().getUnitAt(p.row, p.column)!=null&&game.getSide(p.side).getHalf().getUnitAt(p.row, p.column).getOwner()==game.getCurrentPlayer())
			{
				//is that unit selected or not, if not select it, otherwise deselect it
				if(selectedUnit==game.getSide(p.side).getHalf().getUnitAt(p.row, p.column))
				{
					deselectUnit();
				}
				else
				{
					selectUnit(game.getSide(p.side).getHalf().getUnitAt(p.row, p.column));
				}
			}
			//can the selected unit move there
			else if(selectedUnit!=null&&game.getSide(p.side).getHalf().canMove(selectedUnit, p.row, p.column))
			{
				game.getSide(p.side).getHalf().move(selectedUnit, p.row, p.column);
				if(p.side==Player.PLAYER1)
				{
					//updates all tiles
					updateTiles();
					deselectUnit();
				}
				else if(p.side==Player.PLAYER2)
				{
					//updates all tiles
					updateTiles();
					deselectUnit();
				}
			}
		}
		else
		{
			//switch case sends the clicked tile (or unit or row) to the currently selected card if applicable
			switch(selectedCard.nextRequirement().getType())
			{
				case EMPTY_TILE:
					if(game.getSide(p.side).getHalf().getUnitAt(p.row, p.column)==null)
					{
						((TileRequirement)(selectedCard.nextRequirement())).setTile(p.side, p.row, p.column);
						if(selectedCard.isReady())
						{
							game.playCard(selectedCard.getOwner(), selectedCard);
							updateTiles();
							selectedCard = null;
						}
					}
					break;
				case OPPONENT_EMPTY_TILE:
					break;
				case OPPONENT_TILE:
					break;
				case OPPONENT_UNIT:
					break;
				case OWN_EMPTY_TILE:
					if(selectedCard.getOwner()==p.side&&game.getSide(p.side).getHalf().getUnitAt(p.row, p.column)==null)
					{
						((TileRequirement)(selectedCard.nextRequirement())).setTile(p.side, p.row, p.column);
						if(selectedCard.isReady())
						{
							game.playCard(selectedCard.getOwner(), selectedCard);
							updateTiles();
							selectedCard = null;
						}
					}
					break;
				case OWN_TILE:
					break;
				case OWN_UNIT:
					break;
				case ROW:
					break;
				case TILE:
					break;
				case UNIT:
					break;
			}
		}
	}
	//selects a unit
	public void selectUnit(Unit unit)
	{
		boolean canMove = false;
		//loops highlight all movable tiles
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(game.getSide(unit.getOwner()).getHalf().canMove(unit, i, j))
				{
					highlightPosition(new Position(unit.getOwner(), i, j));
					canMove = true;
				}
			}
		}
		//selects based on if the unit can move
		if(canMove)
		{
			selectedUnit = unit;
			dehighlightPosition(new Position(unit.getOwner(), unit.getRow(), unit.getColumn()));
		}
	}
	//deselects a unit
	public void deselectUnit()
	{
		if(selectedUnit!=null)
		{
			dehighlightAll();
			highlightPosition(new Position(selectedUnit.getOwner(), selectedUnit.getRow(), selectedUnit.getColumn()));
			selectedUnit = null;
		}
	}
	//highlights a position and adds it to the highlightedpositions
	public void highlightPosition(Position p)
	{
		if(p.side==Player.PLAYER1)
		{
			half1[p.row][p.column].highlight();
			highlightedPositions.add(p);
		}
		else if(p.side==Player.PLAYER2)
		{
			half2[p.row][p.column].highlight();
			highlightedPositions.add(p);
		}
	}
	//dehighlights all positions, removing them from highlightedPositions
	public void dehighlightAll()
	{
		for(int i=0;i<highlightedPositions.size();i++)
		{
			if(highlightedPositions.get(i).side==Player.PLAYER1)
			{
				half1[highlightedPositions.get(i).row][highlightedPositions.get(i).column].dehighlight();
				highlightedPositions.remove(highlightedPositions.get(i));
				i--;
			}
			else if(highlightedPositions.get(i).side==Player.PLAYER2)
			{
				half2[highlightedPositions.get(i).row][highlightedPositions.get(i).column].dehighlight();
				highlightedPositions.remove(highlightedPositions.get(i));
				i--;
			}
		}
		highlightedPositions.clear();
	}
	//dehighlights a position and removes it from the highlighted positions
	public void dehighlightPosition(Position p)
	{
		if(p.side==Player.PLAYER1)
		{
			half1[p.row][p.column].dehighlight();
			highlightedPositions.remove(p);
		}
		else if(p.side==Player.PLAYER2)
		{
			half2[p.row][p.column].dehighlight();
			highlightedPositions.remove(p);
		}
	}
	//adds the right player's hand
	public void updateHands()
	{
		hand1.remove();
		hand2.remove();
		if(game.getCurrentPlayer()==Player.PLAYER1)
		{
			addActor(hand1);
		}
		else if(game.getCurrentPlayer()==Player.PLAYER2)
		{
			addActor(hand2);
		}
	}
	//updates idols and tiles, call when something has changed (like ending turn, card played, or unit moved)
	public void updateTiles()
	{
		//these loops go through all board positions, outer loop go through idols
		for(int i=0;i<5;i++)
    	{
			idols1[i].setHealth(game.getSide(Player.PLAYER1).getHalf().getIdolAt(i));
			idols2[i].setHealth(game.getSide(Player.PLAYER2).getHalf().getIdolAt(i));
    		for(int j=0;j<3;j++)
    		{
    			half1[i][j].setUnit(game.getSide(Player.PLAYER1).getHalf().getUnitAt(i, j));
    			half2[i][j].setUnit(game.getSide(Player.PLAYER2).getHalf().getUnitAt(i, j));
    		}
    	}
	}
	//sets up the buttons
	public void setupButtons()
	{
		endTurn = new TextButton("End Turn", new TextButton.TextButtonStyle(buttonUp, buttonDown, buttonDown, font));
		endTurn.setBounds(0, getHeight()-50, 100, 50);
		endTurn.setDisabled(true);
		endTurn.addListener(new ClickListener(){
	        @Override
	        public void clicked(InputEvent event, float x, float y)
	        {
	        	game.endTurn();
	        	game.startTurn();
	        	deselectUnit();
	        	selectedCard = null;
	        	//updates things
	        	updateHands();
	        	updateTiles();
	        }
	    });
		addActor(endTurn);
		sacCards = new TextButton("Cards", new TextButton.TextButtonStyle(buttonUp, buttonDown, buttonDown, font));
		sacCards.setBounds(0, getHeight()-100, 100, 50);
		sacCards.setDisabled(true);
		sacCards.addListener(new ClickListener(){
	        @Override
	        public void clicked(InputEvent event, float x, float y)
	        {
	        	if(selectedCard!=null)
	        	{
	        		game.getSide(selectedCard.getOwner()).sacrificeForCards(selectedCard);
	        		if(selectedCard.getOwner()==Player.PLAYER1)
	        		{
	        			hand1.highlightIndex(-1);
	        		}
	        		else if(selectedCard.getOwner()==Player.PLAYER2)
	        		{
	        			hand2.highlightIndex(-1);
	        		}
	        		selectedCard = null;
	        	}
	        }
	    });
		addActor(sacCards);
		sacAir = new TextButton("A", new TextButton.TextButtonStyle(buttonUpSmall, buttonDownSmall, buttonDownSmall, font));
		sacAir.setBounds(0, getHeight()-150, 50, 50);
		sacAir.setDisabled(true);
		sacAir.addListener(new ClickListener(){
	        @Override
	        public void clicked(InputEvent event, float x, float y)
	        {
	        	if(selectedCard!=null)
	        	{
	        		game.getSide(selectedCard.getOwner()).sacrificeForElements(selectedCard, Element.AIR);
	        		if(selectedCard.getOwner()==Player.PLAYER1)
	        		{
	        			hand1.highlightIndex(-1);
	        		}
	        		else if(selectedCard.getOwner()==Player.PLAYER2)
	        		{
	        			hand2.highlightIndex(-1);
	        		}
	        		selectedCard = null;
	        	}
	        }
	    });
		addActor(sacAir);
		sacEarth = new TextButton("E", new TextButton.TextButtonStyle(buttonUpSmall, buttonDownSmall, buttonDownSmall, font));
		sacEarth.setBounds(50, getHeight()-150, 50, 50);
		sacEarth.setDisabled(true);
		sacEarth.addListener(new ClickListener(){
	        @Override
	        public void clicked(InputEvent event, float x, float y)
	        {
	        	if(selectedCard!=null)
	        	{
	        		game.getSide(selectedCard.getOwner()).sacrificeForElements(selectedCard, Element.EARTH);
	        		if(selectedCard.getOwner()==Player.PLAYER1)
	        		{
	        			hand1.highlightIndex(-1);
	        		}
	        		else if(selectedCard.getOwner()==Player.PLAYER2)
	        		{
	        			hand2.highlightIndex(-1);
	        		}
	        		selectedCard = null;
	        	}
	        }
	    });
		addActor(sacEarth);
		sacFire = new TextButton("F", new TextButton.TextButtonStyle(buttonUpSmall, buttonDownSmall, buttonDownSmall, font));
		sacFire.setBounds(0, getHeight()-200, 50, 50);
		sacFire.setDisabled(true);
		sacFire.addListener(new ClickListener(){
	        @Override
	        public void clicked(InputEvent event, float x, float y)
	        {
	        	if(selectedCard!=null)
	        	{
	        		game.getSide(selectedCard.getOwner()).sacrificeForElements(selectedCard, Element.FIRE);
	        		if(selectedCard.getOwner()==Player.PLAYER1)
	        		{
	        			hand1.highlightIndex(-1);
	        		}
	        		else if(selectedCard.getOwner()==Player.PLAYER2)
	        		{
	        			hand2.highlightIndex(-1);
	        		}
	        		selectedCard = null;
	        	}
	        }
	    });
		addActor(sacFire);
		sacWater = new TextButton("W", new TextButton.TextButtonStyle(buttonUpSmall, buttonDownSmall, buttonDownSmall, font));
		sacWater.setBounds(50, getHeight()-200, 50, 50);
		sacWater.setDisabled(true);
		sacWater.addListener(new ClickListener(){
	        @Override
	        public void clicked(InputEvent event, float x, float y)
	        {
	        	if(selectedCard!=null)
	        	{
	        		game.getSide(selectedCard.getOwner()).sacrificeForElements(selectedCard, Element.WATER);
	        		if(selectedCard.getOwner()==Player.PLAYER1)
	        		{
	        			hand1.highlightIndex(-1);
	        		}
	        		else if(selectedCard.getOwner()==Player.PLAYER2)
	        		{
	        			hand2.highlightIndex(-1);
	        		}
	        		selectedCard = null;
	        	}
	        }
	    });
		addActor(sacWater);
	}
	//sets up idols and tiles
	public void setupTiles()
	{
		//instantiates the arrays
		half1 = new Tile[5][3];
		half2 = new Tile[5][3];
		idols1 = new Idol[5];
		idols2 = new Idol[5];
		//these loops instantiates the tiles, it goes through all board positions, outer loop instantiates idols
		for(int i=0;i<5;i++)
    	{
			//creates a sprite from the idol texture
			Sprite temp = new Sprite(idol);
			//gives the sprite correct bounds
			temp.setBounds(getWidth()-LENGTH*7/2-140+i*LENGTH*3/4, 0, IDOL_LENGTH, IDOL_HEIGHT);
			//creates the idols and adds it to idol array
			idols1[i] = new Idol(game.getSide(Player.PLAYER1).getHalf().getIdolAt(i), temp);
			//adds the tile to the stage
			addActor(idols1[i]);
			//same for player 2
			temp = new Sprite(idol);
			//gives the sprite correct bounds
			temp.setBounds(getWidth()-LENGTH*7/2-140+i*LENGTH*3/4, getHeight()-IDOL_HEIGHT, IDOL_LENGTH, IDOL_HEIGHT);
			//creates the idols and adds it to idol array
			idols2[i] = new Idol(game.getSide(Player.PLAYER2).getHalf().getIdolAt(i), temp);
			//adds the tile to the stage
			addActor(idols2[i]);
    		for(int j=0;j<3;j++)
    		{
    			//creates a sprite from the unselected tile texture
    			temp = new Sprite(defaultTile);
    			//gives the sprite correct bounds
    			temp.setBounds(getWidth()-LENGTH*4-100+i*LENGTH*3/4, HEIGHT*3/4+(2-j)*HEIGHT+i%2*HEIGHT/2, LENGTH, HEIGHT);
    			//rotates the sprite to fit a top-down game view
    			temp.rotate90(true);
    			//creates the tile and adds it to tile array
    			half1[i][j] = new Tile(temp, highlightedTile);
    			//adds the tile to the stage
    			addActor(half1[i][j]);
    			//same for player2
    			temp = new Sprite(defaultTile);
    			temp.setBounds(getWidth()-LENGTH*4-100+i*LENGTH*3/4, getHeight()-HEIGHT*7/4-((2-j)*HEIGHT+i%2*HEIGHT/2), LENGTH, HEIGHT);
    			temp.rotate90(true);
    			half2[i][j] = new Tile(temp, highlightedTile);
    			addActor(half2[i][j]);
    		}
    	}
	}
}
