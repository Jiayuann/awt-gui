package com.knightsight.server;
import java.net.*;
import java.util.*;
import java.io.*;

public class Server2 {
	private ServerSocket server;
	public static final String CRLF="\r\n";
	public static final String BLANK=" ";
	public static void main(String[] args) {
		Server2 server=new Server2();
		server.start();
		
	}
	
	public void start(){
		try {
			server = new ServerSocket(8800);	
			this.receive();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void receive(){
			try {
				Socket client=server.accept();
			 	byte []data=new byte[20480];
			 	//1.��ȡ������
				int len=client.getInputStream().read(data);
				String requestInfo=new String(data,0,len).trim();
				System.out.println(requestInfo);
				
				//2.��Ӧ���ı�
				StringBuilder responseContext=new StringBuilder();
				responseContext.append("<html><head><title>HTTP responseExample</title>"
						+ "</head><body>HelloFomCat</body></html>");
				
				
				//3.httpЭ��--�汾��״̬���룬����
				StringBuilder response=new StringBuilder();
				response.append("HTTP/1.1").append(BLANK).append("200").append(BLANK).append("OK").append(CRLF);
					//��Ӧͷresponse head
				response.append("Server:knight Server/0.0.1").append(CRLF);
				response.append("Date:").append(new Date()).append(CRLF);
				response.append("Content-type:text/html;charset=GBK").append(CRLF);
					//���ĳ���
				response.append("Content-Length:").append(responseContext.toString().getBytes().length).append(CRLF);
					//����֮ǰ
				response.append(CRLF);
					//����
				response.append(responseContext);
				
				//4.�����
				BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
				bw.write(response.toString());
				bw.flush();
				bw.close();
				
				
			} catch (IOException   e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public void stop(){
		
	}
}
