package com.alvarpq.GOTF.gui;



import com.alvarpq.GOTF.coreGame.Game;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class BoardDraw 
{
	
	
	private static int LENGTH = 39;//optimal length
	private static int HEIGHT = 45;//optimal height
	private ArrayList<Hex> hexes=new ArrayList<Hex>();
	private Hex[][] us;
	private Hex[][] them;
	//private Game master;
	
	Texture	tex = new Texture("BoardTile.png");
	Texture selTex = new Texture("hex.png");
	Sprite 	hx = new Sprite(tex);
	Sprite sel = new Sprite(selTex);

	//TODO add Game g parameter
	public BoardDraw()//setting up the board. Probably should be called on every board update, since it will eventaully include the board state.
	{
		us=new Hex[5][3];
		them=new Hex[5][3];
		hexes.clear();
		hx.setSize(LENGTH, HEIGHT);
	//	master=g;
		myBoard(5);
		theEnemy(5);
	}
	
	//main draw function
	public void drawit (SpriteBatch batch) 
	{
		for(int x = 0; x < hexes.size(); x++)
		{
			hexes.get(x).drawit(batch);
		}
		for(int row=0; row < us.length;row++){
			for(int col=0;col<us[0].length;col++)
				if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
					if(us[row][col].getValidLocations(us[row][col].x, us[row][col].y, Gdx.input.getX(), Gdx.input.getY())){
						highlightAdjacentTiles(row, col, us, batch);
					}
		    }
		}
		for(int row=0; row<them.length;row++){
			for(int col=0;col<them[0].length;col++)
				if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
					if(them[row][col].getValidLocations(them[row][col].x, them[row][col].y, Gdx.input.getX(), Gdx.input.getY())){
						highlightAdjacentTiles(row, col, them, batch);
					}
		    }
		}

	}
	
	public void highlightAdjacentTiles(int row, int col, Hex[][] arr, SpriteBatch batch){
		for(int k=0; k<arr.length;k++){
			for(int i=0;i<arr[0].length;i++){
				if(BoardHalf.isAdjacent(k, i, row, col)){
					arr[k][i].select(batch);
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
	private void makeRow( int startX, int startY, Hex[][] arr, int row, boolean backwards)//length in hexes
	{
		for(int x = 0; x < arr[0].length; x++)
		{
			Hex h=new Hex(startX + LENGTH * x, startY, hx, sel);
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
