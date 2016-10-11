package com.knightsight.server2;

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
		
		try {
			Servlet serv=WebApp.getServlet(req.getUrl());
			if(null==serv){
				this.code=404;
			}else{
			serv.service(req, rep);
			}
			rep.pushToClient(code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.code=500;
		}
		// TODO Auto-generated method stub
		
	}
}
