package com.knight.iterator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Test01 {
	public static void main(String[] args) {
	List l=new ArrayList();
	l.add("aaa");
	l.add("bbb");
	l.add("ccc");
	
	Set s=new HashSet();
	s.add("1");
	s.add("2");
	s.add("3");
	/*
	for(Iterator iter=s.iterator();iter.hasNext();){
		String str=(String)iter.next();
		System.out.println(str);
		iter.remove();
	}
	*/
	Iterator iter=s.iterator();
	while(iter.hasNext()){
		String str=(String)iter.next();
		System.out.println(str);
	}
	
	
	
	}
	
	
	
	
}
