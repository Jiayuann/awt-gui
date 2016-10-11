package com.knightsight.server;
import java.net.*;
import java.util.*;
import java.io.*;

public class Server4 {
	private ServerSocket server;
	public static void main(String[] args) {
		Server4 server4=new Server4();
		server4.start();
		
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
			 	Request req=new Request(client.getInputStream());
								
				Response rep=new Response(client.getOutputStream());
				rep.println("<html><head><title>HTTP responseExample</title>");
				rep.println("</head><body>");
				rep.println("welcome").println(req.getParameter("uname")).println("ªÿ¿¥");
				rep.println("</body></html>");
				rep.pushToClient(500);	
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
	}
	
}
