package com.knightsight.server;

public class Servlet {
	public void service(Request req,Response rep){
		rep.println("<html><head><title>HTTP responseExample</title>");
		rep.println("</head><body>");
		rep.println("welcome").println(req.getParameter("uname")).println("ªÿ¿¥");
		rep.println("</body></html>");
  
		
	}

}
