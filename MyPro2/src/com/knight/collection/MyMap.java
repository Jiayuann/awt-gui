package com.knight.collection;

import java.util.LinkedList;
import java.util.List;

public class MyMap {
	int size;
	LinkedList []arr=new LinkedList[99];
	
	public void put(Object key,Object value){
		Entry e=new Entry(key,value);
		int i=e.key.hashCode()%99;
		if(arr[i]==null){
			LinkedList list=new LinkedList();
			list.add(e);
			arr[i]=list;
		}else{
			  arr[i].add(e);
		}
	}
	
	public Object get(Object key){
		int i=key.hashCode()%99;
		if(arr[i]!=null){
			for(int j=0;j<arr[i].size();j++){
				Entry e=(Entry)arr[i].get(j);
				if(e.key.equals(key))
					return e.value;
		}
		}
		return null;	
	}

	
	public static void main(String[] args) {
		MyMap m=new MyMap();
		m.put("ack","bbb");
		m.put("dick","ccc");
		System.out.println(m.get("dick"));
		
	}

}

class Entry{
	
	Object key;
	Object value;
	public Entry(Object key,Object value){
		this.key=key;
		this.value=value;
	}
	
}