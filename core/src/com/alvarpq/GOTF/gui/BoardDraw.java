package com.alvarpq.GOTF.gui;

import java.util.ArrayList;

import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.entity.AnimatedSprite;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class BoardDraw 
{
	
	
	private static int LENGTH = 117;//optimal length
	private static int HEIGHT = 135;//optimal height
	private ArrayList<Hex> hexes=new ArrayList<Hex>();
	private Hex[][] us;
	private Hex[][] them;
	private boolean startClick=false;
	//private Game master;
	Texture	tex = new Texture("BoardTile.png");
	Texture selTex = new Texture("hex.png");
	Sprite 	hx = new Sprite(tex);
	Sprite sel = new Sprite(selTex);

	//TODO add Game g parameter
	public BoardDraw()//setting up the board. Probably should be called on every board update, since it will eventually include the board state.
	{
		hx.setSize(LENGTH, HEIGHT);
		sel.setSize(LENGTH, HEIGHT);
		us=new Hex[5][3];
		them=new Hex[5][3];
		hexes.clear();
		hx.setSize(LENGTH, HEIGHT);
	//	master=g;
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);  
		myBoard(5);
		theEnemy(5);
	}
	
	//IMPORTANT THINGYMAJIGGER FOR GETLOCATION
public static Vector2 getRenderLocation(Player player, int row, int col){
	int hOff = (int) (HEIGHT - Math.sqrt(Math.pow(HEIGHT, 2) / 4 - Math.pow(LENGTH, 2) / 4));
	int x1=0;
	int y1=0;
	x1=hOff*row;
	if(player==Player.PLAYER2){
		if(row % 2 == 1)
		{
			y1=LENGTH * 4 +LENGTH * col;
		}
		else
		{
			y1=LENGTH / 2 + LENGTH * 4 + LENGTH * col;
		}
		}
	else{
		if(row % 2 == 1)
		{
			y1=LENGTH * col;
		}
		else
		{
			y1=LENGTH/2 + LENGTH * col;
		}
		}
	return new Vector2(x1,y1);
	
	}
	
	
	public Hex[][] getP1(){
		return us;
	}
	
	public Hex[][] getP2(){
		return them;
	}
	
	//main draw function
	public void update() 
	{
		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
			for(int row=0;row<us.length;row++){
				for(int col=0;col<us[0].length;col++){
					if(us[row][col].getValidLocations(Gdx.input.getX(), Gdx.input.getY())){
						highlightAdjacentTiles(row, col, us);
					}
			    }
			}
			
			for(int row=0;row<them.length;row++){
				for(int col=0;col<them[0].length;col++)
					if(them[row][col].getValidLocations(Gdx.input.getX(), Gdx.input.getY())){
							highlightAdjacentTiles(row, col, them);
			    }
			}
			startClick=true;

		}
		else{
			startClick=false;
		}

		

	}
	
	public void highlightAdjacentTiles(int row, int col, Hex[][] arr){
		for(int k=0; k<arr.length;k++){
			for(int i=0;i<arr[0].length;i++){
				if(BoardHalf.isAdjacent(k, i, row, col)){
					arr[k][i].adjacent();
					if(!startClick)
						arr[k][i].getSprite().syncFrameWith(arr[row][col].getSprite());
				}
			}
		}
	}
	
	//draws my end of teh board
	public void myBoard(int row)
	{
		//8bit did math. Please send all hatred/questions to him :P
		int hOff = (int) (HEIGHT - Math.sqrt(Math.pow(HEIGHT, 2) / 4 - Math.pow(LENGTH, 2) / 4));
		
		for(int x = 0; x < row; x++)
		{
			if(x %2 == 0)
			{
				makeRow(0, hOff * x, us,x, true);
			}
			else
			{
				makeRow((int)LENGTH / 2, hOff * x, us,x, true);
				
			}
		}
	}
	
	//like my board, but not.
	public void theEnemy(int row)
	{
		int hOff = (int) (HEIGHT - Math.sqrt(Math.pow(HEIGHT, 2) / 4 - Math.pow(LENGTH, 2) / 4));
		
		for(int x = 0; x < row; x++)
		{
			if(x % 2 == 1)
			{
				makeRow((int)(LENGTH * 4), hOff * x, them,x, false);
			}
			else
			{
				makeRow((int)(LENGTH / 2 + LENGTH * 4), hOff * x, them, x, false);
				
			}
		}
	}
	
	//draws a row.
	private void makeRow( int startY, int startX, Hex[][] arr, int row, boolean backwards)//length in hexes
	{
		ArrayList<Sprite> a1=new ArrayList<Sprite>();
		for(int k=0;k<7;k++){
			Sprite s=new Sprite(new Texture("GUI/selTile/selectedTile("+k+").png"));
			s.setSize(LENGTH, HEIGHT);
			a1.add(s);
		}
		
		for(int x = 0; x < arr[0].length; x++)
		{
			Hex h=new Hex(startX, startY+LENGTH*x, hx, new AnimatedSprite(4,a1));
			hexes.add(h);
			if(backwards){
				arr[row][arr[0].length-x-1]=h;
			}
			else{
				arr[row][x]=h;
			}
		}
		
	}
}
