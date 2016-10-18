package com.knight.thread;
import java.lang.Thread;
public class Web12306 implements Runnable{
		private int num=50;
		private boolean flag=true;
		public synchronized void  test(){
			if(num<=0)flag=false;
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		
				System.out.println(Thread.currentThread().getName()+"鎶㈠埌浜�"+num--);

		}
		@Override
		public void run(){
			while(flag){
			test();
			}
		}
public static void main(String []args){
		Web12306 web=new Web12306();
		//浠ｇ悊
		new Thread(web,"a").start();
		new Thread(web,"b").start();	new Thread(web,"d").start();
		new Thread(web,"c").start();
	}
	}