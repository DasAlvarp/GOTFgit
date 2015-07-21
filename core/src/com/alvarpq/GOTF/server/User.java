package com.alvarpq.GOTF.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;

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
		// TODO Auto-generated method stub
		
	}
}
