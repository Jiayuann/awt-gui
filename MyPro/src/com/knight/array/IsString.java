package com.knight.array;

public class IsString {
	public boolean divide(int [] a){
		int count=0;
		boolean c=false;
		for(int i=a.length-1;i>=0;i--){
			count=0;
			for(int j=0;j<=i;j++){
				if(a[j]==a[i]){
					count++;
					if(count>=a.length/2)c=true;
				}
				
			}
		}
		
		return c;
	}

	public static void main(String[] args) {
		IsString i=new IsString();
		int []a={2,5,3,5,5,8,4,5};
		System.out.println(i.divide(a));
		
	}
}
