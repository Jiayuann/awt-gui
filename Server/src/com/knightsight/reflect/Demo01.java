package com.knightsight.reflect;

public class Demo01 {
	public static void main(String[] args) throws ClassNotFoundException {
		
		/* 
		 * 1. object.getClass();
		 * 2. ¿‡.class
		 * 3. full path
		 */
		
		String str="abc";	
		Class<?>clz=str.getClass();
		clz=String.class;
		clz=Class.forName("java.lang.String");
	}
}
