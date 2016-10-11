package com.knight.leet;

public class StringToInteger {
	public static int atoi(String s){
		Integer i=new Integer(s);
		return i.intValue();
	}
	
	public static void main(String[] args) {
		String s="2333";
		System.out.println(atoi(s));
	}
}
