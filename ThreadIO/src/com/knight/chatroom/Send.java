package com.knight.chatroom;
import java.io.*;
import java.net.*;
public class Send implements Runnable{
	private BufferedReader console;
	private DataOutputStream dos;
	private boolean isRunning=true;
	private String name;
	public Send(){
		console=new BufferedReader(new InputStreamReader(System.in));
		
	}
	public Send(Socket client,String name){
		this();
		try {
			dos=new DataOutputStream(client.getOutputStream());
			this.name=name;
			send(this.name);
		} catch (IOException e) {
			e.printStackTrace();
			isRunning=false;
			CloseUtil.closeAll(dos,console);
		}
	}
	//得到控制台输入
	private String getMsgFromConsole(){
		try {
			return console.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	//发送出去
	public void send(String msg){
		if(msg!=null&&!msg.equals(""))
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
				isRunning=false;
				CloseUtil.closeAll(dos,console);
				
			}
	}
	
	@Override
	public void run() {
		while(isRunning){
			send(getMsgFromConsole());
		}
		
	}
	
}
