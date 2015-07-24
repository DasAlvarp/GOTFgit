package com.alvarpq.GOTF.gui;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Side;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
//actor to draw a card
public class Resources extends Actor
{
	//the side with resources
	private Side side;
	//the sprite to draw on
	private Sprite resources;
	//the font to draw numbers with
	private BitmapFont font;
	public Resources(Side side, Sprite resources)
	{
		this.side = side;
		this.resources = resources;
		font = new BitmapFont();
		font.setColor(Color.BLACK);
	}
	//draws the hand (currently only name and resource cost)
	@Override
	public void draw(Batch batch, float parentAlpha)
	{
		resources.draw(batch);
		GlyphLayout temp = new GlyphLayout(font, side.getResources()+"");
		font.draw(batch, temp, resources.getX()+25-temp.width/2, resources.getY()+resources.getHeight()-25+temp.height/2);
		temp.setText(font, side.getMaximumResources()+"");
		font.draw(batch, temp, resources.getX()+75-temp.width/2, resources.getY()+resources.getHeight()-50+temp.height/2);
		temp.setText(font, side.getElement(Element.AIR)+"");
		font.draw(batch, temp, resources.getX()+25-temp.width/2, resources.getY()+resources.getHeight()-75+temp.height/2);
		temp.setText(font, side.getMaximumElement(Element.AIR)+"");
		font.draw(batch, temp, resources.getX()+75-temp.width/2, resources.getY()+resources.getHeight()-100+temp.height/2);
		temp.setText(font, side.getElement(Element.EARTH)+"");
		font.draw(batch, temp, resources.getX()+25-temp.width/2, resources.getY()+resources.getHeight()-125+temp.height/2);
		temp.setText(font, side.getMaximumElement(Element.EARTH)+"");
		font.draw(batch, temp, resources.getX()+75-temp.width/2, resources.getY()+resources.getHeight()-150+temp.height/2);
		temp.setText(font, side.getElement(Element.FIRE)+"");
		font.draw(batch, temp, resources.getX()+25-temp.width/2, resources.getY()+resources.getHeight()-175+temp.height/2);
		temp.setText(font, side.getMaximumElement(Element.FIRE)+"");
		font.draw(batch, temp, resources.getX()+75-temp.width/2, resources.getY()+resources.getHeight()-200+temp.height/2);
		temp.setText(font, side.getElement(Element.WATER)+"");
		font.draw(batch, temp, resources.getX()+25-temp.width/2, resources.getY()+resources.getHeight()-225+temp.height/2);
		temp.setText(font, side.getMaximumElement(Element.WATER)+"");
		font.draw(batch, temp, resources.getX()+75-temp.width/2, resources.getY()+resources.getHeight()-250+temp.height/2);
	}
}