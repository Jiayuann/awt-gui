package com.knightsight.server2;

public class LoginServlet extends Servlet{

	@Override
	public void doGet(Request req, Response rep) throws Exception {
		// TODO Auto-generated method stub
		String name=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		if(login(name,pwd)){
		rep.println("<html><head><title>HTTP responseExample</title>");
		rep.println("</head><body>");
		rep.println("welcome").println(req.getParameter("uname")).println("  login successful");
		rep.println("</body></html>");
		}else{
			rep.println("login failed");
		}
		
	}
	
	public boolean login(String name,String pwd){
		
		return name.equals("coco")&&pwd.equals("cc");
	}

	@Override
	public void doPost(Request req, Response rep) throws Exception {
		// TODO Auto-generated method stub
	
		
	}


	
}
