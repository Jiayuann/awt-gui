package com.knightsight.server2;
import java.util.*;
import java.io.*;
public class Request {
	private String method;
	private  String url;
	private Map<String,List<String>> paraMapValues;
	private String requestInfo;
	
	private InputStream is;
	public static final String CRLF="\r\n";
	public Request(){
		method="";
		url="";
		paraMapValues=new HashMap<String,List<String>>();
		requestInfo="";
		
	}
	public Request(InputStream is){
		method="";
		url="";
		paraMapValues=new HashMap<String,List<String>>();
		requestInfo="";
		
		this.is=is;
		
		try {
			byte []data=new byte[20480];
			int len = is.read(data);
			requestInfo=new String(data,0,len);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return;
		}
		
		parseRequestInfo();
	}
	//����ͷ��Ϣ ����Ϣ���з�������ʽ������·�������������get���ܴ��ڣ� 
	private void parseRequestInfo(){
		if(null==requestInfo||(requestInfo=requestInfo.trim()).equals(""))
			return;
		String paramString="";
		
		String firstLine=requestInfo.substring(0,requestInfo.indexOf(CRLF));
		int idx=requestInfo.indexOf("/");
		this.method=firstLine.substring(0, idx).trim();
		
		String urlStr=firstLine.substring(idx,firstLine.indexOf("HTTP/")).trim();
		if(this.method.equalsIgnoreCase("post")){
			this.url=urlStr;
			paramString=requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();
			
		}else if(this.method.equalsIgnoreCase("get")){
			if(urlStr.contains("?")){
				String []urlArray=urlStr.split("\\?");
				this.url=urlArray[0];
				paramString=urlArray[1];//�����������
			}else{
				 this.url=urlStr;
			}
		}
		//�����������װ��Map
		if(paramString.equals("")){
			return;
		}
		parseParam(paramString);
	}
	
	private void parseParam(String paramString){
		StringTokenizer token=new StringTokenizer(paramString,"&");
		while(token.hasMoreTokens()){
			String keyValue=token.nextToken();
			String []keyValues=keyValue.split("=");
			if(keyValues.length==1){
				keyValues=Arrays.copyOf(keyValues, 2);
				keyValues[1]=null;
			}
			// convert to Map
			String key=keyValues[0].trim();
			String value=null==keyValues[1]?null:keyValues[1].trim();
			if(!paraMapValues.containsKey(key)){
				paraMapValues.put(key, new ArrayList<String>());
			}
			List<String> values=paraMapValues.get(key);
			values.add(value);
		}
	}
	
	//����ҳ�����ƻ�ȡֵ multy single
	public String[] getParameterValues(String name){
		List<String> values=null;
		if((values=paraMapValues.get(name))==null){
			return null;
		}else{
			return values.toArray(new String[0]);
		}
	}
	
	public String getParameter(String name){
		String []values=getParameterValues(name);
		if(null==values){
			return null;
		}
		
		for(String s:values)
			System.out.println(s);
		return values[0];
	}
	
	public String getUrl(){
		
		return url;
	}
}
