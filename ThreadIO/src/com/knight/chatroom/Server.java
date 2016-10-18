package com.knight.chatroom;
import java.io.*;
import java.util.*;
import java.net.*;
public class Server {
	private List<MyChannel> all=new ArrayList<MyChannel>();
	
	public static void main(String[] args) throws IOException{
		new Server().start();
	}
	
	public void start()throws IOException{
		ServerSocket server=new ServerSocket(9900);
		while(true){
		Socket socket=server.accept();
		MyChannel channel=new MyChannel(socket);
		all.add(channel);
		new Thread(channel).start();
		}
		
	}
	/* һ���ͻ���һ����·
	1.������ 2.����� 3.�������� 4.�������� */
	
	class MyChannel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private boolean isRunning=true;
		private String name;
		public MyChannel(Socket socket){
			try {
				dis=new DataInputStream(socket.getInputStream());
				dos=new DataOutputStream(socket.getOutputStream());
				this.name=dis.readUTF();
				System.out.println(this.name);
				this.send("��ӭ����������");
				sendOthers(this.name+"������������");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				CloseUtil.closeAll(dis,dos);
				isRunning=false;
			}
			
		}
		private String receive(){
			String msg="";
			try {
				msg=dis.readUTF();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				CloseUtil.closeAll(dis);
				isRunning=false;
				all.remove(this);
			}
			return msg;
		}
		private void send(String msg){
			if(msg==null||msg.equals("")){
				return;
			}
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				CloseUtil.closeAll(dos);
				isRunning=false;
				all.remove(this);
			}
			
		}
		private  void sendOthers(String msg){
			System.out.println(msg);
			if(msg.startsWith("@")&&msg.indexOf(":")>-1){
				String name=msg.substring(1,msg.indexOf(":"));
				String content=msg.substring(msg.indexOf(":")+1);
				for(MyChannel other:all){
					if(other.name.equals(name)){
						other.send(this.name+"���ĵض���˵"+content);
					}
					
				}
			}else{
				for(MyChannel others:all){
					if(others==this){
						continue;
					}
					others.send(msg);
				}
			}
		}
		
		@Override
		public void run() {
			while(isRunning){
				sendOthers(receive());
			}
			
		}
		
	}
}