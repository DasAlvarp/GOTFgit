package com.alvarpq.GOTF.gui;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BoardDraw {
	
	Texture hex = new Texture("hex.png");

	public void drawit (SpriteBatch batch) {

		batch.draw(hex, 0, 0, 100, 100);

	}
}
