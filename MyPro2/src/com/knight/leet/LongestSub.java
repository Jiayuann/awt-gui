package com.knight.leet;

import java.util.HashMap;
import java.util.Map;

public class LongestSub {
	public static int longestSubstring(String s){
		int maxLength=0;
		int tempLength=0;
		int startIndex=0;
		Map<Character, Integer> m=new HashMap();
		char []ch=s.toCharArray();
		for(int i=0;i<s.length();i++){
			if(!m.containsKey(ch[i])){
				m.put(ch[i], i);
				tempLength++;
			}else{
				startIndex=startIndex>m.get(ch[i])?startIndex:m.get(ch[i]);
				tempLength=i-startIndex;
				m.put(ch[i], i);
			}
			
			if(tempLength>maxLength)maxLength=tempLength;
		}
		return maxLength;
	}
	
	public static void main(String[] args) {
		String s="bcbcabc";
		System.out.println(longestSubstring(s));
	
	}
}
