package com.knight.leet;

import java.util.ArrayList;
import java.util.List;


public class AddTwo {
	public static int convert(LinkedList l){
		int res=0;
		int i=0;
		while(l!=null){
			res+=l.data*Math.pow(10, i++);
			l=l.next;
		}
		return res;
	}

	public static class LinkedList{
	int data;
	LinkedList next;
	public LinkedList(int data){
		this.data=data;
		this.next=null;
	}	
}
	
	public static void main(String[] args) {
		LinkedList l1=new LinkedList(2);
		l1.next=new LinkedList(4);
		l1.next.next=new LinkedList(3);
		LinkedList l2=new LinkedList(5);
		l2.next=new LinkedList(6);
		l2.next.next=new LinkedList(4);
		System.out.println(convert(l1)+convert(l2));
		
		
	}
}
