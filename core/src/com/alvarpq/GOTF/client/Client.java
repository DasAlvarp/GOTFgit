package com.alvarpq.GOTF.client;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
	
	static DataInputStream in;
	static DataOutputStream out;
	static String name;
	public static void main(String[] args) throws Exception{
		Socket sock=new Socket("192.168.0.3",9879);
		System.out.println("Connected to the chat server.");
		in=new DataInputStream(sock.getInputStream());
		out=new DataOutputStream(sock.getOutputStream());
		Input input=new Input(in);
		Thread thread=new Thread(input);
		thread.start();
		System.out.println("Enter a name.");
		Scanner scan=new Scanner(System.in);
		name=scan.nextLine().replaceAll(" ", "_");
		out.writeUTF(name);
		while(true){
			String send=scan.nextLine();
			out.writeUTF(send);
		}
	}
	
	public void run() throws Exception{
		Socket sock=new Socket("192.168.0.3",9879);
		PrintStream ps=new PrintStream(sock.getOutputStream());
		ps.println("Hello from the client!");
		
		InputStreamReader ir=new InputStreamReader(sock.getInputStream());
		BufferedReader br=new BufferedReader(ir);
		
		String message=br.readLine();
		//System.out.println(message);
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