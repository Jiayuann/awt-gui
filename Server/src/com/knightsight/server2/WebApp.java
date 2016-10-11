package com.knightsight.server2;

import java.util.Map;

public class WebApp {
	private static ServletContext context;
	static{
		context=new ServletContext();
		Map<String,String>mapping=context.getMapping();
		mapping.put("/login","login");
		mapping.put("/log","login");
		mapping.put("/reg","register");
		mapping.put("/register","register");
		
		Map<String,String> servlet=context.getServlet();
		servlet.put("login", "com.knightsight.server2.LoginServlet");
		servlet.put("register","com.knightsight.server2.RegisterServlet");
	}
	
	public static Servlet getServlet(String url) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		if(url.equals("")||null==url){
			return null;
			
		}
		String name=context.getServlet().get(context.getMapping().get(url));
		return (Servlet)Class.forName(name).newInstance();
		//return context.getServlet().get(context.getMapping().get(url)); 确保空构造存在 
		
		
	}
}
