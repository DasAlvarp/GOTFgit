package com.alvarpq.GOTF;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.net.UnknownHostException;
import com.alvarpq.GOTF.gui.GameStage;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
public class GOTF extends ApplicationAdapter
{
	//the current stage
	Stage stage;
	DataInputStream in;
	DataOutputStream out;
	//sets the current stage to game stage
	@Override
	public void create() 
	{
		try {
			connect();
			setupGameStage();
		} catch (Exception e){
			System.out.println("Failed to connect to the game server.");
			try
			{
				setupGameStage();
			}
			catch(InstantiationException e1){}
			catch(IllegalAccessException e1){}
			catch(IllegalArgumentException e1){}
			catch(InvocationTargetException e1){}
			catch(SecurityException e1){}
		}
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
	public void setupGameStage() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException
	{
		stage = new GameStage();
		Gdx.input.setInputProcessor(stage);
	}
	
	public void connect() throws UnknownHostException, IOException{
		Socket sock=new Socket("localhost",4444);
		System.out.println("Connected to the game server.");
		in=new DataInputStream(sock.getInputStream());
		out=new DataOutputStream(sock.getOutputStream());
	}
	
}

class Input implements Runnable{

	DataInputStream in;

	public Input(DataInputStream in){
		this.in=in;
	}
	
	@Override
	public void run() {
		while(true){
			String msg;
			try {
				msg=in.readUTF();
				System.out.println(msg);
			} catch (IOException e) {
			}
		}
		
	}
	
}


