package com.knight.leet;

public class ZigZag {
	public static String convert(String s,int nRows){
		if(nRows==1)return s;
		String []res=new String[nRows];
		for(int n=0;n<nRows;n++)res[n]="";
		char []ch=s.toCharArray();
		int i=0,j,gap=nRows-2;
		while(i<s.length()){
			for(j=0;i<s.length()&&j<nRows;j++)res[j]+=ch[i++];
			for(j=gap;i<s.length()&&j>0;j--)res[j]+=ch[i++];
			
		}
		//StringBuilder r=new StringBuilder();
		String r="";
		for(int k=0;k<nRows;k++){
			//r.append(res[k]);
			r+=res[k];
		}
		//return r.toString();
		System.out.println(r.length());
		return r;
		  
	}
	public static void main(String[] args) {
		String s="PAYPALISHIRING";
		System.out.println(convert(s,3));
	}

}
