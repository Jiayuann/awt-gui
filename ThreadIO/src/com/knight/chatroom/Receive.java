package com.knight.chatroom;
import java.io.*;
import java.net.*;

public class Receive implements Runnable{
	private DataInputStream dis;
	private boolean isRunning=true;
	public Receive(){
		
		
	}
	public Receive(Socket client){
		try {
			dis=new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isRunning=false;
			CloseUtil.closeAll(dis);
		}
		
	}
	public String receive(){
		String msg="";
		try {
			msg=dis.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isRunning=false;
			CloseUtil.closeAll(dis);
		}
		return msg;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isRunning){
			System.out.println(receive());
		}
			
	
	}

}
