package com.knightsight.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.*;
import java.io.*;

public class Server {
	private ServerSocket server;
	public static void main(String[] args) {
		Server ser=new Server();
		ser.start();
		
	}
	
	public void start(){
		try {
			server = new ServerSocket(8800);	
			this.receive();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void receive(){
			try {
				Socket client=server.accept();
				String msg=null;
				StringBuilder sb=new StringBuilder();
				BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream()));
				while((msg=br.readLine()).length()>0){
					sb.append(msg);
					sb.append("\r\n");
					if(msg==null){
						break;
					}
				}
				String requestInfo=sb.toString().trim();
				System.out.println(requestInfo);
				
			} catch (IOException   e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public void stop(){
		
		
	}
}
