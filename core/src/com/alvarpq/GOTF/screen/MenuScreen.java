package com.alvarpq.GOTF.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class MenuScreen extends Screen{

	@Override
	public void create() {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);  
=======
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);      //clears the buffer 
>>>>>>> origin/WIP-ScreenManager
		batch.begin();
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}


	public void dispose(SpriteBatch batch) {
		// TODO Auto-generated method stub
	}

	public void update() {
		// TODO Auto-generated method stub
	/*	if(Gdx.input.isButtonPressed(Input.Buttons.LEFT) ){
			if(Gdx.input.getX()>200 && Gdx.graphics.getHeight()-Gdx.input.getY()>0){
				ScreenManager.setScreen(new GameScreen());
			}
		}
		*/
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}
	

}
