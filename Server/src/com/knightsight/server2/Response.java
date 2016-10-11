package com.knightsight.server2;
import java.io.*;
import java.util.Date;

public class Response {
	public static final String CRLF="\r\n";
	public static final String BLANK=" ";
	private BufferedWriter bw;
	
	//ͷ��Ϣ�����ļ�����
	private StringBuilder headInfo;
	private StringBuilder content;
	private int len=0;
	
	public Response(OutputStream os){
		headInfo=new StringBuilder();
		content=new StringBuilder();
		len=0;
		bw=new BufferedWriter(new OutputStreamWriter(os));
		
	}
	public Response print(String info){
		content.append(info);
		len+=info.getBytes().length;
		return this;
		
	}
	
	public Response println(String info){
		content.append(info).append(CRLF);
		len+=(info+CRLF).getBytes().length;
		return this;
		
	}
	private void createHeadInfo(int code){
		headInfo.append("HTTP/1.1").append(BLANK).append(code).append(BLANK);
		switch(code){
		case 200:
			headInfo.append("OK");
			break;
		case 404:
			headInfo.append("NOT FOUND");
			break;
		case 500:
			headInfo.append("SERVER ERROR");
			break;
		}
		headInfo.append(CRLF);
		//��Ӧͷresponse head
		headInfo.append("Server:knight Server/0.0.1").append(CRLF);
		headInfo.append("Date:").append(new Date()).append(CRLF);
		headInfo.append("Content-type:text/html;charset=GBK").append(CRLF);
		//���ĳ���
		headInfo.append("Content-Length:").append(len).append(CRLF);
		headInfo.append(CRLF);
	}
	
	public void pushToClient(int code) throws IOException{
		createHeadInfo(code);
		bw.append(headInfo.toString());
		bw.append(content.toString());
		bw.flush();
		bw.close();
	}
}

/*
     ����localhost:8800 ����ʾresponseText��Ϣ����������ʾ�˺�����
��1��Э��ͷ��Э��汾��״̬�롢����
    HTTP/1.1200 ok
1xx ��Ϣ�� ���ڽ�һ������
2xx �ɹ��� ���յ����󲢽�һ������ 200 ok
3xx �ض����� ����û�гɹ�����ȡ��һ������
4xx �ͻ��˴��� 404not found
5xx ����������
 
��2��Response Header�����������͡�����ʱ�䡢�������ͳ��ȡ�
   Server:ApacheTomcat/1.1.0
   Date: Sat, 31 Dec 2005 23:59:59 GMT
   Content-Type: text/html;charset=GBK
   Content-Length: 122
   Content-Type:text/plain
 
��3��Response Content��Э������
<html>
<head>
<title>Wrox Homepage</title>
</head>
<body>
<!-- body goes here -->
</body>
</html>
 */
