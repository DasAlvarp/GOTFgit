package com.alvarpq.GOTF.gui;
import java.util.LinkedList;
import java.util.List;
import com.alvarpq.GOTF.coreGame.Game;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation.GoblinGuard;
import com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation.GoblinWarrior;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.scenes.scene2d.Stage;
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
	//the game this GameStage displays
	private Game game;
	//the texture for the unselected tile
	private Texture defaultTile;
	//the animation for a selected tile
	private Animation selectedTile;
	//all the tiles (graphical class for displaying tiles and corresponding units)
	private Tile[][] half1;
	private Tile[][] half2;
	private List<Position> selectedPositions;
	public GameStage()
	{
		//sets the size of the stage to fill the whole window
		super(new FitViewport(540, 829));
		//creates a new game
		game = new Game(null, null);
		//adds the background
		addActor(new GameBackground());
		//instantiates the unselected tile
		defaultTile = new Texture("BoardTile.png");
		//instantiates the selected tile animation
    	selectedTile = new Animation(0.125f, new TextureRegion(new Texture("gui/selectedTiles/selectedTile(0).png")),
    	new TextureRegion(new Texture("gui/selectedTiles/selectedTile(1).png")), new TextureRegion(new Texture("gui/selectedTiles/selectedTile(2).png")),
    	new TextureRegion(new Texture("gui/selectedTiles/selectedTile(3).png")), new TextureRegion(new Texture("gui/selectedTiles/selectedTile(4).png")),
    	new TextureRegion(new Texture("gui/selectedTiles/selectedTile(5).png")), new TextureRegion(new Texture("gui/selectedTiles/selectedTile(6).png")));
    	selectedTile.setPlayMode(PlayMode.LOOP_REVERSED);
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
    			temp.setBounds(i*LENGTH*3/4, (2-j)*HEIGHT+i%2*HEIGHT/2, LENGTH, HEIGHT);
    			//rotates the sprite to fit a top-down game view
    			temp.rotate90(true);
    			//creates the tile and adds it to tile array
    			half1[i][j] = new Tile(temp, selectedTile);
    			//adds the tile to the stage
    			addActor(half1[i][j]);
    			//same for player2
    			temp = new Sprite(defaultTile);
    			temp.setBounds(i*LENGTH*3/4, getHeight()-HEIGHT-((2-j)*HEIGHT+i%2*HEIGHT/2), LENGTH, HEIGHT);
    			temp.rotate90(true);
    			half2[i][j] = new Tile(temp, selectedTile);
    			addActor(half2[i][j]);
    		}
    	}
		//instantiates the list of selected positions
		selectedPositions = new LinkedList<Position>();
		//just to try out adding a unit
		game.getSide(Player.PLAYER1).getHalf().addUnit(new GoblinWarrior(0, 0));
		half1[0][0].setUnit(game.getSide(Player.PLAYER1).getHalf().getUnitAt(0, 0));
	}
	@Override
	public boolean mouseMoved(int x, int y)
	{
		//current mousemoved code to make sure the tile the mouse is over is selected, loops go through all tiles
		for(int i=0;i<5;i++)
    	{
    		for(int j=0;j<3;j++)
    		{
    			//is the mouse over player 1's tile at i, j
    			if(half1[i][j].hasInsideBounds(x, getHeight()-y))
    			{
	    			deselectAll();
	    			selectPosition(new Position(Player.PLAYER1, i, j));
    				return true;
    			}
    			//same for player2
    			if(half2[i][j].hasInsideBounds(x, getHeight()-y))
    			{
	    			deselectAll();
	    			selectPosition(new Position(Player.PLAYER2, i, j));
    				return true;
    			}
    		}
    	}
		//in case the mouse is over no tile, deselect all tiles
		deselectAll();
		return true;
	}
	//selects a position and adds it to the selectedpositions
	public void selectPosition(Position p)
	{
		if(p.side==Player.PLAYER1)
		{
			half1[p.row][p.column].select();
			selectedPositions.add(p);
		}
		else if(p.side==Player.PLAYER2)
		{
			half2[p.row][p.column].select();
			selectedPositions.add(p);
		}
	}
	//deselects all positions, removing them from selectedPositions
	public void deselectAll()
	{
		for(Position p:selectedPositions)
		{
			if(p.side==Player.PLAYER1)
			{
				half1[p.row][p.column].deselect();
				selectedPositions.remove(p);
			}
			else if(p.side==Player.PLAYER2)
			{
				half2[p.row][p.column].deselect();
				selectedPositions.remove(p);
			}
		}
		selectedPositions.clear();
	}
	//deselects a position and removes it from the selected positions
	public void deselectPosition(Position p)
	{
		if(p.side==Player.PLAYER1)
		{
			half1[p.row][p.column].deselect();
			selectedPositions.remove(p);
		}
		else if(p.side==Player.PLAYER2)
		{
			half2[p.row][p.column].deselect();
			selectedPositions.remove(p);
		}
	}
}
