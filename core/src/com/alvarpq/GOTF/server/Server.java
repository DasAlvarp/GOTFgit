package com.alvarpq.GOTF.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.alvarpq.GOTF.coreGame.Game;

public class Server {

	static ArrayList<Game> activeGames=new ArrayList<Game>();
	static ServerSocket srvsock;
	static User[] user=new User[30];
	public static void main(String[] args) throws Exception{
		srvsock=new ServerSocket(55555);
		System.out.println("Server up!");
		while(true){
			Socket sock=srvsock.accept();
			for(int i=0;i<30;i++){
				if(user[i]==null){
					System.out.println("Connection from: "+sock.getInetAddress());
					DataOutputStream out=new DataOutputStream(sock.getOutputStream());
					DataInputStream in=new DataInputStream(sock.getInputStream());
					user[i]=new User(out, in);
					Thread th=new Thread(user[i]);
					th.start();
					break;
				}
			}
		}
	}
}
