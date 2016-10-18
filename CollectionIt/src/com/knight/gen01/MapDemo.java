package com.knight.gen01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//·Ö¸î×Ö·û´®
public class MapDemo {
	
	
	
	public static void main(String[] args) {
		String []arr="this is a cat and that is a mice, where is the dog?".split(" ");
		Map<String,Integer> m=new HashMap<String,Integer>();
		for(String key:arr){
			if(!m.containsKey(key))
				m.put(key, 1);
			else
				m.put(key, m.get(key)+1);
		}
		
		Set<String>s=m.keySet();
		Iterator<String> it=s.iterator(); 
		while(it.hasNext()){
			String next=it.next();
			System.out.println(next+m.get(next));
		}
	}
	
	
	
}
