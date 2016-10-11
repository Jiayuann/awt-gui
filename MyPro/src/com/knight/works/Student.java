package com.knight.works;

public class Student {
  String name;
  int id;
  
  public Student(String name, int id){
	  this.name=name;
	  this.id=id;
  }
  
  public void printName(){
	  System.out.println(this.name);
  }
}

class Info extends Student{
	String info;
	public Info(String name, int id,String info) {
		super(name, id);
		this.info=info;
		// TODO Auto-generated constructor stub
	}

	public void getInfo(){
		System.out.print(this.id);
	}
	
}