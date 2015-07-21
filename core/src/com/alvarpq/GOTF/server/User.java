package com.alvarpq.GOTF.server;
import java.io.*;

import com.alvarpq.GOTF.coreGame.Game;
import com.alvarpq.GOTF.coreGame.cards.Deck;
public class User implements Runnable
{
	private DataOutputStream out;
	private DataInputStream in;
	private Deck currentDeck;
	private Game g;
	public User(DataOutputStream out, DataInputStream in, Deck currentDeck)
	{
		g=null;
		this.out=out;
		this.in=in;
		this.currentDeck = currentDeck;
	}
	public Deck getCurrentDeck(){
		return currentDeck;
	}
	
	public void setGame(Game g){
		this.g=g;
	}
	public Game inGame(){
		return g;
	}
	@Override
	public void run() {
		while(true){
			try{
				String cmd=in.readUTF();
				g.getReader().performCommand(cmd);
			}
			catch(IOException e){}
		
	}
}
}
