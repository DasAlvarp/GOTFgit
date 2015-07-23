package com.alvarpq.GOTF.gui;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;
import com.alvarpq.GOTF.coreGame.Game;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.cards.Deck;
import com.alvarpq.GOTF.coreGame.units.Unit;
import com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation.GoblinWarrior;
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
	private static final float LENGTH = 135;
	//a tile's height
	private static final float HEIGHT = 117;
	//a card's length
	private static final float CARD_LENGTH = 110;
	//a card's height
	private static final float CARD_HEIGHT = 165;
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
	//Button spriteDrawables
	SpriteDrawable buttonUp;
	SpriteDrawable buttonDown;
	//all the tiles (graphical class for displaying tiles and corresponding units)
	private Tile[][] half1;
	private Tile[][] half2;
	//all the GraphicalCards in hands
	private List<GraphicalCard> hand1;
	private List<GraphicalCard> hand2;
	//the end turn button
	private TextButton endTurn;
	//the currently highlighted positions
	private List<Position> highlightedPositions;
	//the currently selected unit
	private Unit selectedUnit;
	public GameStage() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException
	{
		//sets the size of the stage to fill the whole window
		super(new FitViewport(1080, 829));
		//creates a new game and starts it with 5 in hand size
		game = new Game(new User(null, null, new Deck(110105, true)), new User(null, null, new Deck(110105, true)));
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
    	//instantiates button SpriteDrawables
    	buttonUp = new SpriteDrawable(new Sprite(new Texture("buttonUp.png")));
    	buttonDown = new SpriteDrawable(new Sprite(new Texture("buttonDown.png")));
    	//instantiates tile arrays
		half1 = new Tile[5][3];
		half2 = new Tile[5][3];
		//these loops instantiates the tiles, it goes through all board positions
		for(int i=0;i<5;i++)
    	{
    		for(int j=0;j<3;j++)
    		{
    			//creates a sprite from the unselected tile texture
    			Sprite temp = new Sprite(defaultTile);
    			//gives the sprite correct bounds
    			temp.setBounds(270+i*LENGTH*3/4, (2-j)*HEIGHT+i%2*HEIGHT/2, LENGTH, HEIGHT);
    			//rotates the sprite to fit a top-down game view
    			temp.rotate90(true);
    			//creates the tile and adds it to tile array
    			half1[i][j] = new Tile(temp, highlightedTile);
    			//adds the tile to the stage
    			addActor(half1[i][j]);
    			//same for player2
    			temp = new Sprite(defaultTile);
    			temp.setBounds(270+i*LENGTH*3/4, getHeight()-HEIGHT-((2-j)*HEIGHT+i%2*HEIGHT/2), LENGTH, HEIGHT);
    			temp.rotate90(true);
    			half2[i][j] = new Tile(temp, highlightedTile);
    			addActor(half2[i][j]);
    		}
    	}
		//instantiates hand lists
		hand1 = new LinkedList<GraphicalCard>();
		hand2 = new LinkedList<GraphicalCard>();
		//these loops instantiates the tiles, it goes through all board positions
		for(int i=0;i<5;i++)
    	{
    			//creates a sprite from the card texture
    			Sprite temp = new Sprite(card);
    			//gives the sprite correct bounds
    			temp.setBounds(100, i*CARD_HEIGHT, CARD_LENGTH, CARD_HEIGHT);
    			//creates the card and adds it to card array
    			hand1.add(new GraphicalCard(game.getSide(Player.PLAYER1).getDeck().getHand().get(i), temp));
    			//adds the card to the stage
    			addActor(hand1.get(i));
    			//same for player2
    			temp = new Sprite(card);
    			temp.setBounds(880, i*CARD_HEIGHT, CARD_LENGTH, CARD_HEIGHT);
    			hand2.add(new GraphicalCard(game.getSide(Player.PLAYER2).getDeck().getHand().get(i), temp));
    			addActor(hand2.get(i));
    	}
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
	        }
	    });
		addActor(endTurn);
		//instantiates the list of selected positions
		highlightedPositions = new LinkedList<Position>();
		selectedUnit = null;
		//just to try out adding a unit
		game.getSide(Player.PLAYER1).getHalf().addUnit(new GoblinWarrior(0, 0));
		half1[0][0].setUnit(game.getSide(Player.PLAYER1).getHalf().getUnitAt(0, 0));
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
			int oldRow = selectedUnit.getRow();
			int oldColumn = selectedUnit.getColumn();
			game.getSide(p.side).getHalf().move(selectedUnit, p.row, p.column);
			if(p.side==Player.PLAYER1)
			{
				half1[oldRow][oldColumn].setUnit(null);
				half1[selectedUnit.getRow()][selectedUnit.getColumn()].setUnit(selectedUnit);
				deselectUnit();
			}
			else if(p.side==Player.PLAYER2)
			{
				half2[oldRow][oldColumn].setUnit(null);
				half2[selectedUnit.getRow()][selectedUnit.getColumn()].setUnit(selectedUnit);
				deselectUnit();
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
}
