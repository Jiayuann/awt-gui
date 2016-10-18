package com.knight.collection;

import java.util.ArrayList;
import java.util.List;

public class SetArrayList {
	int size;
	private Object [] elementData;
	
	public SetArrayList(){
		this(10);
	}
	
	public SetArrayList(int initialCapacity){
		if(initialCapacity<0){
			try{
				throw new Exception();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		elementData=new Object[initialCapacity];
	}
	
	public void add(Object obj){
		if(size>=elementData.length){
			Object []newElement=new Object[size*2];
			for(int i=0;i<elementData.length;i++)newElement[i]=elementData[i];
			elementData=newElement;
					
		}
		elementData[size++]=obj;
	}
	
	public Object get(int index){
		if(index<0||index>size-1){
		try{
			throw new Exception();
		}catch(Exception e){
			e.printStackTrace();
		}
		} 	 	 	
		return elementData[index];
	}
	
	public void remove(int index){
		for(int i=index;i<size;i++){
			elementData[i-1]=elementData[i];
		}
		elementData[--size]=null;
	}
	
	public static void main(String[] args) {
		List list=new ArrayList();
		SetArrayList slist=new SetArrayList();
		slist.add("a"); 	
		slist.add("B");
		slist.add("c");
		slist.add("D");
		
		
		for(int i=0;i<slist.size;i++)
		System.out.println(slist.get(i));
		slist.remove(2);
		for(int i=0;i<slist.size;i++)
			System.out.println(slist.get(i));
	}

}
