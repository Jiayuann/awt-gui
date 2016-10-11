package com.knightsight.server;
import java.net.*;
import java.util.*;
import java.io.*;

public class Server3 {
	private ServerSocket server;
	public static void main(String[] args) {
		Server3 server3=new Server3();
		server3.start();
		
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
			 	byte []data=new byte[20480];
			 	//1.获取输入流
				int len=client.getInputStream().read(data);
				String requestInfo=new String(data,0,len).trim();
				System.out.println(requestInfo);
								
				Response reponse=new Response(client.getOutputStream());
				reponse.println("<html><head><title>HTTP responseExample</title>");
				reponse.println("</head><body>     Hello 杨雪 困了吃水果</body></html>");
				reponse.pushToClient(500);	
				
			} catch (IOException   e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
}
