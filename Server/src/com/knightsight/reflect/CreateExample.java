package com.knightsight.reflect;

import com.knightsight.server2.Servlet;

public class CreateExample {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?>clz=Class.forName("com.knightsight.server2.LoginServlet");
		//���ÿչ��� ȷ���չ������
		Servlet ser=(Servlet)clz.newInstance();
	}
}
