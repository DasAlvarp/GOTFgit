package com.alvarpq.GOTF.gui;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
//actor to draw a card
public class Idol extends Actor
{
	//the health of the idol
	private int health;
	//holds the idol sprite
	private Sprite idol;
	//holds the font for drawing health
	private BitmapFont font;
	//constructs a idols actor
	public Idol(int health, Sprite idol)
	{
		this.health = health;
		this.idol = idol;
		font = new BitmapFont();
		font.setColor(Color.BLACK);		
	}
	//draws the idol
	@Override
	public void draw(Batch batch, float parentAlpha)
	{
		idol.draw(batch);
		GlyphLayout temp = new GlyphLayout(font, health+"");
		font.draw(batch, temp, idol.getX()+idol.getWidth()/2-temp.width/2, idol.getY()+idol.getHeight()/2+temp.height/2);
	}
	public int getHealth()
	{
		return health;
	}
	public void setHealth(int health)
	{
		this.health = health;
	}
}