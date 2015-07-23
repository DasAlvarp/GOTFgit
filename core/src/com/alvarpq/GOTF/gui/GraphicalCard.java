package com.alvarpq.GOTF.gui;
import com.alvarpq.GOTF.coreGame.cards.Card;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
//actor to draw a card
public class GraphicalCard extends Actor
{
	//holds the card
	private Card card;
	//holds the card sprite
	private Sprite cardSprite;
	//holds the font for drawing stats
	private BitmapFont font;
	//constructs a card
	public GraphicalCard(Card card, Sprite cardSprite)
	{
		this.card = card;
		this.cardSprite = cardSprite;
		font = new BitmapFont();
		font.setColor(Color.BLACK);		
	}
	//draws the card (currently only name and resource cost)
	@Override
	public void draw(Batch batch, float parentAlpha)
	{
		cardSprite.draw(batch);
		GlyphLayout temp = new GlyphLayout(font, card.getName()+"");
		font.draw(batch, temp, cardSprite.getX()+cardSprite.getWidth()/2-temp.width/2, cardSprite.getY()+cardSprite.getHeight()-cardSprite.getHeight()/15+temp.height/2);
		temp.setText(font, card.getResourceCost()+"");
		font.draw(batch, temp, cardSprite.getX()+cardSprite.getWidth()/2-temp.width/2, cardSprite.getY()+cardSprite.getHeight()-cardSprite.getHeight()/6.67f+temp.height/2);
	}
	//returns whether a certain coordinate is within the card's bounds
	public boolean hasInsideBounds(float x, float y)
	{
		return cardSprite.getBoundingRectangle().contains(x, y);
	}
}
