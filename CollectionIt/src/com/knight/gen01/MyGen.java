  package com.knight.gen01;

import java.util.ArrayList;
import java.util.List;

public class MyGen {
	
	public static void main(String []args){

	Integer i=new Integer(12);
	MyStudent<Integer> m=new MyStudent<Integer> (12);
	List<Apple> l=new ArrayList<Apple>();
	//List l=new ArrayList();
	Apple e=new Apple();
	l.add(e);
	
}	  
}

class Fruit{
	
}
class Apple extends Fruit{}