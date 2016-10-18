package com.knight.thread;
import java.lang.Thread;
public class StuThread implements Runnable{
	private boolean flag=true;
	@Override
	public void run(){
		while(flag){
		System.out.println("study thread..."+flag);	
		}
	}
	public static void main(String[] args){
		StuThread stu=new StuThread();
		Thread th=new Thread(stu);
		th.start();
		for(int i=0;i<100;i++){
			//System.out.println("my new ");	
			if(i==50){
				th.stop();
			}
			System.out.println("main...."+i);	
		}
	}
}