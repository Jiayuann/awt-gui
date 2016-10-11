package com.knight.collection;

public class MyLinkList {
	Node first;
	Node last;
	int size;
	
	public void add(Object obj){
		if(first==null){
			Node n=new Node(null,obj,null);
			first=n;
			last=n;
			size++;
		}else{
		    Node n=new Node(last,obj,null);
		    last.next=n;
		
		    last=n;
		    size++;
		}	
	}

	public Object get(int index){
		  Node n=first;
		  if(index>size-1||first==null){
			  try{
				  throw new Exception();
			  }catch(Exception e){
				  e.printStackTrace();
			  }
		  }
		  
		  for(int i=0;i<index;i++)
			n=n.next;
		  return n.obj;
	}
	
	public void del(int index){
			Node n=first;
		  for(int i=0;i<index;i++){
			  n=n.next;
		  }
		  Node pre=n.previous;
		  Node ne=n.next;
		  if(pre==null){
			  first=ne;
			  ne.previous=null;
		  }
		  else if(ne==null){
			  last=pre;
			  pre.next=null;
		  }
		  else{
		  pre.next=ne;
		  ne.previous=pre;
		  }
		  size--;
	}
	
	public void del(){
	this.del(this.size-1);
	}
	
	public void printL(){
		Node n=first;
		for(int i=0;i<size;i++){
			System.out.println(n.obj);
			n=n.next;
		}
		
	}
	
	public static void main(String[] args) {
		MyLinkList m=new MyLinkList();
		m.add("aa");
		m.add("bb");	
		m.add("cc");
		m.del(0);
		m.printL();
	}

}




class Node{
	Node previous;
    Object obj;
	Node next;
	
	public Node(){	
	}
	public Node(Node previous, Object obj, Node next) {
		super();
		this.previous = previous;
		this.obj = obj;
		this.next = next;
	}
}