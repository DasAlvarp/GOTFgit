package com.alvarpq.GOTF.client;

import java.io.*;
import java.net.*;

public class Server{
	static ServerSocket srvsock;
	static Users[] user=new Users[30];
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
					user[i]=new Users(out, in, user, i);
					Thread th=new Thread(user[i]);
					th.start();
					break;
				}
			}
		}
	}
	

}

class Users implements Runnable{
	DataOutputStream out;
	DataInputStream in;
	Users[] user=new Users[30];
	String name;
	int pid;
	public Users(DataOutputStream out, DataInputStream in, Users[] user, int pid){
		this.out=out;
		this.in=in;
		this.user=user;
		this.pid=pid;
	}
	
	public void run(){
		try{
			name=in.readUTF();
		} catch(IOException e){
		}
		while(true){
			try{
				String msg=in.readUTF();
				for(int i=0;i<30;i++){
					if(user[i]!=null){
						user[i].out.writeUTF(name+": "+msg);
					}
				}
			}catch(IOException e){
				user[pid]=null;
			}
		}
	}
	
}