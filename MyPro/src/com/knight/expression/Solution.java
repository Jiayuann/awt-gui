package com.knight.expression;

public class Solution {
	public String cut(String s,String p){
		if(s.contains(p))s.replace(p,".");
		return s;
	}

	public boolean isMatching(String s,String p){
		if(s.equals(p))return true;
		//if(s.contains("*")
		return false;
		
	}
	public static void main(String[] args) {
		String s1=new String("steak");
	
		Solution c=new Solution();
		System.out.println(c.cut(s1,"ea"));
		
	}

}
