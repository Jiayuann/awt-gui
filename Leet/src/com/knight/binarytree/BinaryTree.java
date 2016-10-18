package com.knight.binarytree;

public class BinaryTree {
	Object b=new Object();
	int val;
	BinaryTree lchild,rchild;
	public BinaryTree(int val){
		this.val=val;
		this.lchild=null;
		this.rchild=null;
	}
    
	
}

/*
 * typedef struct QNode{
 *   int val;
 *   Struct QNode *next;
 *   }QNode,*QPtr;
 *   
 *   typedef struct Queue{
 *   Qptr front;
 *   Qptr rear;
 *   }
 *   
 */
