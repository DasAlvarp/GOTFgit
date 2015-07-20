package com.alvarpq.GOTF;
import com.alvarpq.GOTF.gui.GameStage;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
public class GOTF extends ApplicationAdapter
{
	//the current stage
	Stage stage;
	//sets the current stage to game stage
	@Override
	public void create() 
	{
		setupGameStage();
	}
	//standard resize
	@Override
	public void resize(int width, int height)
	{
		stage.getViewport().update(width, height, true);
	}
	//clears the screen, renders and updates the current stage
	@Override
	public void render()
	{
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    stage.act(Gdx.graphics.getDeltaTime());
	    stage.draw();
	}
	//standard dispose
	@Override
	public void dispose() {
	    stage.dispose();
	}
	//sets the current stage to game stage and makes sure all input is sent there
	public void setupGameStage()
	{
		stage = new GameStage();
		Gdx.input.setInputProcessor(stage);
	}
}
