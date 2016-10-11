package com.knight.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MySet {
		Map m=new HashMap(); 
		int size;
		public static final Object current=new Object();
		
		public void add(Object obj){
			m.put(obj, current);
			size++;
		}
		
		public void remove(Object obj){
			m.remove(obj);
			size--;
		}
		
		
		
		public static void main(String[] args) {
			MySet s=new MySet();
			s.add("aaa");
			s.add("ccc");
			s.add("bbb");
			System.out.println(s.size);
			s.remove("bbb");
			System.out.println(s.m.size());
		}
		
}
