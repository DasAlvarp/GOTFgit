package com.alvarpq.GOTF.server;

import java.io.*;

import com.alvarpq.GOTF.coreGame.cards.Deck;

public class User implements Runnable{

	private DataOutputStream out;
	private DataInputStream in;
	
	public User(DataOutputStream out, DataInputStream in){
		this.out=out;
		this.in=in;
	}
	public Deck getCurrentDeck(){
		return null;
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
