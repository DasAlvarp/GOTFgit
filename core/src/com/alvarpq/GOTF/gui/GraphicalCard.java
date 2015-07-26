package com.alvarpq.GOTF.gui;
import com.alvarpq.GOTF.coreGame.Element;
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
	//constructs a hand
	public GraphicalCard(Card card, Sprite cardSprite)
	{
		this.card = card;
		this.cardSprite = cardSprite;
		font = new BitmapFont();
		font.setColor(Color.BLACK);		
	}
	//draws the hand
	@Override
	public void draw(Batch batch, float parentAlpha)
	{
		if(card!=null)
		{
			cardSprite.draw(batch);
			GlyphLayout cardSprite2 = new GlyphLayout(font, card.getName()+"");
			font.draw(batch, cardSprite2, cardSprite.getX()+cardSprite.getWidth()/2-cardSprite2.width/2, cardSprite.getY()+cardSprite.getHeight()-cardSprite.getHeight()/15+cardSprite2.height/2);
			cardSprite2.setText(font, card.getResourceCost()+"");
			font.draw(batch, cardSprite2, cardSprite.getX()+cardSprite.getWidth()/2-cardSprite2.width/2, cardSprite.getY()+cardSprite.getHeight()-cardSprite.getHeight()/6.67f+cardSprite2.height/2);
			cardSprite2.setText(font, card.getElementCost(Element.AIR)+"");
			font.draw(batch, cardSprite2, cardSprite.getX()+cardSprite.getWidth()/10*3-cardSprite2.width/2, cardSprite.getY()+cardSprite.getHeight()-cardSprite.getHeight()/6.67f+cardSprite2.height/2);
			cardSprite2.setText(font, card.getElementCost(Element.EARTH)+"");
			font.draw(batch, cardSprite2, cardSprite.getX()+cardSprite.getWidth()/10*4-cardSprite2.width/2, cardSprite.getY()+cardSprite.getHeight()-cardSprite.getHeight()/6.67f+cardSprite2.height/2);
			cardSprite2.setText(font, card.getElementCost(Element.FIRE)+"");
			font.draw(batch, cardSprite2, cardSprite.getX()+cardSprite.getWidth()/10*6-cardSprite2.width/2, cardSprite.getY()+cardSprite.getHeight()-cardSprite.getHeight()/6.67f+cardSprite2.height/2);
			cardSprite2.setText(font, card.getElementCost(Element.WATER)+"");
			font.draw(batch, cardSprite2, cardSprite.getX()+cardSprite.getWidth()/10*7-cardSprite2.width/2, cardSprite.getY()+cardSprite.getHeight()-cardSprite.getHeight()/6.67f+cardSprite2.height/2);
		};
	}
	//gets the card
	public Card getCard()
	{
		return card;
	}
	//sets the card
	public void setCard(Card card)
	{
		this.card = card;
	}
}