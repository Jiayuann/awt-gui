package com.knight.sort;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr={9,80,7,4,5};
		for(int i=0;i<arr.length;i++){
			for(int j=arr.length-1;j>i;j--){
				if(arr[j]<arr[j-1]){
					int temp=arr[j];
					arr[j]=arr[j-1];
					arr[j-1]=temp;
				}
			}
		}
		
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"\t");
		
	}
}
