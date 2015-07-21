package com.alvarpq.GOTF.server;
import java.io.*;
import com.alvarpq.GOTF.coreGame.cards.Deck;
public class User implements Runnable
{
	private DataOutputStream out;
	private DataInputStream in;
	private Deck currentDeck;
	public User(DataOutputStream out, DataInputStream in, Deck currentDeck)
	{
		this.out=out;
		this.in=in;
		this.currentDeck = currentDeck;
	}
	public Deck getCurrentDeck(){
		return currentDeck;
	}
	@Override
	public void run() {
		while(true){
			try{
				String cmd=in.readUTF();
			}
			catch(IOException e){}
		
	}
}
}
