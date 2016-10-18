package com.knight.gen01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyDemo02 {
	public static void main(String[] args) {
		List<Student>l=test();
		Map<String,ClassRoom> m=Count(l);
		Set<String> s=m.keySet();
		Iterator<String> it=s.iterator();
		while(it.hasNext()){
			String next=it.next();
			System.out.println(next+"--"+m.get(next).getTotal());
		}
		
		}
	
	public static Map<String,ClassRoom> Count(List<Student> l){
		Map<String,ClassRoom> m=new HashMap<String,ClassRoom>();
		for(Student key:l){
			String no=key.getno();
			int score=key.getScore();
			String name=key.getName();
			ClassRoom c=m.get(no);
			if(c==null){
				c=new ClassRoom(no);
				m.put(no, c);
			}
			c.getStuList().add(key);
			c.setTotal(c.getTotal()+score);
		}	
		

		return m;

	}
	
	public static List<Student> test(){
		List<Student> l=new ArrayList<Student>();
		l.add(new Student("jack","a",80));
		l.add(new Student("jim","b",89));
		l.add(new Student("navy","b",10));
		l.add(new Student("cello","c",89));
		l.add(new Student("cello","c",89));
		return l;
		
	}

}
