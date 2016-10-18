package com.knight.gen01;

public class MySimpleList {
	private String [] elem={"a","b","c"};
	private int size=elem.length;
	private int cursor=-1;
	
	public boolean hasNext(){
		if(cursor>=size-1)return false;
		return true;
	}
	
	public String next(){
		if(cursor<size){
		cursor++;
		return elem[cursor];
		}
		else return null;
		
	}
	
	public static void main(String[] args) {
		MySimpleList m=new MySimpleList();
		System.out.println(m.next());
		System.out.println(m.next());
		System.out.println(m.next());
		System.out.println(m.cursor);
		System.out.println(m.hasNext());
		
	}
}
