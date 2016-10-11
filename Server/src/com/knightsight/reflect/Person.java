package com.knightsight.reflect;
/*
 * XML事件流解析
 * SAX解析
 * 		1.获得解析工厂
 * 		2，
 * BOM解析 数据量小的适合BOM解析
 * DOM4j解析
 * JDOM解析
 */

public class Person {
	
	private String name;
	private String age;
	
	public Person (){
		
	}
	public Person(String name, String age){
		super();
		this.name=name;
		this.age=age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
}
