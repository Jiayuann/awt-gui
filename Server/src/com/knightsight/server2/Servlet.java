package com.knightsight.server2;

public abstract class Servlet {
	public void service(Request req,Response rep) throws Exception{
		/*
		rep.println("<html><head><title>HTTP responseExample</title>");
		rep.println("</head><body>");
		rep.println("welcome").println(req.getParameter("uname")).println("ªÿ¿¥");
		rep.println("</body></html>");
		*/
		this.doGet(req,rep);
		this.doPost(req,rep);  
		
	}
	public abstract void doGet(Request req,Response rep)throws Exception;
	public abstract void doPost(Request req,Response rep)throws Exception;

}
