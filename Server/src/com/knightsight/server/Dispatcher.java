package com.knightsight.server;

import java.io.IOException;
import java.net.Socket;

public class Dispatcher implements Runnable{
	

	private Socket client;
	private Request req;
	private Response rep;
	private int code;
	
	Dispatcher(Socket client){
		this.client=client;

	 	try {
			req=new Request(client.getInputStream());
			rep=new Response(client.getOutputStream());	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			code=500;
			return;
		}
	}

	@Override
	public void run() {
		Servlet serv=new Servlet();
		serv.service(req,rep);
		try {
			rep.pushToClient(code);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}
}
