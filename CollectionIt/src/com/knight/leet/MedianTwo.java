package com.knight.leet;

public class MedianTwo {
	public static int[] findTwoMedian(int []A, int m, int []B,int n){
		int i=m-1;
		int j=n-1;
		int k=m+n-1;
		int []s=new int[k+1];
		while(i>=0&&j>=0){
			if(A[i]>B[j])
				s[k--]=A[i--];
			else
				s[k--]=B[j--];
		}
		while(i>=0)s[k--]=A[i--];
		while(j>=0)s[k--]=B[j--];
		return s;
		
	}
	
	public static void main(String[] args) {
		int []a={2,4,5,34,38};
		int []b={1,12,32,35,223};
		int []c=findTwoMedian(a,a.length,b,b.length);
		for(int i=0;i<c.length;i++){
			System.out.print(c[i]+"\t");
			
		}
		if(c.length%2==0)
		System.out.print("\n"+(c[c.length/2]+c[c.length/2-1])/2);
				
	}
	
}
