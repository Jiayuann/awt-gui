package com.knight.collection;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
	public static void main(String[] args) {
		Map map=new HashMap();
		map.put("Jaca", new Family("rose",21));
		map.put("me", new Family("lotus",22));
		
		Family f=(Family)map.get("Jaca");map.remove("Jaca");
		System.out.println(f.name);
	 
		
	}

}

class Family{
	String name;
	int age;
	public Family(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
}