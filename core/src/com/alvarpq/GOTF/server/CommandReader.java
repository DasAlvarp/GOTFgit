package com.alvarpq.GOTF.server;

import com.alvarpq.GOTF.coreGame.Game;
import com.alvarpq.GOTF.coreGame.Player;

public class CommandReader {

	private Game game;
	
	public CommandReader(Game game){
		this.game=game;
	}
	
	public void performCommand(String cmd){
		String[] parts=cmd.split(" ");
		if(parts[0].equals("1")){
			Player p=Player.PLAYER1;
		}
		else{
			Player p=Player.PLAYER2;
		}
		if(parts[1].equals("move")){
			
		}
	}
}
