package com.knight.collection2;

import java.util.ArrayList;
import java.util.List;

public class TestE {
	public static void main(String[] args) throws Exception {
		Employee e1=new Employee(0201,"Jack",2000,"2001-01");
		Employee e2=new Employee(0202,"Edward",2001,"2001-02");
		Employee e3=new Employee(0202,"Ale",2001,"2008-02");
		List<Employee> list=new ArrayList<Employee>();
		list.add(e1);
		list.add(e2);list.add(e3);
		TestE t=new TestE();
		t.printName(list);
		
	}
	
	public void printName(List<Employee> list){
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getName());
		}
	}
	
	
}
