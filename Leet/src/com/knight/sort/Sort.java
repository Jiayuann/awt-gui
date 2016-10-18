package com.knight.sort;


class List{
	int[] c;
	public List(int []c){
		this.c=c;
	}
	public void print(){
		for(int i=0;i<c.length;i++){
			System.out.print(c[i]+"\t");
		}
	}
	
	public void insertSort(){
		int i,j;
		for(i=1;i<c.length;i++){
			if(c[i]<c[i-1]){
				int temp=c[i];
				for(j=i-1;c[j]>temp&&j>=0;j--){
					c[j+1]=c[j];
				}
			    c[j+1]=temp;
			}
			
		}
		
	}
}

public class Sort {
	public static void main(String[] args) {
	int []c={3,12,43,9,4,28};
	QSort l=new QSort(c);
	l.print();
	l.qSort(0,l.c.length-1);
	System.out.println();
	l.print();
	}
	
	
}
