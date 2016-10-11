package com.knightsight.server2;

public class RegisterServlet extends Servlet{

	@Override
	public void doGet(Request req, Response rep) throws Exception {
		// TODO Auto-generated method stub
	
	}
	
	

	@Override
	public void doPost(Request req, Response rep) throws Exception {
		// TODO Auto-generated method stub
		rep.println("<html><head><title>HTTP responseExample</title>");
		rep.println("</head><body>");
		rep.println("welcomeBack").println(req.getParameter("uname")).println("ªÿ¿¥");
		rep.println("</body></html>");
		
	}


	
}