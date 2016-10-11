package com.knightsight.linklist;

public class LinkList {
  int val;
  LinkList next;
  public LinkList(int val){
	  this.val=val;
	  this.next=null;
  }
  
  public LinkList reverse(LinkList l){
	LinkList pre=null;
	while(l!=null){
		LinkList next=l.next;
		l.next=pre;
		pre=l;
		l=next;
	}  
	return pre;
  }
  
}
