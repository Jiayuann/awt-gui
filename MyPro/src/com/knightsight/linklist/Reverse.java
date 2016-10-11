package com.knightsight.linklist;

public class Reverse {

  public static void main(String[] args) {
	LinkList l1=new LinkList(3);
	LinkList l2=new LinkList(2);
	LinkList l3=new LinkList(1);
	l1.next=l2;
	l2.next=l3;
	
	LinkList l4=l1.reverse(l1);
	System.out.println(l4.next.val);
}
}
