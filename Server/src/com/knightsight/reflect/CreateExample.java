package com.knightsight.reflect;

import com.knightsight.server2.Servlet;

public class CreateExample {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?>clz=Class.forName("com.knightsight.server2.LoginServlet");
		//调用空构造 确保空构造存在
		Servlet ser=(Servlet)clz.newInstance();
	}
}
