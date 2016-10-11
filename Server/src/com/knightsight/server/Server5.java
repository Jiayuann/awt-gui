package com.knightsight.server;
import java.net.*;
import java.util.*;
import java.io.*;

public class Server5 {
	private ServerSocket server;
	private boolean isShutDown=false;
	public static void main(String[] args) {
		Server5 server5=new Server5();
		server5.start();
		
	}
	
	public void start(){
		try {
			server = new ServerSocket(8800);	
			this.receive();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isShutDown=false;
		}
	} 
	
	public void receive(){
			try {
				while(!isShutDown){
				new Thread(new Dispatcher(server.accept())).start();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	}
	public void stop() throws IOException{
		isShutDown=false;
		server.close();
		
	}
	
}
