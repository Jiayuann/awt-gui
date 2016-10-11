package com.knightsight.server2;
import java.io.*;
import java.util.Date;

public class Response {
	public static final String CRLF="\r\n";
	public static final String BLANK=" ";
	private BufferedWriter bw;
	
	//头信息、正文及长度
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
		//响应头response head
		headInfo.append("Server:knight Server/0.0.1").append(CRLF);
		headInfo.append("Date:").append(new Date()).append(CRLF);
		headInfo.append("Content-type:text/html;charset=GBK").append(CRLF);
		//正文长度
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
     输入localhost:8800 会提示responseText信息，表单键入显示账号密码
（1）协议头。协议版本、状态码、描述
    HTTP/1.1200 ok
1xx 信息类 正在进一步处理
2xx 成功类 接收到请求并进一步处理 200 ok
3xx 重定向类 请求没有成功，采取进一步操作
4xx 客户端错误 404not found
5xx 服务器错误
 
（2）Response Header。服务器类型、日期时间、正文类型长度。
   Server:ApacheTomcat/1.1.0
   Date: Sat, 31 Dec 2005 23:59:59 GMT
   Content-Type: text/html;charset=GBK
   Content-Length: 122
   Content-Type:text/plain
 
（3）Response Content。协议正文
<html>
<head>
<title>Wrox Homepage</title>
</head>
<body>
<!-- body goes here -->
</body>
</html>
 */
