package com.alvarpq.GOTF.gui;
import java.util.List;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.cards.Card;
import com.alvarpq.GOTF.gui.GameStage.Position;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
//actor to draw a card
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
	//draws the hand (currently only name and resource cost)
	@Override
	public void draw(Batch batch, float parentAlpha)
	{
		for(int i=0;i<hand.size();i++)
		{
			Sprite temp = new Sprite(card);
			if(i==highlightedIndex)
			{
				temp.setBounds(x+i*cardWidth, y+cardWidth/3, cardWidth, cardHeight);
			}
			else
			{
				temp.setBounds(x+i*cardWidth, y, cardWidth, cardHeight);
			}
			temp.draw(batch);
			GlyphLayout temp2 = new GlyphLayout(font, hand.get(i).getName()+"");
			font.draw(batch, temp2, temp.getX()+temp.getWidth()/2-temp2.width/2, temp.getY()+temp.getHeight()-temp.getHeight()/15+temp2.height/2);
			temp2.setText(font, hand.get(i).getResourceCost()+"");
			font.draw(batch, temp2, temp.getX()+temp.getWidth()/2-temp2.width/2, temp.getY()+temp.getHeight()-temp.getHeight()/6.67f+temp2.height/2);
		}
	}
	//is a click in these coordinates on a card
	public Card cardClicked(int x, int y)
	{
		if(x>this.x&&x<this.x+cardWidth*hand.size()&&y>this.y&&y<this.y+cardHeight)
		{
			return hand.get((int)((x-this.x)/cardWidth));
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