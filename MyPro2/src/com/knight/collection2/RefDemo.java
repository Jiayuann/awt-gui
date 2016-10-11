package com.knight.collection2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RefDemo {
public static void main(String[] args) {
	List<String> l=new ArrayList<String>();
	l.add("a");
	l.add("b");
	l.add("c");	
	List<String> readList=Collections.unmodifiableList(l);
	//readList.add("d");
	
	
}
}
