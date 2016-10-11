package com.knight.sort;

public class QSort extends List{

	public QSort(int[] c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
	
	public int partition(int low,int high){
		int temp=c[low];
		while(low<high){
		while(low<high&&c[high]>=temp)--high;
		c[low]=c[high];
		while(low<high&&c[low]<=temp)++low;
		c[high]=c[low];
		}
		c[low]=temp;
		return low;
	}
	
	public void qSort(int low,int high){
		if(low<high){
		int pivot=partition(low,high);
		System.out.println(pivot);
		qSort(low,pivot-1);
		qSort(pivot+1,high);
		}
	}
   
	
}
