package com.knightsight.reflect;
/*
 * XML�¼�������
 * SAX����
 * 		1.��ý�������
 * 		2��
 * BOM���� ������С���ʺ�BOM����
 * DOM4j����
 * JDOM����
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
