package com.alvarpq.GOTF.gui;
import java.util.List;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.cards.Card;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
//actor to draw a hand
public class Hand extends Actor
{
	//holds the cards in the hand
	private List<Card> hand;
	//the currently highlighted/selected card's index
	private int highlightedIndex;
	//holds the card sprite
	private Texture card;
	//where to draw
	private float x, y, cardWidth, cardHeight;
	//holds the font for drawing stats
	private BitmapFont font;
	//constructs a hand
	public Hand(List<Card> hand, Texture card, float x, float y, float cardWidth, float cardHeight)
	{
		this.hand = hand;
		this.card = card;
		highlightedIndex = -1;
		this.x = x;
		this.y = y;
		this.cardWidth = cardWidth;
		this.cardHeight = cardHeight;
		font = new BitmapFont();
		font.setColor(Color.BLACK);		
	}
	//draws the hand
	@Override
	public void draw(Batch batch, float parentAlpha)
	{
		for(int i=0;i<hand.size();i++)
		{
			Sprite temp = new Sprite(card);
			if(i==highlightedIndex)
			{
				temp.setBounds(x+(i%5)*cardWidth, y+cardHeight*11/10*(i/5)+cardHeight/10, cardWidth, cardHeight);
			}
			else
			{
				temp.setBounds(x+(i%5)*cardWidth, y+cardHeight*11/10*(i/5), cardWidth, cardHeight);
			}
			temp.draw(batch);
			GlyphLayout temp2 = new GlyphLayout(font, hand.get(i).getName()+"");
			font.draw(batch, temp2, temp.getX()+temp.getWidth()/2-temp2.width/2, temp.getY()+temp.getHeight()-temp.getHeight()/15+temp2.height/2);
			temp2.setText(font, hand.get(i).getResourceCost()+"");
			font.draw(batch, temp2, temp.getX()+temp.getWidth()/2-temp2.width/2, temp.getY()+temp.getHeight()-temp.getHeight()/6.67f+temp2.height/2);
			temp2.setText(font, hand.get(i).getElementCost(Element.AIR)+"");
			font.draw(batch, temp2, temp.getX()+temp.getWidth()/10*3-temp2.width/2, temp.getY()+temp.getHeight()-temp.getHeight()/6.67f+temp2.height/2);
			temp2.setText(font, hand.get(i).getElementCost(Element.EARTH)+"");
			font.draw(batch, temp2, temp.getX()+temp.getWidth()/10*4-temp2.width/2, temp.getY()+temp.getHeight()-temp.getHeight()/6.67f+temp2.height/2);
			temp2.setText(font, hand.get(i).getElementCost(Element.FIRE)+"");
			font.draw(batch, temp2, temp.getX()+temp.getWidth()/10*6-temp2.width/2, temp.getY()+temp.getHeight()-temp.getHeight()/6.67f+temp2.height/2);
			temp2.setText(font, hand.get(i).getElementCost(Element.WATER)+"");
			font.draw(batch, temp2, temp.getX()+temp.getWidth()/10*7-temp2.width/2, temp.getY()+temp.getHeight()-temp.getHeight()/6.67f+temp2.height/2);
		}
	}
	//is a click in these coordinates on a card
	public Card cardClicked(int x, int y)
	{
		if(x>this.x&&x<this.x+cardWidth*5&&y>this.y&&y<this.y+cardHeight*11/10*(hand.size()/5))
		{
			return hand.get((int)((y-this.y)/(cardHeight*11/10))*5+(int)((x-this.x)/cardWidth));
		}
		else if(x>this.x&&x<this.x+cardWidth*(hand.size()%5)&y>this.y+cardHeight*11/10*(hand.size()/5)&&y<this.y+cardHeight*11/10*(hand.size()/5+1))
		{
			return hand.get((int)((y-this.y)/(cardHeight*11/10))*5+(int)((x-this.x)/cardWidth));
		}
		return null;
	}
	//highlights specified index
	public void highlightIndex(int index)
	{
		highlightedIndex = index;
	}
	//highlights specified card
	public void highlight(Card card)
	{
		highlightedIndex = hand.indexOf(card);
	}
}