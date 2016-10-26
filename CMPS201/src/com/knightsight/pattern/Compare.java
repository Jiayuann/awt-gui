package com.knightsight.pattern;

public class Compare implements Comparable<Compare>{
	int num;
	String name;
	int age;
	public Compare(int num, String name, int age) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int compareTo(Compare o) {
		// TODO Auto-generated method stub
		if(o.age>age)
			return -1;
		else if(o.age==age)
			return 0;
		else 
			return 1;
		
	}
	
	public static void main(String[] args) {
		Compare c=new Compare(12,"tom",23);
		Compare j=new Compare(12,"jerry",15);
		System.out.println(c.compareTo(j));
		
	}
}
